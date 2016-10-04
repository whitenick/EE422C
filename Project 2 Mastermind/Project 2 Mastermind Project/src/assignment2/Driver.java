package assignment2;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		boolean humanPlayer = false;
		Scanner inputScan = new Scanner(System.in);
		humanPlayer = Game.Intro(inputScan);
		if(humanPlayer == false) {
			System.exit(0);
		}
		humanPlayer = false;
		if(args.length > 0 && args[0].equals("1")) {
			humanPlayer = true;
		}
		else {
			humanPlayer = false;
		}
		Game startGame = new Game(inputScan, humanPlayer);
		System.out.println("\nGenerating secret code...\n");
		Human gameUser = new Human();
		gameUser.userInput = inputScan.nextLine();
		startGame.runGame(inputScan, gameUser);
	}
}



