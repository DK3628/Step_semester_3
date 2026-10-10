import java.util.*;

public class Examination {
    private final String title;
    private final List<Question> questions = new ArrayList<>();
    private final Set<Student> studentsWhoSubmitted = new HashSet<>();

    public Examination(String title) { this.title = title; }

    public void addQuestion(Question q) { questions.add(q); }
    public Question getQuestion(int number) {
        for (Question q : questions) if (q.getNumber() == number) return q;
        return null;
    }
    public int getTotalPoints() {
        int t = 0;
        for (Question q : questions) t += q.getPoints();
        return t;
    }

    public List<Question> getQuestions() { return Collections.unmodifiableList(questions); }
    public String getTitle() { return title; }

    boolean hasSubmitted(Student s) { return studentsWhoSubmitted.contains(s); }
    void recordSubmission(Student s) { studentsWhoSubmitted.add(s); }
}
