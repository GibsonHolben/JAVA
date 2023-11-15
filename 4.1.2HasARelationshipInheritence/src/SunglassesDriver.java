/**
 * Tests the sunglass class
 * @author Gibson Holben
 * @version 0.1
 */
public class SunglassesDriver 
{
	public static void main(String[] args) 
	{
		System.out.println("Gibson Holben");
		
		//Tests the default constructor
		System.out.println("****************************************************************");
		Sunglasses S1 = new Sunglasses();
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		System.out.println("The color of S1 is: " + S1.getColor());
		System.out.println("**************************************************************** \n");
		
		//Tests the default constructor
		System.out.println("****************************************************************");
		Sunglasses S1A = new Sunglasses();
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		System.out.println("The color of S1A is: " + S1A.getColor());
		System.out.println("**************************************************************** \n");
		
		
		//Tests the overide constructor
		System.out.println("****************************************************************");
		Sunglasses S2A = new Sunglasses(true, "Sunglass Co", "Red", 39.99f); 
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		System.out.println("The color of S2A is: " + S2A.getColor());
		System.out.println("**************************************************************** \n");
		
		
		
		//**************************************
		//One to many testing
		//**************************************
		
		//One manufacturer can be asigned to many sunglasses
		System.out.println("**************************************************************** ");
		//Creates 2 manufacturere
		Manufaturer M1  = new  Manufaturer(false, "Sunglass less cool company"); //id = 5
		Manufaturer M1A = new  Manufaturer(false, "Sunglass cool company"); //id = 6
		//Creates two sunglasses with the same manufacturer (M1)
		Sunglasses S3  = new Sunglasses(M1);
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		Sunglasses S3A = new Sunglasses(M1);
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		System.out.println("Sunglass S3 & S3A's manufacturer is: " + S3A.getManufacturer().getName());
		System.out.println("**************************************************************** \n");
		
		
		System.out.println("**************************************************************** ");
		//Creates two sunglasses with the same manufacturer (M2)
		Sunglasses S3B = new Sunglasses(M1A);
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		Sunglasses S3C = new Sunglasses(M1A);
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		System.out.println("Sunglass S3B & S3C's manufacturer is: " + S3B.getManufacturer().getName());
		
		//Call a method from Manufacturer from SunglassesDriver by: Object > HasA > Function
		System.out.println(S3C.getManufacturer().printMsg());
		
		System.out.println("**************************************************************** \n");
		
		
		System.out.println("****************************************************************");
		Sunglasses S4 = new Sunglasses(M1A, "Yellow", 29.99f);
		System.out.println("The total number of sunglasses is: " + Sunglasses.numberOfGlasses);
		System.out.println("The color of S4 is: " + S4.getColor());
		System.out.println("Sunglass S4 manufacturer is: " + S3B.getManufacturer().getName());
		
		//Prints the hash by default (Sunglasses@15db9742)
		System.out.println("S4.toString() = " + S4.toString());
		
		
		System.out.println("**************************************************************** \n");
		 
		
		
		 
	}
}
