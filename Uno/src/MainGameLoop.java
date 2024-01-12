
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import java.io.File;  
import java.io.IOException;
import java.io.FileWriter; 

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MainGameLoop
{
	//If you see this then you did it!
	/**The curent color of the game
	 * Default = blank*/
	public static String 			CurentColor = "";
	
	/**The player that is playing*/
	public static Player 			CurentPlayer;
	
	/**the main frame*/
	public static MyFrame 			frame;
	
	/**Is the game running?*/
	public static boolean 			isRunning = true;
	
	/**The main deck of the game*/
	static Deck 					MainDeck;
	
	/**An array of players*/
	public static ArrayList<Player> Players;
	
	/**The colors of the cards*/
	static String[] colorsBackup;
	


	/**Controlls the game
	 * @param args Unused*/
	public static void main(String[] args) 
	{
		//Creates the players
		Players = new ArrayList<Player>();
		initGame();

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
					System.exit(0);
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
					frame.SettupColorButtons(300);
				case "cc":
					System.out.println(CurentColor);
;				break;
			}
		}
		
		
		System.out.println("End");
	}
	
	/**
	 * sets the next player
	 */
	public static void nextPlayer()
	{
		if(!MainDeck.Cards.get(0).SpecialEffect.contentEquals("W") || !MainDeck.Cards.get(0).SpecialEffect.contentEquals("W+4"))
		{
			System.out.println("Wild cards played...");
		}
		else
		{
			CurentColor = MainDeck.Cards.get(0).colorValue;
		}

		Players.add(Players.get(0));
		Players.remove(0);
		CurentPlayer = Players.get(0);
		UpdateGraphicsFlip();
		UpdateGraphicsPlayer();
	}
	
	/**
	 * Starts the game
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
	 * Sets up he graphics
	 */
	public static void SettupGraphics()
	{
		switch(MainDeck.Cards.get(0).colorValue)
		{
			case "Red":	frame = new MyFrame(	Color.red, 		Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Blue":	frame = new MyFrame(Color.blue, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":	frame = new MyFrame(Color.green, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Yellow":	frame = new MyFrame(Color.yellow, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Magenta":	frame = new MyFrame(Color.magenta, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Cyan":	frame = new MyFrame(Color.cyan, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Black":	frame = new MyFrame(Color.gray, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
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
			switch(CurentPlayer.MyDeck.Cards.get(0).colorValue)
			{
				case "Red":	frame.resetPlayerhand(Color.red, 		Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Blue":frame.resetPlayerhand(Color.blue, 		Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Green":frame.resetPlayerhand(Color.green,	 	Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":frame.resetPlayerhand(Color.yellow, 	Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":frame.resetPlayerhand(Color.magenta, Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":frame.resetPlayerhand(Color.cyan, 		Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Black":frame.resetPlayerhand(Color.gray, 		Integer.toString(CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
			}
		}
		else
		{
			
			switch(CurentPlayer.MyDeck.Cards.get(0).colorValue)
			{
				case "Red":	frame.resetPlayerhand(Color.red, 			CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":frame.resetPlayerhand(Color.blue, 			CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":frame.resetPlayerhand(Color.green, 		CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":frame.resetPlayerhand(Color.yellow, 		CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":frame.resetPlayerhand(Color.magenta, 	CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":frame.resetPlayerhand(Color.cyan, 			CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Black":frame.resetPlayerhand(Color.gray, 			CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
			}
		}
	
	}

	/**
	 * Flips the top card and updates the graphics
	 */
	public static void Flip()
	{
		MainDeck.Cards.add(MainDeck.Cards.get(0));
		MainDeck.Cards.remove(0);
		UpdateGraphicsFlip();
		if(MainDeck.Cards.get(0).colorValue.equals("Black"))
		{
			Flip();
		}
	}
	/**
	 * Updates the graphics for the main deck
	 */
	public static void UpdateGraphicsFlip()
	{
		if(MainDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(MainDeck.Cards.get(0).colorValue)
			{
				case "Red":
					frame.reset(Color.red, 		 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Blue":
					frame.reset(Color.blue, 	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Green":
					frame.reset(Color.green, 	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":
					frame.reset(Color.yellow,	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":
					frame.reset(Color.magenta,	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":
					frame.reset(Color.cyan,	 	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Black":
					frame.reset(Color.gray,	 	 Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
					
			}
		}
		else
		{
			switch(MainDeck.Cards.get(0).colorValue)
			{
				case "Red":
					frame.reset(Color.red, 		MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":
					frame.reset(Color.blue, 	MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":
					frame.reset(Color.green, 	MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":
					frame.reset(Color.yellow,	MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":
					frame.reset(Color.magenta,	MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":
					frame.reset(Color.cyan,		MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Black":
					frame.reset(Color.gray,		MainDeck.Cards.get(0).SpecialEffect);
				break;
					
			}
		}
		

	}
	
	/**Starts the game*/
	public static void initGame()
	{
		//Creates the settings file
		CreateFile();
		
		//Ask how many players are wanted 
		Scanner sc = new Scanner(System.in);
		System.out.println("How many players");
		String input = sc.nextLine();
		
		
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
					if(MainDeck.Cards.get(0).colorValue.equals("Black"))
					{
						Flip();
					}
					settupDeck(input);
					SettupGraphics();
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
		CurentColor = MainDeck.Cards.get(0).colorValue;
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
			p.Name = "Player" + Integer.toString(i);
			Players.add(p);
			
			for(int j = 0; j < 7; j++)
			{
				p.MyDeck.Cards.add(MainDeck.Cards.get(0));
				MainDeck.Cards.remove(0);
			}
		}
	}
	

	/**Creates a ArrayList of cards and returns them
	 * @return An ArrayList of cards 
	 * @return an array of cards */
	public static ArrayList<Card> CreateCards()
	{
		//Reads the users settings and sets the color array to the proper colors
		String[] colors = new String[4];
		String data;
		String FilePath = System.getProperty("user.home");
		
		
		FilePath = FilePath + "/Documents/Settings.txt";
		try 
		{
			//Reads the file
			 File myObj = new File(FilePath);
		     Scanner myReader = new Scanner(myObj);
		     while (myReader.hasNextLine()) 
		     {
		    	 //Splits the colors
		    	 data = myReader.nextLine();
		    	 System.out.println(data);
		    	 colors = data.split(",");
		    	
		    	 if(colors.length > 4)
		    	 {
		    		 myReader.close();   
		    		 myObj = new File(FilePath);
		    		 System.out.println("More that four colors were inputed...");
		    		 System.out.println("Refactoring colors...");
		    		 if (myObj.delete())
		    		 { 
		    		     System.out.println("Deleted the file: " + myObj.getName());
		    		     CreateFile();
		    		 } 
		    		 else 
		    		 {
		    		     System.out.println("Failed to delete the file.");
		    		 } 
		    		 System.out.println("Game will not be launched...");
		    		 System.out.println("Please restart the game...");
		    		 System.exit(0);
		    	 }
		    	 colorsBackup = colors;
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
			for(int j = 1; j < 14; j++)
			{
				Cards.add(new Card(j, colors[i]));
			}
		}
		
		//Creates the special cards
		String[] specials = { "+2", "R", "S"};
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 1; j < 3; j++)
			{
				Cards.add(new Card(colors[i], specials[j]));
			}
		}
		
		//Creates wild cards
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W"));
		Cards.add(new Card("Black", "W+4"));
		Cards.add(new Card("Black", "W+4"));
		Cards.add(new Card("Black", "W+4"));
		Cards.add(new Card("Black", "W+4"));

		return Cards;
	}
	
	/**
	 * Creates a settings file and writes the setings to it
	 */
	public static void CreateFile()
	{
		
		String FilePath = System.getProperty("user.home");
		FilePath = FilePath + "/Documents/Settings.txt";
		try 
		{
			File myObj = new File(FilePath);
		    if (myObj.createNewFile()) 
		    {
		       System.out.println("File created: " + myObj.getName());
		       
		       try
		       {
		    	   FileWriter myWriter = new FileWriter(FilePath);
			       myWriter.write("Red,Blue,Green,Yellow");
			       myWriter.close();
			       System.out.println("Successfully wrote to the file.");
		       }
		       catch (IOException e)
		       {
		    	   System.out.println("An error occurred while saving the file");
				      e.printStackTrace();
		       }
		       catch (Exception e) 
			   {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
			   }
		     
		    } 
		    else 
		    {
		      System.out.println("File already exists.");
		    }
		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
