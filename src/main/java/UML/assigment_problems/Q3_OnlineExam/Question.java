/** Each question type defines its own evaluation rule. */
public abstract class Question {
    private final int number;
    private final String text;
    private final int points;

    protected Question(int number, String text, int points) {
        this.number = number;
        this.text = text;
        this.points = points;
    }

    protected abstract boolean isCorrect(String response);

    /** Common scoring: full points if correct, else 0. */
    public final int evaluate(String response) {
        return (response != null && isCorrect(response)) ? points : 0;
    }

    public int getNumber() { return number; }
    public String getText() { return text; }
    public int getPoints() { return points; }
}
