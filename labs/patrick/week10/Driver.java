package patrick.week10;

import java.util.Scanner;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Driver {
	
	private static final String[] IMAGE_EXTENSIONS = {"png", "jpg", "bmp", "gif"};
	private static final String[] TEXT_EXTENSIONS = {"txt"};

	public static void main(String[] args) {
				
		System.out.println("Please enter the file name you would like to read in");
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		
		//In Production there would need to be error checking 
		//to make sure filename had correct format
		
		String extension = filename.split("\\.")[1];
		
		scan.close();
		
		if(Arrays.stream(IMAGE_EXTENSIONS).anyMatch(extension::equals)) {
			readImageFile(filename);
		}
		else if(Arrays.stream(TEXT_EXTENSIONS).anyMatch(extension::equals)) {
			readTextFile(filename);
		}
		else {
			System.out.println("Unknown file extension: " + extension);
		}		
		
	}
	
	private static void readImageFile(String filename) {
		System.out.println("Reading image file: " + filename);
		BufferedImage img = null;
		try {
			File f = new File(filename);
		    img = ImageIO.read(f);   
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void readTextFile(String filename) {
		System.out.println("Reading text file: " + filename);	
	    try {
	    	FileReader fileReader = new FileReader(filename);
	    	BufferedReader bufferedReader = new BufferedReader(fileReader);
	    	String line;
	    	while((line = bufferedReader.readLine()) != null) {
	    		System.out.println(line);
	    	}
	    	bufferedReader.close();
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
		}
	}

}
