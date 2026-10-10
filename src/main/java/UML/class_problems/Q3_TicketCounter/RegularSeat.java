public class RegularSeat extends Seat {
    public RegularSeat(String id) { super(id); }
    @Override public double getPrice() { return 150; }
    @Override public String getCategory() { return "Regular"; }
}
