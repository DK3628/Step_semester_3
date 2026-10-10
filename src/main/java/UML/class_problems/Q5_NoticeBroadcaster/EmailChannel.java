public class EmailChannel implements NotificationChannel {
    @Override public String getName() { return "Email"; }
    @Override public void send(Student s, String msg) { System.out.println("[Email → " + s.getName() + "] " + msg); }
}
