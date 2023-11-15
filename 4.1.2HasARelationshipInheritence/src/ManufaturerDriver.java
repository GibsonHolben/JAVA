/**
 * Tests the manufacturer class
 * @author Gibson Holben
 * @version 0.1
 */
public class ManufaturerDriver
{
	public static void main(String[] args)
	{
		 System.out.println("Gibson Holben");
		
		 /*Test M1 (Tests the default constructor)*/
		 System.out.println("*****************************************************************************");
		 Manufaturer M1 = new  Manufaturer();
		 M1.setPublicTraded(true);  //Tests the setters with a Literal bool
		 M1.setName("Gibson corp");  //Tests the setters with a Literal String	 
		 System.out.println("The amount of manufacturers is: " + Manufaturer.totalNumberOfManufacturers);	
		 System.out.println("Is M1 publicly traded: " + M1.getIsPublicTraded()); //Tests the getters
		 System.out.println("M1's name is: " + M1.getName());
		 System.out.println("*****************************************************************************\n");
		 	
		 /*Test M1A (Tests the default constructor)*/
		 System.out.println("*****************************************************************************");
		 Manufaturer M1A = new  Manufaturer();
		 M1A.setPublicTraded(false);
		 M1A.setName("GamerPogGroup"); 
		 System.out.println("The amount of manufacturers is: " + Manufaturer.totalNumberOfManufacturers);
		 System.out.println("Is M1A publicly traded: " + M1A.getIsPublicTraded());
		 System.out.println("M1A's name is: " + M1A.getName());
		 System.out.println("*****************************************************************************\n");
		 
		 /*Test M2 (Tests an overloaded constructor)*/
		 System.out.println("*****************************************************************************");
		 Manufaturer M2 = new  Manufaturer(false, "Mastermind inc");
		 M2.setPublicTraded(false);
		 M2.setName("Mastermind INC"); 
		 System.out.println("The amount of manufacturers is: " + Manufaturer.totalNumberOfManufacturers);
		 System.out.println("Is M2 publicly traded: " + M2.getIsPublicTraded());
		 System.out.println("M2's name is: " + M2.getName());
		 System.out.println("*****************************************************************************\n");
		 
		 /*Test M2A (Tests an overloaded constructor)*/
		 System.out.println("*****************************************************************************");
		 Manufaturer M2A = new  Manufaturer(false, "CrateCorp");
		 M2A.setPublicTraded(false);
		 M2A.setName("Crate Corperation"); 
		 System.out.println("The amount of manufacturers is: " + Manufaturer.totalNumberOfManufacturers);
		 System.out.println("Is M2A publicly traded: " + M2A.getIsPublicTraded());
		 System.out.println("M2A's name is: " + M2A.getName());
		 System.out.println("*****************************************************************************");
	}
}