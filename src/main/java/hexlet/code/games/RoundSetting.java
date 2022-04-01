package hexlet.code.games;

public class RoundSetting {
    private final String question;
    private final String answer;

    public RoundSetting(String target, String currentAnswer) {
        this.question = String.format("Question: %s", target);
        this.answer = currentAnswer;
    }

    /**
     * Check input answer with right answer.
     *
     * @param inputAnswer User response
     * @return Is answer correct
     */
    public boolean checkAnswer(String inputAnswer) {
        return answer.equals(inputAnswer);
    }

    /**
     * Return current question string.
     *
     * @return Current question string.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Return right answer.
     *
     * @return Right answer.
     */
    public String getAnswer() {
        return answer;
    }
}
