/**
 * A simple test case for the Ink class
 * @author Gibson Holben
 * @version 0.0.5
 *
 */
public class InkDriver 
{
	/**
	 * The main method for testing the Ink class
	 * @param args user passed in args that can be used to do things
	 */
	public static void main(String[] args) 
	{
		//Tests the three constructors
		System.out.println("******************************************I1");
		Ink I1 = new Ink();
		I1.printAll();
		System.out.println("******************************************\n");
		
		
		System.out.println("******************************************I2");
		Ink I2 = new Ink("HP", (short) 67, "Black", 39.99f);
		I2.printAll();
		System.out.println("******************************************\n");
		
		
		System.out.println("******************************************I3");
		Ink I3= new Ink("Canon", (short) 910, "Red", (byte) 8, 49.99f);
		I3.printAll();
		System.out.println("******************************************\n");
			
		//Tests is you input the wrong capacity
		System.out.println("******************************************I4");
		Ink I4 = new Ink("HP", (short) 21, "Black",(byte) 8, 39.99f);
		String I4CSV = I4.toString(); 	//Testing the toString function
		System.out.println("Testing the new print thing: " + I4);
		System.out.println("The mem adress is: " + I4.hashCode());
		I4.printAll();
		System.out.println("******************************************\n");
		
		//Getters and setters test
		System.out.println("******************************************I5");
		Ink I5 = new Ink("GibsonInk", (short) 67, "Black",(byte) 8, 59.99f);
		System.out.println("Before Setters: " + I5.toString() + "\n");
		TestGetterAndSetter(I5);
		System.out.println("After Setters: " + I5.toString());
		System.out.println("");
		I5.printAll();
		
		I5.setBrand("SaveFileCorp");
		
		Ink[] i0 = {I1, I2, I3, I4, I5};
		
		Ink.saveCsv(i0,"C:/Users/CTEHolbenG46/"
				+ "Documents/InkFiles/", "InkCSV");
		System.out.println("******************************************\n");
		
		
		
		System.out.println("Gibson Holben");
	}
	
	/**
	 * Tests the getters and setters of the Ink Class
	 * @param i The Ink that the code is run on
	 */
	public static void TestGetterAndSetter(Ink i)
	{
		//Getters and setters
		System.out.println("TESTING THE GETTERS AND SETTERS");
		System.out.println(i.getBrand());
		i.setBrand("Gibson Company");
		System.out.println(i.getBrand());
		
		System.out.println(i.getCapacity());
		i.setCapacity((byte) 10);
		System.out.println(i.getCapacity());
		
		System.out.println(i.getCartridgeSize());
		i.setCartridgeSize((short) 910);
		System.out.println(i.getCartridgeSize());
		
		System.out.println(i.getColorofInk());
		i.setColorofInk("Pink");
		System.out.println(i.getColorofInk());
		
		System.out.println(i.getPrice());
		i.setPrice(199.99f);
		System.out.println(i.getPrice());
		
			
		
		System.out.println(Ink.getAmountOfInkCartridges());
		
		
		System.out.println( i.getDateCreated());
		

		System.out.println(i.getIdentification());		
		
		System.out.println("END TESTING THE GETTERS AND SETTERS \n");
		
	}

}
