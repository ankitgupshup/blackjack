package blackjack;

import java.util.ArrayList;


public class Hand {
	private String nameOfPlayer;
	private ArrayList<Card> handContents;
	public int netValue;

	public Hand(String player) {
		nameOfPlayer = player;
		handContents = new ArrayList<Card>();
		netValue = 0;
	}

	public void display() {
		System.out.println(nameOfPlayer + ":");
		for (Card card: handContents) {
			card.display();
		}
		System.out.println(nameOfPlayer + "'s total: " + netValue);
	}
	
	public void hiddenDisplay() {
		System.out.println(nameOfPlayer + ":");
		System.out.println("<Face Down Card>");
		for (int i = 1; i<handContents.size(); i++) {
			handContents.get(i).display();
		}
	}

	public void take(Card dealtCard, boolean show) {
		handContents.add(dealtCard);
		getNetValue(dealtCard);
		if (show) {
			System.out.println();
			System.out.println(nameOfPlayer + " takes a card:");
			dealtCard.display();
		}
	}

	public void getNetValue(Card dealtCard) {
		
		if (dealtCard.rank.equals("A")){
			if (netValue <= 10) {
				netValue += 11;
			}
			else {
				netValue += 1;
			}
		}
		else {
			netValue += dealtCard.value;
		}

	}
}

