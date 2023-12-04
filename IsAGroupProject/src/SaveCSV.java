import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves an array of ???CLASS TO BE CHANGED???
 * @author Gibson Holben
 * @version 0.0.1
 */
public class SaveCSV
{
	/**
	 * Saves the variables on an array of MeleeWeapons to a text file at a
	 *  user specified path in a CVS format. Deliminator = |
	 * @param MeleeWeaponArray An array of MeleeWeapons that are saved to a file
	 * @param Path The path to the file
	 * @param Name The name of of the file
	 */
	public static void saveCsv(MeleeWeapon[] MeleeWeaponArray, String Path, String Name)
	{
		try
		{
			//Checks if the file exists
			File f = new File(Path + Name + ".txt");	
			if(!f.exists()) 
			{
				//Creates a new file if it does not exist
				File myFile = new File(Path + Name + ".txt"); 	  
				myFile.createNewFile();  
			}
			
			//Opens a new FileWriter
			FileWriter myWriter = new FileWriter(Path +  Name + ".txt");
			
			//Loops through an array of Printers and writes the data to the FileWriter
			for(int i = 0; i < MeleeWeaponArray.length; i++)
			{
				String s0 = MeleeWeaponArray[i].toString();
				myWriter.write(s0 + "\n");	
			}
			
			myWriter.write("\n");
			
			//Saves the data in the FileWriter
			myWriter.close();
			System.out.println("Saved file to: " + Path + Name + ".txt");
		}
		catch (FileNotFoundException e)
		{
			//If the file cannot be found then print this error
			
			throw new IllegalArgumentException("The file path could not be found");
		}
		catch (IOException e)
		{
			//All other errors go here
			throw new IllegalArgumentException("Could not save the file");
		}
		
	}
}
