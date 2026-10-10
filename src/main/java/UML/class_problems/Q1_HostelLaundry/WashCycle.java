/** One wash: links a student, a machine and a wash type. */
public class WashCycle {
    private final Student student;
    private final WashingMachine machine;
    private final WashType washType;

    public WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }
    public Student getStudent() { return student; }
    public WashingMachine getMachine() { return machine; }
    public WashType getWashType() { return washType; }
    public double calculateCharge() { return washType.getCharge(); }
}
