package hexlet.code;

import java.util.Scanner;

public class Cli {
	public static void greetingUser() {
		Scanner inRead = new Scanner(System.in);
		System.out.print("May I have your name?\t");
		final var name = inRead.next();
		System.out.println("Hello, " + name + "!");
	}
}
