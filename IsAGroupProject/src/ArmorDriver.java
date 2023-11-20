/**
 * Test case for Armor
 * @author Gibson Holben
 * @version 0.0.0.1
 */
public class ArmorDriver
{
	public static void main(String[] args)
	{
		System.out.println("******************************A1");
		Armor A1 = new Armor();
		System.out.println("******************************\n");
		
		System.out.println("******************************A2");
		Armor A2 = new Armor("Shock", true, (short) 100);
		testGettersAndSetters(A2);
		System.out.println("******************************\n");
		
		System.out.println("******************************A3");
		Armor A3 = new Armor("Astral", true, (short) 1000);
		A3.printAll();
		System.out.println(A3.toString());
		System.out.println("******************************\n");
		
				
	}
	
	/**
	 * Tests the getters and setters on a passed in armor
	 * @param A The armor that the test is run on
	 */
	public static void testGettersAndSetters(Armor A)
	{
		System.out.println(A.getArmorType());
		System.out.println(A.getDateCreated());
		System.out.println(A.getProtectionLvl());
		System.out.println(A.getisBulletProof());
		
		A.setArmorType("Burning");
		A.setProtectionLvl((short) 89);
		A.setBulletProof(false);
		
		System.out.println(A.getArmorType());
		System.out.println(A.getDateCreated());
		System.out.println(A.getProtectionLvl());
		System.out.println(A.getisBulletProof());
	}

}
