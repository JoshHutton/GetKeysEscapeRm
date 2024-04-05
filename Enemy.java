package game;

/**
 * Enemy.java
 * 
 * Represents non-player enemies.
 * 
 * @author Joey Sopikiotis, Cole Serfass
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Enemy {

	/**
	 * The name of the enemy
	 */
	private String name;
	
	/**
	 * The description of the enemy's attack.
	 */
	private String attDescrip;
	
	/**
	 * The current health of the enemy.
	 */
	private int hitPoints;
	
	/**
	 * The damage the enemy can deal
	 */
	private int damage;
	
	/**
	 * A description of the enemy's unfortunate demise.
	 */
	private String deathDescription;

	/**
	 * Constructor
	 * @param name The name of the enemy
	 * @param attDescrip The enemy's attack description
	 * @param hitPoints The enemy's HP
	 * @param damage The amount of damage the enemy deals
	 * @param deathDescription The description of the enemy's demise
	 */
	public Enemy(String name, String attDescrip, int hitPoints, int damage, String deathDescription) {
		this.name = name;
		this.attDescrip = attDescrip;
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.deathDescription = deathDescription;
	}

	/**
	 * Accessor method for the enemy's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accessor method for the enemy's attack description
	 * @return the attDescrip
	 */
	public String getAttDescrip() {
		return attDescrip;
	}

	/**
	 * Accessor method for the enemy's HP
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * Method that models the enemy taking damage
	 * @param dealt The damage the enemy takes
	 */
	public void takeDamage(int dealt) {
		hitPoints -= dealt;
	}

	/**
	 * Accessor method for the damage
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * Accessor method for the death description
	 * @return the deathDescription
	 */
	public String getDeathDescription() {
		return deathDescription;
	}

	/*
	 EXAMPLES
	 Enemy guard = new Enemy("guard", "wacked with baton", 50, 10) 
	 Enemy inmate = new Enemy("inmate", "punched", 30, 5)
	 Enemy chef = new Enemy("chef", "cut with knife", 20, 12)
	 Enemy cockroach = new Enemy("cockroach", "nibbled your toes", 1, 1)
	 Enemy warden = new Enemy("warden", "bopped you", 1000, 20)  
	 */
}
