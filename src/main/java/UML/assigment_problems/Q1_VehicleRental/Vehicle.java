/**
 * Base class for all vehicles. Each category supplies its own charge rule.
 * Availability can only be changed by the rental workflow (package-private methods).
 */
public abstract class Vehicle {
    private final String name;
    private boolean available = true;

    protected Vehicle(String name) { this.name = name; }

    public abstract double calculateCharge(int days);

    public String getName() { return name; }
    public boolean isAvailable() { return available; }

    void markRented() {
        if (!available) throw new IllegalStateException(name + " is currently unavailable.");
        available = false;
    }
    void markReturned() { available = true; }
}
