package patrick.week5;

public class Player {

	private int currentPosition;
	private String playerName;
	
	public Player(String playerName, int currentSquare) {
		this.playerName = playerName;
		this.currentPosition = 1;
	}
	
	public void movePlayer(int number) {
		this.currentPosition += number;
	}
	
	public int getCurrentPosition () {
		return currentPosition;
	}
	
	public void setCurrentPosition(int number) {
		this.currentPosition = number;
	}
	
	@Override
	public String toString() {
		return playerName;
	}
}
