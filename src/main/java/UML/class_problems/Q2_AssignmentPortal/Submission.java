import java.time.LocalDate;

/** Holds student, assignment, date and status. Status can only change via submit/grade rules. */
public class Submission {
    private final Student student;
    private final Assignment assignment;
    private LocalDate submissionDate;
    private SubmissionStatus status;
    private long daysLate;
    private double finalMarks;

    public Submission(Student student, Assignment assignment, LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.daysLate = assignment.calculateDaysLate(submissionDate);
        this.status = SubmissionStatus.SUBMITTED;
    }

    /** Re-submit before grading is allowed; after grading it is blocked. */
    public void resubmit(LocalDate newDate) {
        if (status == SubmissionStatus.GRADED)
            throw new IllegalStateException("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
        this.submissionDate = newDate;
        this.daysLate = assignment.calculateDaysLate(newDate);
    }

    /** Final marks are computed at grading time. */
    public void grade(double awardedMarks) {
        if (status != SubmissionStatus.SUBMITTED)
            throw new IllegalStateException("Cannot grade: '" + assignment.getTitle() + "' is not in Submitted state.");
        if (awardedMarks < 0 || awardedMarks > assignment.getMaxMarks())
            throw new IllegalArgumentException("Marks must be between 0 and " + assignment.getMaxMarks());
        this.finalMarks = assignment.applyLatePenalty(awardedMarks, daysLate);
        this.status = SubmissionStatus.GRADED;
    }

    public Student getStudent() { return student; }
    public Assignment getAssignment() { return assignment; }
    public LocalDate getSubmissionDate() { return submissionDate; }
    public SubmissionStatus getStatus() { return status; }
    public long getDaysLate() { return daysLate; }
    public double getFinalMarks() { return finalMarks; }
}
