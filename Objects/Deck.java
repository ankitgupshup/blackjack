package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deckContents;
	private String[] Suits = {"C", "D", "H", "S"}; //Clubs, Diamonds, Hearts, Spades
	private String[] Ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private int count;

	public Deck() {
		deckContents = new ArrayList<Card>();
		for (String suit : Suits) {
			for (String rank : Ranks) {
				deckContents.add(new Card(suit,rank));
			}		
		}
		count = deckContents.size();
	}

	public void deal(Hand player, boolean show) {
		Card dealtCard = deckContents.get(0);
		deckContents.remove(0);
		player.take(dealtCard, show);
		count = deckContents.size();
	}

	public void shuffle() {
		ArrayList<Card> newDeckContents = new ArrayList<Card>();
		Random rand = new Random();
		int count = deckContents.size();
		int track = 0;
		for (int i=0; i < count; i++){
			track = count - i;
			int index = rand.nextInt(track);
			Card a = deckContents.get(index);
			deckContents.remove(index);
			newDeckContents.add(i, a);
		}
		deckContents = newDeckContents;
	}

	public void displayDeck() {
		for (Card card: deckContents ){
			card.display();
		}
	}


}