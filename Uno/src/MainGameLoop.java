
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

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
				break;
			}
		}
		
		
		System.out.println("End");
	}
	
	/**
	 * sets the next player
	 */
	public static void nextPlayer()
	{
		CurentColor = MainDeck.Cards.get(0).colorValue;
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
			}
		}
		else
		{
			
			switch(CurentPlayer.MyDeck.Cards.get(0).colorValue)
			{
				case "Red":	frame.resetPlayerhand(Color.red, 		CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":frame.resetPlayerhand(Color.blue, 		CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":frame.resetPlayerhand(Color.green, 	CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":frame.resetPlayerhand(Color.yellow, 	CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
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
					frame.reset(Color.red, 		Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Blue":
					frame.reset(Color.blue, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Green":
					frame.reset(Color.green, 	Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":
					frame.reset(Color.yellow,	 Integer.toString(MainDeck.Cards.get(0).numberValue));
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
					
			}
		}
		

	}
	
	/**Starts the game*/
	public static void initGame()
	{
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
					
					
					settupDeck(input);
					SettupGraphics();
					CurentPlayer = Players.get(0);
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid number");
					initGame();
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
	
	/**
	 * Sets up he graphics
	 */
	public static void SettupGraphics()
	{
		switch(MainDeck.Cards.get(0).colorValue)
		{
			case "Red":	frame = new MyFrame(Color.red, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Blue":	frame = new MyFrame(Color.blue, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":	frame = new MyFrame(Color.green, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Yellow":	frame = new MyFrame(Color.yellow, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
				
		}
	}

	
	/**Creates a ArrayList of cards and returns them
	 * @return An ArrayList of cards */
	public static ArrayList<Card> CreateCards()
	{
		ArrayList<Card> Cards = new ArrayList<Card>();
		String[] colors = {"Red", "Blue", "Green", "Yellow"};
		
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 1; j < 14; j++)
			{
				Cards.add(new Card(j, colors[i]));
			}
		}
		
		String[] specials = { "+2", "R", "S"};
		
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 1; j < 4; j++)
			{
				Cards.add(new Card(colors[i], specials[j]));
			}
		}
		
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
}
