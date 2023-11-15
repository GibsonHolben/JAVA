import java.time.LocalDate;
/**
 * Calculates an Identfication number with the passed in amount + the date created
 * @author Gibson Holben
 * @version 1.0
 */
public class Id 
{
	/**
	 * Calculates an idntification number and returns the value
	 *  = 
	 * @return amount + curent date (yyyy/mm/dd)
	 * 
	 * @param amount a number (such as the amount of said object that has been crated) 
	 */
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
