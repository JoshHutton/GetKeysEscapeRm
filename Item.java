package game;
/**
 * Item
 * 
 * Interface to access the names of items 
 * 
 * @author Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public interface Item {

	/**
	 * Method stub for the accessor method for name
	 * @return The item's name
	 */
	public String getName();

	/**
	 * Method stub for the toString method for items
	 * @return The item's name as a string
	 */
	public String toString();

	/**
	 * Accessor method for the item's description
	 * @return The item's description
	 */
	public String getDescription();
}