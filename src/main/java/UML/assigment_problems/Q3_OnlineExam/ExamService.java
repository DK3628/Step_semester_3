import java.util.*;

public class ExamService {

    public Attempt start(Student student, Examination exam) {
        if (exam.hasSubmitted(student)) {
            System.out.println(student.getName() + " has already submitted " + exam.getTitle() + ".");
            return null;
        }
        System.out.println(exam.getTitle() + " started by " + student.getName() + ".");
        return new Attempt(student, exam);
    }

    public void answer(Attempt attempt, int questionNumber, String response) {
        Question q = attempt.getExam().getQuestion(questionNumber);
        if (q == null) {
            System.out.println("Question " + questionNumber + " does not exist.");
            return;
        }
        try {
            attempt.recordAnswer(q, response);
            System.out.println("Answer recorded for Question " + questionNumber + ".");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void submit(Attempt attempt) {
        Examination exam = attempt.getExam();
        Student student = attempt.getStudent();
        if (exam.hasSubmitted(student)) {
            System.out.println(student.getName() + " has already submitted " + exam.getTitle() + ".");
            return;
        }
        try {
            attempt.submit();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }
        exam.recordSubmission(student);
        System.out.println(exam.getTitle() + " submitted by " + student.getName() + ".");

        StringJoiner sj = new StringJoiner(", ");
        for (Question q : exam.getQuestions()) {
            int pts = attempt.getQuestionScores().get(q.getNumber());
            sj.add("Question " + q.getNumber() + ": " + (pts > 0 ? "Correct" : "Incorrect") + " (" + pts + " points)");
        }
        System.out.println("Result: " + sj + ". Total score: " + attempt.getTotalScore() + "/" + exam.getTotalPoints() + ".");
    }
}
