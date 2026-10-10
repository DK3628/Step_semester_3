/** Abstraction used by NoticeBoard. Add WhatsApp etc. by implementing this. */
public interface NotificationChannel {
    String getName();
    void send(Student student, String message);
}
