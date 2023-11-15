/**
 * Creates manufacturers with name, id, and isPublicTraded
 * @author Gibson Holben
 * @version 0.1
 */
public class Manufaturer
{
	//This class can exist on its own
	//Sunglasses needs this class to exist
	//Composition is any object that requires another object to exist
	
	/** The id of the manufacturer  */
	private int 		id;
	/** is the manufacturer publicly traded */
	private boolean 	isPublicTraded 	= false;
	/** The name of the manufacturer */ 
	private String 		Name = " ";

	
	
	
	//****static variables****
	/** The number of manufacturers  */
	public static int   totalNumberOfManufacturers = 0;
	
	
	
	
	//*****************************************
	//Constructors
	//*****************************************
	/** Creates a manufacturer  */
	Manufaturer()
	{
		Manufaturer.totalNumberOfManufacturers += 1;
		id = Manufaturer.totalNumberOfManufacturers;
	}

	/**
	 * Overloaded constructor with one or more constructor
	 * @param isTraded is the manufacturer publicly traded
	 * @param name The name of the manufacturer
	 */
	Manufaturer(boolean isTraded, String name)
	{
		isPublicTraded = isTraded;
		Name = name;
		Manufaturer.totalNumberOfManufacturers += 1;
		id = Manufaturer.totalNumberOfManufacturers;
	}

	
	
	
	//*****************************************
	//Getters and setters
	//*****************************************

	/**
	 * Returns the variable IsPublicTraded
	 * @return IsPublicTraded
	 */
	public boolean getIsPublicTraded() {
		return isPublicTraded;
	}

	/**
	 * Sets IsPublicTraded 
	 * @param isPublicTraded the value that IsPublicTraded will be set to
	 */
	public void setPublicTraded(boolean isPublicTraded) {
		this.isPublicTraded = isPublicTraded;
	}

	/**
	 * Returns the variable name
	 * @return
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Sets name
	 * @param name the value that name will be set to
	 */
	public void setName(String name) {
		Name = name;
	}
	
	
	
	public String printMsg()
	{
		return "Called Manufacturer.printMsg";
	}
}