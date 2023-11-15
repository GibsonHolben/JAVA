/**
 * Creates a sunglass with a color, price, and a referance to the manufacturer
 * @author Gibson Holben
 * @version 0.1
 */
public class Sunglasses
{
	//**************************************************
	//Variables
	//**************************************************
	
	/** The color of the sunglasses */
	private String 			Color = "Black";
	/** The id of the Sunglass*/
	private int id;
	/** The clas Manufacturer */
	private Manufaturer 	M1;
	/** The price of the sunglasses */
	private float 			price = 0f;

	//**static**
	/** The number of sunglasses that exist */
	public static int numberOfGlasses = 0;
	
	/** Overides the default constructor*/
	Sunglasses()
	{
		 Sunglasses.numberOfGlasses += 1;	 
		 M1 = new  Manufaturer();
		 id =  Sunglasses.numberOfGlasses;
	}
	
	/**
	 * Creates a Sunglasses with the user passed in values
	 * @param isTraded Is the manufacturer publicly traded
	 * @param namer the name of the manufacturer
	 * @param col the color of the sunglasses
	 * @param price the price of the sunglasses
	 */
	Sunglasses(boolean isTraded, String namer, String col, float p)
	{
		 Sunglasses.numberOfGlasses += 1;
		 M1 	= new  Manufaturer(isTraded, namer);
		 Color 	= col;
		 price 	= p;
		 id 	=  Sunglasses.numberOfGlasses;
	}
	
	/**
	 * Creates a sunglass 
	 * allows a 1 to many relationship
	 * @param m The Manufaturer
	 */
	Sunglasses(Manufaturer m)
	{
		 Sunglasses.numberOfGlasses += 1;
		 
		 M1 =  m;
		 id =  Sunglasses.numberOfGlasses;
	}
	
	/**
	 * Creates a sunglass 
	 * allows a 1 to many relationship and allow user input for the sunglass instance properties
	 * @param m The Manufaturer
	 * @param col The color of the sunglass
	 * @param p the price of the sunglass
	 */
	Sunglasses(Manufaturer m, String col, float p)
	{
		 Sunglasses.numberOfGlasses += 1;
		 
		 M1 	= m;
		 Color 	= col;
		 price 	= p;
		 id 	=  Sunglasses.numberOfGlasses;
	}
	
	/**
	 * Returns the color of the sunglass
	 * @return Color
	 */
	public String getColor() {
		return Color;
	}

	/**
	 * Sets the color of the sunglass
	 * @param color the new color of the sunglass 
	 */
	public void setColor(String color) {
		Color = color;
	}

	/**
	 * Returns the id of the sunglass
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the price of the sunglass
	 * @return prie
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the price of the sunglass
	 * @param price the new price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Returns the manufacturer of the sunglass
	 * @return price
	 */
	public Manufaturer getManufacturer() {
		return M1;
	}

	
//	public String toString()
//	{
//		//false;Ford;Id
//		
//		String s1 = Color + ";" + id + ";" + price + ";";
//		return s1;
//	}
}
