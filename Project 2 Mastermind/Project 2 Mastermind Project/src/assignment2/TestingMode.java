package assignment2;

import java.util.Scanner;

public class TestingMode extends GameConfiguration {
	public static int userGuesses = guessNumber;
	public static int numberColors = colors.length;
	public static String[] colorStringArray = colors;
	public static int pegCount = pegNumber;
		public static void edit(Scanner input){
			System.out.print("Enter Desired Number of Guesses: ");
			userGuesses = input.nextInt();
			System.out.println("\nEnter Desired Number of Pegs: ");
			pegCount = input.nextInt();
			System.out.print("\nEnter Desired Colors: ");
			String colorString = input.next();
			int colorLength = colorString.length();
			String[] colorArray = new String[colorLength];
			colorStringArray = colorArray;
		}
	}

