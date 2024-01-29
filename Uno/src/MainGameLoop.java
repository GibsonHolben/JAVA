
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*; 

/**
 * Controls the whole game. including the card creation, player creation, and update loop
 * @author CTEHolbenG46
 * @version 0.6.2
 */
public class MainGameLoop
{
	//*********************FIX THE INSTRUCTONS
	
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
	
	/**The colors of the cards*/
	static String[] 				ColorsBackup;
	
	/**The acceptable colors for the cards*/
	static String[] 				AcceptedColors = {"Red", "Blue", "Green", "Yellow", "Magenta", "Cyan", "Orange"};
	
	/**Holds the settings Example: card colors, wild card draw */
	public static String[] 			Settings = new String[4];


	/**Controls the game
	 * @param args Unused*/
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		//Creates the players
		Players = new ArrayList<Player>();
		initGame();
		SettupGraphics();

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
				case "test":
					Frame.SettupColorButtons(300);
				case "cc":
					System.out.println(CurentColor);
				break;
				case "toS":
					System.out.println(Frame.toString());
				case "Help":
					System.out.println("ff, hand, p, view, test, cc, toS, Help");
				break;
				case "Settings": 
					PrintSettings();
					break;
				default: System.out.println("Invalid input: Help for commands");
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
	
	
	/**Starts the game*/
	public static void initGame()
	{
		//Checks if the players are greater that 0
		if(Players.size() > 0)
		{
			//Clears all players from the game
			Players.clear();
		}
		
		//Creates the files
		String input = "1";
		FileManager.CreateFiles();
		
		//Reads the file
		String FilePath = FileManager.Home;
		FilePath = FilePath + "/Players.json";
		File myObj = new File(FilePath);
	    Scanner myReader;
		try 
		{
			 myReader = new Scanner(myObj);
			 while (myReader.hasNextLine()) 
		     {
				 input = myReader.nextLine();
		     }
		} 
		catch (FileNotFoundException e1) 
		{
			
			e1.printStackTrace();
		}
	    
			
		
		//Sets up the players		
		if(!input.isEmpty())
		{
			//Check if the corect amount of players is entered
			if(Integer.parseInt(input) < 5 && Integer.parseInt(input) > 0)
			{
				
				try
				{
					//Settup main deck
					MainDeck = new Deck(CreateCards());
					MainDeck.Shuffle();			
					settupDeck(input);
				
					CurentPlayer = Players.get(0);
				}
				catch(Exception e)
				{
					System.out.println("Error");
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Please enter a valid number (1-4)");
				initGame();
			}
		}
		
		//Checks for wild cards on the top
		while(MainDeck.Cards.get(0).ColorValue.equals("Black"))
		{
			//Flips the deck if they are on top
			System.out.println("Wild card was on top... \nfliping the deck...");
			MainDeck.Cards.add(MainDeck.Cards.get(0));
			MainDeck.Cards.remove(0);
			
		}
		CurentColor = MainDeck.Cards.get(0).ColorValue;
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
		UpdateGraphicsFlip();
		UpdateGraphicsPlayer();
	}
	
	/**
	 * Starts the game and initalizes the graphics
	 */
	public static void Start()
	{
		UpdateGraphicsFlip();
		UpdateGraphicsPlayer();
	}
	
	/**
	 * Flips the curent players hand
	 */
	public static void FlipCurentHand()
	{
		CurentPlayer.MyDeck.Cards.add(CurentPlayer.MyDeck.Cards.get(0));
		CurentPlayer.MyDeck.Cards.remove(0);
		UpdateGraphicsPlayer();
	}
	/**
	 * Flips the curent players hand backwards
	 */
	public static void FlipCurentHandBack()
	{
		CurentPlayer.MyDeck.Cards.add(0, CurentPlayer.MyDeck.Cards.get(CurentPlayer.MyDeck.Cards.size() - 1));
		CurentPlayer.MyDeck.Cards.remove(CurentPlayer.MyDeck.Cards.size() - 1);
		UpdateGraphicsPlayer();
	}
	

	/**
	 * Flips the top card and updates the graphics
	 */
	public static void Flip()
	{
		MainDeck.Cards.add(MainDeck.Cards.get(0));
		MainDeck.Cards.remove(0);
		UpdateGraphicsFlip();
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
	 * Updates the graphics for the main deck
	 */
	public static void UpdateGraphicsFlip()
	{
		if(MainDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(MainDeck.Cards.get(0).ColorValue)
			{
				case "Red":
					Frame.reset(Color.red, 						 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Blue":
					Frame.reset(Color.blue, 					 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Green":
					Frame.reset(Color.green, 					 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":
					Frame.reset(new Color(255, 206, 71),	 	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":
					Frame.reset(Color.magenta,	 				 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":
					Frame.reset(Color.cyan,	 					 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Orange":
					Frame.reset(new  Color(252, 148, 20),	 	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Black":
					Frame.reset(Color.black,	 				 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
					
			}
		}
		else
		{
			switch(MainDeck.Cards.get(0).ColorValue)
			{
				case "Red":
					Frame.reset(Color.red, 					MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":
					Frame.reset(Color.blue, 				MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":
					Frame.reset(Color.green, 				MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":
					Frame.reset(new Color(255, 206, 71),	MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":
					Frame.reset(Color.magenta,				MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":
					Frame.reset(Color.cyan,					MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Orange":
					Frame.reset(new  Color(252, 148, 20),	MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Black":
					Frame.reset(Color.black,					MainDeck.Cards.get(0).SpecialEffect);
				break;		
					
			}
		}
		

	}
	
	/**
	 * Sets up the graphics and creates a frame
	 */
	public static void SettupGraphics()
	{
		switch(MainDeck.Cards.get(0).ColorValue)
		{
			case "Red":		Frame = new MyFrame(	Color.red, 					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;			
			case "Blue":	Frame = new MyFrame(Color.blue, 				Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":	Frame = new MyFrame(Color.green, 				Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Yellow":	Frame = new MyFrame(new Color(255, 206, 71), 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Magenta":	Frame = new MyFrame(Color.magenta, 				Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Cyan":	Frame = new MyFrame(Color.cyan, 				Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Orange":	Frame = new MyFrame(new  Color(252, 148, 20), 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Black":	Frame = new MyFrame(Color.black, 				Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
				
		}
	}

	
	
	/**
	 * Updates the graphics for the players hand
	 */
	public static void UpdateGraphicsPlayer()
	{
		if(CurentPlayer.MyDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(CurentPlayer.MyDeck.Cards.get(0).ColorValue)
			{
				case "Red":		Frame.resetPlayerhand(Color.red, 						Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Blue":	Frame.resetPlayerhand(Color.blue, 						Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Green":	Frame.resetPlayerhand(Color.green,	 					Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":	Frame.resetPlayerhand(new Color(255, 206, 71), 		Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":	Frame.resetPlayerhand(Color.magenta,					Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":	Frame.resetPlayerhand(Color.cyan, 						Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Orange":	Frame.resetPlayerhand(new  Color(252, 148, 20), Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Black":	Frame.resetPlayerhand(Color.black, 						Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
			}
		}
		else
		{
			
			switch(CurentPlayer.MyDeck.Cards.get(0).ColorValue)
			{
				case "Red":		Frame.resetPlayerhand(Color.red, 					CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":	Frame.resetPlayerhand(Color.blue, 					CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":	Frame.resetPlayerhand(Color.green, 				CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":	Frame.resetPlayerhand(new Color(255, 206, 71), 	CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":	Frame.resetPlayerhand(Color.magenta, 			CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":	Frame.resetPlayerhand(Color.cyan, 					CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;	
				case "Orange":	Frame.resetPlayerhand(new  Color(252, 148, 20), 	CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;	
				case "Black":	Frame.resetPlayerhand(Color.black, 					CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
			}
		}
	
	}
	
	
	
	/**
	 * Sets up the player hands
	 * @param input the amount of players
	 */
	public static void settupDeck(String input)
	{
		for(int i = 0; i < Integer.parseInt(input); i++)
		{
			Player p = new Player();
			p.Name = "Player" + Integer.toString(i + 1);
			Players.add(p);
			
			for(int j = 0; j < 7; j++)
			{
				p.MyDeck.Cards.add(MainDeck.Cards.get(0));
				MainDeck.Cards.remove(0);
			}
		}
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

	/**Creates a ArrayList of cards and returns them
	 * @return An ArrayList of cards */
	public static ArrayList<Card> CreateCards()
	{
		//Reads the users settings and sets the color array to the proper colors
		String[] colors = new String[4];
		String data;
		String FilePath = FileManager.Home; 
		FilePath = FilePath + "/Settings.json";

		try 
		{
			//Reads the file
			 File myObj = new File(FilePath);
		     Scanner myReader = new Scanner(myObj);
		     while (myReader.hasNextLine()) 
		     {
		    	 //Splits the colors
		    	 data = myReader.nextLine();
		    	 Settings = data.split("/");
		    	 System.out.println(data);
		    	 
		    	 colors = Settings[0].split(",");
		    	 System.out.println(Settings[1]);
		    	 
		    	 if(Integer.parseInt(Settings[1]) > 9 || Integer.parseInt(Settings[1]) < 1)
		    	 {
		    		 myReader.close();   
		    		 JOptionPane.showMessageDialog(Frame, "Invalid Settings... Wild card value must be less than 10... Refactoring...");
		    		 fixColors();
		    	 }
		    	 
		    	 if(Integer.parseInt(Settings[2]) > 99 || Integer.parseInt(Settings[2]) < 1)
		    	 {
		    		 myReader.close();   
		    		 JOptionPane.showMessageDialog(Frame, "Invalid Settings... Card count must be between 1 and 100... Refactoring...");
		    		 fixColors();
		    	 }
		    	 
		    	 
		    	//Checks the colors and makes sure they are right
		    	 if(colors.length > 4)
		    	 {
		    		
		    		myReader.close();   
		    		 JOptionPane.showMessageDialog(Frame, "Invalid Settings... Only four colors are supported Refactoring...");
		    		fixColors();
		    			
		    	 }
		    	 else
		    	 {
		    		 for(int i = 0; i < colors.length; i++)
		    		 {
		    			if( colors[i].equals(AcceptedColors[0])||
		    				colors[i].equals(AcceptedColors[1])||
		    				colors[i].equals(AcceptedColors[2])||
		    				colors[i].equals(AcceptedColors[3])||
		    				colors[i].equals(AcceptedColors[4])||
		    				colors[i].equals(AcceptedColors[5])||
		    				colors[i].equals(AcceptedColors[6]))
		    			{
		    				System.out.println("Corect: " + colors[i]);
		    			}
		    			else
		    			{
		    				myReader.close();   
		    				JOptionPane.showMessageDialog(Frame, "Invalid Settings... Supported colors are: Red, Blue, Green, Yellow, Orange, Magenta, & Cyan.. Refactoring...");
			    			fixColors();
		    			}
		    		 }
		    		
		    		 
		    	 }
		    	 ColorsBackup = colors;
		     }
		     myReader.close();  
		  
		   
		} 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		ArrayList<Card> Cards = new ArrayList<Card>();
	
		//Creates the basic cards
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 0; j < Integer.parseInt(Settings[2]); j++)
			{
				Cards.add(new Card(j, colors[i]));
			}
		}
				
		
		//Creates the special cards
		String[] specials = { "+2", "S"};
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				Cards.add(new Card(colors[i], specials[j]));
			}
		}
		
		//Creates wild cards
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W"));
		
		//Creates wild + &SETTING& cards
		Cards.add(new Card("Black", "W+" + Settings[1]));
		Cards.add(new Card("Black", "W+" + Settings[1]));
		Cards.add(new Card("Black", "W+" + Settings[1]));
		Cards.add(new Card("Black", "W+" + Settings[1]));

		return Cards;
	}
	
}
