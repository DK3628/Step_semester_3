import java.util.*;

/** Common rental logic: works with any Vehicle subtype. */
public class RentalService {
    private final Map<Vehicle, Rental> activeRentals = new HashMap<>();

    public Rental rent(Customer customer, Vehicle vehicle, int days) {
        if (days <= 0) {
            System.out.println("Rental period must be at least 1 day.");
            return null;
        }
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getName() + " is currently unavailable.");
            return null;
        }
        Rental rental = new Rental(vehicle, customer, days);
        vehicle.markRented();
        activeRentals.put(vehicle, rental);
        System.out.printf(Locale.US, "%s rented successfully by %s. Rental charge: $%.2f.%n",
                vehicle.getName(), customer.getName(), rental.getCharge());
        return rental;
    }

    public void returnVehicle(Customer customer, Vehicle vehicle) {
        Rental rental = activeRentals.get(vehicle);
        if (rental == null || rental.getCustomer() != customer) {
            System.out.println(vehicle.getName() + " has no active rental for " + customer.getName() + ".");
            return;
        }
        rental.close();
        activeRentals.remove(vehicle);
        vehicle.markReturned();
        System.out.println(vehicle.getName() + " returned by " + customer.getName() + ".");
    }
}
