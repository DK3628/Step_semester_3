import java.time.LocalDate;

/** Leave workflow; policy enforcement is delegated to the Employee subtype. */
public class LeaveService {

    public LeaveRequest submit(Employee employee, LocalDate start, LocalDate end) {
        if (end.isBefore(start)) {
            System.out.println("Cannot submit: end date is before start date.");
            return null;
        }
        LeaveRequest req = new LeaveRequest(employee, start, end);
        String problem = employee.validateLeave(req.getDays());
        if (problem != null) {
            System.out.println("Cannot submit leave for " + employee.getName() + ": " + problem);
            return null;
        }
        System.out.println("Leave request submitted for " + employee.getName()
                + " (" + req.periodLabel() + "). Status: " + req.getStatus() + ".");
        return req;
    }

    public void approve(Reviewer reviewer, LeaveRequest req) {
        try {
            req.approve(reviewer);
            report(req, "approved");
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }

    public void reject(Reviewer reviewer, LeaveRequest req) {
        try {
            req.reject(reviewer);
            report(req, "rejected");
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }

    public void changeStatus(LeaveRequest req, LeaveStatus target, Reviewer reviewer) {
        try {
            req.changeStatus(target, reviewer);
            report(req, target.toString().toLowerCase());
        } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
    }

    private void report(LeaveRequest req, String verb) {
        System.out.println(req.getEmployee().getName() + "'s leave request (" + req.periodLabel()
                + ") " + verb + ". Status: " + req.getStatus() + ".");
    }
}
