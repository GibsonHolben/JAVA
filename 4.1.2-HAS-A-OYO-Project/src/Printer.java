import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
/**
 * A simple class used to create a printer with several instance variables
 * @author Gibson Holben
 * @version 0.1.3
 */
public class Printer 
{
	/**The amount of printers that have been created
	 * Default = 0*/
	private static int 		amountOfPrinters = 0;
	
	/**The Brand that created the printer
	 * Default = Blank*/
	private String 			Brand = "";
	
	/**The color of the printer
	 * Default = Blank*/
	private String 			Color = "";
	
	/**The date that this printer was created*/
	private LocalDate 		DateCreated;
	
	/**The id number of the curent printer*/
	private final int 		IDENTIFICATION_NUMBER; 
	
	/**A array of referances to the Ink object
	 * Default array length is 1*/
	private Ink[] 			InkCartridge = new Ink[1];
	
	/**Is the printer turned on
	 * Default = false*/
	private boolean 		isPrinterOn = false;
	
	/**The amount of paper in the printer
	 * Default = 0
	 * Maximum = 100*/
	private short 			paper = 0;
	
	/**The price of the product
	 * Default = 0.0*/
	private float 			price = 0.0f;
	
	/**The size of the printer ink cartridge port
	 *limited to 67, 910, and 21
	 *Default = 0*/
	private short 			portSize = 0;
	
	/**How many sheets of paper the printer can print at once
	 * Default = 0*/
	private byte 			sheetsPerMin = 0;
	
	/**
	 * Creates a basic printer with a default
	 * ink and the default values. 
	 */
	Printer()
	{
		Printer.amountOfPrinters++;
		InkCartridge[0] = new Ink();
		IDENTIFICATION_NUMBER = Id.CalculateIdentification(Printer.amountOfPrinters);
	}
	
	/**
	 * Creates a printer with the default settings and a 
	 * fully created Ink
	 * @param Brand The Ink's brand
	 * @param cSize The Ink's cartridge size
	 * @param InkColor The Ink's color
	 * @param capacity The Ink's capacity 
	 * @param price The Ink's price
	 */
	Printer(String Brand, short cSize, String InkColor, byte capacity, float price)
	{
		Printer.amountOfPrinters++;
		
		InkCartridge[0] = new Ink(Brand, cSize,
									InkColor, capacity, price);
		
		IDENTIFICATION_NUMBER = Id.CalculateIdentification(Printer.amountOfPrinters);
		
	}
	
	/**
	 * Creates a Printer with used passed in values and
	 *  assigns the ink to a use passed in Ink
	 * @param Ink The Ink
	 * @param Brand The Brand of the printer
	 * @param Color The color of the printer
	 * @param isPrinterOn Is the printer turned on
	 * @param paper How much paper the printer has
	 * @param price The price of the printer
	 * @param portSize The port size of the printer
	 * @param sheetesPerMin how many sheetes of paper the printer 
	 * can print in one min
	 */
	Printer(Ink Ink, String Brand, String Color, boolean isPrinterOn, 
			short paper, float price, short portSize, byte sheetesPerMin)
	{
		Printer.amountOfPrinters++;
		IDENTIFICATION_NUMBER = Id.CalculateIdentification(Printer.amountOfPrinters);
		
		InkCartridge[0] = Ink;
		this.Brand = Brand;
		this.Color = Color;
		this.isPrinterOn = isPrinterOn;
		this.paper = paper;
		this.price = price;
		this.sheetsPerMin = sheetesPerMin;
		
		if(portSize == Ink.getCartridgeSize())
			this.portSize = portSize;
		else
			throw new IllegalArgumentException("Printer port size must match Ink's port size");


	}
	
	
	/**
	 * Creates a Printer with used passed in array of Inks 
	 * WARNING: If the passed in array is greater that 5 it will be set to 5!
	 * @param i The Ink array
	 * @param Brand The Brand of the printer
	 * @param Color The color of the printer
	 * @param isPrinterOn Is the printer turned on
	 * @param paper How much paper the printer has
	 * @param price The price of the printer
	 * @param portSize The port size of the printer
	 * @param sheetesPerMin how many sheetes of paper the
	 *  printer can print in one min
	 */
	Printer(Ink[] i, String Brand, String Color, boolean isPrinterOn, 
			short paper,float price, short portSize, byte sheetesPerMin)
	{
		Printer.amountOfPrinters++;
		IDENTIFICATION_NUMBER = Id.CalculateIdentification(Printer.amountOfPrinters);
		InkCartridge = new Ink[i.length];
		
		if(InkCartridge.length > 5)
		{
			InkCartridge = new Ink[5];
			System.out.println("WARNING: You have exeded the max length "
								+ "of Inks allowed in one printer."
								+ " Data will be lost!");
		}
		
		//Loops through an array of Inks
		for(int i2 = 0; i2 < i.length && i2 < 5; i2++)
		{
			//Assigns InkCartridge to be the passed in array
			InkCartridge[i2] = i[i2];
		}
		
		this.Brand = Brand;
		this.Color = Color;
		this.isPrinterOn = isPrinterOn;
		this.paper = paper;
		this.price = price;
		this.portSize = portSize;
		this.sheetsPerMin = sheetesPerMin;	
	}
	
	
	/**
	 * Returns the amount of printers that have been made
	 * @return amountOfPrinters
	 */
	public static int getAmountOfPrinters() {
		return amountOfPrinters;
	}

	/**
	 * Returns the brand of the printer
	 * @return Brand
	 */
	public String getBrand() {
		return Brand;
	}
	
	/**
	 * Sets the brand of the printer
	 * @param brand The new Brand
	 */
	public void setBrand(String brand) {
		Brand = brand;
	}

	/**
	 * Returns the color of the printer
	 * @return Color
	 */
	public String getColor() {
		return Color;
	}

	/**
	 * Sets the color of the printer
	 * @param color the new color
	 */
	public void setColor(String color) {
		Color = color;
	}

	/**
	 * Returns the date created 
	 * @return DateCreated
	 */
	public LocalDate getDateCreated() {
		return DateCreated;
	}

	/**
	 * Returns the inks 
	 * @return InkCartridge
	 */
	public Ink[] getInkCartridge() {
		return InkCartridge;
	}

	/**
	 * Sets the ink
	 * @param inkCartridge new new InkCartridge
	 */
	public void setInkCartridge(Ink[] inkCartridge) {
		InkCartridge = inkCartridge;
	}

	/**
	 * Returns is the printer on
	 * @return isPrinterOn
	 */
	public boolean isPrinterOn() {
		return isPrinterOn;
	}

	/**
	 * Sets if the printer is on
	 * @param isPrinterOn the new isPrinterOn
	 */
	public void setPrinterOn(boolean isPrinterOn) {
		this.isPrinterOn = isPrinterOn;
	}

	/**
	 * Return the paper in the printer
	 * @return paper
	 */
	public short getPaper() {
		return paper;
	}

	/**
	 * Sets the paper in the printer
	 * @param paper the new paper
	 */
	public void setPaper(short paper) {
		this.paper = paper;
	}

	/**
	 * Returns the price of the printer
	 * @return price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the price of the printer
	 * @param price the new price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Returns the port size of the printer
	 * @return portSize
	 */
	public short getPortSize() {
		return portSize;
	}

	
	/**
	 * Sets the port size of the printer
	 * @param portSize the new port size
	 */
	public void setPortSize(short portSize) {
		this.portSize = portSize;
	}

	/**
	 * Returns the sheets per min
	 * @return sheetsPerMin
	 */
	public byte getSheetsPerMin() {
		return sheetsPerMin;
	}

	/**
	 * Sets the sheets Per Min
	 * @param sheetsPerMin the new sheetsPerMin
	 */
	public void setSheetsPerMin(byte sheetsPerMin) {
		this.sheetsPerMin = sheetsPerMin;
	}

	/**
	 * Returns the identification number of the printer
	 * @return IDENTIFICATION_NUMBER
	 */
	public int getIDENTIFICATION_NUMBER() {
		return IDENTIFICATION_NUMBER;
	}

	
	
//	/**
//	 * Calculates the identification number of the Printer
//	 * id = number of printers + curent date (yyyy/mm/dd)
//	 * @return An identification number
//	 */
//	private int CalculateIdentification() 
//	{
//		
//		//Gets the curent date
//		DateCreated = LocalDate.now();
//		
//		//Creates an id number 
//		String S = Printer.amountOfPrinters + DateCreated.toString();
//		String NewS = S.replace("-", "");
//		
//		//Returns the newly created identification number
//		return Integer.parseInt(NewS);		
//	}
	
	/**
	 * Prints all the variables to the console in an orderly fashion
	 */
	public void printAll()
	{
		System.out.println("Brand: " + Brand);
		System.out.println("Color: " + Color);
		System.out.println("isPrinterOn: " + isPrinterOn);
		System.out.println("paper: " + paper);
		System.out.println("price: " + price);
		System.out.println("IDENTIFICATION_NUMBER: " + IDENTIFICATION_NUMBER);
		System.out.println("portSize: " + portSize);
		System.out.println("sheetesPerMin: " + sheetsPerMin);
		System.out.println("DateCreated: " + DateCreated);
		System.out.println("amountOfPrinters: " + Printer.amountOfPrinters);
		
	}
	
	/**
	 * Returns the variables of the curent Printer as a CVS formated String
	 * @return The variables as a String
	 */
	public String toString()
	{
		String s1 = Brand + "|" + Color + "|" + isPrinterOn + "|";
		String s2 = paper + "|" + price + "|" + IDENTIFICATION_NUMBER;
		String s3 = "|"  + portSize + "|" + sheetsPerMin;
		String s4 = "|" + DateCreated;
		return s1 + s2 + s3 + s4;
	}
	
	/**
	 * Saves the variables on an array of Printers to a text file at a
	 *  user specified path in a CVS format. Deliminator = |
	 * @param printers An array of printers that are saved to a file
	 * @param Path The path to the file
	 * @param Name The name of of the file
	 */
	public static void saveCsv(Printer[] printers, String Path, String Name)
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
			for(int i = 0; i < printers.length; i++)
			{
				String s0 = printers[i].toString();
				myWriter.write(s0 + "\n");	
			}
			
			myWriter.write(Printer.amountOfPrinters + "\n");
			
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