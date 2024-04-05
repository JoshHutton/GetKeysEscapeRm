package game;

/**
 * ItemWeap.java
 * 
 * Class to model weapons in the game
 * 
 * @author Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class ItemWeap implements Item {

	/**
	 * The hit strength of the weapon
	 */
	private int powerLVL;
	
	/**
	 * The name of the weapon
	 */
	private String name;
	
	/**
	 * The description of the weapon when not in your inventory
	 */
	private String description;
	
	/**
	 * The description of what happens when you attack an enemy with this weapon
	 */
	private String hitDescription;

	/**
	 * Constructor to set up weapon items
	 * @param name The name of the weapon
	 * @param description The weapon's description when not in your inventory
	 * @param powerLVL The weapon's damage output
	 * @param hitDescription The text displayed after each hit
	 */
	public ItemWeap(String name, String description, int powerLVL, String hitDescription) {
		this.name = name;
		this.description = description;
		this.powerLVL = powerLVL;
		this.hitDescription = hitDescription;
	}

	/**
	 * Accessor method for the hit description
	 * @return the hitDescription
	 */
	public String getHitDescription() {
		return hitDescription;
	}

	/**
	 * Accessor method for the strength of the weapon
	 * @return the powerLVL
	 */
	public int getPowerLVL() {
		return powerLVL;
	}

	/**
	 * Accessor method for the name of the weapon
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Accessor method for the description of the weapon
	 * @return The weapon's description as a string
	 */
	@Override
	public String getDescription() {
		return description;
	}
	
	/**
	 * Method that changes the name of the weapon to a string
	 * @return the name as a string
	 */
	@Override
	public String toString() {
		return getName();
	}
	
	/*
	 EXAMPLES
	ItemWeap sword = new ItemWeap("sword", "A nice sword in its sheath is lying on the ground", 50, "Stab stab");
	ItemWeap baseballBat = new ItemWeap("baseball bat", "A Louisville Slugger is leaning against the wall", 30, "Whack!");
	*/
	
}
