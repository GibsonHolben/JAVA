/**
 * Test case for Armor
 * @author Gibson Holben
 * @version 0.0.6.3
 */
public class ArmorDriver
{
	public static void main(String[] args)
	{	
		System.out.println("******************************A1");
		Armor A1 = new Armor();
		System.out.println(A1.toString());
		System.out.println("******************************\n");
		
		System.out.println("******************************A2");
		Armor A2 = new Armor("Shock", true, (short) 100, "Copper");
		System.out.println(A2.toString());
		System.out.println("******************************\n");
		
		System.out.println("******************************A3");
		Armor A3 = new Armor("Astral", true, (short) 1000, "Crystal");
		A3.printAll();
		System.out.println(A3.toString());
		System.out.println("******************************\n");		
	}
	
	

}
