import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Used for setting up the objects and functions
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Setup
{
	
	
	/**
	 * Sets up the button 
	 * @param Button the button to setup
	 */
	public static void Button(JButton Button, JPanel panel)
	{
		Fonts(						Button, 15);
		Button.setBounds(				190, 400, 100, 60);
		Button.setBorder(				new LineBorder(Color.BLACK, 2));
		Button.setBackground(			Color.white);
		Button.setFocusPainted(			false);
		Button.setVisible(				true);
		panel.setLayout(				null);
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
		
	}
	
	/**
	 * Sets up the button with x and y cordenants
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 */
	public static void Button(JButton Button, int x, int y, JPanel panel)
	{	
		Fonts(						Button, 15);
		Button.setBorder(				new LineBorder(Color.black, 2));
		Button.setFocusPainted(			false);
		Button.setBackground(			Color.white);
		Button.setBounds(				x, y, 100,60);
		Button.setVisible(				true);
		panel.setLayout(				null);
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
	}
	
	/**
	 * Sets up the button with x and y cordenants
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 * @param panel The JPanel that the button is being added to
	 */
	public static void Button(JButton Button, 
								int x, int y, int w, int h, 
								JPanel panel)
	{	
		Fonts(							Button, 15);
		Button.setBorder(				new LineBorder(Color.black, 2));
		Button.setFocusPainted(			false);
		Button.setBackground(			Color.white);
		Button.setBounds(				x, y, w, h);
		Button.setVisible(				true);
	
		
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
		panel.setVisible(				true);
		
	}
	
	/**Creates a ArrayList of cards and returns them
	 * @return An ArrayList of cards */
	public static ArrayList<Card> CreateCards()
	{
		//Reads the users settings and sets the color array 
		//to the proper colors
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
		    	 MainGameLoop.Settings = data.split("/");
		    	 System.out.println(data);
		    	 
		    	 colors =  MainGameLoop.Settings[0].split(",");
		    	 System.out.println( MainGameLoop.Settings[1]);
		    	 
		    	 if(Integer.parseInt( MainGameLoop.Settings[1]) > 9 || 
		    			 Integer.parseInt( MainGameLoop.Settings[1]) < 1)
		    	 {
		    		 myReader.close();   
		    		 JOptionPane.showMessageDialog( MainGameLoop.Frame, 
		    				 "Invalid Settings... Wild card value must"
		    				 + " be less than 10... Refactoring...");
		    		 Setup.fixColors();
		    	 }
		    	 
		    	 if(Integer.parseInt( MainGameLoop.Settings[2]) > 99 || 
		    			 Integer.parseInt( MainGameLoop.Settings[2]) < 1)
		    	 {
		    		 myReader.close();   
		    		 JOptionPane.showMessageDialog( MainGameLoop.Frame, 
		    				 "Invalid Settings... Card count must be "
		    				 + "between 1 and 100... Refactoring...");
		    		 Setup.fixColors();
		    	 }
		    	 
		    	 
		    	//Checks the colors and makes sure they are right
		    	 if(colors.length > 4)
		    	 {
		    		
		    		myReader.close();   
		    		 JOptionPane.showMessageDialog( MainGameLoop.Frame, 
		    				 "Invalid Settings... Only four colors are"
		    				 + "supported Refactoring...");
		    		 Setup.fixColors();
		    			
		    	 }
		    	 else
		    	 {
		    		 for(int i = 0; i < colors.length; i++)
		    		 {
		    			if( colors[i].equals(Card.AcceptedColors[0])||
		    				colors[i].equals(Card.AcceptedColors[1])||
		    				colors[i].equals(Card.AcceptedColors[2])||
		    				colors[i].equals(Card.AcceptedColors[3])||
		    				colors[i].equals(Card.AcceptedColors[4])||
		    				colors[i].equals(Card.AcceptedColors[5])||
		    				colors[i].equals(Card.AcceptedColors[6]))
		    			{
		    				System.out.println("Corect: " + colors[i]);
		    			}
		    			else
		    			{
		    				myReader.close();   
		    				JOptionPane.showMessageDialog( MainGameLoop.Frame,
		    						"Invalid Settings... Supported colors are: "
		    						+ "Red, Blue, Green, Yellow, Orange, Magenta, "
		    						+ "& Cyan.. Refactoring...");
		    				 Setup.fixColors();
		    			}
		    		 }
		    		
		    		 
		    	 }
		    	 Card.ColorsBackup = colors;
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
			for(int j = 0; j < Integer.parseInt( MainGameLoop.Settings[2]); j++)
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
		Cards.add(new Card("Black", "W+" +  MainGameLoop.Settings[1]));
		Cards.add(new Card("Black", "W+" +  MainGameLoop.Settings[1]));
		Cards.add(new Card("Black", "W+" +  MainGameLoop.Settings[1]));
		Cards.add(new Card("Black", "W+" +  MainGameLoop.Settings[1]));

		return Cards;
	}
	
	/**
	 * Creates a JLabel at specified cordenates with a 
	 * specified size and a specified text
	 * @param x the x cords of the label
	 * @param y the y cords of the label
	 * @param w the width of the label
	 * @param h the height of the label
	 * @param text the text of the label
	 * @return a new JLabel of the label
	 */
	public static JLabel CreateLabel(int x, int y, int w, int h, String text)
	{
		JLabel jb = new JLabel(text);
		jb.setBounds(new Rectangle(x, y, w, h));
		
		return jb;
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

	
	/**
	 * Sets the font on a jbutton
	 * @param Jb the button that the font is changed on
	 * @param fontsize the new size of the font
	 */
	public static void Fonts(JButton Jb, int fontsize)
	{
		Jb.setFont(new Font("URW Grotesk", Font.BOLD, fontsize));
	}

	

	
	
	/**Starts the game and initilizes all the neccecary features of the game
	 * as well as does edits on some of the settings*/
	public static void initGame()
	{
		//Clears all players from the game on the second initilization
		if(MainGameLoop.Players.size() > 0)
		{
			MainGameLoop.Players.clear();
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
			 input = myReader.nextLine();
			 
			//Sets up the players		
			if(!input.isEmpty())
			{
				//Check if the corect amount of players is entered
				if(Integer.parseInt(input) < 5 && 
						Integer.parseInt(input) > 0)
				{
					//Settup main deck
					MainGameLoop.MainDeck = new Deck(CreateCards());
					MainGameLoop.MainDeck.Shuffle();			
					Setup.settupDeck(input);
					MainGameLoop.CurentPlayer = MainGameLoop.Players.get(0);		
				}
				else
				{
					System.out.println("Please enter a valid number"
											+ " (1-4)");
					initGame();
				}
			}	
		} 
		catch (FileNotFoundException e1) 
		{
			System.out.println("Players file could not be read");
			e1.printStackTrace();
		}
				
		//Checks for wild cards on the top
		while(!MainGameLoop.MainDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			//Flips the deck if they are on top
			System.out.println("Special card was on top... "
					+ "\nfliping the deck...");
			MainGameLoop.MainDeck.Cards.add(MainGameLoop.MainDeck.Cards.get(0));
			MainGameLoop.MainDeck.Cards.remove(0);
			
		}
		MainGameLoop.CurentColor = MainGameLoop.MainDeck.Cards.get(0).ColorValue;
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
			MainGameLoop.Players.add(p);
			
			for(int j = 0; j < 7; j++)
			{
				p.MyDeck.Cards.add(MainGameLoop.MainDeck.Cards.get(0));
				MainGameLoop.MainDeck.Cards.remove(0);
			}
		}
	}
	
	
	
}
