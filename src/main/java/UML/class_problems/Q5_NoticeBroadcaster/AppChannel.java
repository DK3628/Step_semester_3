public class AppChannel implements NotificationChannel {
    @Override public String getName() { return "App"; }
    @Override public void send(Student s, String msg) { System.out.println("[App → " + s.getName() + "] " + msg); }
}
