public class Main {
    public static void main(String[] args) {
        Examination examA = new Examination("Exam A");
        examA.addQuestion(new MultipleChoiceQuestion(1, "Which is a Java keyword?", 5, "C"));
        examA.addQuestion(new TrueFalseQuestion(2, "Java supports multiple class inheritance.", 5, false));

        ExamService service = new ExamService();
        Student s1 = new Student("Student 1");

        Attempt attempt = service.start(s1, examA);
        service.answer(attempt, 1, "C");
        service.answer(attempt, 2, "True");
        service.submit(attempt);
        service.answer(attempt, 1, "A");   // blocked
    }
}
