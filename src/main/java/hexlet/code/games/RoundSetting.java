package hexlet.code.games;

public final class RoundSetting {
    private final String question;
    private final String answer;

    public RoundSetting(String target, String currentAnswer) {
        this.question = String.format("Question: %s", target);
        this.answer = currentAnswer;
    }

    public boolean checkAnswer(String inputAnswer) {
        return answer.equals(inputAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
