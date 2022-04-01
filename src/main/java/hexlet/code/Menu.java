package hexlet.code;

import hexlet.code.games.GameEnum;

import java.util.Scanner;

public class Menu {
    private final Scanner inRead = new Scanner(System.in);

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        for (var i = 0; i < GameEnum.LIST.length; i++) {
            System.out.printf("%d - %s\n", i + 1, GameEnum.LIST[i].name());
        }
        System.out.println("0 - Exit");
    }

    private void startGame(int gameId) {
        final var selectGame = GameEnum.getGame(gameId);
        if (selectGame == null || selectGame.getRight() == null) {
            System.out.println("This game is currently unavailable. Please choose another.");
            return;
        }
        System.out.println("You choice: " + selectGame.getLeft());
        selectGame.getRight().runGame();
    }

    /**
     * Print menu for run the game.
     */
    public void run() {
        while (true) {
            int currentChoice;
            printMenu();
            System.out.print("Your choice:\t");
            if (inRead.hasNextInt()) {
                currentChoice = inRead.nextInt();
            } else {
                System.out.println("Incorrect data. Please repeat.");
                inRead.next();
                continue;
            }
            if (currentChoice == 0) {
                return;
            }
            startGame(currentChoice);
        }
    }
}
