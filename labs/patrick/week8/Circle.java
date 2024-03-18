package patrick.week8;
public class Circle extends Shape {

	private int radius;

	Circle() {
		// call super-class constructor with number of sides for this shape, i.e. 1
		super(1);
	}

	@Override
	public int getArea() {
		// since the return type is 'int' need to cast result so it matches the method declaration within the Shape class.
		return (int)(Math.PI * radius * radius);
	}

	@Override
	public String toString() {
		return "Circle with a radius of " + radius + ", " + super.toString();
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
