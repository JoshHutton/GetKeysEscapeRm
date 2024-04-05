package game;

/**
 * Hit.java
 * 
 * Class to model combat with an enemy
 *
 * @author Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Hit implements Command {

	/**
	 * Method to attack an enemy
	 * @param otherWords The enemy targeted
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String otherWords, Room rm, Player pc) {
		boolean hitEnemy = false;
		for (Enemy i : rm.getEnemiesInRoom()) {
			if (otherWords.equalsIgnoreCase(i.getName())) {
				hitEnemy = true;
				i.takeDamage(pc.getDps());
				System.out.println(pc.getHitDescription());
			}
		}
		if (!hitEnemy)
			System.out.println("I don't see a " + otherWords + " to hit!");
	}
}
