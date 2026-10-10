public class QuickWash implements WashType {
    @Override public String getName() { return "Quick"; }
    @Override public int getDurationMinutes() { return 30; }
    @Override public double getCharge() { return 20.0; }
}
