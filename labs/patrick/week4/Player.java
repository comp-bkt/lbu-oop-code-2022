package patrick.week4;

import java.util.ArrayList;

public class Player {

	private final String playerName;
	protected ArrayList<Card> hand;
	
	
	public Player(String playerName) {
		this.playerName = playerName;
		hand = new ArrayList<Card>();
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void clear() {
        hand.clear();
    }

	public void addCard(Card c) {
        if (c == null)
            throw new NullPointerException("Can't add a null card to a hand.");
        hand.add(c);
    }
	
	public void removeCard(Card c) {
        hand.remove(c);
    }
	
	public int getCardCount() {
        return hand.size();
    }
	
	public boolean findCard(int value, int suit) {
		Card card = hand.stream().filter(obj -> obj.getValue() == value && obj.getSuit()==suit).findFirst().orElse(null);
		if(card != null) return true;
		else return false;
	}
	
	public String showHand() {
		String response = "";
		for (Card c:hand) {
			response += (" " + c.toString());
		}
		return response;
	}
	
	
}
