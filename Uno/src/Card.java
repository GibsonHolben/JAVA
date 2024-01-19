
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Card 
{	
	/**The value of the card
	 * Default = 0*/
	public int 		numberValue = 0;
	
	/**The color of the card*/
	public String 	ColorValue = "Red";
	
	/**
	 * Card special effects
	 * Default = blank
	 */
	public String 	SpecialEffect = "";
	
	
	/**
	 * Creates a card with passed in values
	 * @param newValue the value of the card
	 * @param NewColor the color of the card
	 */
	Card(int newValue, String NewColor)
	{
		numberValue = newValue;
		ColorValue 	= NewColor;
	}
	
	
	/**
	 * creates a card with the passe in values and speial effects
	 * @param NewColor the color of the card
	 * @param Special the cards special effect
	 */
	Card(String NewColor, String Special)
	{
		SpecialEffect = Special;
		ColorValue 	  = NewColor;
	}
	
	/**
	 * Prints the variables on the object
	 */
	public String toString()
	{
		if(SpecialEffect.isEmpty())
		{
			String s = numberValue + "," + ColorValue;
			return s;
		}
		else
		{
			String s = numberValue + "," + ColorValue + "," + SpecialEffect;
			return s;
		}
	}
	
	/**
	 * Runs when tha card is played
	 */
	public void onPlay()
	{
		if(SpecialEffect.equals("+2"))
		{
			MainGameLoop.Players.get(1).DrawCard(2);
		}
		
		if(SpecialEffect.equals("W+4"))
		{
			MainGameLoop.Frame.canPlay = false;
			MainGameLoop.Frame.SettupColorButtons(300);
			MainGameLoop.Players.get(1).DrawCard(4);
		}
		
		if(SpecialEffect.equals("S"))
		{
			
		}
		
		if(SpecialEffect.equals("W"))
		{
			MainGameLoop.Frame.canPlay = false;
			MainGameLoop.Frame.SettupColorButtons(300);
		}
	}
}
