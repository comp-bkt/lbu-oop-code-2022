package patrick.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lights {
    private final String[] commands =
            {"on", "off", "colour", "status", "exit", "type"};
    private ArrayList<Bulb> bulbs = new ArrayList<Bulb>();
    public static void main(String[] args){
        new Lights();
    }

    public Lights() {
        initialiseRGBBulbs();
        initialiseBulbs();
        while (true) {
            String input = getUserCommand();
            if (!processCommand(input)) break;
        }
        System.out.println("Thank you - the Light Program is terminating");
    }
    private boolean processCommand(String input) {
        String[] commands = input.split(" ");
        if(!isValidCommand(commands[0])){
            System.out.println("Invalid Command");
            return true;
        }
        switch(commands[0]) {
            case "on":
                turnOnBulb(commands);
                return true;
            case "colour":
                turnColourBulb(commands);
                return true;
            case "exit":
                return false;
            default:
                System.out.println("Command not yet implemented");
                return true;
        }
    }
    public boolean isValidCommand(String command) {
        return Arrays.asList(commands).contains(command);
    }

    private String getUserCommand() {
        System.out.println("Enter your command: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private void initialiseBulbs() {
        System.out.println("How many Bulbs do you want to create");
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<number; i++){
            Bulb bulb = new Bulb();
            bulbs.add(bulb);
        }
    }
    private void initialiseRGBBulbs() {
        System.out.println("How many RGBBulbs do you want to create");
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<number; i++){
            RGBBulb bulb = new RGBBulb();
            bulbs.add(bulb);
        }
    }
    private void turnOnBulb(String[] commands) {
        if(commands.length!=2) {
            System.out.println("Incorrect number of parameters");
            return;
        }
        try {
            int bulbNumber = Integer.parseInt(commands[1]);
            bulbs.get(bulbNumber).setOn(true);
        }
        catch(NumberFormatException e){
            System.out.println("Parameter 2 needs to be a number");
        }
    }
    private void turnColourBulb(String[] commands) {
        if(commands.length!=2) {
            System.out.println("Incorrect number of parameters");
            return;
        }
        try {
            int bulbNumber = Integer.parseInt(commands[1]);
            if(bulbs.get(bulbNumber) instanceof RGBBulb) {
                ((RGBBulb) bulbs.get(bulbNumber)).setCurrentColour(RGBBulb.GREEN);
            }
            else {
                System.out.println("Incompatible bulb");
            }
        }
        catch(NumberFormatException e){
            System.out.println("Parameter 2 needs to be a number");
        }
    }
}