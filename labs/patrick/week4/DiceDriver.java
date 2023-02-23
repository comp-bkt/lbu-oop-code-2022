import java.util.Scanner;

public class DiceDriver {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many sides for your dice");
		
		int numberOfSides = scanner.nextInt();
		
		Dice dice = new Dice(numberOfSides);
		//Dice dice = new Dice() //TO SHOW DIFFERENT CONSTRUCTORS BEING CALLED
		dice.rollDice();
			
		//dice.setSides(100); //TO SHOW THAT SETTER RESTRICTS VALUES
		//dice.currentNumber = numberOfSides; //TO SHOW THAT CURRENTNUMBER CANT BE ACCESSED DIRECTLY
			
		System.out.println(dice.getCurrentNumber());
				
		scanner.close();
	}

}
