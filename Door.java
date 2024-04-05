package game;

/**
 * Door.java
 * 
 * Class to model a door in the game.
 *
 * @author Joshua Hutton
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Door {
	
	/**
	 * Stores the current condition of the door
	 */
	private boolean unlocked;
	
	/**
	 * Constructor
	 * @param The initial condition of the door
	 */
	public Door(boolean unlocked) {
		this.unlocked = unlocked;
	}
	
	/**
	 * Returns the status of a door: whether it is unlocked or not
	 * @return True if unlocked, false if locked
	 */
	public boolean doorstatus() {
		return unlocked;
	}
	
	/**
	 * Method that unlocks the door
	 */
	public void unlock() {
		unlocked = true;
	}
}
