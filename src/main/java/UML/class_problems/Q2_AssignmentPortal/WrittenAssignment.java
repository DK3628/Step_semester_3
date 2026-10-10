import java.time.LocalDate;

public class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, double maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }
    @Override protected double getPenaltyRatePerDay() { return 0.20; }
}
