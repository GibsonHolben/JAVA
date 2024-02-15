import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

/**
 * Used to create all the files needed for the game
 * @author CTEHolbenG46
 * @version 2.4.2
 *
 */
public class FileManager 
{
	/**A path to the UNO game directory*/
	public static String 		Home;
	
	//Final
	/**The default settings of the game*/
	static final String 		DEFAULTSETTINGS = "Red,Blue,Green,Yellow/4/11/true/Red";

	/**The File extention of the settings files*/
	public final static String  FILEEXTENTION 	= ".ini";
	
	/**
	 * Changes the amount of players
	 * @param input the new amount of players
	 */
	public static void ChangePlayers(String input)
	{
		try 
		{
			String PlayerPath  = FileManager.Home + "/Players" + FILEEXTENTION;
			FileWriter PlayerWriter = new FileWriter(PlayerPath);
		    PlayerWriter.write(input);
		    PlayerWriter.close();
		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred while getting player settings");
		      Setup.FixColors();
		      e.printStackTrace();
		}
	}
	
	
	/**
	 * Creates all the files for the game
	 * Including the settings file, the player 
	 * count file, and the how to play file
	 */
	public static void CreateFiles()
	{
		//Setup variables
		Home = System.getProperty("user.home")+ "/Documents/Uno";
		File Uno = new File(Home);
		Path path = Paths.get(Home);
		
		//Create the files if needed
		if(Files.notExists(path) || Files.notExists(Paths.get(Home + "/Logs")))
		{
			CreateDir(Uno);
			CreateDir(new File(Home + "/Logs"));
		}
		else
		{
			System.out.println("Directory exists: " + Uno.toString());
		}
		
		String SettingsPath = Home + "/Settings" + FileManager.FILEEXTENTION;
		try 
		{
			File Settings = new File(SettingsPath);

		    if (Settings.createNewFile()) 
		    {
		       System.out.println("File created: " + Settings.getName());

		       try
		       {
		    	   FileWriter SettingsWriter = new FileWriter(SettingsPath);
			       SettingsWriter.write(DEFAULTSETTINGS);
			       SettingsWriter.close();
			       System.out.println("Successfully wrote to the file.");		     
		       }
		       catch (IOException e)
		       {
		    	   System.out.println("An error occurred while writing to the file");
				   e.printStackTrace();
		       }
		       catch (Exception e) 
			   {
				      System.out.println("An error occurred");
				      e.printStackTrace();
			   }   
		    } 
		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred while saving the file: " + SettingsPath);
		      e.printStackTrace();
		}
		
		
		
		String HTPath = Home + "/HTP.txt";

		try 
		{
			File HowToPlay = new File(HTPath);

		    if (HowToPlay.createNewFile()) 
		    {
		       System.out.println("File created: " + HowToPlay.getName());

		       try
		       {
		    	   FileWriter HTPWriter = new FileWriter(HTPath);
			       HTPWriter.write("How do you play the game of UNO?\r\n" + 
			       		"\r\n" + 
			       		"On your turn:\r\n" + 
			       		"	You can play a card when"
			       		+ " it matches either the color"
			       		+ " or number of the card, or "
			       		+ "if you have any wild cards.\r\n" + 
			       		" 	If you have no playable "
			       		+ "cards, you must draw a card from the "
			       		+ "draw pile.\r\n" + 
			       		"\r\n" + 
			       		"Goal:\r\n" + 
			       		" 	The aim of UNO is to be the"
			       		+ " first player"
			       		+ " to get rid of all of"
			       		+ " your cards so you'll want to"
			       		+ " avoid picking"
			       		+ " up cards as best you can.\r\n" + 
			       		"\r\n" + 
			       		"Cards:\r\n" + 
			       		"	0-13 numbers\r\n" + 
			       		"	S: Skips the next player\r\n" + 
			       		"	+2:  Forces the next player to"
			       		+ " draw 2 cards\r\n" + 
			       		"	W: Lets you change the color to"
			       		+ " your choice\r\n" + 
			       		"	W+4 Lets you change the color to"
			       		+ " your choice and forces "
			       		+ "the next player to draw 4 cards\r\n" + 
			       		"\r\n" + 
			       		"How to use interface: \r\n" + 
			       		"	To start this UNO game, simple select"
			       		+ " you desired amount "
			       		+ "of players and press [Start].\r\n" + 
			       		"	Next use the [Flip>] and [<Flip]"
			       		+ " buttons to look through "
			       		+ "your hand of cards.\r\n" + 
			       		"	After the card that is on the top "
			       		+ "of your hand is the "
			       		+ "card that you wish to play, simply\r\n" + 
			       		"	click the card and it will be"
			       		+ " automaticly played.\r\n" + 
			       		"	If you are unable to take your "
			       		+ "turn due to not having a "
			       		+ "playable card thn you may press"
			       		+ " the \r\n" + 
			       		"	[Skip] Button. This button will "
			       		+ "draw a card for you and "
			       		+ "the game will move on to the next"
			       		+ " player\r\n" + 
			       		"		");
			       HTPWriter.close();
			       System.out.println("Successfully wrote to the file.");		     
		       }
		       catch (IOException e)
		       {
		    	   System.out.println("An error occurred while writing to the file");
				   e.printStackTrace();
		       }
		       catch (Exception e) 
			   {
				    System.out.println("An error occurred.");
				    e.printStackTrace();
			   }   
		    } 

		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred while saving the file: " + HTPath);
		      e.printStackTrace();
		}
		
	
		String PlayersPath  = Home + "/Players" + FILEEXTENTION;
		try 
		{
			File Players = new File(PlayersPath);

		    if (Players.createNewFile()) 
		    {
		       System.out.println("File created: " + Players.getName());

		       try
		       {
		    	   FileWriter PlayerWriter = new FileWriter(PlayersPath);
		    	   PlayerWriter.write("2");
		    	   PlayerWriter.close();
			       System.out.println("Successfully wrote to the file.");		     
		       }
		       catch (IOException e)
		       {
		    	   System.out.println("An error occurred while writing to the file");
				      e.printStackTrace();
		       }
		       catch (Exception e) 
			   {
				      System.out.println("An error occurred");
				      e.printStackTrace();
			   }   
		    } 
		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred while saving the file: " + PlayersPath);
		      e.printStackTrace();
		}
	}
	
	/**
	 * Creates a directory
	 * @param File the file that is created
	 */
	static void CreateDir(File File)
	{
		boolean file = File.mkdir();  
		if(file)
		{  
	        System.out.println("Folder is created successfully");  
	    }
	    else
	    {  
	       System.out.println("File already exists/an error has occored");  
	    }      
	}

	/**
	 * Generates a log of anything important in the game (Decks, Settings etc...)
	 */
	public static void GenerateLogs()
	{
		try 
		{
			LocalDateTime now = LocalDateTime.now(); 
			String date = now.toString();
			date = date.replace("-","");
			date = date.replace(":","");
			date = date.replace(".","");
		
			String LogPath = Home + "/Logs/log" + date + ".txt";
			File Log = new File(LogPath);
			if(!Log.exists())
			{
				if(Log.createNewFile())
				{
					System.out.println("Log Folder has been created");
				}
				else
				{
					System.out.println("Log folder could not be created");
				}

			}
			FileWriter LogWriter;
			LogWriter = new FileWriter(LogPath);
			LogWriter.write( "[MAINDECK]**************************************\n" + MainGameLoop.MainDeck.PrintDeck(true) + 
							MainGameLoop.PrintPlayerDecks() + "[SETTINGS]**************************************\n" + MainGameLoop.PrintSettings());
			LogWriter.close();
			System.out.println("Successfully wrote to the file");	
			System.out.println(LogPath);
			if (Desktop.isDesktopSupported()) 
			{
				 try 
				 {
					 Desktop.getDesktop().edit(Log);
				 } 
				 catch (IOException e) 
				 {
					e.printStackTrace();
				 }
			}
			else
			{
				System.out.println("System does not support notepad");
			}	
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	      
	      
	}
	/**
	 * Shows the how to play file
	 */
	public static void ShowHowToPlay()
	{
		if (Desktop.isDesktopSupported()) 
		{
			
			String HTPath  = FileManager.Home + "/HTP.txt";
		    try 
		    {
				Desktop.getDesktop().edit(new File(HTPath));
			} 
		    catch (IOException e) 
		    {
				e.printStackTrace();
			}
		} 
		else 
		{
		   System.out.println("Error getting how to play file");
		}
		
	}
	
	/**
	 * Shows the settings file and prints the 
	 * instructions on how to use said settings
	 */
	public static void ShowSettings()
	{
		if (Desktop.isDesktopSupported()) 
		{
		
			String SettingsPath = FileManager.Home + "/Settings" + FILEEXTENTION;
		    try 
		    {
		    	System.out.println("Opening with notepad...");
		    	System.out.println("Settings are deliminated as follows");
		    	System.out.println("Colors/Wild Draw Amount/Amount of each "
		    			+ "color card/Play Sound Effect");
		    	System.out.println("Only four colors are used");
		    	System.out.println("Supported colors are: Red, Blue, Green,"
		    			+ " Yellow, Orange, Magenta, & Cyan");
				Desktop.getDesktop().edit(new File(SettingsPath));
			} 
		    catch (IOException e) 
		    {
				e.printStackTrace();
			}
		} 
		else 
		{
		   System.out.println("Error getting settings file");
		}
		
	}
	
	/**
	 * Returns the object as a string 
	 * @return Home + "," + FILEEXTENTION + "," + DEFAULTSETTINGS;
	 */
	public String toString()
	{
        return Home + "," + FILEEXTENTION + "," + DEFAULTSETTINGS;
	}
}
