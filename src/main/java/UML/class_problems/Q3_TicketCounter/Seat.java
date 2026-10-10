/** Each seat category defines its own price. */
public abstract class Seat {
    private final String seatId;
    protected Seat(String seatId) { this.seatId = seatId; }
    public String getSeatId() { return seatId; }
    public abstract double getPrice();
    public abstract String getCategory();
}
