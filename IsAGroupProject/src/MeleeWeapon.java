import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Creates a melee weapon
 * @author Gibson Holben
 * @version 0.1.2
 */
public class MeleeWeapon 
{
	
	/**The material that the melee weapon is made out of
	 * Must be Gold, Metal, Plastic, Crystal, and Vibranium
	 * Default = Metal*/
	String MeleeWeaponMaterial 		= "Metal";
	
	/**The Shinnyness of the Melee Weapon
	 * Min: 1 Max: 100
	 * Default = 100*/
	byte Sharpness 				= 100;
	
	/**The weapon that the clone uses 
	 * Must be a Spear, Sword, Hammer, or Scythe
	 * Default = Spear*/
	String Weapon 					= "Spear";
	
	
	/**
	 * Creates a MeleeWeapon with all instance variables
	 * @param MeleeWeapon The weapon that the clone uses (String)
	 * @param Shinnyness The Shinnyness of the Melee Weapon (byte)
	 * @param MeleeWeaponMaterial The material of the weapon (String)
	 */
	private MeleeWeapon(String Weapon,
						byte Shinnyness,
						String MeleeWeaponMaterial)					
	{
		this.Weapon 				= Weapon;
		this.Sharpness 			= Shinnyness;
		this.MeleeWeaponMaterial 	= MeleeWeaponMaterial;
	}
	


	/**
	 * Returns the variables of MeleeWeapon in a csv format
	 */
	public String toString()
	{
		return MeleeWeaponMaterial + "|" + Sharpness + "|" + Weapon;
	}
	
	/**
	 * Prints the variables to the console in an orderly fashion
	 */
	public void printAll()
	{

		System.out.format("%-20s%9s%n", "MeleeWeaponMaterial:" , MeleeWeaponMaterial);
		System.out.format("%-20s%9s%n", "Shinnyness: ",          Sharpness);
		System.out.format("%-20s%9s%n", "Weapon: ", 			  Weapon);

	}
	
	/**
	 * Compares a passed in MeleeWeapons to the one this function is called on
	 * and returns true if they match and visa versa
	 * @param MeleeWeapon the passed in MeleeWeapon
	 * @return does the passed in MeleeWeapon match this MeleeWeapon
	 */
	public boolean equals(MeleeWeapon MeleeWeapon)
	{
		if(this.Weapon 					== MeleeWeapon.Weapon
											&& this.Sharpness 			== 
											MeleeWeapon.Sharpness
											&& this.MeleeWeaponMaterial == 
											MeleeWeapon.MeleeWeaponMaterial)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	/**
	 * Builder class for meleeWeapon
	 * @author Gibson Holben
	 * @version 0.0.4
	 */
	public static class MeleeWeaponBuilder
	{
		
		
		
		
		/**
		 * Takes in the variables and applys edits to them
		 * and builds the object if they are good
		 * @param Weapon The weapon that the clone uses 
		 * @param Shinnyness The Shinnyness of the Melee Weapon
		 * @param MeleeWeaponMaterial The material that the melee weapon
		 *  is made out of
		 * @return a built  MeleeWeapon is good and null id bad
		 */
		public MeleeWeapon Build(String Weapon,
							 	 byte Shinnyness,
								 String MeleeWeaponMaterial)
		{
			//Trims the variables
			Weapon 				= Weapon.trim();
			MeleeWeaponMaterial = 
					MeleeWeaponMaterial.trim();
			
			
			
			
			
			if(weaponEdits(Weapon) == true && 
				shinnynessEdits(Shinnyness) == true &&
				weaponMaterialEdits(MeleeWeaponMaterial) == true)
			{
				//If the object values are good then create
				//a good report and build the object
				File file = new File(
						"C:/Users/CTEHolbenG46/Documents/MeleeWeapon/"
						+ "OutputAmount.txt");
				 Scanner Scanner;
				try 
				{
					increeseCounter();
					Scanner = new Scanner(file);
					String s = Scanner.nextLine();
					Scanner.close();
					goodReport("Report" + s, "C:/Users/CTEHolbenG46/"
									+ "Documents/MeleeWeapon/", Weapon, Shinnyness, 
									MeleeWeaponMaterial);
				} 
				catch (FileNotFoundException e) 
				{
					
				}    
				return new MeleeWeapon(Weapon, Shinnyness, MeleeWeaponMaterial);
				
			}
			else
			{
				//If the object values are not good then make the object null and 
				//create a bad report
				File file = new File(
						"C:/Users/CTEHolbenG46/Documents/MeleeWeapon/"
						+ "OutputAmount.txt");
				Scanner Scanner;
				try
				{
					increeseCounter();
					Scanner = new Scanner(file);
					String s = Scanner.nextLine();
					Scanner.close();
					badReport("Report" + s, "C:/Users/CTEHolbenG46/Documents/"
								+ "MeleeWeapon/", Weapon, Shinnyness, 
								MeleeWeaponMaterial);
				}
				catch (FileNotFoundException e) 
				{
					
				}
				return null;
			}
		
		}
		
		
		/**
		 * Checks the Weapon variable and makes sure it is good
		 * @param weapon The weapon that the clone uses 
		 * @return if the variables are good
		 */
		private boolean weaponEdits(String weapon)
		{
			switch(weapon)
			{
				case "Spear":
				case "Sword":
				case "Hammer": 
				case "Scythe": return true;
				default: 	return false;
					
			}
		}
		
		/**
		 * Checks the Shinnyness variable and makes sure it is good
		 * @param shinnyness The Shinnyness of the Melee Weapon
		 * @return  if the variables are good
		 */
		private boolean shinnynessEdits(byte shinnyness)
		{
			if(shinnyness > 0 && shinnyness < 101)
			{
				return true;
			}
			else
			{
				return false;
				
			}		
			
		}
		
		/**
		 * Checks the MeleeWeaponMaterial variable and makes sure it is good
		 * @param MeleeWeaponMaterial The material that the melee weapon is made out of
		 * @return  if the variables are good
		 */
		private boolean weaponMaterialEdits(String MeleeWeaponMaterial)
		{
			switch(MeleeWeaponMaterial)
			{
				case "Gold":
				case "Metal":
				case "Plastic": 
				case "Vibranium": return true;
				default: return false;
					
					
			}
		}
		
		
		/**
		 * Incresses the report number and saves it to a file
		 */
		public void increeseCounter()
		{
			try 
			{
				Scanner scanner = new Scanner(new File("C:/Users/CTEHolbenG46/"
						+ "Documents/MeleeWeapon/OutputAmount.txt"));
				
				Integer number = scanner.nextInt();
				number++;
				FileWriter myWriter = new FileWriter("C:/Users/CTEHolbenG46/"
						+ "Documents/"
						+ "MeleeWeapon/OutputAmount.txt");
				
				myWriter.write(number.toString());
				myWriter.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * Creates a good report if the object is built
		 * @param name The name of the file 
		 * @param path the path to where the file is saved
		 * @param Weapon The weapon that the clone uses 
		 * @param Shinnyness The Shinnyness of the Melee Weapon
		 * @param MeleeWeaponMaterial The material that the melee weapon
		 *  is made out of
		 */
		public void goodReport(String name, String path, String Weapon,
				byte Shinnyness,
				String MeleeWeaponMaterial)
		{
			if( name == "" || name == " ")
			{
				name = "GoodReport";
			}
				
			try
			{
				File file = new File(path + name + ".txt");	
				if(!file.exists()) 
				{
					File myFile = new File(path + name+ ".txt"); 	  
					myFile.createNewFile();  
				}
				FileWriter myWriter = new FileWriter(path + name+ ".txt");
			    String s = "Report has come back good\n" + "Weapon: " + Weapon
								    		+"\nShinnyness: "
								    		+ Shinnyness
											+"\nWeaponMaterial: "
											+ MeleeWeaponMaterial;
				myWriter.write(s);
				myWriter.close();
				System.out.println("Saved the file to " +
						path + name+ ".txt");
				
				 
			}
			catch (FileNotFoundException e)
			{
				//If the file cannot be found then print this error
				System.out.println("The file could not be found");
			}
			catch (IOException e)
			{
				System.out.println("Could not save the file (good)");
			}
		}
		
		/**
		 * Creates a bad report if the object fails to build
		 * @param name The name of the file 
		 * @param path the path to where the file is saved
		 * @param Weapon The weapon that the clone uses 
		 * @param Shinnyness The Shinnyness of the Melee Weapon
		 * @param MeleeWeaponMaterial The material that the melee weapon 
		 * is made out of
		 */
		public void badReport(String name, String path, String Weapon,
				byte Shinnyness,
				String MeleeWeaponMaterial)
		{
			
			
			if( name == "" || name == " ")
			{
				name = "BadReport";
			}
				
			try
			{
				File f = new File(path + name + ".txt");	
				if(!f.exists()) 
				{
					File myFile = new File(path + name + ".txt"); 	  
					myFile.createNewFile();  
				}
				FileWriter myWriter = new FileWriter(path + name+ ".txt");
			    String s = "Report has come back bad\n" + "Weapon: " + Weapon
			    							+"\nShinnyness: " + 
			    							Shinnyness
			    							+"\nWeaponMaterial: " +
			    							MeleeWeaponMaterial;
				myWriter.write(s);
				myWriter.close();
				System.out.println("Saved the file to " +
						path + name+ ".txt");
				
				 
			}
			catch (FileNotFoundException e)
			{
				//If the file cannot be found then print this error
				System.out.println("The file could not be found");
			}
			catch (IOException e)
			{
				System.out.println("Could not save the file");
			}
		}
	}

	
}


