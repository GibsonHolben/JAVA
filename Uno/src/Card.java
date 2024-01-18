
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Card 
{	
	/**The value of the card
	 * Default = 0*/
	public int 		NumberValue = 0;
	
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
	 * @param newColor the color of the card
	 */
	Card(int newValue, String newColor)
	{
		NumberValue = newValue;
		ColorValue 	= newColor;
	}
	
	
	/**
	 * creates a card with the passe in values and speial effects
	 * @param newColor the color of the card
	 * @param special the cards special effect
	 */
	Card(String newColor, String special)
	{
		SpecialEffect = special;
		ColorValue 	  = newColor;
	}
	
	/**
	 * Prints the variables on the object
	 */
	public String toString()
	{
		if(SpecialEffect.isEmpty())
		{
			String s = NumberValue + "," + ColorValue;
			return s;
		}
		else
		{
			String s = NumberValue + "," + ColorValue + "," + SpecialEffect;
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
			MainGameLoop.frame.canPlay = false;
			MainGameLoop.frame.SettupColorButtons(300);
			MainGameLoop.Players.get(1).DrawCard(4);
		}
		
		if(SpecialEffect.equals("R"))
		{
			
		}
		
		if(SpecialEffect.equals("W"))
		{
			MainGameLoop.frame.canPlay = false;
			MainGameLoop.frame.SettupColorButtons(300);
		}
	}
}
