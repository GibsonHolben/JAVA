/**
 * Creates a melee 
 * @author Gibson Holben
 * @version 0.0.1
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
	 * Overiden default construtor
	 */
	MeleeWeapon()
	{
		
	}
	
	/**
	 * Creates a MeleeWeapon with all instance variables
	 * @param MeleeWeapon The weapon that the clone uses 
	 * @param Shinnyness The Shinnyness of the Melee Weapon
	 * @param MeleeWeaponMaterial The material of the weapon
	 */
	MeleeWeapon(String Weapon,
				byte Shinnyness,
				String MeleeWeaponMaterial)
	{
		//Weapon edits
		if(Weapon == "Spear" 
				|| Weapon == "Sword"
				|| Weapon == "Hammer" 
				|| Weapon == "Scythe")
		{
			this.Weapon = Weapon;
		}
		else
		{
			throw new IllegalArgumentException("Please use one of the following:"
					+ " Spear, Sword, Hammer, or Scythe");
		}
		
		//Shinyness edits
		if()
		{
			this.Shinnyness = Shinnyness;
		}
		else
		{
			throw new IllegalArgumentException("peramiter must be between 1 and 100");
		}
	
		
		this.MeleeWeaponMaterial = MeleeWeaponMaterial;
	}
}
