package game;
import java.util.ArrayList;

/**
 * Use.java
 * 
 * Class to model the "use ..." command.
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Use implements Command {

	/**
	 * Method to run the "use ..." command
	 * @param otherWords The word/s after "use" in the command
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		for (Item i : playerInventory) {
			if (otherWords.equalsIgnoreCase(i.getName()) && rm.canUse(i.getName())) {
				if (rm.consumedOnUse(i)) {
					playerInventory.remove(i);
				}
				rm.use(i);
				return;
			}
		}
		System.out.println("I don't know how to use that here");
	}
}