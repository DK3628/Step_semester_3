public class SUV extends Vehicle {
    public SUV(String name) { super(name); }
    /** $60/day, 10% off for rentals of 5+ days. */
    @Override public double calculateCharge(int days) {
        double total = 60.0 * days;
        return days >= 5 ? total * 0.90 : total;
    }
}
