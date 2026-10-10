public class Truck extends Vehicle {
    public Truck(String name) { super(name); }
    /** $80/day plus a flat $50 handling fee. */
    @Override public double calculateCharge(int days) { return 80.0 * days + 50.0; }
}
