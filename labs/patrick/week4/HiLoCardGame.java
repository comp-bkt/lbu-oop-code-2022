package patrick.week4;

import java.util.Scanner;

public class HiLoCardGame {

	public static void main(String[] args) {		
				
		boolean stillPlaying = true;
		
		System.out.println("Play your Cards Right - HiLo Challenge");
		Deck deck = new Deck();
		
		Card currentCard = deck.dealCard();		
		//deck.shuffle();  //PLAY WITH AN UNSHUFFLED DECK
		System.out.println("Starting Card is " + currentCard.toString());
		
		Scanner scan = new Scanner(System.in);
		int count = 0;
		
		while (stillPlaying) {
			try {
				Card nextCard = deck.dealCard();
				System.out.println("Will the next Card be (H)igher or (L)ower");
				String guess = scan.nextLine();
				
				if((nextCard.getValue()-currentCard.getValue())==0) {
					System.out.println("Cards value match - unlucky - the next card is " + nextCard.toString());
					stillPlaying = false;
				}
				else if ((nextCard.getValue()-currentCard.getValue())>0 && guess.equals("H")) {
					currentCard = nextCard;
					System.out.println("Good Guess - next Card is " + currentCard.toString());
					count++;
				}
				else if ((nextCard.getValue()-currentCard.getValue())<0 && guess.equals("L")) {
					currentCard = nextCard;
					System.out.println("Good Guess - - next Card is " + currentCard.toString());
					count++;
				}
				else {
					System.out.println("Unlucky the next Card was " + nextCard.toString());
					stillPlaying = false;
				}
			}
			catch(IllegalStateException e) {
				System.out.println("You made it through the full pack!");
				break;
			}
						
			
		}		
		System.out.println("You had a streak of " + count + " correct guesses");
		scan.close();
	}

}
