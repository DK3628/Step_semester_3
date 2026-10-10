public class Suite extends Room {
    public Suite(int number) { super(number); }
    /** $300/night plus a flat $75 amenities fee per stay. */
    @Override public double calculatePrice(int nights) { return 300.0 * nights + 75.0; }
    @Override protected String getCategoryName() { return "Suite"; }
}
