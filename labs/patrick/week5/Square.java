package patrick.week5;

public class Square {

	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_LADDER = 1;
	public static final int TYPE_SNAKE = 2;
	
	private int number;
	private int goesto;
	private int squareType;
	
	public Square(int number) {
		this.squareType = Square.TYPE_NORMAL;
		this.number = number;
		this.goesto = number;
	}
	
	public Square(int squareType, int number) {
		this.squareType = Square.TYPE_NORMAL; //has to be
		this.number = number;
		this.goesto = number;
	}
	
	public Square(int squareType, int number, int goesto) {
		this.squareType = squareType;
		this.number = number;
		this.goesto = goesto;
	}
	
	
	public void modifySquare(int number, int squareType, int goesto) {
		this.squareType = squareType;
		this.number = number;
		this.goesto = goesto;
	}

	
	public int getNumber() {
		return number;
	}
	
	public int getGoesTo() {
		return goesto;
	}
	
	public int getSquareType() {
		return squareType;
	}
	
	@Override
	public String toString() {
		switch (squareType) {
		case Square.TYPE_NORMAL:
			return "Normal";
		case Square.TYPE_LADDER:
			return "a Ladder move to " + goesto;
		case Square.TYPE_SNAKE:
			return "a Snake move to " + goesto;
		default:
			return "Current Square is Normal";	
		}
	}
	
}
