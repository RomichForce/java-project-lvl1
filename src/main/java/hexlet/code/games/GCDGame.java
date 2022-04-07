package hexlet.code.games;

import hexlet.code.Engine;

public final class GCDGame extends Engine {
    private static final String START_MESSAGE = "Find the greatest common divisor of given numbers.";
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 100;

    public GCDGame() {
        super(START_MESSAGE);
    }

    public RoundSetting setNextRound() {
        final int firstValue = getRandomValue(RAND_MIN, RAND_MAX);
        final int secondValue = getRandomValue(RAND_MIN, RAND_MAX);

        final String questTarget = String.format("%d %d", firstValue, secondValue);
        final String rightAnswer = String.valueOf(getGCD(firstValue, secondValue));
        return new RoundSetting(questTarget, rightAnswer);
    }

    private int getGCD(int firstValue, int secondValue) {
        if (secondValue == 0) {
            return firstValue;
        }
        return getGCD(secondValue, firstValue % secondValue);
    }
}
