package game;
import java.util.ArrayList;

/**
 * Inspect.java
 * 
 * Class to model inspection of an item in the player's inventory
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Inspect implements Command {

	/**
	 * Method to inspect an item in the player's inventory
	 * @param otherWords The item to be inspected
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		for (Item i : playerInventory) {
			if (otherWords.equalsIgnoreCase(i.getName())) {
				System.out.println(i.getDescription());
				return;
			}
		}
		System.out.println("I don't have that item!");
	}
}
