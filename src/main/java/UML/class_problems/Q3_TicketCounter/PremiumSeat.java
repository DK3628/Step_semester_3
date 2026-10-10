public class PremiumSeat extends Seat {
    public PremiumSeat(String id) { super(id); }
    @Override public double getPrice() { return 250; }
    @Override public String getCategory() { return "Premium"; }
}
