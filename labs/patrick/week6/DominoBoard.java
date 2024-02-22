package patrick.week6;

import java.util.ArrayList;

public class DominoBoard {

	private ArrayList<Domino> currentBoard;
	
	public DominoBoard() {
		currentBoard = new ArrayList<Domino>();
	}
	
	public void insertStart(Domino domino) {
		currentBoard.add(0, domino);
	}
	
	public void insertEnd(Domino domino) {
		currentBoard.add(domino);
	}
	
	public int getNumberToMatchFromLeftEnd() {
		return currentBoard.get(0).getNumberFromSide(Domino.LEFT);				
	}
	
	public int getNumberToMatchFromRightEnd() {
		return currentBoard.get(currentBoard.size()-1).getNumberFromSide(Domino.RIGHT);				
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Domino domino:currentBoard) {
			str += domino.getNumberFromSide(0)+":"+domino.getNumberFromSide(1) + " ";
		}
		return str;
	}
}
