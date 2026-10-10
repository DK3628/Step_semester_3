import java.time.LocalDate;
import java.util.*;

/** Each room category supplies its own pricing. Room tracks its reservations. */
public abstract class Room {
    private final int number;
    private final List<Reservation> reservations = new ArrayList<>();

    protected Room(int number) { this.number = number; }

    public abstract double calculatePrice(int nights);
    protected abstract String getCategoryName();

    public String getDisplayName() { return getCategoryName() + " " + number; }
    public int getNumber() { return number; }

    /** Check-out day is exclusive: stays [in, out) overlap only if they share a night. */
    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
        for (Reservation r : reservations)
            if (r.isActive() && r.overlaps(checkIn, checkOut)) return false;
        return true;
    }

    void addReservation(Reservation r) { reservations.add(r); }
}
