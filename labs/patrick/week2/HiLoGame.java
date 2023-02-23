import java.util.Random;
import java.util.Scanner;

public class HiLoGame {

	public static void main(String[] args) {		
		
		Random numbers = new Random();		
		boolean stillPlaying = true;
		int currentNumber =  numbers.nextInt(11);		
		
		System.out.println("The range of numbers is 0->10");		
		System.out.println("Starting number is " + currentNumber);		
		
		Scanner scan = new Scanner(System.in);
		int count = 0;		
		while (stillPlaying) {
			int nextNumber = numbers.nextInt(11);
						
			System.out.println("Will the next number be (H)igher or (L)ower");
			String guess = scan.nextLine();
			
			if((nextNumber-currentNumber)==0) {
				System.out.println("Numbers match - pick again - number is still " + currentNumber);
			}
			else if ((nextNumber-currentNumber)>0 && guess.equals("H")) {
				currentNumber = nextNumber;
				System.out.println("Good Guess - next number is " + currentNumber);
				count++;
			}
			else if ((nextNumber-currentNumber)<0 && guess.equals("L")) {
				currentNumber = nextNumber;
				System.out.println("Good Guess - next number is " + currentNumber);
				count++;
			}
			else {
				System.out.println("Unlucky the number was " + nextNumber);
				stillPlaying = false;
			}
		}		
		System.out.println("You had a streak of " + count + " correct guesses");
		
		scan.close();
	}

}

