package game;

/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author Cole Serfass, Joshua Hutton, Joey Sopikiotis
 * Wheaton College, CSCI 245
 * March 20, 2019
 */
public class PlayGame {
    
	/**
	 * The main method of the whole game
	 * @param args
	 */
    public static void main(String[] args) {
        System.out.println("Convicted of worshipping Melora, an unapproved god in the Dwendalian empire, \n"
        		+ "Kelsier is currently in jail seeking to escape and reconvene with his equally rebellious acolytes.\n"
        		+ "Your mission: get him out of jail alive!");
        Game game = Game.getInstance();   // reference to the game object
        Parser parser = new Parser(game);

        while (parser.executeTurn(game))
        	System.out.print("");
        	//this space left intentionally blank
        	
            
        System.out.println("Game over.");
    }
}
