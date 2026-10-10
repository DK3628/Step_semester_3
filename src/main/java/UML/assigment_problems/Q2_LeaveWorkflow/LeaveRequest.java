import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/** Owns its status and guards every transition. */
public class LeaveRequest {
    private final Employee employee;
    private final LocalDate start;
    private final LocalDate end;
    private LeaveStatus status = LeaveStatus.PENDING;
    private Reviewer reviewedBy;

    LeaveRequest(Employee employee, LocalDate start, LocalDate end) {
        this.employee = employee;
        this.start = start;
        this.end = end;
    }

    /** Only Pending -> Approved/Rejected is valid, and only with a reviewer. */
    public void changeStatus(LeaveStatus target, Reviewer reviewer) {
        if (status != LeaveStatus.PENDING || target == LeaveStatus.PENDING)
            throw new IllegalStateException("Cannot change leave request status from " + status + " to " + target + ".");
        if (reviewer == null)
            throw new IllegalStateException("A reviewer is required to " + target.toString().toLowerCase() + " a request.");
        status = target;
        reviewedBy = reviewer;
    }

    public void approve(Reviewer r) { changeStatus(LeaveStatus.APPROVED, r); }
    public void reject(Reviewer r) { changeStatus(LeaveStatus.REJECTED, r); }

    public int getDays() { return (int) (end.toEpochDay() - start.toEpochDay()) + 1; }

    public String periodLabel() {
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MMM d", Locale.ENGLISH);
        if (start.getMonth() == end.getMonth() && start.getYear() == end.getYear())
            return month.format(start) + "-" + end.getDayOfMonth();
        return month.format(start) + "-" + month.format(end);
    }

    public Employee getEmployee() { return employee; }
    public LocalDate getStart() { return start; }
    public LocalDate getEnd() { return end; }
    public LeaveStatus getStatus() { return status; }
    public Reviewer getReviewedBy() { return reviewedBy; }
}
