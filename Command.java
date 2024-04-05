package game;

/**
 * Command.java
 * 
 * Interface for all of the in-game commands available to the player
 * 
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public interface Command {
	
	/**
	 * Method stub to run a command
	 * @param otherWords The words in the command
	 * @param rm The current room
	 * @param pc The player
	 */
	public void run(String otherWords, Room rm, Player pc);
}
