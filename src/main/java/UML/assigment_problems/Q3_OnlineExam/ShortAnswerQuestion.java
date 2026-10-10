public class ShortAnswerQuestion extends Question {
    private final String expected;
    public ShortAnswerQuestion(int number, String text, int points, String expected) {
        super(number, text, points);
        this.expected = expected;
    }
    @Override protected boolean isCorrect(String r) { return expected.trim().equalsIgnoreCase(r.trim()); }
}
