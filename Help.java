package game;

/**
 * Class that models the help command.
 *
 * @author Cole Serfass, Joshua Hutton
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class Help implements Command{
	
	/**
	 * Method for the help command
	 * @param otherWords The words in the command, not used here
	 * @param rm The current room
	 * @param pc The player
	 */
	@Override
	public void run(String nextWords, Room rm, Player pc) {
		System.out.println("You can always use the Help command (Which you've discovered) and the Look command at any time.\n"
				+ "Outside of that, try to grab items using the get command followed by the name of the item,\n"
				+ "use them with the use command followed by the name of the item,\n"
				+ "or place with the place command. These should each be formatted like this: \"get keys\".\n"
				+ "You can also inspect items you already have picked up by typing inspect [item],\n"
				+ "view inventory with inventory, and health with hp.\n"
				+ "You can also attack enemies by using the command \"hit [enemy]\". Good luck!");
	}
}
