package blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	static Deck theDeck = new Deck();
	static Hand dealerHand;
	static Hand playerHand;
	static int playerMoney = 10;
	static int playerBet;
	static int roundCount;
	static boolean gameOver=false;
	static String nameOfPlayer;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to BlackJack! What is your name?");
		nameOfPlayer = input.nextLine();
		while(true){
			System.out.println();
			System.out.println(nameOfPlayer + ", what would you like to do?");
			System.out.println("1: New Deck");
			System.out.println("2: Shuffle Cards"); // 
			System.out.println("3: Display All Cards in Deck");
			System.out.println("4: Play BlackJack");
			System.out.println("5: RESET GAME"); // New deck, player has $10
			System.out.println("6: QUIT PROGRAM");
			String line = input.nextLine();
			if (line.equals("6")){
				return;
			}
			else {
				try {
					menu(line);
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("Exception thrown  :" + e);
					System.out.println("No more cards! Go back to menu for new deck.");
				}
			}
		}
	}
	
	private static void menu(String line){
		if (line.equals("1")) {
			theDeck = new Deck();
			System.out.println("New deck made.");
		}
		else if (line.equals("2")){
			theDeck.shuffle();
			System.out.println("Deck is now shuffled.");
		}
		else if (line.equals("3")){
			System.out.println();
			theDeck.displayDeck();
		}
		else if (line.equals("4")){
			while (playerMoney > 0) {
				startPlay();
				gameOver = false;
				System.out.println("You have " + Integer.toString(playerMoney) + " dollars.");
				System.out.println("Do you want to play again? (Y/N)");
				String choice = input.nextLine();
				if (!choice.toUpperCase().equals("Y")){
					return;
				}
			}
			System.out.println("You have no more money, loser. You cannot play unless you reset.");
		}
		else if (line.equals("5")){
			theDeck = new Deck();
			playerMoney = 10;
			System.out.println("Game is now reset. Choose 2 to shuffle.");
		}
		else {
			System.out.println("That is not an option!");
		}

	}

	private static void startPlay(){
		dealerHand = new Hand("Dealer");
		playerHand = new Hand(nameOfPlayer);
		roundCount = 1;
		askBet();
		while (playerBet > playerMoney){
			System.out.println("You cannot bet that much!");
			askBet();
		}
		theDeck.deal(dealerHand, false);
		theDeck.deal(playerHand, false);
		theDeck.deal(dealerHand, false);
		theDeck.deal(playerHand, false);
		reveal();
		while(!gameOver){
			askPlayer();
		}
	}
	
	private static void askBet(){
		System.out.println("You have " + Integer.toString(playerMoney) + " dollars. How much do you wanna bet?");
		String bet = input.nextLine();
		try {
			playerBet = Integer.valueOf(bet).intValue();
		}
		catch (NumberFormatException e){
			System.out.println("Exception thrown  :" + e);
			System.out.println("Please put in an integer.");
		}
	}

	private static void askPlayer() {
		System.out.println();
		System.out.println("Do you want another card? (Y/N)");
		String choice = input.nextLine();
		if (choice.toUpperCase().equals("Y") ){
			roundCount += 1;
			theDeck.deal(playerHand, true);
			if (playerHand.netValue > 21){
				System.out.println("Your hand went over 21!");
				dealerWins();
			}
			else{
				reveal();
			}
		}
		else if (choice.toUpperCase().equals("N")){
			while(!gameOver){
				dealerDraws();
			}
		}
		else {
			System.out.println("Pick either Y or N !");
		}
	}


	private static void dealerDraws() {
		if (dealerHand.netValue > 21){
			System.out.println("Dealer's hand went over 21!");
			playerWins();
		}
		else if (dealerHand.netValue <= 16){
			theDeck.deal(dealerHand, true);
		}
		else {
			System.out.println("Dealer stands.");
			if (playerHand.netValue < dealerHand.netValue) {
				dealerWins();
			}
			else if (playerHand.netValue > dealerHand.netValue){
				playerWins();
			}
			else {
				playerWins();
				System.out.println("It's a tie!");
			}
		}
	}

	private static void reveal(){
		System.out.println();
		System.out.println("ROUND " + Integer.toString(roundCount) + ":");
		dealerHand.hiddenDisplay();
		playerHand.display();
	}

	private static void endReveal(){
		System.out.println();
		System.out.println("RESULTS:");
		dealerHand.display();
		playerHand.display();
	}
	
	private static void dealerWins() {
		endReveal();
		System.out.println();
		System.out.println("Dealer wins!");
		playerMoney -= playerBet;
		gameOver=true;
	}

	private static void playerWins(){
		endReveal();
		System.out.println();
		System.out.println(nameOfPlayer + ", you win!");
		playerMoney += playerBet;
		gameOver=true;
	}


}
