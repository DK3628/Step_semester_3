/** Each employee type supplies its own leave rule; the workflow never changes. */
public abstract class Employee {
    private final String name;
    protected Employee(String name) { this.name = name; }
    public String getName() { return name; }

    /** Maximum number of days allowed in a single leave request. */
    protected abstract int getMaxDaysPerRequest();
    public abstract String getTypeName();

    /** Returns null if valid, otherwise the reason it is invalid. */
    public String validateLeave(int days) {
        if (days > getMaxDaysPerRequest())
            return getTypeName() + " leave cannot exceed " + getMaxDaysPerRequest() + " days per request.";
        return null;
    }
}
