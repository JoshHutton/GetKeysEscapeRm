package game;

/**
 * PortalGun.java
 * 
 * Class to model the portal gun.
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class PortalGun extends ItemOther implements Item {
	
	/**
	 * Contains the room where the blue portal was fired.
	 */
	private Room blueRoom;
	/**
	 * Contains the room where the red portal was fired.
	 */
	private Room redRoom;
	
	/**
	 * Constructor
	 * Allows for simple creation, as the creation is the same for each
	 * instance and is moderately longwinded to type.
	 */
	public PortalGun() {
		super("portal gun", "A strange device is lying on the ground", 
				"creates a portal between the two places it is used in. Used by typing \"portal blue\" or \"portal red\""
				+ " and traveled through by typing \"use portal\"");		
	}

	/**
	 * Sets the room where the blue portal was fired.
	 * @param blue
	 */
	public void setBlue(Room blue) {
		blueRoom = blue;
	}
	
	/**
	 * Sets the room where the red portal was fired.
	 * @param red
	 */
	public void setRed(Room red) {
		redRoom = red;
	}
	
	/**
	 * Method called when the user attempts to move through the portal.
	 * @param currRoom The room the player is currently in
	 * @return the room that you will move to after portalling.
	 * @return is null if the portals are not established or not in this room.
	 */
	public Room usePortal(Room currRoom) {
		if(redRoom == null || blueRoom == null) {
			System.out.println("Not all portals have been established.");
			return currRoom;
		}
		if(currRoom == redRoom) { 
			return blueRoom;
		}else if (currRoom == blueRoom) {
			return redRoom;
		}else {
			System.out.println("There is no portal in the room you are in.");
			return currRoom;
		}
	}
}