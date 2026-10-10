import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/** Workflow for submitting and grading. Independent of concrete assignment types. */
public class SubmissionPortal {
    private final Map<String, Submission> submissions = new HashMap<>();

    private String key(Student s, Assignment a) { return s.getName() + "|" + a.getTitle(); }

    private static String fmt(double v) {
        return v == Math.rint(v) ? String.valueOf((long) v) : String.format("%.2f", v);
    }

    public void submit(Student student, Assignment assignment, LocalDate date) {
        Submission existing = submissions.get(key(student, assignment));
        try {
            Submission sub;
            if (existing == null) {
                sub = new Submission(student, assignment, date);
                submissions.put(key(student, assignment), sub);
            } else {
                existing.resubmit(date);
                sub = existing;
            }
            long late = sub.getDaysLate();
            String timing = late == 0 ? "on time" : late + (late == 1 ? " day late" : " days late");
            System.out.printf("%s's submission for '%s' received (%s). Status: %s.%n",
                    student.getName(), assignment.getTitle(), timing, sub.getStatus());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void grade(Student student, Assignment assignment, double awarded) {
        Submission sub = submissions.get(key(student, assignment));
        if (sub == null) {
            System.out.println("No submission found for " + student.getName() + " on '" + assignment.getTitle() + "'.");
            return;
        }
        try {
            sub.grade(awarded);
            String base = String.format("%s graded: %s/%s", student.getName(),
                    fmt(sub.getFinalMarks()), fmt(assignment.getMaxMarks()));
            if (sub.getDaysLate() > 0) {
                base += " after " + fmt(assignment.getPenaltyFraction(sub.getDaysLate()) * 100) + "% late penalty";
            }
            System.out.println(base + ". Status: " + sub.getStatus() + ".");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
