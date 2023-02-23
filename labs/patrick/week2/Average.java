import java.util.Scanner;

public class Average {

	public static void main(String[] args) {		
		int size;		
		
		if(args.length>0) size = Integer.parseInt(args[0]);
		else size = 3; //default to 3 if no CLA given
		
		int[] values = new int[size];	
		
		Scanner myScanner = new Scanner(System.in);		
		for(int i=0; i<size; i++) {
			System.out.println("please enter value " + (i + 1) + ">");
			
			if(myScanner.hasNextInt()) {
				values[i] = myScanner.nextInt();
			}
			else {
				System.out.println("Please enter a number");
				myScanner.next();
				i--;
			}			
		}				
		
		double total = 0;
		for(int i=0; i<size; i++) {
			total += values[i];
		}		
		double calculatedAverage = total/size;		
		
		System.out.println("The average of your numbers is " + calculatedAverage);
		
		myScanner.close();
	}

}
