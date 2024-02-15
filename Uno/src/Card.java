
/**
 * A standard UNO card, used when determining
 * what to do when the card is played as well as holding the data of the card
 * @author CTEHolbenG46
 * @version 0.1.8
 */
public class Card 
{	

	
	/**The color of the card
	 * Default = Red*/
	public String 	ColorValue 		= "Red";
	
	
	/**The value of the card
	 * Default = 0*/
	public int 		numberValue 	= 0;
	/**
	 * Card special effects
	 * Default = blank
	 */
	public String 	SpecialEffect 	= "";
	
	
	
	
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
	 * creates a card with the passed in values
	 * and special effects
	 * @param NewColor the color of the card
	 * @param SpecialEffect the cards special effect
	 */
	Card(String NewColor, String SpecialEffect)
	{
		this.SpecialEffect = SpecialEffect;
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
            return numberValue + "," + ColorValue;
		}
		else
		{
            return numberValue + "," + ColorValue +
					"," + SpecialEffect;
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
				MainGameLoop.Players.get(1).PullCard(2);
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
					MainGameLoop.Players.get(1).PullCard(
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
