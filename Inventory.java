package game;
import java.util.ArrayList;

/**
 * Inventory.java
 * 
 * Class to model the player's inventory
 * The command prints out all of the items in the player's inventory
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Inventory implements Command {

	/**
	 * Method to access the player's inventory
	 * @param otherWords The words in the command, not used in this class.
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		for (Item i : playerInventory)
			System.out.println(i.getName());
	}
}
