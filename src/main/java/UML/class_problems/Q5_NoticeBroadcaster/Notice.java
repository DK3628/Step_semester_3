import java.util.*;

/** A notice validates itself: a title and at least one target department are required. */
public class Notice {
    private final String title;
    private final Set<String> targetDepartments;

    public Notice(String title, String... departments) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("A title is required.");
        Set<String> depts = new LinkedHashSet<>();
        if (departments != null)
            for (String d : departments) if (d != null && !d.isBlank()) depts.add(d.trim());
        if (depts.isEmpty())
            throw new IllegalArgumentException("At least one target department is required.");
        this.title = title.trim();
        this.targetDepartments = Collections.unmodifiableSet(depts);
    }

    public String getTitle() { return title; }
    public Set<String> getTargetDepartments() { return targetDepartments; }
}
