package game;

/**
 * ItemOther.java
 * 
 * Class to model other items in the game
 * 
 * @author Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class ItemOther implements Item {

	/**
	 * The name of the item
	 */
	private String name;
	
	/**
	 * The item's description when not in the player's inventory
	 */
	private String description;
	
	/**
	 * The effect of the item
	 */
	private String effect;

	/**
	 * Constructor to set up other items
	 * @param name The name of the item
	 * @param description The item's description
	 * @param effect What the item does
	 */
	public ItemOther(String name, String description, String effect) {
		this.name = name;
		this.effect = effect;
		this.description = description;
	}

	/**
	 * Accessor method for the effect of the weapon
	 * @return the effect
	 */
	public String getEffect() {
		return effect;
	}


	/**
	 * Accessor method for the weapon's name
	 * @return The name of the weapon
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Accessor method for the weapon's description
	 * @return The weapon's description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Method to change the name to a string
	 * @return the name as a string
	 */
	@Override
	public String toString() {
		return getName();
	}

	/*
	EXAMPLES
	ItemOther flashlight = new ItemOther(flashlight, allows you to see the room); 
	ItemOther needle = new ItemOther(strange needle, doubles item damage for 5 hits);
	*/

}


