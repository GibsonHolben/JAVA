
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
	public String 	colorValue = "Red";
	
	/**
	 * Card special effects
	 * Default = blank
	 */
	public String 	SpecialEffect = "";
	
	
	/**
	 * Creates a card with user passed in values
	 * @param newValue the value of the card
	 * @param newColor the color of the card
	 */
	Card(int newValue, String newColor)
	{
		numberValue = newValue;
		colorValue 	= newColor;
	}
	
	
	/**
	 * 
	 * @param newValue the value of the card
	 * @param newColor the color of the card
	 * @param special the cards special effect
	 */
	Card(String newColor, String special)
	{
		SpecialEffect = special;
		colorValue 	  = newColor;
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
			MainGameLoop.Players.get(1).DrawCard(4);
		}
		
		if(SpecialEffect.equals("R"))
		{
			
		}
		
		if(SpecialEffect.equals("W"))
		{
			
		}
	}
}
