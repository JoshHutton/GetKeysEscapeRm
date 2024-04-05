package game;

import java.util.ArrayList;

/**
 * Portal.java
 * 
 * Class to model the mechanics of the portal commands.
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Portal implements Command {

	/**
	 * Method to run the command to place a portal
	 * @param otherWords The color of the portal, must be either red or blue
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		ArrayList<Item> pInv = pc.getPlayerInventory();
		for (Item i : pInv) {
			if(i instanceof PortalGun) {
				if(otherWords.trim().equals("red")) {
					System.out.println("You use the gun on an open space and, where there was previously a solid surface, "
							+ "there is now a swirling red void");
					((PortalGun) i).setRed(rm);
				}else if(otherWords.trim().equals("blue")) {
					System.out.println("You use the gun on an open space and, where there was previously a solid surface, "
							+ "there is now a swirling blue void");
					((PortalGun) i).setBlue(rm);
				}else if(otherWords.equals("")) {
					Game.getInstance().setCurrentRoom(((PortalGun) i).usePortal(rm));
				}else {
					System.out.println("That's not on the gun! Just blue and red."); 
				}
				return;
			}
		}
		System.out.println("You don't have the portal gun!");
	}
}
