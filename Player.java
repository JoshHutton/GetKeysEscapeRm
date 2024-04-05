package game;
import java.util.ArrayList;

/**
 * Player.java
 * 
 * A class that models the player in this game
 *
 * @author Cole Serfass, Joey Sopikiotis, Joshua Hutton
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Player {
	
	/**
	 * Stores all items the player has gathered
	 */
	private ArrayList<Item> playerInventory;

	/**
	 * Stores the player's current health
	 */
	private int hitPoints;

	/**
	 * Stores the maximum hitpoints a player can have
	 */
	private int HPCap;
	
	/**
	 * Stores the player's current damage per hit
	 */
	private int dps;
	
	/**
	 * Describes an attack
	 */
	private String hitDescription;
	
	/**
	 * The instance of the player
	 */
	private static Player instance = null;
	
    /**
     * Static method to create instance of Singleton class Player
     * @return The instance of Player if no instance exists
     */
	public static Player getPlayerInstance() {
        if (instance == null) {
            instance = new Player(new ArrayList<Item>(), 100, 1);
			instance.setHitDescription("You slap them soundly across the face.");
		}
        return instance; 
	}
	
	/**
	 * Constructor
	 * Creates the player
	 * @param playerInventory The player's starting inventory
	 * @param HPCap The player's max HP
	 * @param baseDPS The player's base DPS
	 */
	private Player(ArrayList<Item> playerInventory, int HPCap, int baseDPS) {
		this.playerInventory = playerInventory;
		this.hitPoints = HPCap;
		this.HPCap = HPCap;
		dps = baseDPS;
		hitDescription = "You punch it";
	}

	/**
	 * Accessor method for the DPS
	 * @return the dps of the player
	 */
	public int getDps() {
		return dps;
	}

	/**
	 * Mutator method for the DPS
	 * @param dps the dps to set
	 */
	public void setDps(int dps) {
		this.dps = dps;
	}

	/**
	 * Accessor method for the hit description
	 * @return the hitDescription
	 */
	public String getHitDescription() {
		return hitDescription;
	}

	/**
	 * Mutator method for the hit description
	 * @param hitDescription the hitDescription to set
	 */
	public void setHitDescription(String hitDescription) {
		this.hitDescription = hitDescription;
	}

	/**
	 * Accessor method for the player's inventory
	 * @return the playerInventory
	 */
	public ArrayList<Item> getPlayerInventory() {
		return playerInventory;
	}

	/**
	 * Adds an element to the player's inventory.
	 * @param the element to add
	 */
	public void addToInventory(Item k) {
		playerInventory.add(k);
	}
	
	/**
	 * Accessor method for the player's hit points
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * Accessor method for the player's maximum HP
	 * @return the player's HPCap
	 */
	public int getHPCap() {
		return HPCap;
	}
	
	/**
	 * Damages the player
	 * @param damage taken
	 */
	public void takeDamage(int k) {
		hitPoints -= k;
		if(hitPoints < 0) {
			hitPoints = 0;
		}
	}
	
	/**
	 * Heals the player
	 * @param amount healed
	 */
	public void heal(int k) {
		hitPoints += k;
		if(hitPoints > HPCap)
			hitPoints = HPCap;
	}
}