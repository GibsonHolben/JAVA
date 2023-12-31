import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
/**
 * A simple class that creates ink that is used by a printer
 * @author Gibson Holben
 * @version 0.0.9
 */
public class Ink 
{
	//***********************
	//Static variables
	//***********************
	
	/**The amout of ink carterages that exist*/
	private static int  amountOfInkCartridges = 0;
	
	//***********************
	//Standerd variables
	//***********************
	
	/**The brand of the curent ink cartridge. 
	 * Default is ""*/
	private String 	    Brand  = "";
	
	/**The size of the printer ink cartridge limited to 67, 910, and 21 
	 * Default is 0*/
	private short 		cartridgeSize = 0;
	
	/**The color of the ink in the cartridge
	 * Default is ""*/
	private String 		ColorofInk = "";
	
	/**The amount of ink the cartrage can hold (milliliter)
	 * Default is 0*/
	private byte 		capacity = 0;
	
	/**The date that the curent ink cartridge was created*/
	private LocalDate 	DateCreated;
	
	/**The id number of the curent Ink with the amount of inks + the date created*/
	private final int 	IDENTIFICATION; 
	
	/**The price of the curent ink cartridge
	 * Default is 0*/
	private float 		price = 0;
	
	
	/**
	 * Creates a simple Ink with an identification number
	 */
	Ink()
	{
		amountOfInkCartridges += 1;
		IDENTIFICATION = Id.CalculateIdentification(amountOfInkCartridges);
	}
	
	/**
	 * 
	 * Creates a simple Ink with an identification number
	 * and all the variables except capacity set via user input
	 * @param NewBrand The name of the brand that made the ink
	 * @param newCartridgeSize the size of the cartridge
	 * (limited to 67, 910, and 21)
	 * @param NewColorOfInk The color of the ink
	 * @param newPrice The price of the ink
	 */
	Ink(String NewBrand, short newCartridgeSize,
			String NewColorOfInk, float newPrice)
	{
		amountOfInkCartridges += 1;
		
		Brand 			= NewBrand;	
		ColorofInk 	 	= NewColorOfInk;
		price	 		= newPrice;
		
		if(isCorectSize(newCartridgeSize))
		{
			cartridgeSize = newCartridgeSize;
		}
		
		//Gets the date (y/m/d)
		IDENTIFICATION = Id.CalculateIdentification(amountOfInkCartridges);
	}
	
	/**
	 * Creates a simple Ink with an identification number
	 * and all the variables set via user input
	 * @param NewBrand The name of the brand that made the ink
	 * @param newCartridgeSize the size of the cartridge
	 * (limited to 67, 910, and 21)
	 * @param NewColorOfInk NewColorOfInk The color of the ink
	 * @param newCapacity The capacity of the ink cartridge (milliliter)
	 * @param newPrice The price of the ink
	 */
	Ink(String NewBrand, short newCartridgeSize, 
			String NewColorOfInk, byte newCapacity, float newPrice)
	{
		amountOfInkCartridges += 1;
		
		Brand 			= NewBrand;
		ColorofInk 	 	= NewColorOfInk;                                
		capacity 		= newCapacity;                       
		price	 		= newPrice;                          
		
		if(isCorectSize(newCartridgeSize))
		{
			cartridgeSize = newCartridgeSize;
		}		
		
		//Gets the date (y/m/d)
		IDENTIFICATION = Id.CalculateIdentification(amountOfInkCartridges);
	}
	
	
	/**
	 * Returns the amount of ink cartridges
	 * @return amountOfInkCartridges
	 */
	public static int getAmountOfInkCartridges() {
		return amountOfInkCartridges;
	}
	/**
	 * Returns the brand of the curent Ink
	 * @return Brand
	 */
	public String getBrand() {
		return Brand;
	}

	/**
	 * Sets the brand of the curent Ink
	 * @param brand The new brand
	 */
	public void setBrand(String brand) {
		Brand = brand;
	}

	/**
	 * Returns the cartridgeSize
	 * @return cartridgeSize
	 */
	public short getCartridgeSize() {
		return cartridgeSize;
	}
	/**
	 * Sets the value of cartridgeSize
	 * @param cartridgeSize The new cartridge size
	 */
	public void setCartridgeSize(short cartridgeSize) {
		this.cartridgeSize = cartridgeSize;
	}

	/**
	 * Returns the color of the curent Ink
	 * @return ColorofInk
	 */
	public String getColorofInk() {
		return ColorofInk;
	}

	/**
	 * Sets the color of the curent Ink
	 * @param colorofInk The new color of Ink
	 */
	public void setColorofInk(String colorofInk) {
		ColorofInk = colorofInk;
	}

	/**
	 * Returns the capacity of the curent Ink
	 * @return capacity
	 */
	public byte getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity of the curent Ink 
	 * @param capacity the new capacity
	 */
	public void setCapacity(byte capacity) {
		this.capacity = capacity;
	}

	/**
	 * Returns the curent in Inks's date of creation
	 * @return DateCreated
	 */
	public LocalDate getDateCreated() {
		return DateCreated;
	}

	/**
	 * Returns the price of the curent Ink
	 * @return price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the price of the curent Ink
	 * @param price the new price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Returns the identification number of the curent Ink
	 * @return identification
	 */
	public int getIdentification() {
		return IDENTIFICATION;
	}

	/**
	 * Checks if your carterage size matches the ones defined
	 * @param sizer the size of the carterage
	 * @return if the size is corect
	 */
	private boolean isCorectSize(short sizer)
	{
		if(sizer == 67 || sizer == 910 || sizer == 21)	
		{
			return true;
		}
		else
		{
			System.out.println("Please use one of the following: "
					+ "67, 910, 21. Size will be defaulted to 0");
			return false;
			
		}
	}
	
	
	/**
	 * Prints out the variables of the curent Ink to the console
	 */
	public void printAll()
	{
		System.out.println("Brand is: " + Brand);
		System.out.println("Cartridge size is: " + cartridgeSize);
		System.out.println("Color is: " + ColorofInk);
		System.out.println("Capacity is: " + capacity);
		System.out.println("Date Created is: " + DateCreated);
		System.out.println("Identification number is: " + IDENTIFICATION);
		System.out.println("Price is: " + price);
		System.out.println("Amount of Ink Cartridges: " + amountOfInkCartridges);
	}
	
	/**
	 * Returns the object Ink in String form and saves the
	 *  CSV file to a folder on the computer
	 *  @return CSV formated String of the curent Ink's variables
	 */
	public String toString()
	{
		String s1 = Brand + "|" + cartridgeSize + "|" + ColorofInk + "|";
		String s2 = capacity + "|" + DateCreated + "|" + IDENTIFICATION;
		String s3 = "|" + price + "|";
		return s1 + s2 + s3;
		
	}
	
	/**
	 * Saves the variables on an array of Printers to a text file at a
	 *  user specified path in a CVS format. Deliminator = |
	 * @param inks An array of inks that are saved to a file
	 * @param Path The path to the file
	 * @param Name The name of of the file
	 */
	public static void saveCsv(Ink[] inks, String Path, String Name)
	{
		try
		{
			//Checks if the file exists
			File f = new File(Path + Name + ".txt");	
			if(!f.exists()) 
			{
				//Creates a new file if it does not exist
				File myFile = new File(Path + Name + ".txt"); 	  
				myFile.createNewFile();  
			}
			
			//Opens a new FIleWriter
			FileWriter myWriter = new FileWriter(Path +  Name + ".txt");
			
			//Loops through an array of Printers and writes the data to the FileWriter
			for(int i = 0; i < inks.length; i++)
			{
				String s1 = inks[i].toString();
				myWriter.write(s1 + "\n");	
			}
			myWriter.write(Ink.amountOfInkCartridges + "\n");	
			
			//Saves the data in the FileWriter
			myWriter.close();
			System.out.println("Saved file to: " + Path + Name + ".txt");
		}
		catch (FileNotFoundException e)
		{
			//If the file cannot be found then print this error
			
			throw new IllegalArgumentException("The file path could not be found");
		}
		catch (IOException e)
		{
			throw new IllegalArgumentException("Could not save the file");
		}
		
	}
	
	
	
	
}