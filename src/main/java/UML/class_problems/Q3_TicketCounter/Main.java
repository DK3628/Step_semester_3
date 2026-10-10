import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Show show = new Show("Campus Premiere", LocalDateTime.of(2025, 3, 15, 19, 0));
        LocalDateTime now = LocalDateTime.of(2025, 3, 15, 17, 0); // before the show
        BookingService service = new BookingService();
        Customer asha = new Customer("Asha"), ravi = new Customer("Ravi"), neha = new Customer("Neha");

        Booking ashaBooking = service.book(asha, show, List.of("A1", "A2", "F5"), now);
        service.book(ravi, show, List.of("A2"), now);          // already booked
        service.book(ravi, show, List.of("R1"), now);
        service.cancel(ashaBooking, now);
        service.book(neha, show, List.of("A2"), now);
    }
}
