package patrick.week4;

import java.util.Random;

public class Dice {	 
	
	private int currentNumber = 0;
	private int sides = 0;
	
	public Dice() {
		this.setSides(6);		
	}
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	public int getCurrentNumber() {
		return currentNumber;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		if(sides>1 && sides<20) {
			this.sides = sides;
		}
	}

	public void rollDice() {
		Random generator = new Random();
		currentNumber = generator.nextInt(sides) + 1;
	}
}
