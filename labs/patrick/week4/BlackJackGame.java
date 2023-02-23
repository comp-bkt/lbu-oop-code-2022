import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BlackJackGame {

	public static void main(String[] args) {
		
		System.out.println("Welcome to BlackJack - who can get closer to 21");		
		System.out.println("How many people are playing?");	
		
		Scanner scan = new Scanner(System.in);
		int numberOfPlayers = scan.nextInt();
		ArrayList<BlackJackPlayer> players = new ArrayList<BlackJackPlayer>();
		
		for(int i=0; i<numberOfPlayers; i++) {
			System.out.println("Please enter the name for Player " + (i+1));
			String playerName = scan.next();
			BlackJackPlayer player = new BlackJackPlayer(playerName);
			players.add(player);
		}
		
		Deck deck = new Deck();
		deck.shuffle();
		
		//start each player with 2 cards
		for(int i=0; i<2; i++){
			for(int j=0; j<numberOfPlayers; j++) {
				players.get(j).addCard(deck.dealCard());
			}
		}
		
		for(int i=0; i<numberOfPlayers; i++) {
			System.out.println(players.get(i).getPlayerName());
			while (true) {
				System.out.println("Your current total is " + players.get(i).getTotal() );
				if(players.get(i).getTotal()>21) {
					System.out.println("BUSTED");
					players.get(i).setPlayerStatus(BlackJackPlayer.BUSTED);
					break;
				}
				System.out.println("Would you like another card (y/n)" );
				String action = scan.next();
				if(action.equals("n")) {
					players.get(i).setPlayerStatus(BlackJackPlayer.STUCK);
					break;
				}
				else {
					players.get(i).addCard(deck.dealCard());
				}
			}
		}
		
		//find the winner
		players.removeIf(obj -> obj.getPlayerStatus()==BlackJackPlayer.BUSTED);
		players.sort(Comparator.comparing(BlackJackPlayer::getTotal).reversed());
		
		System.out.println("Players not BUSTED");
		for(int i=0; i<players.size(); i++) {
			System.out.println(players.get(i).getPlayerName() + " had a total of " + players.get(i).getTotal());			
			System.out.println(players.get(i).showHand());
		}
		
		scan.close();
	}

}
