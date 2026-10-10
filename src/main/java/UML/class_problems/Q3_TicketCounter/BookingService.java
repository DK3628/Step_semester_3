import java.time.LocalDateTime;
import java.util.*;

public class BookingService {
    public static final int MAX_SEATS_PER_BOOKING = 6;

    /** All-or-nothing: validates every seat before reserving any. */
    public Booking book(Customer customer, Show show, List<String> seatIds, LocalDateTime now) {
        try {
            if (show.hasStarted(now)) throw new IllegalStateException("Show has already started.");
            if (seatIds.isEmpty()) throw new IllegalArgumentException("Select at least one seat.");
            if (seatIds.size() > MAX_SEATS_PER_BOOKING)
                throw new IllegalArgumentException("Cannot book more than " + MAX_SEATS_PER_BOOKING + " seats at once.");
            if (new HashSet<>(seatIds).size() != seatIds.size())
                throw new IllegalArgumentException("Duplicate seats selected.");

            List<Seat> chosen = new ArrayList<>();
            for (String id : seatIds) {
                if (!show.seatExists(id)) throw new IllegalArgumentException("Seat " + id + " does not exist.");
                if (!show.isAvailable(id)) throw new IllegalStateException("Seat " + id + " is already booked for this show.");
                chosen.add(show.getSeat(id));
            }
            show.reserve(chosen);
            Booking b = new Booking(customer, show, chosen);
            System.out.printf("Booking confirmed for %s: %s. Total: ₹%,.2f.%n",
                    customer.getName(), b.seatList(), b.calculateTotal());
            return b;
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void cancel(Booking booking, LocalDateTime now) {
        try {
            booking.cancel(now);
            System.out.printf("%s's booking cancelled. Seats %s released.%n",
                    booking.getCustomer().getName(), booking.seatList());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
