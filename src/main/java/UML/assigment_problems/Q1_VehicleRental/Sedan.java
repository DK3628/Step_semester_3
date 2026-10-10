public class Sedan extends Vehicle {
    public Sedan(String name) { super(name); }
    @Override public double calculateCharge(int days) { return 40.0 * days; }
}
