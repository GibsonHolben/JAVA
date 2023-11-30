/**
 * Test case for MeleeWeapon
 * @author Gibson Holben
 * @version 0.0.5
 */
public class MeleeWeaponDriver 
{
	public static void main(String[] args) 
	{
		System.out.println("**************************************");
		MeleeWeapon MeleeWeaopn1 = new MeleeWeapon();
		MeleeWeaopn1.printAll();
		System.out.println("**************************************\n");
		
		System.out.println("**************************************");
		MeleeWeapon MeleeWeaopn2 = new MeleeWeapon("Sword", (byte) 100, "Vibranium");
		MeleeWeaopn2.printAll();
		System.out.println("**************************************\n");
		
		System.out.println("**************************************");
		MeleeWeapon MeleeWeaopn3 = new MeleeWeapon("Sword", (byte) 100, "Vibranium");
		MeleeWeaopn3.printAll();
		System.out.println("**************************************\n");
		
		if(MeleeWeaopn3.equals(MeleeWeaopn2))
		{
			System.out.println("Good");
		}
		else 
		{
			System.out.println("False");
		}
		
		if(MeleeWeaopn1.equals(MeleeWeaopn2))
		{
			System.out.println("Good");
		}
		else 
		{
			System.out.println("False");
		}
	}
}
