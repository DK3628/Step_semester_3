public class SmsChannel implements NotificationChannel {
    @Override public String getName() { return "SMS"; }
    @Override public void send(Student s, String msg) { System.out.println("[SMS → " + s.getName() + "] " + msg); }
}
