package patrick.week4;

public class BlackJackPlayer extends Player {
	
	public final static int IN_PLAY = 0;
	public final static int STUCK = 1;
	public final static int BUSTED = 2;

	private int total;
	private int playerStatus;
	
	public BlackJackPlayer(String playerName) {
		super(playerName);
		playerStatus = IN_PLAY;
	}

	public int getTotal() {
		total = 0;
		for(Card c:hand) {
			if(c.getValue()>10) total+=10;
			else total+=c.getValue();
		}
		return total;
	}
	
	public void setPlayerStatus(int status) {
		playerStatus = status;
	}
	
	public int getPlayerStatus() {
		return playerStatus;
	}
}
