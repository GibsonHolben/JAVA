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
		System.out.println("**************************************MW1");
		MeleeWeapon MeleeWeaopn = new MeleeWeapon.MeleeWeaponBuilder().Build("Hammer", 
																		  (byte) 99, 
																		  "Metal");
		MeleeWeaopn.printAll();
		System.out.println(MeleeWeaopn.toString());
		System.out.println("**************************************\n");
		
		//null
		
		System.out.println("**************************************MW2");
		MeleeWeapon MeleeWeaopn2 = new MeleeWeapon.MeleeWeaponBuilder().Build("happy", 
				  (byte) 101, 
				  "cruise ship");
		System.out.println("**************************************\n");
		
		System.out.println("**************************************MW3");
		MeleeWeapon MeleeWeaopn3 = new MeleeWeapon.MeleeWeaponBuilder().Build("Sword",
																	(byte) 65,
																	"Gold");
		MeleeWeaopn3.printAll();
		System.out.println(MeleeWeaopn3.toString());
		System.out.println("**************************************\n");
	
	}
}
