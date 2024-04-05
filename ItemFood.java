package game;

/**
 * ItemFood.java
 * 
 * Class to model food in the game
 * 
 * @author Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class ItemFood implements Item {

	/**
	 * The name of the item
	 */
	private String name;
	
	/**
	 * the description of the item
	 */
	private String description;
	
	/**
	 * The health boost this item provides
	 */
	private int healthBoost;

	/**
	 * Constructor to set up food items 
	 * @param name The name of the item
	 * @param description the description of the item
	 * @param healthBoost The healing the item provides
	 */
	public ItemFood(String name, String description, int healthBoost) {
		this.description = description;
		this.name = name;
		this.healthBoost = healthBoost;
	}

	/**
	 * Accessor method for the name of the item
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Accessor method of the description of the item
	 * @return The description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Accessor method for the health boost
	 * @return the health boost
	 */
	public int getHealthBoost() {
		return healthBoost;
	}

	/**
	 * Method to convert the name to a string
	 * @return the name as a string
	 */
	@Override
	public String toString() {
		return getName();
	}

	/*
	EXAMPLES
	ItemFood rice = new ItemFood("rice", 3);
	ItemFood chickenNugget = new ItemFood("chicken nuggets", 6);
	ItemFood stupeFries = new ItemFood("stupe fries", 4);
	ItemFood szechuanSauce = new ItemFood("szechuan sauce", 25);
	ItemFood hulkMeat = new ItemFood("hulk meat", 30);
	*/

}
