package hexlet.code;

import hexlet.code.games.GameEnum;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Scanner;

public final class Menu {
    private static final Scanner SCAN = new Scanner(System.in);

    public void show() {
        Integer currentChoice;
        Pair<String, Engine> gameItem;
        printGameList();
        while (true) {
            System.out.print("Your choice: ");
            currentChoice = parseInt(SCAN.next());
            if (currentChoice != null && currentChoice == 0) {
                return;
            }
            gameItem = gatGameItem(currentChoice);
            if (gameItem == null) {
                System.out.println("Incorrect data. Please repeat.");
                continue;
            }
            break;
        }
        startGame(currentChoice);
    }

    private static void printGameList() {
        System.out.println("Please enter the game number and press Enter.");
        for (var i = 0; i < GameEnum.LIST.length; i++) {
            System.out.printf("%d - %s\n", i + 1, GameEnum.LIST[i].name());
        }
        System.out.println("0 - Exit");
    }

    private void startGame(int gameId) {
        final var selectGame = GameEnum.getGame(gameId);
        assert selectGame != null;
        selectGame.getRight().runGame();
    }

    private Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Pair<String, Engine> gatGameItem(Integer choice) {
        if (choice == null) {
            return null;
        }
        return GameEnum.getGame(choice);
    }
}
