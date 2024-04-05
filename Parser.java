package game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Parser {

	/**
	 * For user input from the keyboard.
	 */
	private Scanner keyboard;

	/**
	 * The object storing the actual details of the game rather than the mechanics.
	 */
	private Game gm;

	/**
	 * The map from command text to the command when run.
	 */
	private HashMap<String, Command> commands;

	/**
	 * Stores all player based information
	 */
	private Player pc;

	/**
	 * Stores a list of possible directions simply to allow a more sophisticated
	 * response to the user.
	 */
	private ArrayList<String> directionOptions;

	/**
	 * Constructor builds both the command map and direction list, initializes game
	 * and player
	 * @param game The game object
	 */
	public Parser(Game game) {
		//adds the directional hypothetical options so the program can better understand the user
		directionOptions = new ArrayList<String>();
		directionOptions.add("north");
		directionOptions.add("south");
		directionOptions.add("east");
		directionOptions.add("west");
		directionOptions.add("down");
		directionOptions.add("up");
		directionOptions.add("forward");
		directionOptions.add("backward");
		
		gm = game;
		pc = Player.getPlayerInstance(); //reference to the player
		
		keyboard = new Scanner(System.in);
		
		//Creates the map from strings to commands objects. Also allows for synonymous commands
		commands = new HashMap<String, Command>();
		commands.put("look", new Look());
		commands.put("help", new Help());
		commands.put("get", new Get());
		commands.put("inventory", new Inventory());
		commands.put("place", new Place());
		commands.put("drop", new Place());
		commands.put("use", new Use());
		commands.put("eat", new Eat());
		commands.put("consume", new Eat());
		commands.put("munch", new Eat());
		commands.put("chomp", new Eat());
		commands.put("unlock", new Unlock());
		commands.put("open", new Unlock());
		commands.put("dig", new Dig(gm));
		commands.put("shovel", new Dig(gm));
		commands.put("hit", new Hit());
		commands.put("attack", new Hit());
		commands.put("punch", new Hit());
		commands.put("kill", new Hit());
		commands.put("health", new GetHitPoints());
		commands.put("hp", new GetHitPoints());
		commands.put("hitpoints", new GetHitPoints());
		commands.put("hit points", new GetHitPoints());
		commands.put("wait", new Wait());
		commands.put("stall", new Wait());
		commands.put("portal", new Portal());
		commands.put("inspect", new Inspect());
		commands.put("quit", new Exit(gm));
		commands.put("die", new Exit(gm));
	}

	/**
	 * Let the user make one "turn" at this game. Give the user a description of the
	 * room, prompt for a command, and interpret the command.
	 * 
	 * @param game A reference to the object representing the game.
	 */
	public boolean executeTurn(Game game) {
		gm = game;
		// The room that the user is in.
		Room room = gm.getCurrentRoom();
		
		//All possible rooms
		Room[][] roomarray = gm.getRoomArray();
		
		//checks if the user is in the room for winning
		if (room.equals(roomarray[3][3])) {
			System.out.println(
					"Congratulations! You have successfully escaped from the prison! Time to reconvene with your acolytes!");
			return false;
		}
		
		//gets the user's input
		System.out.print("Enter command--> ");
		String command = keyboard.nextLine().toLowerCase().trim(); // user's command
		String nextWord;
		
		//gets the first word of the command and all words after it.
		if (command.contains(" ")) {
			nextWord = command.substring(command.indexOf(' ') + 1);
			command = command.substring(0, command.indexOf(' '));
		} else {
			nextWord = "";
		}
		
		//checks if the command is in the map
		if (commands.containsKey(command)) {
			//if so, run it.
			commands.get(command).run(nextWord, room, pc);
		} else if (room.hasDirection(command)) {
			//otherwise, check if it's a direction from the room.
			Door door = room.getDoor(command);
			if (door.doorstatus()) {
				//if the door is unlocked, go there.
				gm.setCurrentRoom(room.goDirection(command));
				System.out.println(gm.getCurrentRoom().getDescription());
			} else { 
				System.out.println("The door is locked");
			}
		} else if (directionOptions.contains(command)) {
			//check if the user is trying to go in a direction where there is no door.
			//if they are, reprimand them
			System.out.println("There is no door to the " + command);
		} else {
			//if none of the previous cases catch the user, they have failed.
			System.out.println("I don't know how to " + command);
		}
		
		//Get the enemies to go through
		ArrayList<Enemy> enemies = room.getEnemiesInRoom();
		
		//Detects if the room is empty
		Boolean initiallyempty;
		if (enemies.isEmpty()) {
			initiallyempty = true;
		} else {
			initiallyempty = false;
		}
		//creates a list of killed enemies
		ArrayList<Enemy> deadEnemies = new ArrayList<Enemy>();

		//kills enemies that have died, damages you for those not killed.
		for (Enemy i : enemies) {
			if (i.getHitPoints() <= 0) {
				deadEnemies.add(i);
			} else {
				pc.takeDamage(i.getDamage());
				System.out.println("The " + i.getName() + " " + i.getAttDescrip());
				System.out.println("You have " + pc.getHitPoints() + " HP left.");
			}
		}
		
		//removes dead enemies from the room.
		for (Enemy i : deadEnemies) {
			enemies.remove(i);
			System.out.println(i.getDeathDescription());
		}
		
		//if all enemies are dead, the doors open.
		if (enemies.isEmpty() && !initiallyempty) { // Lets you escape from the room only if you have killed all the
													// enemies within it
			room.unlock();
		}

		// if the player is still alive, returns true and another turn begins
		return pc.getHitPoints() > 0 && !gm.isOver();
	}
}
