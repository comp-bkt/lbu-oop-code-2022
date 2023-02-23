/*
 * code base for Card class based on example from
 * https://math.hws.edu/javanotes/source/chapter5/Deck.java
*/

public class Deck {

	private Card[] deck;
	private int cardsUsed;

	public Deck() {
		deck = new Card[52];
		int cardCt = 0; // How many cards have been created so far.
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				deck[cardCt] = new Card(value, suit);
				cardCt++;
			}
		}
		cardsUsed = 0;
	}

	public void shuffle() {
		for (int i = deck.length - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsUsed = 0;
	}
	
	public int cardsLeft() {
        return deck.length - cardsUsed;
    }

	public Card dealCard() {
        if (cardsUsed == deck.length)
            throw new IllegalStateException("No cards are left in the deck.");
        cardsUsed++;
        return deck[cardsUsed - 1];
        // Programming note:  Cards are not literally removed from the array
        // that represents the deck.  We just keep track of how many cards
        // have been used.
    }
}
