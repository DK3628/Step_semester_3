public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) { super(name); }
    @Override protected int getMaxDaysPerRequest() { return 20; }
    @Override public String getTypeName() { return "Full-time"; }
}
