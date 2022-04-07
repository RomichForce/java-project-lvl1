package hexlet.code.games;

import hexlet.code.Engine;

public final class EvenGame extends Engine {
    private static final String START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 100;

    public EvenGame() {
        super(START_MESSAGE);
    }

    public RoundSetting setNextRound() {
        final int target = getRandomValue(RAND_MIN, RAND_MAX);
        final String rightAnswer = target % 2 == 0 ? "yes" : "no";
        return new RoundSetting(String.valueOf(target), rightAnswer);
    }
}
