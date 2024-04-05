package game;
import java.util.ArrayList;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Game {
	
    /**
     * The current room the user is in. This serves two
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * Return the room in which the user is currently in.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * The instance of the game.
     */
    private static Game instance = null; 
  
    /**
     * The array of rooms
     */
    private Room[][] rooms;
    
    /**
     * A method to access the array of rooms
     * @return The array of rooms
     */
    protected Room[][] getRoomArray() { return rooms; }
    
    /**
     * Static method to create instance of Singleton class Game
     * @return The instance of Game if no instance exists
     */
    public static Game getInstance() { 
        if (instance == null) 
            instance = new Game(); 
        return instance; 
    } 
    
    /**
     * Sets over to true
     */
    public void gameOver() {
		over = true;
	}

	/**
     * Constructor to set up the game.
     */
    private Game() {
    	rooms = new Room[4][4];
    	//Room[0][0]
    	String jail = "You are in an old jail cell. Bones and shards of bone lie scattered around you on the floor.\n"
    			+ "A bowl of unappealing food lies half-buried in a small patch of dirt in the corner.\n"
    			+ "To the east, you notice that some fool of a guard left the cell door ajar.\n";
    	//Room[2][2]
    	String hallway = "You are creeping through the cell block that you were confined in, which is surprisingly empty.\n"
    			+ "To the west, you notice that a cell door is ajar. To the east, you notice an imposing door that seems to exudes evil.\n"
    			+ "To the north and south, there are two doors that look like they might lead outside.\n";
    	//Room[0][1]
    	String courtyard = "You are in a stone courtyard within the confines of the jail compound."
    			+ "The courtyard is surrounded by a barbed wire fence that is impossible to climb.\n"
    			+ "The courtyard loops around a corner and continues eastward. There is a door leading back inside the jail to the south.\n";
    	//Room[1][0]
    	String wardenoffice = "You are in what seems to be the warden's office, which is thankfully empty.\n"
    			+ "There is a large desk with many important-looking papers on it in the corner.\n"
    			+ "There is a patch of loose dirt underneath the desk.\n"
    			+ "The door you came in from seems to be the only entrance and exit from this room.\n";
    	//Room[2][3]
    	String downstairs = "You are standing in a narrow underground passage without windows. Behind you stone steps lead down from the trapdoor.\n"
    			+ "The passage continues eastward.\n";
    	//Room[1][1]
    	String gate = "You are standing in front of an old rusty gate.\n"
    			+ "On either side of the gate is a barbed wire fence that surrounds the whole compound and is impossible to climb.\n"
    			+ "To the west lies the main courtyard. This seems like the only way out.\n";
    	//Room[1][2]
    	String outside = "You are standing in front of the gate, having by some miracle been able to escape without anyone noticing.\n"
    			+ "Or so you thought...\n"
    			+ "Your way is barred by a group of mage guards, who wave their staffs at you threateningly.\n"
    			+ "Looks like you'll have to find another exit.\n";
    	//Room[3][3]
    	String outskirts = "You have arrived at the outskirts of the small town you had been held captive with. There is nothing dangerous in sight.\n";
  
    	rooms[0][0] = new Room(jail);
    	rooms[0][0].addItem(new ItemFood("bread", "A loaf of stale bread has found a home on the ground", 10));
    	rooms[0][0].addItem(new ItemWeap("bone", "A particularly large shard of bone is lying in the corner", 5, 
    			"You thwack him over the head with the bone you found."));
    	rooms[0][0].addUsableItem("shovel");
    	
    	rooms[2][2] = new Room(hallway);
    	rooms[2][2].addItem(new ItemWeap("stick", "A rather large and pointy stick leans against one wall", 10, 
    			"You stab everywhere that is unprotected."));
    	
    	rooms[0][1] = new Room(courtyard);
    	ArrayList<Enemy> enemiesin01 = new ArrayList<Enemy>();
    	enemiesin01.add(new Enemy("skeleton", "throws one of his bones at you", 10, 10, "The skeleton's bones clatter to the ground."));
    	rooms[0][1].setEnemiesInRoom(enemiesin01);
    	rooms[0][1].addItem(new ItemOther("shovel", "There's an old shovel with a bent handle lying around", "digs through dirt"));
    	
    	rooms[1][0] = new Room(wardenoffice);
    	Item key = new ItemOther("keys", "A glint of copper reveals a ring of large keys mostly hidden in the semidarkness", "unlocks stuff");
    	rooms[1][0].addItem(key);
    	rooms[1][0].addUsableItem("shovel");
    	
    	rooms[2][3] = new Room(downstairs);
    	ArrayList<Enemy> enemiesin23 = new ArrayList<Enemy>();
    	rooms[2][3].addItem(new ItemOther("gold", "A heaping pile of gold rests on an ornate ceramic pedestal, out of place in its "
    			+ "dreary surroundings", "This will make you very wealthy"));
    	enemiesin23.add(new Enemy("warden", "blasts you with a bolt of black lightning from his staff", 50, 20, 
    			"The warden's eyes widen in surprise, but then close as he takes his last breath."));
    	rooms[2][3].setEnemiesInRoom(enemiesin23);
    	
    	rooms[1][1] = new Room(gate);
    	rooms[1][1].addUsableItem("keys");
    	
    	rooms[1][2] = new Room(outside);
    
    	rooms[3][3] = new Room(outskirts);
    	
    	Room.makeUsableInAllRooms("portal gun");
    	
    	//Binding the rooms to each other with direction commands and doors that are either locked or unlocked
    	rooms[0][0].setDir("east", rooms[2][2], new Door(true));
    	rooms[2][2].setDir("north", rooms[0][1], new Door(true));
    	rooms[2][2].setDir("east", rooms[1][0], new Door(true));
    	rooms[2][2].setDir("south", rooms[1][1], new Door(true));
    	rooms[2][2].setDir("west", rooms[0][0], new Door(true));
    	rooms[1][0].setDir("west", rooms[2][2], new Door(true));
    	rooms[0][1].setDir("south", rooms[2][2], new Door(false));
    	rooms[0][1].setDir("east", rooms[1][1], new Door(false));
    	rooms[1][1].setDir("west", rooms[0][1], new Door(true));
    	rooms[1][1].setDir("south", rooms[1][2], new Door(false));
    	rooms[1][1].setDir("north", rooms[2][2], new Door(true));
    	rooms[1][2].setDir("north", rooms[1][1], new Door(true));
    	rooms[2][3].setDir("up", rooms[1][0], new Door(false));
    	rooms[2][3].setDir("east", rooms[3][3], new Door(false));
    	
    	currentRoom = rooms[0][0]; //sets the room that you start in
        over = false;
    }
    
    /**
     * Is this game over or not?
     * @return True if the game is over, false if not
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different room.
     * @param currentRoom The room to move to
     */
    public void setCurrentRoom(Room currentRoom) { 
    	this.currentRoom = currentRoom; 
    }
}