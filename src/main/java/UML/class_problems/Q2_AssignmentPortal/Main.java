import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Assignment lab = new CodingAssignment("Linked List Lab", 50, LocalDate.of(2025, 3, 10));
        Assignment essay = new WrittenAssignment("Design Essay", 50, LocalDate.of(2025, 3, 12));
        Student asha = new Student("Asha"), ravi = new Student("Ravi");
        SubmissionPortal portal = new SubmissionPortal();

        portal.submit(asha, lab, LocalDate.of(2025, 3, 10));
        portal.submit(ravi, essay, LocalDate.of(2025, 3, 14));
        portal.grade(asha, lab, 45);
        portal.grade(ravi, essay, 40);
        portal.submit(asha, lab, LocalDate.of(2025, 3, 11));  // blocked
    }
}
