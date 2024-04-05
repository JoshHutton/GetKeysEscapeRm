package game;

import java.util.ArrayList;

/**
 * Dig.java
 * 
 * Class for commands that dig things up in a room
 *
 * @author Joshua Hutton
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Dig implements Command {

	private Game gm; 
	
	/**
	 * Constructor
	 * @param gm The game
	 */
	public Dig(Game gm) {
		this.gm = gm;
	}
	
	/**
	 * Method to run the "dig" command, which references dig(gm) found in Room
	 * @param otherWords The words in the command, not used in this class
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		for (Item i : playerInventory) {
			if ("shovel".equalsIgnoreCase(i.getName())) {
				if (rm.canUse("shovel")) {
					rm.dig(gm);
				} else {
					System.out.println("The ground is too hard to dig here.");
				}
				return;
			}
		}
		System.out.println("You don't have the shovel!");
	}
}