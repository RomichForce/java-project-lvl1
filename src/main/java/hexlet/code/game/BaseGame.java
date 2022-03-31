package hexlet.code.game;

import java.util.Scanner;

public abstract class BaseGame {
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String CORRECT_MESSAGE = "Correct!";
    private static final String UNCORRECT_MESSAGE =
            "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n";
    private static final String SUCCESS_MESSAGE = "Congratulations, %s!\n";
    private static final int ROUND_COUNT = 3;
    private static final Scanner SCAN = new Scanner(System.in);

    private final String startMessage;
    private String playerName;
    private RoundSetting roundSetting;

    public BaseGame(String message) {
        this.startMessage = message;
    }

    /**
     * Input answer on question.
     *
     * @return User response
     */
    public String inputAnswer() {
        System.out.print("Your answer:\t");
        return SCAN.next();
    }

    private void getPlayerName() {
        System.out.print("May I have your name?\t");
        this.playerName = SCAN.next();
        System.out.printf("Hello, %s!\n", playerName);
    }

    /**
     * Start the game.
     */
    public void runGame() {
        getPlayerName();
        System.out.println(WELCOME_MESSAGE);
        System.out.println(startMessage);
        for (var i = 0; i < ROUND_COUNT; i++) {
            this.roundSetting = setNextRound();
            System.out.println(roundSetting.getQuestion());
            final String inputAnswer = inputAnswer();
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
}
