import java.util.ArrayList;
import java.util.Scanner;

public class FindTheAceSpades {

	public static void main(String[] args) {
		
		System.out.println("Who has the Ace of Spades");		
		System.out.println("How many people are playing?");	
		
		Scanner scan = new Scanner(System.in);
		int numberOfPlayers = scan.nextInt();
		ArrayList<Player> players = new ArrayList<Player>();
		
		for(int i=0; i<numberOfPlayers; i++) {
			System.out.println("Please enter the name for Player " + (i+1));
			String playerName = scan.next();
			Player player = new Player(playerName);
			players.add(player);
		}
		
		Deck deck = new Deck();
		deck.shuffle();
		
		while (deck.cardsLeft()>0){
			players.get(deck.cardsLeft()%numberOfPlayers).addCard(deck.dealCard());
		}
		
		for(int i=0; i<numberOfPlayers; i++) {
			System.out.println("Checking " + players.get(i).getPlayerName());
			if(players.get(i).findCard(Card.ACE, Card.SPADES)) {
				System.out.println("ACE OF SPADES FOUND!!!!");
				System.out.println(players.get(i).showHand());
			}		
			else {
				System.out.println("NOT FOUND");
				System.out.println(players.get(i).showHand());
			}
		}
		
		scan.close();

	}

}
