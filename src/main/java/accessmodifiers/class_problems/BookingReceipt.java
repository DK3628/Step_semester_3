import java.util.Arrays;

// Note: Removed 'final' modifier from class to allow GroupBookingReceipt to extend it,
// while keeping all fields strictly final and deeply copied.
public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers != null ? Arrays.copyOf(seatNumbers, seatNumbers.length) : new String[0];
    }

    public String[] getSeatNumbers() {
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }
    
    public String getBookingId() {
        return bookingId;
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = getSeatNumbers();
        if (index >= 0 && index < updatedSeats.length) {
            updatedSeats[index] = newSeat;
        }
        return new BookingReceipt(this.bookingId, updatedSeats);
    }
}