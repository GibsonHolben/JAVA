/**
 * A class used to create a shoe with private variables
 * @author Gibson Holben
 * @version 0.1.2
 */
public class Shoe 
{
	//What is the differance between pubic and privite...
	//Public is a variable or method that can be accessed by any other classes that want to use it. It can be changed and altered by the user as they so desire
	//Privite is a variable to method that other classes cannot access without asking for the corect permisions and cannot be altered by the user
	
	//Instance variables
	/**The price of the shoe*/
	private float price;
	
	/**The size of the shoe. Half sized are alowed*/
	private float size;
	
	/**The material that makes up the sole of a shoe*/
	private String SoleMaterial;
	
	//static instance member
	//shared between all the objects created by the class
	/**A static vaiable that keeps track of the amount of shoes created*/
	public static int amountOfShoes = 0;
	
	//*******************************************************
	//constructors
	//*******************************************************
	
	/**
	 * Constructs a default shoe 
	 * Default price is $1.00
	 * Default size is 1.0
	 * Default material is Rubber
	 */
	Shoe()
	{
		price = 1.00f;
		size = 1.0f;
		SoleMaterial = "Rubber";
		Shoe.amountOfShoes += 1;
	}
	
	/**
	 * Creates a shoe with the values that are passed in by the user
	 * @param priceValue The user passed in price of the shoe
	 * @param sizeValue The user passed in size of the shoe
	 * @param SoleMat The user passed in material of the sole
	 */
	Shoe(float priceValue, float sizeValue, String SoleMat)
	{
		price = priceValue;
		size = sizeValue;
		SoleMaterial = SoleMat;
		Shoe.amountOfShoes += 1;
	}
	
	
	//*******************************************************
	//Getters and Setters
	//*******************************************************
	
	/**
	 * Returns the price of the specific object
	 * @return price of the shoe
	 */
	public float getPrice(){
		return price;
	}
	
	/**
	 * Sets the price of the specific object
	 * @param price new price of the shoe
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Returns the size of the specific object
	 * @return size of the shoe
	 */
	public float getSize() {
		return size;
	}

	/**
	 * Sets the size of the specific object
	 * @param size new size of the shoe
	 */
	public void setSize(float size) {
		this.size = size;
	}

	/**
	 * Returns the sole material of the specific object
	 * @return the sole material of the shoe
	 */
	public String getSoleMaterial() {
		return SoleMaterial;
	}

	/**
	 * Sets  the sole material of the specific object
	 * @param soleMaterial new material of the shoe
	 */
	public void setSoleMaterial(String soleMaterial) {
		SoleMaterial = soleMaterial;
	}
}
