package patrick.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DominoGame {

	private DominoBoard board;
	private ArrayList<Player> players;
	private boolean noWinner;
	
	//hard coded 4 players
	private static String[] names = {"Abe", "Bob", "Cat", "Dave"};
	private static final int TOTAL_PLAYERS = 4;
	
	public static void main(String[] args) {	
		new DominoGame();
	}
	
	public DominoGame() {
			
		createBoard();
		createPlayers(TOTAL_PLAYERS);
		boolean stillPlaying = true;
		
		System.out.println("Dominoes - Play the Game");
		DominoSet deck = new DominoSet();				
		deck.shuffle();  		
		
		dealDominoes(5, deck);
		
		if(addTheStartingDomino()==false) {
			System.out.println("No Player has a double");
			System.out.println("Game Cancelled");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		int count = 0;
		
		while (stillPlaying) {			
			for (int i=0; i<TOTAL_PLAYERS; i++) {
				int leftSide = board.getNumberToMatchFromLeftEnd();
				int rightSide = board.getNumberToMatchFromRightEnd();
				Domino domino = players.get(i).chooseDomino(leftSide, rightSide);
				if(domino!=null) {
					if(domino.getNumberFromSide(1)==leftSide) board.insertStart(domino);
					else board.insertEnd(domino);
				}
				else {
					System.out.println(players.get(i).getPlayerName()+ " picked up");
					try {
						players.get(i).addDomino(deck.dealDomino());
					}
					catch(Exception e) {
						System.out.println("no dominoes left");
						count++;
						if(count>20) {
							System.out.println("No Winner");
							stillPlaying = false;
						}
					}
				}
				if(players.get(i).getDominoCount()==0) {
					System.out.println("Winner is " + players.get(i).getPlayerName() );
					stillPlaying = false;
				}
			}			
		}		
		System.out.println("Game Over");
		System.out.println(board.toString());
		scan.close();
	}
	
	private void createPlayers(int number) {
		players = new ArrayList<Player>();
		for (int i=0; i<number; i++) {
			Player player = new Player(names[i%TOTAL_PLAYERS]);
			players.add(player);
		}
		
	}

	private void createBoard() {
		board = new DominoBoard();	
			
	}
	
	private void dealDominoes(int numberOfDominoes, DominoSet deck) {
		System.out.println("Dealing Dominoes");
		for(int i=0; i<TOTAL_PLAYERS; i++){
			for(int j=0; j<numberOfDominoes; j++){
				players.get(i).addDomino(deck.dealDomino());
			}
		}
	}
		
	public boolean addTheStartingDomino() {
		for(int value=6; value>=0; value--){
			for(int i=0; i<TOTAL_PLAYERS; i++) {
				if(players.get(i).findDomino(value,value)!=null) {
					board.insertStart(players.get(i).findDomino(value,value));
					players.get(i).removeDomino(players.get(i).findDomino(value,value));
					System.out.println(players.get(i).getPlayerName() + " played " + value+":"+value);
					Collections.rotate(players, -(i+1)); //set the next player as starter		
					return true;
				}
			}
		}
		return false;
	}	
}
