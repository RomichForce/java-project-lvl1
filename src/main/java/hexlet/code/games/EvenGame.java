package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame extends Engine {
    private static final String START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 100;

    public EvenGame() {
        super(START_MESSAGE);
    }

    private int getRandomValue() {
        return RAND.nextInt(RAND_MIN, RAND_MAX);
    }

    /**
     * Set up new data for the next round.
     *
     * @return Data for the next round.
     */
    public RoundSetting setNextRound() {
        final int target = getRandomValue();
        final String rightAnswer = target % 2 == 0 ? "yes" : "no";
        return new RoundSetting(String.valueOf(target), rightAnswer);
    }
}
