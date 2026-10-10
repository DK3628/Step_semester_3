import java.time.LocalDateTime;
import java.util.*;

/** A movie show: owns its seat layout and tracks which seats are booked. */
public class Show {
    private final String movieName;
    private final LocalDateTime startTime;
    private final Map<String, Seat> seats = new LinkedHashMap<>();
    private final Set<String> bookedSeatIds = new HashSet<>();

    /** Layout: rows A-C Regular (1-10), D-F Premium (1-10), R Recliner (1-5). */
    public Show(String movieName, LocalDateTime startTime) {
        this.movieName = movieName;
        this.startTime = startTime;
        for (char row = 'A'; row <= 'C'; row++)
            for (int n = 1; n <= 10; n++) addSeat(new RegularSeat("" + row + n));
        for (char row = 'D'; row <= 'F'; row++)
            for (int n = 1; n <= 10; n++) addSeat(new PremiumSeat("" + row + n));
        for (int n = 1; n <= 5; n++) addSeat(new ReclinerSeat("R" + n));
    }

    private void addSeat(Seat s) { seats.put(s.getSeatId(), s); }

    public boolean seatExists(String id) { return seats.containsKey(id); }
    public boolean isAvailable(String id) { return seats.containsKey(id) && !bookedSeatIds.contains(id); }
    public Seat getSeat(String id) { return seats.get(id); }
    public boolean hasStarted(LocalDateTime now) { return !now.isBefore(startTime); }

    public List<String> getAvailableSeatIds() {
        List<String> list = new ArrayList<>();
        for (String id : seats.keySet()) if (!bookedSeatIds.contains(id)) list.add(id);
        return list;
    }

    // package-private: only BookingService / Booking may change seat state
    void reserve(List<Seat> toBook) { for (Seat s : toBook) bookedSeatIds.add(s.getSeatId()); }
    void release(List<Seat> toRelease) { for (Seat s : toRelease) bookedSeatIds.remove(s.getSeatId()); }

    public String getMovieName() { return movieName; }
    public LocalDateTime getStartTime() { return startTime; }
}
