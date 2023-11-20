import java.time.LocalDate;
/**
 * Creates an Armor that is used by a clone
 * @author Gibson Holben
 * @version 0.0.0.1
 */
public class Armor 
{
	//*****************************
	//Instance vars
	//*****************************
	
	/**The type of armor that the curent armor is 
	 *Examples include: flight, shock, burning, etc...
	 * Default = blank*/
	private String 				ArmorType = "";
	
	/**The date that the armor was created*/
	private final LocalDate 	DATECREATED;
	
	/**Is the armor bulletproof
	 * Default = false*/
	private boolean 			isBulletProof = false;
	

	/**The level of protection that the armor has
	 * Range: 0 - 100
	 * Default = 50*/
	private short 				protectionLvl = 50;
	
	//*****************************
	//Constructors
	//*****************************
	
	/**
	 * <p>The default constructor</p>
	 * <p>Sets the date created</p>
	 */
	Armor()
	{
		DATECREATED = LocalDate.now();
	}
	
	/**
	 * Overloaded constructor that takes in all the variables
	 * @param ArmorType		The type of armor that the curent armor is
	 * @param isBulletProof Is the armor bulletproof
	 * @param protectionLvl The level of protection that the armor has
	 */
	Armor(String ArmorType, boolean isBulletProof, short protectionLvl)
	{
		DATECREATED 		= LocalDate.now();
		this.ArmorType 		= ArmorType;
		this.isBulletProof 	= isBulletProof;
		this.protectionLvl 	= protectionLvl;		
	}
	
	//*****************************
	//Getters and Setters
	//*****************************
	/**
	 * Returns armorType 
	 * @return the armorType
	 */
	public String getArmorType() {
		return ArmorType;
	}

	/**
	 * Sets armorType
	 * @param armorType the new armorType 
	 */
	public void setArmorType(String armorType) {
		ArmorType = armorType;
	}

	/**
	 * Returns isBulletProof 
	 * @return the isBulletProof
	 */
	public boolean getisBulletProof() {
		return isBulletProof;
	}

	/**
	 * Sets isBulletProof
	 * @param isBulletProof the new isBulletProof 
	 */
	public void setBulletProof(boolean isBulletProof) {
		this.isBulletProof = isBulletProof;
	}

	/**
	 * Returns protectionLvl 
	 * @return the protectionLvl
	 */
	public short getProtectionLvl() {
		return protectionLvl;
	}

	/**
	 * Sets protectionLvl
	 * @param protectionLvl the new protectionLvl 
	 */
	public void setProtectionLvl(short protectionLvl) {
		this.protectionLvl = protectionLvl;
	}

	/**
	 * Returns DATECREATED 
	 * @return the DATECREATED
	 */
	public LocalDate getDateCreated() {
		return DATECREATED;
	}

	
	
	//*****************************
	//Methods
	//*****************************
	
	/**
	 * Prints the instance pariables to the console in an orderly fassion
	 */
	public void printAll()
	{
		System.out.println("Armor Type: " 		+ ArmorType);
		System.out.println("Date Created: "		+ DATECREATED);
		System.out.println("Protection Level: " + protectionLvl);
		System.out.println("Is bullet proof: "  + isBulletProof);
	}
	

	/**
	 * Returns the instance variables in a CSV format
	 * @return The variables in a CSV format
	 */
	public String toString()
	{
		String S1 = ArmorType + "|" + DATECREATED + "|" + protectionLvl + "|" + isBulletProof;
		return S1;
	}
	
	
}
