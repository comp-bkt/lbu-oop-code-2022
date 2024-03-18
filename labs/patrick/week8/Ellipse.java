package patrick.week8;
public class Ellipse extends Rectangle {

	/**
	 * Constructor.
	 */
	Ellipse() {
		// need to use set sides, since inherited constructor will set the sides to '4'
		this.setSides(1);
	}

	@Override
	public int getArea() {
		// area of ellipse is PI * ((width * height) /4)
		return (int)(Math.PI * (super.getArea() / 4));
	}
	
	@Override
	public String toString() {
		return "Ellipse based on a " + super.toString();
	}

}
