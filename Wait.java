package game;

/**
 * Wait.java
 * 
 * Class to model the "wait" command.
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Wait implements Command {

	/**
	 * Method to not do anything for this turn
	 * @param otherWords The words in the command, not used here
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		return;
	}
}