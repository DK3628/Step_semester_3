public class DeluxeRoom extends Room {
    public DeluxeRoom(int number) { super(number); }
    @Override public double calculatePrice(int nights) { return 160.0 * nights; }
    @Override protected String getCategoryName() { return "Deluxe Room"; }
}
