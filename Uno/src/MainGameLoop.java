
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*; 

/**
 * Controls the whole game. including the card creation, 
 * player creation, and update loop
 * @author CTEHolbenG46
 * @version 0.6.2
 */
public class MainGameLoop
{
	//*********************
	
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
	
	/**Is the game running?*/
	public static boolean 			isRunning = true;
	
	/**The main deck of the game*/
	static Deck 					MainDeck;
	
	/**An array of players*/
	public static ArrayList<Player> Players;
	
	
	/**Holds the settings Example: 4 card colors, 
	 * wild card draw, the amount of each color in the deck 
	 * and weather the sound effets are played*/
	public static String[] 			Settings = new String[4];


	/**Controls the game
	 * @param args Unused*/
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		//Creates the players
		Players = new ArrayList<Player>();
		Setup.initGame();
		Visuals.SettupGraphics(MainDeck, Frame);

		//Main loop
		while(isRunning == true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a command");
			String input = sc.nextLine();
			
			//Commands
			switch(input)
			{
				case "ff":
					isRunning = false;	
					break;
				case "flip":
					Flip();
					break;
				case "hand":
					System.out.println(CurentPlayer.Name);
					CurentPlayer.MyDeck.PrintDeck();
					break;
				case "p":
					System.out.println("Pause");
					break;
				case "view":
					MainDeck.PrintDeck();
					break;
				case "cc":
					System.out.println(CurentColor);
					break;
				case "Help":
					System.out.println("ff, hand, p, view,"
							+ " test, cc, toS, Help, Settings");
					break;
				case "Settings": 
					PrintSettings();
					break;
				default: System.out.println("Invalid input:"
						+ " Help for commands");
			}
			
		}
		
		//Shows who wins
		while(isRunning == false)
		{
			
			Frame.hideButtons();
			Frame.repaint();
		
		}
		
		//Exit the game
		System.exit(0);
		System.out.println("End");
	}
	
	
	//*****************************************************
	
	/**
	 * Flips the curent players hand
	 */
	public static void FlipCurentHand()
	{
		CurentPlayer.MyDeck.Cards.add(
				CurentPlayer.MyDeck.Cards.get(0));
		CurentPlayer.MyDeck.Cards.remove(0);
		Visuals.UpdateGraphicsPlayer(CurentPlayer, Frame);
	}
	
	/**
	 * Flips the curent players hand backwards
	 */
	public static void FlipCurentHandBack()
	{
		CurentPlayer.MyDeck.Cards.add(0, 
				CurentPlayer.MyDeck.Cards.get(
						CurentPlayer.MyDeck.Cards.size() - 1));
		CurentPlayer.MyDeck.Cards.remove(
				CurentPlayer.MyDeck.Cards.size() - 1);
		Visuals.UpdateGraphicsPlayer(CurentPlayer, Frame);
	}
	

	/**
	 * Flips the top card and updates the graphics
	 */
	public static void Flip()
	{
		MainDeck.Cards.add(MainDeck.Cards.get(0));
		MainDeck.Cards.remove(0);
		Visuals.UpdateGraphicsFlip(MainDeck, Frame);
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
		Visuals.UpdateGraphicsFlip(MainDeck, Frame);
		Visuals.UpdateGraphicsPlayer(CurentPlayer, Frame);
	}
	
	/**
	 * Prints the settings of the game
	 */
	public static void PrintSettings()
	{
		for(int i = 0; i < Settings.length; i++)
		{
			System.out.println(Settings[i]);
		}
	}
	
	/**
	 * Starts the game and initalizes the graphics
	 */
	public static void Start()
	{
		Visuals.UpdateGraphicsFlip(MainDeck, Frame);
		Visuals.UpdateGraphicsPlayer(CurentPlayer, Frame);
	}
	
	
	
	
	

	
	
	
	
	
	/**
	 * Fix the Settings if they are incorect
	 */
	public static void fixColors()
	{

		 
		String FilePath = FileManager.Home + "/Settings.json";
		 File myObj = new File(FilePath);
		 myObj = new File(FilePath);
		 
		 System.out.println("incorect settings were inputed");
		 System.out.println("Refactoring settings...");
		 if (myObj.delete())
		 { 
		    System.out.println("Deleted the file: " + myObj.getName());
		    FileManager.CreateFiles();
		 } 
		 else 
		 {
		     System.out.println("Failed to delete the file.");
		 } 
		 System.out.println("Game will not be launched...");
		 System.out.println("Please restart the game...");
		 System.exit(0);	

	}

	
	
}
