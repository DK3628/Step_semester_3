/** Tracks the rented vehicle, the customer and the rental period. */
public class Rental {
    private final Vehicle vehicle;
    private final Customer customer;
    private final int days;
    private final double charge;
    private boolean active = true;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.charge = vehicle.calculateCharge(days);
    }

    void close() { active = false; }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public int getDays() { return days; }
    public double getCharge() { return charge; }
    public boolean isActive() { return active; }
}
