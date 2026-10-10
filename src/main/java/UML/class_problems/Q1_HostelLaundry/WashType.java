/** Abstraction for a wash type. New types (e.g. Delicate) just implement this. */
public interface WashType {
    String getName();
    int getDurationMinutes();
    double getCharge();
}
