/**
 * Test case for MeleeWeapon
 * @author Gibson Holben
 * @version 0.0.5
 */
public class MeleeWeaponDriver 
{
	public static void main(String[] args) 
	{

		
		//Builder class testing
		System.out.println("**************************************");
		MeleeWeapon MeleeWeaopn = new MeleeWeapon.Builder().Build("Hammer", 
																		  (byte) 99, 
																		  "Metal");
		System.out.println("\n");
		MeleeWeaopn.printAll();
		System.out.println(MeleeWeaopn.toString());
		System.out.println("**************************************\n");
		//null
		MeleeWeapon MeleeWeaopn2 = new MeleeWeapon.Builder().Build("happy", 
				  (byte) 101, 
				  "cruise ship");
		MeleeWeaopn.printAll();
		System.out.println("**************************************\n");
		
	
	}
}
