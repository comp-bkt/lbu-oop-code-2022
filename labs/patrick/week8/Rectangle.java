package patrick.week8;
public class Rectangle extends Shape {

	private int width;

	private int height;

	Rectangle() {
		// call super-class constructor with number of sides for this shape, i.e. 4
		super(4);
	}

	@Override
	public int getArea() {

		return width * height;
	}

	@Override
	public String toString() {

		return "Rectangle with a width of " + width + ", a height of " + height + ", " 
		+ super.toString();
	}
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
