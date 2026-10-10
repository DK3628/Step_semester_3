import java.util.*;

public class Student {
    private final String name;
    private final String department;
    private final Set<NotificationChannel> preferredChannels = new LinkedHashSet<>();

    public Student(String name, String department, NotificationChannel... channels) {
        this.name = name;
        this.department = department;
        for (NotificationChannel c : channels) preferredChannels.add(c);
    }

    public void addChannel(NotificationChannel c) { preferredChannels.add(c); }
    public void removeChannel(NotificationChannel c) { preferredChannels.remove(c); }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public Set<NotificationChannel> getPreferredChannels() { return Collections.unmodifiableSet(preferredChannels); }
}
