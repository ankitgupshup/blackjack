package blackjack;

public class Card {
	private String suit;
	public String rank;
	public int value;

	public Card(String inputSuit, String inputRank){
		suit = inputSuit;
		rank = inputRank;
		if (rank.equals("A")){
			value = 1; //This will be specified 1 or 11 in Hand.java
		}
		else if (rank.equals("K") || rank.equals("J") || rank.equals("Q")) {
			value = 10;
		}
		else {
			value = Integer.parseInt(rank); //Integer.valueOf(rank).intValue();
		}
		
	}

	public void display() {
		String fullSuit;
		String fullRank;
		
		if (suit.equals("C")){
			fullSuit = "Clubs";
		}
		else if (suit.equals("D")){
			fullSuit = "Diamonds";
		}
		else if (suit.equals("H")){
			fullSuit = "Hearts";
		}
		else {
			fullSuit = "Spades";
		}
		
		if (rank.equals("A")){
			fullRank = "Ace";
		}
		else if (rank.equals("K") ){
			fullRank = "King";
		}
		else if (rank.equals("J")){
			fullRank = "Jack";
		}
		else if (rank.equals("Q")){
			fullRank = "Queen";
		}
		else {
			fullRank = rank;
		}

		System.out.println(fullRank + " of " + fullSuit);
	}

}