package game;
import java.util.ArrayList;

/**
 * Place.java
 * 
 * Class to model the placing of an object in a room.
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Place implements Command {

	/**
	 * Method to place an item in a room
	 * @param otherWords The item to be placed in the room
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		//go through the inventory. If you have the item, place it.
		for (Item i : playerInventory) {
			if (otherWords.equalsIgnoreCase(i.getName())) {
				rm.addItem(i);
				playerInventory.remove(i);
				break;
			}
		}
	}
}
