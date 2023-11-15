/**
 * Headphone class is mutable example with constructors.
 * Instance variables are included
 * @author Gibson Holben
 */
public class Headphones
{


	/** Headphones Color**/
	String Color;
	
	/**Avalable Headphones material: plasic, metal**/
	String Material;
	
	/**Production serial number **/ 
	int serialNumber;
	
	/**The volume on the headphone*/
	int volume;

	
	
	/**
	 * <p>Heaphones default constuctor overide</p>
	 * <p>Color default is blank</p>
	 * <p>serialNumber default is 0</p>
	 */
	Headphones()
	{
		Color = " ";
		Material = " ";
		serialNumber = 0;
		volume = 0;
	}

	/**
	 * This constructor will produce a headphones with a custon color
	 * @param col user defined color
	 * Default serial number is 0
	 */
	Headphones(String col)
	{
		//To name the vars the same you must use this.
		this.Color = col;
		Material = " ";
		serialNumber = 0;
		volume = 0;
	}
	
	/**
	 * <p>This constructor will produce a headphones with a custon color and material</p>
	 * <p>Avalable Headphones material: plasic, metal</p>
	 * @param mat user defined Material
	 * @param col user defined color
	 */
	Headphones( String col, String mat)
	{
		this.Color = col;
		this.Material = mat;
		serialNumber = 0;
		volume = 0;
	}
	
	//*******************************************************************************************************************************************************
	//Instance methods (Alphabetial order and System docs)	Behavior or action that the headphone does
	//*******************************************************************************************************************************************************
	/**
	 * The default methed to muliply the volume by 2
	 *  @author Gibson Holben
	 */
	public void increaseVolume()
	{
		if(volume == 0)		//Fixes a logic error
			volume = 1;
		volume *= 2;
	}
	
	/**
	 * This method allows the user to define the multipyer amount
	 * @param increese The amount that the volume is multiplied
	 * @author Gibson Holben
	 */
	public void increaseVolume(int increese)
	{
		if(volume == 0)		//Fixes a logic error
			volume = 1;
		volume *= increese;
	}
	
	//The system genrates a construcotor if you don't make one
	//overloading constructor is creating differant ways to construct an object
	//constuructors must match the name of the class.
	//overloaded constructor because it has the same name
	//but it will have a differant signature
	//Headphone(String test1)
	//Headphone(String test2) 
	//Both of these are the same and cannot exist together
}