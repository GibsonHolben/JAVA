import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager 
{
	public static String Home;
	
	public static void CreateFiles()
	{
		
		Home = System.getProperty("user.home")+ "/Documents/Uno";
		File Uno = new File(Home);
		
		
		boolean file = Uno.mkdir();  
		if(file)
		{  
	        System.out.println("Folder is created successfully");  
	    }
	    else
	    {  
	       System.out.println("File already exists/an error has occored");  
	    }      
		String FilePath = Home + "/Settings.json";
		
		

		try 
		{
			File myObj = new File(FilePath);

		    if (myObj.createNewFile()) 
		    {
		       System.out.println("File created: " + myObj.getName());

		       try
		       {
		    	   FileWriter myWriter = new FileWriter(FilePath);
			       myWriter.write("Red,Blue,Green,Yellow/4");
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
		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		
		
		String FilePath2 = Home + "/HTP.json";

		try 
		{
			File myObj2 = new File(FilePath2);

		    if (myObj2.createNewFile()) 
		    {
		       System.out.println("File created: " + myObj2.getName());

		       try
		       {
		    	   FileWriter myWriter2 = new FileWriter(FilePath2);
			       myWriter2.write("How do you play the game of UNO?\r\n" + 
			       		"\r\n" + 
			       		"On your turn:\r\n" + 
			       		"	You can play a card when it matches either the color or number of the card, or if you have any wild cards.\r\n" + 
			       		" 	If you have no playable cards, you must draw a card from the draw pile.\r\n" + 
			       		"\r\n" + 
			       		"Goal:\r\n" + 
			       		" 	The aim of UNO is to be the first player to get rid of all of your cards so you'll want to avoid picking up cards as best you can.\r\n" + 
			       		"\r\n" + 
			       		"Cards:\r\n" + 
			       		"	0-13 numbers\r\n" + 
			       		"	S: Skips the next player\r\n" + 
			       		"	+2:  Forces the next player to draw 2 cards\r\n" + 
			       		"	W: Lets you change the color to your choice\r\n" + 
			       		"	W+4 Lets you change the color to your choice and forces the next player to draw 4 cards\\r\\n" + 
			       		"How to use interface: \r\n" + 
			       		"	To play this UNO game, simple select you desired py		");
			       myWriter2.close();
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

		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
	
		String FilePath3  = Home + "/Players.json";
		try 
		{
			File myObj3 = new File(FilePath3);

		    if (myObj3.createNewFile()) 
		    {
		       System.out.println("File created: " + myObj3.getName());

		       try
		       {
		    	   FileWriter myWriter3 = new FileWriter(FilePath3);
			       myWriter3.write("2");
			       myWriter3.close();
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
		}       
		catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
