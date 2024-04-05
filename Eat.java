/**
 * 
 */
package game;

import java.util.ArrayList;

/**
 * Eat.java
 * 
 * Class to model eating items in the game, which is linked to restoring health.
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Eat implements Command {

	/**
	 * Method to consume food and thus restore health
	 * @param otherWords the food to eat
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		boolean foundFood = false;
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		if(otherWords.equals("")) {
			System.out.println("Eat what?");
		} else {
			for (Item i : playerInventory) {
				if (otherWords.equalsIgnoreCase(i.getName())) {
					if (i instanceof ItemFood) {
						foundFood = true;
						int hp = pc.getHitPoints();
						if (hp < pc.getHPCap()) {
							pc.heal(((ItemFood) i).getHealthBoost());
							playerInventory.remove(i);
						} else {
							System.out.println("I'm already full.");
						}
					} else {
						System.out.println("I'm not gonna eat that!");
					}
					return;
				}
			}
			if (!foundFood)
				System.out.println("You don't have that currently.");
		}
	}
}