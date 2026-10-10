import java.util.*;

/** Finds target students and delivers via each preferred channel, using only the interface. */
public class NoticeBoard {
    private final List<Student> students = new ArrayList<>();

    public void registerStudent(Student s) { students.add(s); }

    public void post(Notice notice) {
        System.out.println("Notice '" + notice.getTitle() + "' posted to "
                + String.join(", ", notice.getTargetDepartments()) + ".");
        for (Student s : students) {
            if (!notice.getTargetDepartments().contains(s.getDepartment())) continue;
            for (NotificationChannel ch : s.getPreferredChannels()) {
                ch.send(s, notice.getTitle());
            }
        }
    }
}
