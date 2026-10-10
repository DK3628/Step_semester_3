import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HotelService {
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("MMM d", Locale.ENGLISH);

    private static String range(LocalDate in, LocalDate out) { return F.format(in) + " to " + F.format(out); }

    public boolean checkAvailability(Room room, LocalDate in, LocalDate out) {
        boolean ok = !out.isAfter(in) ? false : room.isAvailable(in, out);
        System.out.println(room.getDisplayName() + (ok ? " is available from " : " is not available from ") + range(in, out) + ".");
        return ok;
    }

    public Reservation reserve(Customer customer, Room room, LocalDate in, LocalDate out) {
        if (!out.isAfter(in) || !room.isAvailable(in, out)) {
            System.out.println(room.getDisplayName() + " is not available from " + range(in, out) + ".");
            return null;
        }
        Reservation r = new Reservation(customer, room, in, out);
        room.addReservation(r);
        System.out.printf(Locale.US, "Reservation confirmed for %s, %s (%s). Price: $%.2f.%n",
                customer.getName(), room.getDisplayName(), Reservation.period(in, out), r.getPrice());
        return r;
    }

    public void cancel(Reservation r, LocalDate today) {
        try {
            r.cancel(today);
            System.out.println("Reservation for " + r.getCustomer().getName() + ", " + r.getRoom().getDisplayName()
                    + " (" + Reservation.period(r.getCheckIn(), r.getCheckOut()) + ") cancelled successfully.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
