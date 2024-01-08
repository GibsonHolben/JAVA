
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Card 
{	
	/**The value of the card
	 * Default = 0*/
	public int numberValue = 0;
	
	/**The color of the card*/
	public String colorValue = "Red";
	
	
	/**Creates a card with user passed in values*/
	Card(int newValue, String newColor)
	{
		numberValue = newValue;
		colorValue = newColor;
	}
}
