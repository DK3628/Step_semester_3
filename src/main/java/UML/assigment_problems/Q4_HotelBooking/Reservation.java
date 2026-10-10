import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Reservation {
    public static final int CANCELLATION_DEADLINE_DAYS = 2;   // must cancel at least 2 days before check-in

    private final Customer customer;
    private final Room room;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final double price;
    private boolean active = true;

    Reservation(Customer customer, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = room.calculatePrice(getNights());
    }

    public int getNights() { return (int) ChronoUnit.DAYS.between(checkIn, checkOut); }
    public LocalDate getCancellationDeadline() { return checkIn.minusDays(CANCELLATION_DEADLINE_DAYS); }

    boolean overlaps(LocalDate in, LocalDate out) { return checkIn.isBefore(out) && in.isBefore(checkOut); }

    void cancel(LocalDate today) {
        if (!active) throw new IllegalStateException("Reservation is already cancelled.");
        if (today.isAfter(getCancellationDeadline()))
            throw new IllegalStateException("Cannot cancel: the cancellation deadline ("
                    + getCancellationDeadline() + ") has passed.");
        active = false;
    }

    public static String period(LocalDate in, LocalDate out) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM d", Locale.ENGLISH);
        return f.format(in) + "-" + (in.getMonth() == out.getMonth() ? String.valueOf(out.getDayOfMonth()) : f.format(out));
    }

    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public double getPrice() { return price; }
    public boolean isActive() { return active; }
}
