import java.util.*;

/** Tracks student, exam, answers and state. Answers are frozen after submission. */
public class Attempt {
    private final Student student;
    private final Examination exam;
    private final Map<Integer, Answer> answers = new LinkedHashMap<>();
    private AttemptStatus status = AttemptStatus.IN_PROGRESS;
    private final Map<Integer, Integer> questionScores = new LinkedHashMap<>();
    private int totalScore;

    Attempt(Student student, Examination exam) { this.student = student; this.exam = exam; }

    public void recordAnswer(Question q, String response) {
        if (status == AttemptStatus.SUBMITTED)
            throw new IllegalStateException("Cannot change answers for a submitted examination.");
        answers.put(q.getNumber(), new Answer(q, response));
    }

    /** Evaluates every question polymorphically; no type checks needed. */
    void submit() {
        if (status == AttemptStatus.SUBMITTED)
            throw new IllegalStateException("Examination already submitted.");
        status = AttemptStatus.SUBMITTED;
        totalScore = 0;
        for (Question q : exam.getQuestions()) {
            Answer a = answers.get(q.getNumber());
            int pts = q.evaluate(a == null ? null : a.getResponse());
            questionScores.put(q.getNumber(), pts);
            totalScore += pts;
        }
    }

    public Student getStudent() { return student; }
    public Examination getExam() { return exam; }
    public AttemptStatus getStatus() { return status; }
    public int getTotalScore() { return totalScore; }
    public Map<Integer, Integer> getQuestionScores() { return Collections.unmodifiableMap(questionScores); }
}
