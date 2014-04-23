Object Oriented Programming Class at CSULB, Spring 2014


Simulates a BlackJack game, also known as 21. Written on Java.

Menu consists of:
1. New Deck - creates a deck of playing cards
2. Shuffling
3. Displaying all cards
4. Playing BlackJack

Option 4 plays the game. The human will play against the computer, which is the Dealer. The object of the game is to get as close as possible to 21 without going over and trying to beat the dealer's hand.


Rules:
- The dealer deals one card to the player, face up and one card to himself face down. Then he deals one card to the player face up and one card to himself face up. Then he offers a card to the player.
- The player may accept cards from the dealer, or he may "stand" (stand means that he takes no more cards). If the player gets more than 21 points, he loses immediately. When the player stops taking cards, the dealer turns over his face down card and begins to lay down cards for himself. 
- The dealer must continue to take cards until he gets 17 points or more, at which time he stops. If the dealer goes over 21, the player wins.
- If both the player and the dealer are under 21, then the one who is closest to 21 wins. If there is a tie, the player wins.
 
When you start the game, give the player 10 dollars, and before each bet, allow the player to wager any or all of his money. If the player loses all his money, give him the boot (you don't want any free-loaders in your fine gambling establishment).



Things to remember: 
1. When a card is dealt from the deck, it is logically REMOVED from the deck. 
2. If there are no more cards in the deck, you must tell the player that the current game cannot continue and he will have to go to the main menu and get a new deck of cards and re-shuffle.
3. Aces can count as either 1 or 11. So if you have in your hand a 6, 10, Ace, and 3, that can either be 20 or 30. You will want to count it as 20 because 30 means you lose.
