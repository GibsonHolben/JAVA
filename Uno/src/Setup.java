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
 * @version 0.0.7
 */
public class Setup
{
	
	/**
	 * Sets up the button with x and y cordenants
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 * @param w the width of the button
	 * @param h the height of the button
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
	
	/**
	 * Gets a awt.Color from a String color
	 * @param color
	 * @return the awt.Color version from a String
	 */
	public static Color GetColor(String color)
	{
		switch(color)
		{
			case "Red":		return Visuals.RED;	
			case "Blue":	return Visuals.BLUE;			
			case "Green":	return Visuals.GREEN;			
			case "Yellow":	return Visuals.YELLOW;			
			case "Magenta":	return Visuals.MAGENTA;			
			case "Cyan":	return Visuals.CYAN;			
			case "Orange":	return Visuals.ORANGE;			
			case "Grey":	return Visuals.GREY;			
			case "Black":	return Visuals.BLACK;
			default: return Visuals.RED;		
		}
	}
	
	/**Creates a ArrayList of cards and returns them
	 * @return An ArrayList of cards */
	public static ArrayList<Card> CreateCards()
	{
		//Reads the users settings and sets the color array 
		//to the proper colors
		String[] colors = new String[4];
		String SettingsData;
		String SettingsFilePath = FileManager.Home; 
		SettingsFilePath = SettingsFilePath + "/Settings"+ FileManager.FILEEXTENTION;

		try 
		{
			//Reads the file
			 File SettingsObj = new File(SettingsFilePath);
		     Scanner SetingsReader = new Scanner(SettingsObj);
		     while (SetingsReader.hasNextLine()) 
		     {
		    	 //Splits the colors
		    	 SettingsData = SetingsReader.nextLine();
		    	 MainGameLoop.Settings = SettingsData.split("/");
		    	 System.out.println(SettingsData);
		    	 
		    	
		    	 
		    	 colors =  MainGameLoop.Settings[0].split(",");
		    	 System.out.println( MainGameLoop.Settings[1]);
		    	 
		    	 if(Integer.parseInt( MainGameLoop.Settings[1]) > 9 || 
		    			 Integer.parseInt( MainGameLoop.Settings[1]) < 1)
		    	 {
		    		 SetingsReader.close();   
		    		 JOptionPane.showMessageDialog( MainGameLoop.Frame, 
		    				 "Invalid Settings... Wild card value must"
		    				 + " be less than 10... Refactoring...");
		    		 Setup.FixColors();
		    	 }
		    	 
		    	 if(Integer.parseInt( MainGameLoop.Settings[2]) > 99 || 
		    			 Integer.parseInt( MainGameLoop.Settings[2]) < 1)
		    	 {
		    		 SetingsReader.close();   
		    		 JOptionPane.showMessageDialog( MainGameLoop.Frame, 
		    				 "Invalid Settings... Card count must be "
		    				 + "between 1 and 100... Refactoring...");
		    		 Setup.FixColors();
		    	 }
		    	 
		    	 
		    	//Checks the colors and makes sure they are right
		    	 if(colors.length > 4)
		    	 {
		    		
		    		SetingsReader.close();   
		    		 JOptionPane.showMessageDialog( MainGameLoop.Frame, 
		    				 "Invalid Settings... Only four colors are"
		    				 + "supported Refactoring...");
		    		 Setup.FixColors();
		    			
		    	 }
		    	 else
		    	 {
		    		 for(int i = 0; i < colors.length; i++)
		    		 {
		    			if( colors[i].equals(Settings.ACCEPTEDCOLORS[0])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[1])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[2])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[3])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[4])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[5])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[6])||
		    				colors[i].equals(Settings.ACCEPTEDCOLORS[7]))
		    			{
		    				System.out.println("Corect: " + colors[i]);
		    			}
		    			else
		    			{
		    				SetingsReader.close();   
		    				JOptionPane.showMessageDialog( MainGameLoop.Frame,
		    						"Invalid Settings... Supported colors are: "
		    						+ "Red, Blue, Green, Yellow, Orange, Magenta, "
		    						+ ", Cyan, and Grey .. Refactoring...");
		    				 Setup.FixColors();
		    			}
		    		 }
		    		 
		    		 if(MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[0])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[1])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[2])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[3])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[4])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[5])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[6])||
			    		MainGameLoop.Settings[4].equals(Settings.ACCEPTEDCOLORS[7]))
		    		{
		    			System.out.println("Corect: " + MainGameLoop.Settings[4]);
		    		}
		    		else
		    		{
		    			SetingsReader.close();   
		    			JOptionPane.showMessageDialog( MainGameLoop.Frame,
	    						"Invalid Settings... Supported colors are: "
	    						+ "Red, Blue, Green, Yellow, Orange, Magenta, "
	    						+ " Cyan, and Grey .. Refactoring...");
		    			 Setup.FixColors();
		    		}		
		    		 
		    	 }
		    	 Settings.ColorsBackup = colors;
		     }
		     SetingsReader.close();  
		  
		   
		} 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred while reading"
		      					 + " the settings file");
		      JOptionPane.showMessageDialog(MainGameLoop.Frame, 
		    		  "An error occurred while reading the settings file");
		      JOptionPane.showMessageDialog(MainGameLoop.Frame,
		    		  "Refactoring Settings");
		      Setup.FixColors();
		      e.printStackTrace();
		}
		
		ArrayList<Card> Cards = new ArrayList<Card>();
	
		//Creates the basic cards
		for(int k = 0; k < 2; k++)
		{
			for(int i = 0; i < colors.length; i++)
			{
				for(int j = 0; j < Integer.parseInt( MainGameLoop.Settings[2]); j++)
				{
					Cards.add(new Card(j, colors[i]));
				}
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
	 * Recreate the settings file if needed
	 */
	public static void FixColors()
	{
		 String SettingsFilePath = FileManager.Home +
				 "/Settings" + FileManager.FILEEXTENTION;
		 File Settings = new File(SettingsFilePath);
		 Settings = new File(SettingsFilePath);
		 
		 System.out.println("incorect settings were inputed");
		 System.out.println("Refactoring settings...");
		 if (Settings.delete())
		 { 
		    System.out.println("Deleted the file: " + Settings.getName());
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
	 * as well as does edits on some of the settings
	 * Gets called from main as well as MyFrame*/
	public static void initGame()
	{
		//Clears all players from the game on the second initilization
		if(MainGameLoop.Players.size() > 0)
		{
			MainGameLoop.Players.clear();
		}
		
		//Creates the files
		String PlayerInput;
		FileManager.CreateFiles();
		
		//Reads the file
		String PlayerFilePath = FileManager.Home;
		PlayerFilePath = PlayerFilePath + "/Players" + FileManager.FILEEXTENTION;
		File PlayerObj = new File(PlayerFilePath);
	    Scanner PlayerReader;
		try 
		{
			 PlayerReader = new Scanner(PlayerObj);
			 PlayerInput = PlayerReader.nextLine();
			 
			//Sets up the players		
			if(!PlayerInput.isEmpty())
			{
				//Check if the corect amount of players is entered
				if(Integer.parseInt(PlayerInput) < 5 && 
						Integer.parseInt(PlayerInput) > 0)
				{
					//Settup main deck
					MainGameLoop.MainDeck = new Deck(CreateCards());
					MainGameLoop.MainDeck.Shuffle();			
					Setup.settupDeck(PlayerInput);
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
