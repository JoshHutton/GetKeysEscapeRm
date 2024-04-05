package game;

/**
 * Exit.java
 * 
 * Class that models the command to kill the player
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Exit implements Command {

	/**
	 * The game object
	 */
	private Game gm;
	
	/**
	 * Constructor
	 * @param gm The game
	 */
	public Exit(Game gm) {
		this.gm = gm;
	}
	
	/**
	 * Method for the player to commit suicide
	 * @param otherWords The words in the command
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		System.out.println("You have succeeded in killing yourself.");
		gm.gameOver();
	}
}
