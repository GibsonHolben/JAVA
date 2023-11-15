/**
 * A class used to hold the address of a building
 * @author Gibson Holben
 * @version 0.0.3
 */
public class Address
{	
	/**The City that the building is located in
	 * Default = Blank*/
	private String City = " ";
	
	/**The state that the building is located in
	 * Default = Blank*/
	private String State = "";
	
	/** The street and house number of the building
	 * Default = Blank*/
	private String StreetAddress = "";
	
	/**The Zip Code of the building
	 * Default = 0*/
	private int zipCode = 0;
	
	/**
	 * Overides the default constructor
	 */
	Address()
	{
		//Empty
	}
	
	/**
	 * An overloaded constructor the creates an 
	 * Address with all the variables passed in
	 * @param StreetAddress The new StreetAddress
	 * @param City The new City
	 * @param zipCode The new zipCode
	 */
	Address(String StreetAddress, String City, String State, int zipCode)
	{
		this.StreetAddress  = 			StreetAddress;
		this.State 			= 			State;
		this.City 			= 			City;
		this.zipCode 		= 			zipCode;
	}

	/**
	 * Returns the strees address of the BUilding
	 * @return StreetAddress
	 */
	public String getStreetAddress() {
		return StreetAddress;
	}

	/**
	 * Sets the strees address of the Building
	 * @param streetAddress the new Address of the buildings
	 */
	public void setStreetAddress(String streetAddress) {
		StreetAddress = streetAddress;
	}

	/**
	 * Returns the City that the building is located in
	 * @return City
	 */
	public String getCity() {
		return City;
	}

	/**
	 * Sets the city that the Building is located in
	 * @param city the new City
	 */
	public void setCity(String city) {
		City = city;
	}

	/**
	 * Returns the state that the building is located in
	 * @return State
	 */
	public String getState() {
		return State;
	}

	/**
	 * Sets the State that the building is located in
	 * @param state the new State
	 */
	public void setState(String state) {
		State = state;
	}

	/**
	 * Returns the zip code of the building
	 * @return zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code of the Building
	 * @param zipCode the new zip code
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
	/**
	 * Returns the variables of Address in a CSV formated String
	 * @return StreetAddress|City|zipCode
	 */
	public String toString()
	{
		//Merges the Strings
		String s = StreetAddress + "|" + City + "|" + State +  "|" + zipCode;
		
		//Returns them
		return s;
	}
	
	/**
	 * Prints the variables to the console in an orderly fashion 
	 */
	public void printAll()
	{
		System.out.println("StreetAdress: " +  StreetAddress);
		System.out.println("City: " + City);
		System.out.println("State: " + State);
		System.out.println("zipCode: " + zipCode);
	}
}
