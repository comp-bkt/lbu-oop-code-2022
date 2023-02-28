
public class SnakesAndLadderBoard {

	private Square[] boardSquares;
	
	
	public SnakesAndLadderBoard() {
		boardSquares = new Square[100];
		for (int i=0; i<100; i++) {
			boardSquares[i] = new Square(i+1);
		}
	}
	
	public void modifySquare(int square, int squareType, int goesto) {
		boardSquares[square-1].modifySquare(square, squareType, goesto);
	}
		
	public Square getCurrentSquare(int square) {
		return boardSquares[square-1];
	}
	
}
