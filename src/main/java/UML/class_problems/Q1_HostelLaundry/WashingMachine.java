/**
 * A machine runs one wash at a time. Its busy/free state is derived from
 * currentCycle, which can only be changed by package-private methods
 * (used by LaundryService), so outside code cannot alter the status directly.
 */
public class WashingMachine {
    private final String id;
    private WashCycle currentCycle;

    public WashingMachine(String id) { this.id = id; }

    public String getId() { return id; }
    public boolean isFree() { return currentCycle == null; }

    void occupy(WashCycle cycle) {
        if (!isFree()) throw new IllegalStateException("Machine " + id + " is currently busy.");
        currentCycle = cycle;
    }

    void release() {
        if (isFree()) throw new IllegalStateException("Machine " + id + " has no active cycle.");
        currentCycle = null;
    }
}
