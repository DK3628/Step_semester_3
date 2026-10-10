import java.time.LocalDateTime;
import java.util.*;

public class Booking {
    private static int counter = 1;
    private final int bookingId = counter++;
    private final Customer customer;
    private final Show show;
    private final List<Seat> seats;
    private boolean cancelled;

    Booking(Customer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = Collections.unmodifiableList(new ArrayList<>(seats));
    }

    public double calculateTotal() {
        double total = 0;
        for (Seat s : seats) total += s.getPrice();
        return total;
    }

    public String seatList() {
        StringJoiner sj = new StringJoiner(", ");
        for (Seat s : seats) sj.add(s.getSeatId());
        return sj.toString();
    }

    /** Allowed only before the show starts; releases all seats. */
    public void cancel(LocalDateTime now) {
        if (cancelled) throw new IllegalStateException("Booking is already cancelled.");
        if (show.hasStarted(now)) throw new IllegalStateException("Cannot cancel: the show has already started.");
        show.release(seats);
        cancelled = true;
    }

    public int getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Show getShow() { return show; }
    public List<Seat> getSeats() { return seats; }
    public boolean isCancelled() { return cancelled; }
}
