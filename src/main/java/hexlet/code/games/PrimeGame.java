package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame extends Engine {
    private static final String START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 100;

    public PrimeGame() {
        super(START_MESSAGE);
    }

    private int getRandomValue() {
        return RAND.nextInt(RAND_MIN, RAND_MAX);
    }

    private boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if ((value % i) == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Set up new data for the next round.
     *
     * @return Data for the next round.
     */
    public RoundSetting setNextRound() {
        final int target = getRandomValue();
        final String rightAnswer = isPrime(target) ? "yes" : "no";
        return new RoundSetting(String.valueOf(target), rightAnswer);
    }
}
