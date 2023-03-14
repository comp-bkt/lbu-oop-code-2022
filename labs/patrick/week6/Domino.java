
public class Domino {

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	private int[] values = new int[2];
	
	public Domino(int side1, int side2) {
		values[0] = side1;
		values[1] = side2;
	}
	
	public void swap() {
		int side1 = values[0];
		int side2 = values[1];
		values[0] = side2;
		values[1] = side1;
	}
	
	public int getNumberFromSide(int side) {
		return values[side];
	}
	
	@Override
	public String toString() {
		return "Domino: "+ getNumberFromSide(Domino.LEFT) + ":" + getNumberFromSide(Domino.RIGHT);
	}
}
