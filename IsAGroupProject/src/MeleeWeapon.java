/**
 * Creates a melee 
 * @author Gibson Holben
 * @version 0.1.2
 */
public class MeleeWeapon 
{
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
	 * Default construtor
	 */
	MeleeWeapon()
	{
		
	}
	
	/**
	 * Creates a MeleeWeapon with all instance variables
	 * @param MeleeWeapon The weapon that the clone uses (String)
	 * @param Shinnyness The Shinnyness of the Melee Weapon (byte)
	 * @param MeleeWeaponMaterial The material of the weapon (String)
	 */
	MeleeWeapon(String Weapon,
				byte Shinnyness,
				String MeleeWeaponMaterial)
	{
		//Weapon (change to switch
		if(Weapon == "Spear"|| Weapon =="Sword"||
				Weapon =="Hammer"|| Weapon =="Scythe")
		{
			this.Weapon = Weapon;
		}
		else
		{
			throw new IllegalArgumentException("Please use one of the following:"
					+ " Spear, Sword, Hammer, or Scythe");
		}
		//Shinnyness
		if(Shinnyness > 0 && Shinnyness < 101)
		{
			this.Shinnyness = Shinnyness;
		}
		else 
		{
			throw new IllegalArgumentException("Value must be between 0 and 100");
		}
		//MeleeWeaponMaterial
		switch(MeleeWeaponMaterial)
		{
			case "Gold": 
			case "Metal": 
			case "Plastic": 
			case "Crystal": 
			case "Vibranium": 
				this.MeleeWeaponMaterial = MeleeWeaponMaterial;
				break;
			default:
				throw new IllegalArgumentException("Please use one of the following:"
						+ " Gold, Metal, Plastic, Crystal, and Vibranium");
		}
	}
	
	

	public String toString()
	{
		return new String("Temp");
	}
	
	/**
	 * Pritnts the variables to the console in an orderly fashion
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
}
