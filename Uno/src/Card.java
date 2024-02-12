
/**
 * A standard UNO card, used when determining
 *  what to do when the card is played
 * @author CTEHolbenG46
 * @version 0.1.5
 */
public class Card 
{	

	
	/**The color of the card
	 * Default = Red*/
	public String 	ColorValue = "Red";
	
	
	/**The value of the card
	 * Default = 0*/
	public int 		numberValue = 0;
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
	 * creates a card with the passe in values 
	 * and speial effects
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
	 * Deliminator = ,
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
			String s = numberValue + "," + ColorValue + 
					"," + SpecialEffect;
			return s;
		}
	}
	
	/**
	 * Runs when the card is played
	 */
	public void onPlay()
	{
		if(SpecialEffect.equals("+2"))
		{
			try
			{
				MainGameLoop.Players.get(1).DrawCard(2);
			}	
			catch(Exception e)
			{
				System.out.println("Could not draw cards");
			}
		}
		
		if(SpecialEffect.equals("W+" + MainGameLoop.Settings[1]))
		{
			MainGameLoop.CurentColor = "Black";
			if(MainGameLoop.isRunning)
			{
				MainGameLoop.Frame.canPlay = false;
				MainGameLoop.Frame.SettupColorButtons(300);
				
				try
				{
					MainGameLoop.Players.get(1).DrawCard(
							Integer.parseInt(MainGameLoop.Settings[1]));
				}
				catch(Exception e)
				{
					System.out.println("Could not draw cards");
				}
			}
		}
		
		if(SpecialEffect.equals("S"))
		{
			MainGameLoop.NextPlayer();
		}
		
		if(SpecialEffect.equals("W"))
		{
			MainGameLoop.CurentColor = "Black";
			if(MainGameLoop.isRunning)
			{
				MainGameLoop.Frame.canPlay = false;
				MainGameLoop.Frame.SettupColorButtons(300);
			}
		}
	}
}
