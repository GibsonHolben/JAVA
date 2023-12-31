/**
 * A simple class that is used to test the Printer class
 * @author Gibson Holben
 * @version 0.1.0
 */
public class PrinterDriver
{
	public static void main(String[] args) 
	{
		//Default
		System.out.println("**************************P1");
		Printer P1 = new Printer();
		System.out.println(P1.toString());
		P1.printAll();
		System.out.println("**************************\n");
		
		//Overloaded 1
		System.out.println("**************************P2");
		//Testing the constructor that 
		//creates an empty printer with an Ink
		Printer P2 = new Printer("HP", (short) 21,
				"Red", (byte) 100, 99.99f);
		System.out.println(P2.toString());
		P2.printAll();
		System.out.println("**************************\n");
		

		
		//Overloaded 2
		System.out.println("**************************P3");
		
		Ink I1 = new Ink("HP", (short) 21,
				"Yellow", (byte) 100, 99.99f);
		Printer P3 = new Printer(I1, "Gibson Printer", "Black", true,
				(short) 17, 49.99f, (short) 21, (byte ) 12);
		System.out.println(P3.toString());
		P3.printAll();
		System.out.println("**************************\n");
		
		
		
		//Overloaded 3. passing an array that is at the max size
		System.out.println("**************************P4");
		Ink I2 = new Ink("HP", (short) 21,
				"Pink", (byte) 100, 99.99f);
		Ink I3 = new Ink("HP", (short) 21,
				"Green", (byte) 100, 99.99f);
		Ink I4 = new Ink("HP", (short) 21,
				"Blue", (byte) 100, 99.99f);
		Ink I5 = new Ink("HP", (short) 21,
				"Purple", (byte) 100, 99.99f);
		Ink I6 = new Ink("HP", (short) 21,
				"Orange", (byte) 100, 99.99f);
		Ink[] Inkr = {I1,I2,I3,I4,I5};
		Printer P4 = new Printer(Inkr, "PrintersAreCool", "Red", true,
				(short) 28, 23.99f, (short) 67, (byte ) 10);
		System.out.println(P4.toString());
		P4.printAll();
		System.out.println("**************************\n");
		
		
		
		//passing an array that is above max size
		System.out.println("**************************P5");
		Ink[] Inkr2 = {I1,I2,I3,I4,I5,I6};
		Printer P5 = new Printer(Inkr2, "PrintersAreAmazingTools", "White", true,
				(short) 15, 87.99f, (short) 910, (byte ) 19);
		System.out.println(P5.toString());
		P5.printAll();
		testGettersSetters(P5);
		System.out.println("**************************\n");
		
		
		
		//passing an array that is below max size
		System.out.println("**************************P6");
		Ink[] Inkr3 = {I1,I2,I3,I4};
		Printer P6 = new Printer(Inkr3, "ILovePrinters.co", "Green", false,
				(short) 82, 1200f, (short) 21, (byte ) 15);
		System.out.println(P6.toString());
		P6.printAll();
		System.out.println("**************************\n");
		
		
		//Testing saveCsv
		Printer[] P0 = {P1,P2,P3,P4,P5,P6};
		Printer.saveCsv(P0, "C:/Users/CTEHolbenG46/"
				+ "Documents/InkFiles/", "PrinterCSV");
	}
	
	/**
	 * Tests the getters and setters of the passed in Printer
	 * @param p the passed in printer
	 */
	public static void testGettersSetters(Printer p)
	{
		//Testing the getters and setters
		System.out.println("\n");
		System.out.println("**TESTING GETTERS AND SETTERS**");
		
		System.out.println(p.getBrand());
		p.setBrand("Gibson and co");
		System.out.println(p.getBrand());
		
		System.out.println(p.getColor());
		p.setColor("Magenta");
		System.out.println(p.getColor());
				
		System.out.println(p.getPrice());
		p.setPrice(999.99f);
		System.out.println(p.getPrice());
		
		
		System.out.println(p.getPaper());
		p.setPaper((short) 12);
		System.out.println(p.getPaper());
		
		
		System.out.println(p.getPortSize());
		p.setPortSize((short) 910);
		System.out.println(p.getPortSize());
		
		
		System.out.println(p.getSheetsPerMin());
		p.setSheetsPerMin((byte) 12);
		System.out.println(p.getSheetsPerMin());
		
		System.out.println(p.getIDENTIFICATION_NUMBER());
		
		System.out.println(p.getDateCreated());

		System.out.println(Printer.getAmountOfPrinters());
				
			
		System.out.println("**TESTING GETTERS AND SETTERS**\n");
	}

}
