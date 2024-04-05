package game;

/**
 * Get.java
 * 
 * Class to model the command to pick items up.
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Get implements Command {

	/**
	 * Method to pick items up
	 * @param otherWords The item to pick up
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		Item got = rm.removeItem(otherWords);
		if(got != null) {
			pc.addToInventory(got);
			System.out.println("Picked up " + got);
			if(got instanceof ItemWeap) {
				if(pc.getDps() <= ((ItemWeap)got).getPowerLVL()) {
					pc.setDps(((ItemWeap) got).getPowerLVL());
					pc.setHitDescription(((ItemWeap) got).getHitDescription());
				}
			}
		}else {
			System.out.println("That's not in the room.");
		}
	}
}
