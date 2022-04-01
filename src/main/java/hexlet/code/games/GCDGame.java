package hexlet.code.games;

import hexlet.code.Engine;

public class GCDGame extends Engine {
    private static final String START_MESSAGE = "Find the greatest common divisor of given numbers.";
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 100;

    public GCDGame() {
        super(START_MESSAGE);
    }

    private int getRandomValue() {
        return RAND.nextInt(RAND_MIN, RAND_MAX);
    }

    public int getGCD(int firstValue, int secondValue) {
        if (secondValue == 0) {
            return firstValue;
        }
        return getGCD(secondValue, firstValue % secondValue);
    }

    /**
     * Set up new data for the next round.
     *
     * @return Data for the next round.
     */
    public RoundSetting setNextRound() {
        final int firstValue = getRandomValue();
        final int secondValue = getRandomValue();

        final String questTarget = String.format("%d %d", firstValue, secondValue);
        final String rightAnswer = String.valueOf(getGCD(firstValue, secondValue));
        return new RoundSetting(questTarget, rightAnswer);
    }
}
