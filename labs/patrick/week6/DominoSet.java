
public class DominoSet {

	private Domino[] deck;
	private int dominosUsed;

	public DominoSet() {
		deck = new Domino[28];
		int count=0;
		for (int side1 = 0; side1 <= 6; side1++) {
			for (int side2 = side1; side2 <= 6; side2++) {
				deck[count] = new Domino(side1, side2);
				count++;
			}
		}
		dominosUsed = 0;
	}

	public void shuffle() {
		for (int i = deck.length - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			Domino temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		dominosUsed = 0;
	}
	
	public int dominoesLeft() {
        return deck.length - dominosUsed;
    }

	public Domino dealDomino() {
        if (dominosUsed == deck.length)
            throw new IllegalStateException("No dominoes are left in the deck.");
        dominosUsed++;
        return deck[dominosUsed - 1];
        // Programming note:  Dominoes are not literally removed from the array
        // that represents the deck.  We just keep track of how many dominoes
        // have been used.
    }
}
