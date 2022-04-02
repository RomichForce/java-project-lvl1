package hexlet.code;

import hexlet.code.games.GameEnum;

import java.util.Scanner;

public class Menu {
    private static final Scanner SCAN = new Scanner(System.in);

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        for (var i = 0; i < GameEnum.LIST.length; i++) {
            System.out.printf("%d - %s\n", i + 1, GameEnum.LIST[i].name());
        }
        System.out.println("0 - Exit");
    }

    private void startGame(int gameId) {
        final var selectGame = GameEnum.getGame(gameId);
        if (selectGame == null) {
            System.out.println("This game is not listed. Please choose another.");
            return;
        }
        System.out.println();
        selectGame.getRight().runGame();
    }

    private Integer tryParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Print menu for run the game.
     */
    public void run() {
        while (true) {
            Integer currentChoice;
            printMenu();
            System.out.print("Your choice: ");
            currentChoice = tryParseInt(SCAN.next());
            if (currentChoice == null) {
                System.out.println("Incorrect data. Please repeat.");
                continue;
            }
            if (currentChoice == 0) {
                return;
            }
            startGame(currentChoice);
        }
    }
}
