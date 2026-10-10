public class ReclinerSeat extends Seat {
    public ReclinerSeat(String id) { super(id); }
    @Override public double getPrice() { return 400; }
    @Override public String getCategory() { return "Recliner"; }
}
