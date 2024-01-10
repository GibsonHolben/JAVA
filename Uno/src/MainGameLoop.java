
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
	
	/**The main deck of the game*/
	static Deck MainDeck;
	
	/**Is the game running?*/
	public static boolean isRunning = true;
	
	/**The curent color of the game
	 * Default = blank*/
	public static String CurentColor = "";
	
	/**the main frame*/
	public static MyFrame frame;
	
	
	public static ArrayList<Player> Players;

	/**Controlls the game
	 * @param args Unused*/
	public static void main(String[] args) 
	{
		Players = new ArrayList<Player>();
		initGame();

		while(isRunning == true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a command");
			String input = sc.nextLine();
			
			if(input.equals("ff"))
			{
				isRunning = false;
			}
			if(input.equals("flip"))
			{
				Flip();
				UpdateGraphics();
			}
			if(input.equals("view"))
			{
				MainDeck.PrintDeck();
			}
			if(input.equals("p"))
			{
				System.out.println("ok");
			}
			
			if(input.equals("MyHand"))
			{
				System.out.println("which player?");
				String input2 = sc.nextLine();
				Players.get(Integer.parseInt(input2)).MyDeck.PrintDeck();
			}
			
		}
		System.out.println("End");
	}
	
	/**
	 * Updates the graphics and fames a new frame
	 */
	public static void UpdateGraphics()
	{
		switch(MainDeck.Cards.get(0).colorValue)
		{
			case "Red":	frame.reset(Color.red, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Blue":frame.reset(Color.blue, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":frame.reset(Color.green, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Yellow":frame.reset(Color.yellow, Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
				
		}

	}
	
	/**
	 * Flips the top card and updates the graphics
	 */
	public static void Flip()
	{
		MainDeck.Cards.add(MainDeck.Cards.get(0));
		MainDeck.Cards.remove(0);
	}
	
	/**Starts the game*/
	public static void initGame()
	{
		MainDeck = new Deck(CreateCards());
		MainDeck.Shuffle();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many players");
		String input = sc.nextLine();
		
		for(int i = 0; i < Integer.parseInt(input); i++)
		{
			Player p = new Player();
			Players.add(p);
			
			for(int j = 0; j < 7; j++)
			{
				p.MyDeck.Cards.add(MainDeck.Cards.get(0));
				MainDeck.Cards.remove(0);
			}
		}
		System.out.println("Hello");
		
		SettupGraphics();
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
		
		return Cards;
	
	}
}
