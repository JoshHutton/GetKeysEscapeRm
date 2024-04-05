package game;
import java.util.*;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Joshua Hutton, Cole Serfass, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Room {

	/**
	 * The player object
	 */
	private Player pc;
	
	/**
	 * A hashmap of rooms adjacent to this one.
	 */
	private HashMap<String, Room> adjacentRooms;

	/**
	 * A hashmap of doors leading to other rooms from this room.
	 */
	private HashMap<String, Door> adjacentDoors;
	
	/**
	 * A description of this room
	 */
	private String description;

	/**
	 * An list of items in the current room
	 */
	private ArrayList<Item> inRoom;
	
	/**
	 * A list of items usable in the current room
	 */
	private ArrayList<String> usableItems;

	/**
	 * A list of items that have been consumed
	 */
	private ArrayList<Item> consumedItems;
	
	/**
	 * A list of enemies in the current room
	 */
	private ArrayList<Enemy> enemiesInRoom;
	
	/**
	 * A list of items that are usable in all rooms
	 */
	private static ArrayList<String> usableInAllRooms;
	
	/**
	 * Stores the array of rooms
	 */
	private Room[][] rooms;
	
	/**
	 * Checks to see if a certain direction command is valid in this room
	 * @param adj The direction to be examined
	 * @return Whether the direction command is valid in this room or not
	 */
	public boolean hasDirection(String adj) {
		return adjacentRooms.containsKey(adj);
	}
	
	/**
	 * Gets the adjacent room in a certain direction
	 * @param adj The direction to go
	 * @return The room in that direction
	 */
	public Room goDirection(String adj) {
		return adjacentRooms.get(adj);
	}
	
	/**
	 * Gets the adjacent door in a certain direction
	 * @param adj The direction to go
	 * @return The door in that direction
	 */
	public Door getDoor(String adj) {
		return adjacentDoors.get(adj);
	}
	
	/**
	 * Constructor
	 * @param description A String describing this room to the user.
	 */
	public Room(String description) {
		pc = Player.getPlayerInstance(); //accesses the instance of the player
		adjacentRooms = new HashMap<String, Room>();
		adjacentDoors = new HashMap<String, Door>();
		this.description = description;
		inRoom = new ArrayList<Item>();
		usableItems = new ArrayList<String>();
		if(usableInAllRooms == null) {
			usableInAllRooms = new ArrayList<String>();
		}
		consumedItems = new ArrayList<Item>();
		enemiesInRoom = new ArrayList<Enemy>();
	}
	
	/**
	 * Method to make an item usable in all rooms.
	 * The item is added to the list usableInAllRooms
	 * @param toAdd The item to add to the list
	 */
	public static void makeUsableInAllRooms(String toAdd) {
		toAdd.trim();
		usableInAllRooms.add(toAdd);
	}
	
	/**
	 * Adds an item to the usable items list for a room
	 * @param toAdd The item to add
	 */
	public void addUsableItem(String toAdd) {
		toAdd = toAdd.trim();
		usableItems.add(toAdd);
	}

	/**
	 * Removes an item from the usable items list for a room
	 * @param toRemove The item to remove
	 */
	public void removeUsableItem(String toRemove) {
		toRemove = toRemove.trim();
		usableItems.remove(toRemove);
	}
	
	/**
	 * A method that binds a door and the room beyond it to a specific direction command
	 * @param dir The direction command associated with the room and door
	 * @param rmDir The room in that direction
	 * @param drDir The door in that direction
	 */
	public void setDir(String dir, Room rmDir, Door drDir) {
		adjacentRooms.put(dir, rmDir);
		adjacentDoors.put(dir, drDir);
	}
	
	/**
	 * Retrieve a description of this room (to the user).
	 * @return A string containing the description of the room and any items or enemies in the room
	 */
	public String getDescription() {
		String look = description;
		//look = look + "\n\nItems around: ";
		for (Item i : inRoom) {
			//look = look + "\n" + i.getName();
			look = look + i.getDescription() + "\n";
		}
		//look = look + "\n\nEnemies around: ";
		for (Enemy i : enemiesInRoom) {
			//look = look + "\n" + i.getName();
			look = look + "\n" + "The " + i.getName() + " bars your way!";
		}
		return look;
	}

	/**
	 * Accessor for the room in that direction
	 * @param dir The direction in question
	 * @return The room in that direction
	 */
	public Room getDir(String dir) {
		return adjacentRooms.get(dir);
	}

	/**
	 * Accessor for the items in a room
	 * @return The list of items inside
	 */
	public ArrayList<Item> getItemsInside() {
		return inRoom;
	}

	/**
	 * Adds an item to the room
	 * @param itemAdded The item added to the room
	 */
	public void addItem(Item itemAdded) {
		inRoom.add(itemAdded);
	}

	/**
	 * Removes an item from a room if it is already in the room
	 * @param itemRemoved The item to be removed
	 * @return The item removed if it's in there
	 * @return Null if the item was not in the room
	 */
	public Item removeItem(String itemRemoved) {
		for (Item i : inRoom) {
			if (itemRemoved.equalsIgnoreCase(i.getName())) {
				inRoom.remove(i);
				return i;
			}
		}
		return null;
	}
	
	/**
	 * Checks if an item can be used in this room
	 * @param used The item in question
	 * @return True if the item is in usableItems or usableInAllRooms, false if not
	 */
	public boolean canUse(String used) {
		return usableItems.contains(used) || usableInAllRooms.contains(used);
	}
	
	/**
	 * Checks to see if an item is consumed on use
	 * @param used The item in question
	 * @return True if it is a consumable item, false if not 
	 **/
	public boolean consumedOnUse(Item used) {
		return consumedItems.contains(used);
	}
	
	/**
	 * A method that links special items with the use command
	 * @param used The item used
	 */
	public void use(Item used) {
		Game gm = Game.getInstance();
		if(used.getName().equals("keys")) {
			this.unlock();
			System.out.println("The locked door swings open slowly.");
		}else if(used instanceof PortalGun) {
			gm.setCurrentRoom(((PortalGun) used).usePortal(this));
		}else if(used.getName().equals("shovel")) {
			this.dig(gm);
		}
	}
	
	/**
	 * Method to unlock the doors in the current room.
	 */
	public void unlock() {
		for(Door dr : adjacentDoors.values()) {
			dr.unlock();
		}
	}

	/**
	 * Method to dig in the current room
	 * @param gm The game object
	 */
	public void dig(Game gm) {
		ArrayList<Item> playerInventory = pc.getPlayerInventory();
		rooms = gm.getRoomArray(); //Accesses and stores the array of rooms
		System.out.print("You dig in the soft dirt and unearth ");
		if(this.equals(rooms[0][0])) {
			System.out.print("a strange device that looks very science-y\n");
			playerInventory.add(new PortalGun());
		} else {
			System.out.print("a wooden trapdoor\n");
			rooms[1][0].setDir("down", rooms[2][3], new Door(true));
		}
		this.removeUsableItem("shovel");
	}
	
	/**
	 * Accessor method for enemiesInRoom
	 * @return the enemies in the current room
	 */
	public ArrayList<Enemy> getEnemiesInRoom() {
		return enemiesInRoom;
	}

	/**
	 * Mutator method for enemiesInRoom
	 * @param enemiesInRoom the enemies to set in the room
	 */
	public void setEnemiesInRoom(ArrayList<Enemy> enemiesInRoom) {
		this.enemiesInRoom = enemiesInRoom;
	}
}