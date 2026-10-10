public class Contractor extends Employee {
    public Contractor(String name) { super(name); }
    @Override protected int getMaxDaysPerRequest() { return 3; }
    @Override public String getTypeName() { return "Contractor"; }
}
