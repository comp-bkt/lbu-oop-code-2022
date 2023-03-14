import java.util.ArrayList;

public class Player {

	private final String playerName;
	protected ArrayList<Domino> hand;
	
	
	public Player(String playerName) {
		this.playerName = playerName;
		hand = new ArrayList<Domino>();
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void clear() {
        hand.clear();
    }

	public void addDomino(Domino d) {
        if (d == null)
            throw new NullPointerException("Can't add a null domino to a hand.");
        hand.add(d);
    }
	
	public void removeDomino(Domino d) {
        hand.remove(d);
    }
	
	public int getDominoCount() {
        return hand.size();
    }
	
	public Domino findDomino(int side1, int side2) {
		Domino domino = hand.stream().filter(obj -> obj.getNumberFromSide(Domino.LEFT) == side1 && obj.getNumberFromSide(Domino.RIGHT)==side2).findFirst().orElse(null);
		return domino;
	}
	
	public Domino findAnyDomino(int side1, int side2) {
		Domino domino = hand.stream().filter(obj -> obj.getNumberFromSide(Domino.LEFT) == side1 || obj.getNumberFromSide(Domino.RIGHT)==side2).findFirst().orElse(null);
		return domino;
	}
	
	public String showHand() {
		String response = "";
		for (Domino d:hand) {
			response += (" " + d.toString());
		}
		return response;
	}

	public Domino chooseDomino(int leftSide, int rightSide) {
		Domino domino = null;
		if(findAnyDomino(leftSide, leftSide)!=null) {
			domino = findAnyDomino(leftSide, leftSide);
			if(domino.getNumberFromSide(Domino.RIGHT)!=leftSide) domino.swap();
			removeDomino(domino);
			System.out.println(getPlayerName() + " played " + domino.toString());					
		}
		else if (findAnyDomino(rightSide, rightSide)!=null) {
			domino = findAnyDomino(rightSide, rightSide);
			if(domino.getNumberFromSide(Domino.LEFT)!=rightSide) domino.swap();
			removeDomino(domino);
			System.out.println(getPlayerName() + " played " + domino.toString());					
		}
		return domino;
	}
}
