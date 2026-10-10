import java.time.LocalDate;

public class CodingAssignment extends Assignment {
    public CodingAssignment(String title, double maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }
    @Override protected double getPenaltyRatePerDay() { return 0.10; }
}
