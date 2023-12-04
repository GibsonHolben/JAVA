import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Creates a melee 
 * @author Gibson Holben
 * @version 0.1.2
 */
public class MeleeWeapon 
{
	/**
		 * @author CTEHolbenG46
		 * @version 0.0.1
		 */
	

	/**The weapon that the clone uses 
	 * Must be a Spear, Sword, Hammer, or Scythe
	 * Default = Spear*/
	String Weapon = "Spear";
	
	/**The Shinnyness of the Melee Weapon
	 * Min: 1 Max: 100
	 * Default = 100*/
	byte Shinnyness = 100;
	
	/**The weapon that the melee weapon is made out of
	 * Must be Gold, Metal, Plastic, Crystal, and Vibranium
	 * Default = Metal*/
	String MeleeWeaponMaterial = "Metal";
	
	
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
		this.Weapon = Weapon;
		this.Shinnyness = Shinnyness;
		this.MeleeWeaponMaterial = MeleeWeaponMaterial;
	}
	


	/**
	 * Returns the variables of MeleeWeapon in a csv format
	 */
	public String toString()
	{
		return Weapon + "|" + Shinnyness + "|" + MeleeWeaponMaterial;
	}
	
	/**
	 * Prints the variables to the console in an orderly fashion
	 */
	public void printAll()
	{
		System.out.println("Weapon: " + Weapon);
		System.out.println("Shinnyness: " + Shinnyness);
		System.out.println("MeleeWeaponMaterial: " + MeleeWeaponMaterial);
	}
	
	/**
	 * Compares a passed in MeleeWeapons to the one this function is called on
	 * and returns true if they match and visa versa
	 * @param MeleeWeapon the passed in MeleeWeapon
	 * @return does the passed in MeleeWeapon match this MeleeWeapon
	 */
	public boolean equals(MeleeWeapon MeleeWeapon)
	{
		if(this.Weapon == MeleeWeapon.Weapon
				&& this.Shinnyness == MeleeWeapon.Shinnyness
				&& this.MeleeWeaponMaterial == MeleeWeapon.MeleeWeaponMaterial)
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
	public static class Builder
	{
		public MeleeWeapon Build(String Weapon,
									byte Shinnyness,
									String MeleeWeaponMaterial)
		{
			
		 boolean isGood = true;

			switch(Weapon)
			{
				case "Spear":
				case "Sword":
				case "Hammer": 
				case "Scythe":
					break;
				default:
					isGood = false;
			}
			if(Shinnyness > 0 && Shinnyness < 101)
			{
			}
			else
			{
				isGood = false;
				
			}			
			switch(MeleeWeaponMaterial)
			{
				case "Gold":
				case "Metal":
				case "Plastic": 
				case "Vibranium":
					break;
				default:
					isGood = false;
					
			}
			if(isGood)
			{
				File file = new File(
						"C:/Users/CTEHolbenG46/Documents/MeleeWeapon/OutputAmount.txt");
			        Scanner sc;
					try 
					{
						sc = new Scanner(file);
						String s = sc.nextLine();
						 goodReport("report" + s, "C:/Users/CTEHolbenG46/Documents/MeleeWeapon/", Weapon, Shinnyness, MeleeWeaponMaterial);
					} 
					catch (FileNotFoundException e) 
					{
				
					}
			 
			       
				
				return new MeleeWeapon(Weapon, Shinnyness, MeleeWeaponMaterial);
				
			}
			else
			{
				return null;
			}
		
		}
		
		public void goodReport(String name, String path, String Weapon,
				byte Shinnyness,
				String MeleeWeaponMaterial)
		{
			
			
			if( name == "" || name == " ")
				name = "GoodReport";
			try
			{
				File f = new File(path + name + ".txt");	
				if(!f.exists()) 
				{
					File myFile = new File(path + name+ ".txt"); 	  
					myFile.createNewFile();  
				}
				FileWriter myWriter = new FileWriter(path + name+ ".txt");
			    String s = "Report has come back good\n" + "Weapon: " + Weapon;
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


