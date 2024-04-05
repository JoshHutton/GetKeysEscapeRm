package game;

import java.util.ArrayList;

/**
 * Unlock.java
 * 
 * Unlocks all doors in the room if the user has keys. Consumes the keys.
 * 
 * @author Cole Serfass, Joshua Hutton
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Unlock implements Command {
	
	@Override
	/**
	 * Method to unlock doors in the room
	 * @param otherWords The words in the command, not used here
	 * @param rm The current room
	 * @param pc The player
	 */
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		for (Item i : playerInventory) {
			if ("keys".equalsIgnoreCase(i.getName())) {
				if (rm.canUse("keys")) {
					rm.unlock();
					System.out.println("The locked door swings open slowly.");
					rm.removeUsableItem("keys");
				}else {
					System.out.println("You can't use them here.");
				}
				return;
			}
		}
		System.out.println("You don't have the keys!");
	}
}
