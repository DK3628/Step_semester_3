import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        HotelService hotel = new HotelService();
        Room r101 = new StandardRoom(101), r201 = new DeluxeRoom(201);
        Customer a = new Customer("Customer A"), b = new Customer("Customer B"), c = new Customer("Customer C");
        LocalDate today = LocalDate.of(2024, 12, 20);

        hotel.checkAvailability(r101, LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        Reservation resA = hotel.reserve(a, r101, LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        hotel.reserve(b, r101, LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 7));   // overlap
        hotel.cancel(resA, today);
        hotel.reserve(c, r201, LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 12));
    }
}
