public class MultipleChoiceQuestion extends Question {
    private final String correctOption;
    public MultipleChoiceQuestion(int number, String text, int points, String correctOption) {
        super(number, text, points);
        this.correctOption = correctOption;
    }
    @Override protected boolean isCorrect(String r) { return correctOption.equalsIgnoreCase(r.trim()); }
}
