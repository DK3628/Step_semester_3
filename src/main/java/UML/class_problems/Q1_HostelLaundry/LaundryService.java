/** Common booking logic. Never needs to change when a new WashType is added. */
public class LaundryService {

    public WashCycle startWash(Student student, WashingMachine machine, WashType type) {
        if (!machine.isFree()) {
            System.out.println("Machine " + machine.getId() + " is currently busy.");
            return null;
        }
        WashCycle cycle = new WashCycle(student, machine, type);
        machine.occupy(cycle);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                type.getName(), machine.getId(), student.getName(),
                type.getDurationMinutes(), cycle.calculateCharge());
        return cycle;
    }

    public void completeWash(WashingMachine machine) {
        if (machine.isFree()) {
            System.out.println(machine.getId() + " has no active cycle.");
            return;
        }
        machine.release();
        System.out.println(machine.getId() + " cycle completed. " + machine.getId() + " is now free.");
    }
}
