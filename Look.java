package game;

/**
 * Look.java
 * 
 * Class to model the "look" command, which scans the player's surroundings.
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Look implements Command {
	
	/**
	 * Method to look around the room
	 * @param otherWords The words in the command, not used in this class
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		System.out.println(rm.getDescription());
	}
}