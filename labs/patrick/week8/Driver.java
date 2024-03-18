package patrick.week8;
public class Driver {

	public static void main(String[] args) {

		Rectangle r1 = new Rectangle();
		
		r1.setHeight(10);
		r1.setWidth(5);
		System.out.println(r1.toString());

		Circle c1 = new Circle();
		c1.setRadius(10);
		System.out.println(c1);
		
		Ellipse e1 = new Ellipse();
		e1.setHeight(10);
		e1.setWidth(5);
		System.out.println(e1);
	}

}
