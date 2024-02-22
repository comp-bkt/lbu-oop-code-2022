package patrick.week5;

import java.util.ArrayList;

public class SnakesAndLaddersGame {
	
	private SnakesAndLadderBoard board;
	private Dice dice;
	private ArrayList<Player> players;
	private boolean noWinner;
	
	//hard coded 4 players
	private static String[] names = {"Abe", "Bob", "Cat", "Dave"};
	private static final int TOTAL_PLAYERS = 4;

	public static void main(String[] args) {
		new SnakesAndLaddersGame();
	}
	
	public SnakesAndLaddersGame() {
		noWinner = true;
		
		createBoard();
		createDice();
		createPlayers(TOTAL_PLAYERS);
		
		while (noWinner) {
			for (Player player : players) {
				dice.rollDice();
				player.movePlayer(dice.getCurrentNumber());
				if(player.getCurrentPosition() >= 100) {
					System.out.println(player.toString()+ " You have reached the end of the board - WINNER");
					noWinner=false;
				}
				else {
					System.out.println(player.toString() + " You landed on Square " + player.getCurrentPosition() + 
						" This square is " 
						+ board.getCurrentSquare(player.getCurrentPosition()).toString() );
					
					if(board.getCurrentSquare(player.getCurrentPosition()).getSquareType()==Square.TYPE_LADDER) {
						player.setCurrentPosition(board.getCurrentSquare(player.getCurrentPosition()).getGoesTo());
					}
					
					if(board.getCurrentSquare(player.getCurrentPosition()).getSquareType()==Square.TYPE_SNAKE) {
						player.setCurrentPosition(board.getCurrentSquare(player.getCurrentPosition()).getGoesTo());
					}
				}
			}
			System.out.println("");
		}

	}

	private void createPlayers(int number) {
		players = new ArrayList<Player>();
		for (int i=0; i<number; i++) {
			Player player = new Player(names[i%TOTAL_PLAYERS], 1);
			players.add(player);
		}
		
	}

	private void createDice() {
		dice = new Dice(6);
		
	}

	private void createBoard() {
		board = new SnakesAndLadderBoard();	
		
		board.modifySquare(5, Square.TYPE_LADDER, 12);
		board.modifySquare(15, Square.TYPE_LADDER, 25);
		board.modifySquare(22, Square.TYPE_LADDER, 70);
		board.modifySquare(31, Square.TYPE_LADDER, 40);
		board.modifySquare(55, Square.TYPE_LADDER, 62);
		board.modifySquare(72, Square.TYPE_LADDER, 86);
		
		board.modifySquare(95, Square.TYPE_SNAKE, 17);
		board.modifySquare(92, Square.TYPE_SNAKE, 41);
		board.modifySquare(81, Square.TYPE_SNAKE, 64);
		board.modifySquare(58, Square.TYPE_SNAKE, 3);
		board.modifySquare(38, Square.TYPE_SNAKE, 26);
		board.modifySquare(19, Square.TYPE_SNAKE, 9);		
	}

}
