import java.time.LocalDate;
/**
 * Creates an Armor that used by a clone
 * @author Gibson Holben
 * @version 0.0.6.3
 */
public class Armor 
{
	
	//*****************************
	//Instance vars
	//*****************************
	/**<p>The type of armor that the curent armor is  
	 * Examples include: flight, shock, burning, etc... 
	 * Default = Dull</p>*/
	public String 				ArmorType = "Dull";
	
	/**The date that the armor was created */
	public final LocalDate 		DATECREATED;
	
	/**<p>Is the armor bulletproof
	 * Default = false</p>*/
	public boolean 				isBulletProof = false;
	
	/**<p>The material that the armor is made out of 
	 * Default = Metal </p>*/
	public String 				Material = "Metal";

	/**<p>The level of protection that the armor has 
	 * Range: 0 - 100 
	 * Default = 50</p>*/
	public short 				protectionLvl = 50;
	
	
	
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
	 * <p>Overloaded constructor that takes in all the variables</p>
	 * @param ArmorType		The type of armor that the curent armor is
	 * @param isBulletProof Is the armor bulletproof
	 * @param protectionLvl The level of protection that the armor has
	 * @param Material The material that the armor is made out of
	 */
	Armor(String ArmorType, boolean isBulletProof, short protectionLvl, String Material)
	{
		DATECREATED 		= LocalDate.now();
		this.ArmorType 		= ArmorType;
		this.isBulletProof 	= isBulletProof;
		this.protectionLvl 	= protectionLvl;	
		this.Material = Material;
	}
	
	
	//*****************************
	//Methods
	//*****************************
	/**
	 * <p>Prints the instance variables to
	 * the console in an orderly fassion</p>
	 */
	public void printAll()
	{
		System.out.println("ArmorType: " 		+ ArmorType);
		System.out.println("DateCreated: "		+ DATECREATED);
		System.out.println("ProtectionLevel: " 	+ protectionLvl);
		System.out.println("IsBulletProof: "  	+ isBulletProof);
		System.out.println("Material: " 		+ Material);
	}
	

	/**
	 * <p>Returns the instance variables in a CSV format</p>
	 * Deliminator = |
	 * @return The variables in a CSV format
	 * 
	 */
	public String toString()
	{
		String S1 = ArmorType + "|" + DATECREATED + "|" + 
				protectionLvl + "|" + isBulletProof + "|" + Material;
		return S1;
	}

	
	
	
}
