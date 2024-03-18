package patrick.week8;

abstract class Shape extends Object {
	
	private int sides;
	
	public int getSides() {
		return sides;
	}
	
	public void setSides(int sides) {
		this.sides = sides;
	}

	abstract public int getArea(); 

	@Override
	public String toString() {

		return "area is " + getArea() + ", the number of sides is " + sides;
	}

	Shape(int sides) {

		this.sides = sides;
	}
}
