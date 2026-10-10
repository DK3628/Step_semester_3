public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) { super(name); }
    @Override protected int getMaxDaysPerRequest() { return 5; }
    @Override public String getTypeName() { return "Part-time"; }
}
