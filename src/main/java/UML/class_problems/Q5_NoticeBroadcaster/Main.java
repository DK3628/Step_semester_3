import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        NotificationChannel email = new EmailChannel(), sms = new SmsChannel(), app = new AppChannel();
        NoticeBoard board = new NoticeBoard();
        board.registerStudent(new Student("Asha", "CSE", email, app));
        board.registerStudent(new Student("Ravi", "ECE", sms));

        post(board, "Lab Closed Tomorrow", "CSE");
        post(board, "Fee Deadline Extended", "CSE", "ECE");
        post(board, "Sports Day");   // no department -> rejected
    }

    private static void post(NoticeBoard board, String title, String... depts) {
        try {
            board.post(new Notice(title, depts));
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: " + e.getMessage());
        }
    }
}
