import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Base class for all assignments. Each subclass supplies only its own
 * late-penalty rate; the grading workflow never changes for new types.
 * Assignment owns the "days late" calculation since it knows the due date.
 */
public abstract class Assignment {
    private final String title;
    private final double maxMarks;
    private final LocalDate dueDate;

    protected Assignment(String title, double maxMarks, LocalDate dueDate) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title is required.");
        if (maxMarks <= 0) throw new IllegalArgumentException("Max marks must be positive.");
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    /** Fraction of awarded marks lost per day late (e.g. 0.10 = 10%). */
    protected abstract double getPenaltyRatePerDay();

    public String getTypeName() { return getClass().getSimpleName(); }

    public long calculateDaysLate(LocalDate submittedOn) {
        return Math.max(0, ChronoUnit.DAYS.between(dueDate, submittedOn));
    }

    public double getPenaltyFraction(long daysLate) {
        return Math.min(1.0, getPenaltyRatePerDay() * daysLate);
    }

    public double applyLatePenalty(double awardedMarks, long daysLate) {
        double result = awardedMarks * (1.0 - getPenaltyFraction(daysLate));
        return Math.round(result * 100.0) / 100.0;
    }

    public String getTitle() { return title; }
    public double getMaxMarks() { return maxMarks; }
    public LocalDate getDueDate() { return dueDate; }
}
