public class Answer {
    private final Question question;
    private final String response;
    public Answer(Question question, String response) { this.question = question; this.response = response; }
    public Question getQuestion() { return question; }
    public String getResponse() { return response; }
}
