public class TrueFalseQuestion extends Question {
    private final boolean correctAnswer;
    public TrueFalseQuestion(int number, String text, int points, boolean correctAnswer) {
        super(number, text, points);
        this.correctAnswer = correctAnswer;
    }
    @Override protected boolean isCorrect(String r) { return Boolean.parseBoolean(r.trim()) == correctAnswer
            && (r.trim().equalsIgnoreCase("true") || r.trim().equalsIgnoreCase("false")); }
}
