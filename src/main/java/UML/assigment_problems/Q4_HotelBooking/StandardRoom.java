public class StandardRoom extends Room {
    public StandardRoom(int number) { super(number); }
    @Override public double calculatePrice(int nights) { return 100.0 * nights; }
    @Override protected String getCategoryName() { return "Standard Room"; }
}
