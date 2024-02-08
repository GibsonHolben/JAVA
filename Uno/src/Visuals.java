import java.awt.Color;

/**
 * Handels the graphical updates of the game
 * @author CTEHolbenG46
 * @version 0.0.3
 */
public class Visuals
{
	/**
	 * The color of the red card
	 * Default = 197, 34, 55
	 */
	public final static Color RED 		= new Color(197, 34, 55);
	
	/**
	 * The color of the blue card
	 * Default = 1, 84, 164
	 */
	public final static Color BLUE 	= new Color(1, 84, 164);
	
	/**
	 * The color of the green card
	 * Default = 98, 156, 59
	 */
	public final static Color GREEN 	= new Color(98, 156, 59);
	
	/**
	 * The color of the yellow card
	 * Default = 237, 208, 44
	 */
	public final static Color YELLOW 	= new Color(237, 208, 44);
	
	/**
	 * The color of the magenta card
	 * Default = Color.magenta
	 */
	public final static Color MAGENTA 	= Color.magenta;
	
	/**
	 * The color of the cyan card
	 * Default = color.cyan
	 */
	public final static Color CYAN 	= Color.cyan;
	
	/**
	 * The color of the orange card
	 * Default = 255, 127, 39
	 */
	public final static Color ORANGE 	= new Color(255, 127, 39);
	
	/**
	 * The color of the grey card
	 * Default = 77, 77, 77
	 */
	public final static Color GREY 	= new Color(77, 77, 77);
	
	/**
	 * The color of the black card
	 * Default = 0, 0, 0
	 */
	public final static Color BLACK 	= new Color(0, 0, 0);
	
	/**
	 * Sets up the graphics and creates a frame
	 */
	public static void SettupGraphics()
	{
		MainGameLoop.Frame = new MyFrame(Setup.GetColor(MainGameLoop.MainDeck.Cards.get(0).ColorValue), Integer.toString(	MainGameLoop.MainDeck.Cards.get(0).numberValue));
	}

	
	/**
	 * Updates the graphics for the main deck
	 */
	public static void UpdateGraphicsFlip()
	{
		try
		{
			if(MainGameLoop.MainDeck.Cards.get(0).SpecialEffect.isEmpty())
			{
				MainGameLoop.Frame.reset(Setup.GetColor(MainGameLoop.MainDeck.Cards.get(0).ColorValue), 			
						Integer.toString(
						MainGameLoop.MainDeck.Cards.get(0).numberValue));
			}
			else
			{
				MainGameLoop.Frame.reset(Setup.GetColor(MainGameLoop.MainDeck.Cards.get(0).ColorValue), 				
						MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
			}
		}
		catch(Exception e)
		{
			System.out.println("Could not update deck graphics");
		}

	}
	
	
	/**
	 * Updates the graphics for the players hand
	 */
	public static void UpdateGraphicsPlayer()
	{
		try
		{
			if(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect.isEmpty())
			{
				MainGameLoop.Frame.resetPlayerhand(Setup.GetColor(	MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).ColorValue), 
													Integer.toString(
													MainGameLoop.CurentPlayer.
													MyDeck.Cards.get(0).numberValue));
			}
			else
			{
				MainGameLoop.Frame.resetPlayerhand(Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).ColorValue), 	
													MainGameLoop.CurentPlayer.
													MyDeck.Cards.get(0).SpecialEffect);
			}
		}
		catch(Exception e)
		{
			System.out.println("Could not update player graphics");
		}
	}
}
