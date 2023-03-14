import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SmartHome {

	private final int HUB_ID = 9999;
	private ArrayList<SmartBulb> bulbs = new ArrayList<SmartBulb>();

	//some commands still to be implemented
	private final String[] VALID_COMMANDS = 
		{ "on", "off", "set", "status", "help", "end" };

	public SmartHome() {

	}

	public void init() {
		// TODO set up keyboard input to specify number of smartBulbs to add
		Scanner scanner = new Scanner(System.in);
		displayMessage("How many Bulbs do you need to connect?");
		int number = scanner.nextInt();

		for (int i = 0; i < number; i++) {
			SmartBulb bulb = new SmartBulb(HUB_ID, i);
			bulbs.add(bulb);
		}
		displayMessage("You have connected " + number + " SmartBulbs");
	}

	public void listen() {
		// TODO create a loop to listen for user input and action events
		Scanner scanner = new Scanner(System.in);
		while (true) {
			displayMessage("Please enter an action - type "
					+ "help for available commands");
			String action = scanner.nextLine();
			if (action.contentEquals("end")) {
				displayMessage("Shutting Down......");
				displayMessage("Bye");
				break;
			} else {
				processCommand(action);
			}
		}
	}

	private void processCommand(String action) {
		String[] commands = action.split(" ");
		if (isCommandValid(commands[0]) == false) {
			displayMessage("Invalid Command - " + "please type help for all commands");
			return;
		}
		switch (commands[0]) {
		case "help":
			showHelp();
			break;
		case "on":
			doOnCommand(commands);
			break;
		case "off":
			doOffCommand(commands);
			break;
		default:
			showHelp();
		}
	}

	private void doOnCommand(String[] commands) {
		displayMessage("Issued On Command");
		if(commands.length!=2) {
			displayMessage("Invalid On Command Format - please type help for more info");
			return;
		}
		if(commands[1].contentEquals("all")) { //this would need to be reserved and unavailable as a zone name
			turnOnAllBulbs();
			return;
		}
		try {
			int id = Integer.parseInt(commands[1]);
			turnOnBulbWithID(id);
		}
		catch(NumberFormatException error) {
			turnOnBulbWithZone(commands[1]);
		}
		
	}

	private void turnOnBulbWithZone(String string) {
		// TODO Auto-generated method stub
		
	}

	private void turnOnBulbWithID(int id) {
		try {
			bulbs.get(id).turnBulbOn(HUB_ID);
			displayMessage("Bulb with id " + id + " turned on");
		}
		catch (IndexOutOfBoundsException error) {
			displayMessage("Invalid ID value given");
		}
		
	}

	private void turnOnAllBulbs() {
		for(int i=0; i<bulbs.size(); i++) {
			bulbs.get(i).turnBulbOn(HUB_ID);
		}
		displayMessage("All Bulbs turned On");
	}
	
	private void doOffCommand(String[] commands) {
		displayMessage("Issued Off Command");
		if(commands.length!=2) {
			displayMessage("Invalid Off Command Format - please type help for more info");
			return;
		}
		if(commands[1].contentEquals("all")) { //this would need to be reserved and unavailable as a zone name
			turnOffAllBulbs();
			return;
		}
		try {
			int id = Integer.parseInt(commands[1]);
			turnOffBulbWithID(id);
		}
		catch(NumberFormatException error) {
			turnOffBulbWithZone(commands[1]);
		}
		
	}

	private void turnOffBulbWithZone(String string) {
		// TODO Auto-generated method stub
		
	}

	private void turnOffBulbWithID(int id) {
		try {
			bulbs.get(id).turnBulbOff(HUB_ID);
			displayMessage("Bulb with id " + id + " turned off");
		}
		catch (IndexOutOfBoundsException error) {
			displayMessage("Invalid ID value given");
		}
		
	}

	private void turnOffAllBulbs() {
		for(int i=0; i<bulbs.size(); i++) {
			bulbs.get(i).turnBulbOff(HUB_ID);
		}
		displayMessage("All Bulbs turned Off");
	}

	private boolean isCommandValid(String command) {
		// is command is contained in VALID_COMMANDS
		boolean valid = Arrays.stream(VALID_COMMANDS).anyMatch(command::equals);

		return valid;
	}

	private void displayMessage(String string) {
		System.out.println(string);
	}

	private void showHelp() {
		// TODO Auto-generated method stub
		displayMessage("List of Commands");
		displayMessage("---------------");
		displayMessage("help - show help");
		displayMessage("end - shutdown SmartHome");
		displayMessage("on all - switches all lights on");
		displayMessage("off all - switches all lights off");
		displayMessage("on #id - switches light with id (number) on");
		displayMessage("off #id - switches light with id (number) off");
		displayMessage("on #name - switches light(s) with name (word) on");
		displayMessage("off #name - switches light(s) with name (word) off");
		displayMessage("set #id #name - set light id(number) to have name (word)");
		displayMessage("status all - show status of all lights - response is #id on/off #name ");
		displayMessage("status #id - show status of light id(number) - response on/off + name ");
	}

}
