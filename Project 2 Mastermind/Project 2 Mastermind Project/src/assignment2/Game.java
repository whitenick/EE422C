package assignment2;

import java.util.Scanner;
import java.lang.Character;

public class Game {
	GameConfiguration currentGame;
	int numberGames = 1;
	boolean testingMode = false;
	public static int iterator = 0;
	public Game(){
		this(null, false);
	}
	public Game(Scanner input, boolean userNumber){
		testingMode = userNumber;
		if(testingMode == true) {
			TestingMode.edit(input);
		}
	}
	
	public static boolean Intro(Scanner input){
		System.out.print("Welcome to MASTERMIND. Here are the rules.\n\nThis is a text version of the classic board game Mastermind.\nThe computer will think of a secret code. The code consists of 4 \ncolored pegs. \nThe pegs MUST be one of six colors: blue, green, orange, purple, \nred, or yellow. A color may appear more than once in the code. You \ntry to guess what colored pegs are in the code and what order they \nare in. After you make a valid guess the result (feedback) will be \ndisplayed. \nThe result consists of a black peg for each peg you have guessed \nexactly correct (color and position) in your guess. For each peg in \nthe guess that is the correct color, but is out of position, you get \na white peg. For each peg that is fully incorrect, you get no \nfeedback. \nOnly the first letter of the color is displayed. B for Blue, R for \nRed, and so forth. \nWhen entering guesses you only need to enter the first character of \neach color as a capital letter. \n\nYou have 12 guesses to figure out the secret code or you lose the \ngame. Are you ready to play? (Y/N) : ");
		char result = input.next().charAt(0);
		if(result == 'Y'){
			System.out.println("\nLet's Play!");
			return true;
		}
		else {
			System.out.println("\nGoodbye");
			return false;
		}
}
	public void runGame(Scanner input, Human user){
		while(!user.gameFinish){
			if(!user.invalidGuess){																//Intro for analyzing valid input (could be put into method)
				System.out.println("You have " + user.userGuesses + " guesses left.");
			}
			System.out.println("What is your next guess?");
			System.out.print("Type in the characters from your guess and press enter.\nEnter Guess: ");
			user.userInput = input.next();
			if (user.userInput.equalsIgnoreCase("HISTORY")) {
				Human.History();
				continue;
			}
			user.numberChar = user.userInput.length();
			user.invalidGuess = false;
			if(user.userInput.length()!=Parameters.numberPeg) {
				System.out.println(user.userInput + "--> INVALID GUESS");
				user.invalidGuess = true;
			}
			if(!user.invalidGuess){
				for(int i = 0; i<user.userInput.length(); i++){
					if(!Character.isUpperCase(user.userInput.charAt(i))){
						System.out.println(user.userInput + " --> INVALID GUESS\n");
						user.invalidGuess = true;
						break;
					}
				}
			}
			if(user.invalidGuess == false) {		//start gameEngine
				Parameters.previousGuesses[iterator] = user.userInput;
				user.userAttempt = user.userInput.toCharArray();
				
				Computer.gameEngine(user);
				user.userGuesses--;
			}
			
			//Print guessing results to console 
			
			System.out.print("\n" + user.userInput + " --> Result: ");
			
			if(user.blackPegs>0){
				if(user.blackPegs>1){
					System.out.print(user.blackPegs + " black pegs, ");
				}
				else {
					System.out.print(user.blackPegs + " black peg, ");
				}
				Parameters.previousBlackPegs[iterator] = user.blackPegs;
			}
			if(user.whitePegs>0){
					if(user.whitePegs>1){
						System.out.println(user.whitePegs + " white pegs");
					}
					else {
						System.out.println(user.whitePegs + " white peg");
					}
					Parameters.previousWhitePegs[iterator] = user.whitePegs;
					System.out.print("\n");
				}
			else if((user.whitePegs & user.blackPegs) == 0) {
				System.out.println("No pegs\n");
			}
			
			if (user.gameWon == true){
				System.out.println(" --You Win!!");
			}
			
			if (user.userGuesses == 0)	{
				System.out.println("\nSorry, you are out of guesses. You lose, boo-hoo");
			}
			
			iterator++;
			
			//prompt for another game 
			
			if(user.userGuesses == 0 || user.gameWon == true){
				System.out.print("\nAre you ready for another game? (Y/N): ");
				char result = input.next().charAt(0);
				if(result == 'Y'){
					System.out.println("\nLet's Play!");
					user.gameFinish = false;
					iterator = 0;
					user.userGuesses = TestingMode.userGuesses;
						
				}
				else {
					System.out.println("\nGoodbye");
					user.gameFinish = true;
				}
			}
			
			//debug tools
			if(testingMode == true){	
				System.out.println("\n" + Computer.randomCode + "\n");
			}
		
		}
		
		return;
	
	}
}


class Parameters extends Game{
	public Parameters(){
		
	}
	public static int guesses = TestingMode.userGuesses;
	public String[] colors = TestingMode.colorStringArray;
	public static int numberPeg = TestingMode.pegCount;
	public static String[] previousGuesses = new String[TestingMode.userGuesses];
	public static int[] previousBlackPegs = new int[TestingMode.userGuesses];
	public static int[] previousWhitePegs = new int[TestingMode.userGuesses];
}


class Human extends Parameters{
		int userGuesses = Parameters.guesses;
		public static final int maxGuesses = Parameters.guesses;
		String userInput = null;
		int[] colorNumber = new int[this.colors.length];
		public char[] userAttempt = null;
		int numberChar = 0; 
		boolean invalidGuess = false;
		boolean gameFinish = false;
		boolean gameWon = false;
		int blackPegs = 0;
		int whitePegs = 0;
		public static void History(){
			for(int i = 0; i<iterator; i++){
				System.out.println(previousGuesses[i] + "		" + previousBlackPegs[i] + "B_" + previousWhitePegs[i] + "W" );
				
			}
		};
}


class Computer extends Parameters {
	public static String randomCode = SecretCodeGenerator.getInstance().getNewSecretCode();
	public static char[] secretCode = null;
	public static void gameEngine(Human user){
		Computer.secretCode = Computer.randomCode.toCharArray();
		user.blackPegs = 0;
		user.whitePegs = 0;
		for(int i = 0; i<user.numberChar; i++) {
			for(int k = 0; k<user.numberChar; k++){
				if(user.userInput.charAt(i) == randomCode.charAt(k)){
					if(secretCode[k] != '-'){
						if(i==k){
							user.blackPegs++;
							user.userAttempt[i] = '-';
							secretCode[k] = '-';
							break;
						}
						else {
							user.whitePegs++;
							user.userAttempt[i] = '-';
							secretCode[k] = '-';
							break;
						}
					}
				}
			}
		}
		if(user.blackPegs == TestingMode.pegCount && user.whitePegs == 0){
			user.gameWon = true;
		}
	}
 }
