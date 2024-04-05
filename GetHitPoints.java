package game;

/**
 * GetHitPoints.java
 * 
 * Class to model the command to check the player's current hit points
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class GetHitPoints implements Command {

	/**
	 * Method to check the player's hitpoints
	 * @param otherWords The words in the command, not used in this class
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		System.out.println("HP: " + pc.getHitPoints());
	}
}
