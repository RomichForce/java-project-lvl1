package hexlet.code;

import hexlet.code.games.RoundSetting;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Engine {
    protected static final ThreadLocalRandom RAND = ThreadLocalRandom.current();
    private static final String WELCOME_MESSAGE = "\nWelcome to the Brain Games!";
    private static final String CORRECT_MESSAGE = "Correct!";
    private static final String UNCORRECT_MESSAGE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n";
    private static final String SUCCESS_MESSAGE = "Congratulations, %s!\n";
    private static final int ROUND_COUNT = 3;
    private static final Scanner SCAN = new Scanner(System.in);

    private final String startMessage;
    private String playerName;
    private RoundSetting roundSetting;

    public Engine(String message) {
        this.startMessage = message;
    }

    /**
     * Running the game.
     */
    public void runGame() {
        getPlayerName();
        System.out.println(startMessage);
        for (var i = 0; i < ROUND_COUNT; i++) {
            this.roundSetting = setNextRound();
            System.out.println(roundSetting.getQuestion());
            final String inputAnswer = getUserInput("Your answer:");
            final String rightAnswer = roundSetting.getAnswer();
            if (roundSetting.checkAnswer(inputAnswer)) {
                System.out.println(CORRECT_MESSAGE);
            } else {
                System.out.printf(UNCORRECT_MESSAGE, inputAnswer, rightAnswer, playerName);
                return;
            }
        }
        System.out.printf(SUCCESS_MESSAGE, playerName);
    }

    public abstract RoundSetting setNextRound();

    public final String getUserInput(String prefix) {
        System.out.printf("%s ", prefix);
        return SCAN.next();
    }

    protected final void getPlayerName() {
        System.out.println(WELCOME_MESSAGE);
        this.playerName = getUserInput("May I have your name?");
        System.out.printf("Hello, %s!\n", playerName);
    }

    protected final int getRandomValue(int startRange, int endRange) {
        return RAND.nextInt(startRange, endRange);
    }
}
