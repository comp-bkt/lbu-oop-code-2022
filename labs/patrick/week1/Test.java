import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
				
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter your name>");
		String myName = myScanner.nextLine();
		
		if(myName.length()>6) {
			System.out.println(myName +", you have a long name");
		}
		else {
			System.out.println(myName + ", that's a short name");
		}

		myScanner.close();
											
	}

}
