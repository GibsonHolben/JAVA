import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controls the whole game.
 * @author CTEHolbenG46
 * @version 10.4.2
 */
public class MainGameLoop
{
	
	/**The current color of the main deck
	 * Default = blank*/
	public static String 			CurentColor = "";
	
	/**The player that is playing*/
	public static Player 			CurentPlayer;
	
	/**The player that has won
	 * Default = blank player*/
	public static Player 			CurentWinPlayer = new Player();
	
	/**the main frame*/
	public static MyFrame 			Frame;
	
	/**
	 * isthe game started
	 * default = false
	 */
	public static boolean 			isGameStarted = false;
	
	/**Is the game running?
	 * Default = true*/
	public static boolean 			isRunning = true;
	
	/**The main deck of the game*/
	public static Deck 				MainDeck;
	
	/**An array of players*/
	public static ArrayList<Player> Players;

	/**Holds the settings Example: 4 card colors, 
	 * wild card draw, the amount of each color in the deck 
	 * and weather the sound effets are played
	 * [0] the colors of the cards
	 * [1] how many cards a wild+ make you draw
	 * [2] how many cards of each color there are
	 * [3] play the sound
	 * [4]The background of the game*/

	public static String[] 			Settings = new String[5];


	/**Controls the game
	 * @param args Unused*/
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		game();
	}
	
	/**
	 * Contolles the game. Startup, While loop are controlled from here
	 */
	public static void game()
	{
		try
		{
			Frame.dispose();
			Players = new ArrayList<Player>();
			System.out.println("Disposed of old stuff");
		}
		catch (Exception ignored)
		{
			System.out.println("First time played");
		}
		
		//Creates the players
		Players = new ArrayList<Player>();
		
		//Calls the game initilization
		Setup.initGame();
		
		//Sets up the graphics
		Visuals.SettupGraphics();
		Frame.setLocationRelativeTo(null);

		Scanner DebugScanner = new Scanner(System.in);
		//Main game loop
		while(isRunning)
		{
			//Sets the frame visible 
			Frame.setVisible(true);
			
			System.out.println("Please enter a command");
			String Command = DebugScanner.next();
			
			switch(Command)
			{
				case "Log":
					System.out.println("Generating log...");
					FileManager.GenerateLogs();
					break;
				default: 
					System.out.println("Please enter a command");
					break;
			}
		}
		
		DebugScanner.close();
	}
	
	/**
	 * Flips the curent players hand
	 */
	public static void FlipCurentHand()
	{
		CurentPlayer.MyDeck.Cards.add(0,
				CurentPlayer.MyDeck.Cards.get(
						CurentPlayer.MyDeck.Cards.size() - 1));
		CurentPlayer.MyDeck.Cards.remove(
						CurentPlayer.MyDeck.Cards.size() - 1);
		if(CurentPlayer.curentCardIndex < CurentPlayer.MyDeck.Cards.size() -1)
		{
			CurentPlayer.curentCardIndex += 1;
		}
		else
		{
			CurentPlayer.curentCardIndex = 0;
		}
		Visuals.UpdateGraphicsPlayer();
	}
	
	/**
	 * Flips the curent players hand backwards
	 */
	public static void FlipCurentHandBack()
	{
		CurentPlayer.MyDeck.Cards.add(
				CurentPlayer.MyDeck.Cards.get(0));
		CurentPlayer.MyDeck.Cards.remove(0);
		if(CurentPlayer.curentCardIndex > 0 )
		{
			CurentPlayer.curentCardIndex -= 1;
		}
		else
		{
			CurentPlayer.curentCardIndex = CurentPlayer.MyDeck.Cards.size() - 1;
		}
		
		Visuals.UpdateGraphicsPlayer();	
	}
	

	/**
	 * Flips the top card and updates the graphics
	 */
	public static void Flip()
	{
		MainDeck.Cards.add(MainDeck.Cards.get(0));
		MainDeck.Cards.remove(0);
		Visuals.UpdateGraphicsFlip();
		
		
	}
	
	
	/**
	 * Moves the game on to the next player 
	 */
	public static void NextPlayer()
	{

		if(!MainDeck.Cards.get(0).SpecialEffect.contains("W"))
		{
			CurentColor = MainDeck.Cards.get(0).ColorValue;
		}

		Players.add(Players.get(0));
		Players.remove(0);
		CurentPlayer = Players.get(0);
		Visuals.UpdateGraphicsFlip();
		Visuals.UpdateGraphicsPlayer();
		NextPlayerFrame Npf = new NextPlayerFrame();
		Npf.setVisible(true);
		Frame.setAlwaysOnTop(false);
	}
	/**
	 * Returns the players decks
	 * @return the players decks
	 */
	public static String PrintPlayerDecks()
	{
		String ret = "";
		
		for(int i = 0; i < Players.size(); i++)
		{
			ret = ret + "[" + Players.get(i).Name + "]**************************************\n";
			ret = ret + Players.get(i).MyDeck.PrintDeck(true);
		}
		return ret;
	}

	/**
	 * Prints the settings of the game
	 * @return the settings as a string
	 */
	public static String PrintSettings()
	{
		String ret = "";
		for(int i = 0; i < Settings.length; i++)
		{
			ret = ret + Settings[i] + "\n";
		}
		return ret;
	}
	
	/**
	 * Starts the game and initalizes the graphics
	 */
	public static void Start()
	{
		Visuals.UpdateGraphicsFlip();
		Visuals.UpdateGraphicsPlayer();
	}
}
