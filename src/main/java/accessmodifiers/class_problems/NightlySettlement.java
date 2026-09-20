import java.util.Arrays;

public class NightlySettlement {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0;
        int nulls = 0;
        int groups = 0;
        int individuals = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nulls++;
                continue;
            }
            processed++;
            if (receipt instanceof GroupBookingReceipt) {
                groups++;
            } else {
                individuals++;
            }
        }
        return processed + " processed | " + nulls + " null skipped | " + groups + " group | " + individuals + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]); // Proves defensive copy out
        
        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(b.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));
        
        BookingReceipt[] batch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}