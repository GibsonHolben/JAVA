import java.time.LocalDate;
/**
 * Calculates an Identfication number with the 
 * passed in amount + date created or count + date created
 * @author Gibson Holben
 * @version 1.2.7
 */
public class Id 
{
	
	/**The amount of times the id has been created*/
	private static int count;
	
	
	/** Calculates an idntification number and then returns it
	 * 
	 * @return amount + curent date (yyyy/mm/dd)*/
	public static int CalculateIdentification() 
	{
		count +=1;
		//Creates a new date created
		LocalDate DateCreated;
		
		//Gets the curent date
		DateCreated = LocalDate.now();
		
		//Creates an id number 
		String S = count + DateCreated.toString();
		String NewS = S.replace("-", "");
		
		//Returns the newly created identification number
		return Integer.parseInt(NewS);		
	}
	
	
	/** Calculates an idntification number with a passed in number
	 * and then returns it
	 * 
	 * @return amount + curent date (yyyy/mm/dd)
	 * @param amount A number (such as the amount of
	 *  said object that has been created)  */
	public static int CalculateIdentification(int amount) 
	{
		
		//Creates a new date created
		LocalDate DateCreated;
		
		//Gets the curent date
		DateCreated = LocalDate.now();
		
		//Creates an id number 
		String S = amount + DateCreated.toString();
		String NewS = S.replace("-", "");
		
		//Returns the newly created identification number
		return Integer.parseInt(NewS);		
	}
}
