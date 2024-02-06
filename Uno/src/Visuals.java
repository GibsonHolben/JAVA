import java.awt.Color;

import javax.swing.JFrame;

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
	 * The color of the black card
	 * Default = 0, 0, 0
	 */
	public final static Color BLACK 	= new Color(0, 0, 0);
	
	/**
	 * Sets up the graphics and creates a frame
	 */
	public static void SettupGraphics()
	{
		switch(MainGameLoop.MainDeck.Cards.get(0).ColorValue)
		{
			case "Red":		MainGameLoop.Frame = new MyFrame(RED, 		
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;			
			case "Blue":	MainGameLoop.Frame = new MyFrame(BLUE, 	
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":	MainGameLoop.Frame = new MyFrame(GREEN, 	
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Yellow":	MainGameLoop.Frame = new MyFrame(YELLOW, 
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Magenta":	MainGameLoop.Frame = new MyFrame(MAGENTA, 	
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Cyan":	MainGameLoop.Frame = new MyFrame(CYAN, 	
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Orange":	MainGameLoop.Frame = new MyFrame(ORANGE, 
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Black":	MainGameLoop.Frame = new MyFrame(BLACK, 	
					Integer.toString(
							MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
				
		}
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
				switch(MainGameLoop.MainDeck.Cards.get(0).ColorValue)
				{
					case "Red":
						MainGameLoop.Frame.reset(RED, 			
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Blue":	
						MainGameLoop.Frame.reset(BLUE, 		
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Green":
						MainGameLoop.Frame.reset(GREEN, 			
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Yellow":
						MainGameLoop.Frame.reset(YELLOW,
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Magenta":
						MainGameLoop.Frame.reset(MAGENTA,	 		
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Cyan":
						MainGameLoop.Frame.reset(CYAN,	 			
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Orange":
						MainGameLoop.Frame.reset(ORANGE,	
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
					case "Black":
						MainGameLoop.Frame.reset(BLACK,	 			
										Integer.toString(
										MainGameLoop.MainDeck.Cards.get(0).numberValue));
					break;
						
				}
			}
			else
			{
				switch(MainGameLoop.MainDeck.Cards.get(0).ColorValue)
				{
					case "Red":
						MainGameLoop.Frame.reset(RED, 				
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Blue":
						MainGameLoop.Frame.reset(BLUE, 			
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Green":
						MainGameLoop.Frame.reset(GREEN, 			
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Yellow":
						MainGameLoop.Frame.reset(YELLOW,
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Magenta":
						MainGameLoop.Frame.reset(MAGENTA,			
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Cyan":
						MainGameLoop.Frame.reset(CYAN,				
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Orange":
						MainGameLoop.Frame.reset(ORANGE,	
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;
					case "Black":
						MainGameLoop.Frame.reset(BLACK,			
								MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
					break;		
					
						
				}
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
				switch(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).ColorValue)
				{
					case "Red":		MainGameLoop.Frame.resetPlayerhand(RED, 
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Blue":	MainGameLoop.Frame.resetPlayerhand(BLUE, 		
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Green":	MainGameLoop.Frame.resetPlayerhand(GREEN,	 	
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Yellow":	MainGameLoop.Frame.resetPlayerhand(YELLOW, 
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Magenta":	MainGameLoop.Frame.resetPlayerhand(MAGENTA,
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Cyan":	MainGameLoop.Frame.resetPlayerhand(CYAN, 	
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Orange":	MainGameLoop.Frame.resetPlayerhand(ORANGE, 
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
					case "Black":	MainGameLoop.Frame.resetPlayerhand(BLACK, 	
									Integer.toString(
									MainGameLoop.CurentPlayer.
									MyDeck.Cards.get(0).numberValue));
					break;
				}
			}
			else
			{
				
				switch(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).ColorValue)
				{
					case "Red":	MainGameLoop.Frame.resetPlayerhand(RED, 	
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;
					case "Blue":MainGameLoop.Frame.resetPlayerhand(BLUE, 	
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;
					case "Green":MainGameLoop.Frame.resetPlayerhand(GREEN, 		
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;
					case "Yellow":MainGameLoop.Frame.resetPlayerhand(YELLOW, 
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;
					case "Magenta":MainGameLoop.Frame.resetPlayerhand(MAGENTA, 	
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;
					case "Cyan":MainGameLoop.Frame.resetPlayerhand(CYAN, 			
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;	
					case "Orange":MainGameLoop.Frame.resetPlayerhand(ORANGE, 
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;	
					case "Black":MainGameLoop.Frame.resetPlayerhand(BLACK, 		
							MainGameLoop.CurentPlayer.
							MyDeck.Cards.get(0).SpecialEffect);
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Could not update player graphics");
		}
		
	
	}
}
