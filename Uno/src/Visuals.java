import java.awt.Color;

import javax.swing.JFrame;

/**
 * Handels the graphical updates of the game
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Visuals
{
	/**
	 * Sets up the graphics and creates a frame
	 */
	public static void SettupGraphics()
	{
		switch(MainGameLoop.MainDeck.Cards.get(0).ColorValue)
		{
			case "Red":		MainGameLoop.Frame = new MyFrame(Color.red, 		
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;			
			case "Blue":	MainGameLoop.Frame = new MyFrame(Color.blue, 	
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":	MainGameLoop.Frame = new MyFrame(Color.green, 	
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			
			case "Yellow":	MainGameLoop.Frame = new MyFrame(new Color(255, 206, 71), 
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Magenta":	MainGameLoop.Frame = new MyFrame(Color.magenta, 	
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Cyan":	MainGameLoop.Frame = new MyFrame(Color.cyan, 	
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Orange":	MainGameLoop.Frame = new MyFrame(new  Color(252, 148, 20), 
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
			case "Black":	MainGameLoop.Frame = new MyFrame(Color.black, 	
					Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
			break;
				
		}
	}

	
	/**
	 * Updates the graphics for the main deck
	 */
	public static void UpdateGraphicsFlip()
	{
		if(MainGameLoop.MainDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(MainGameLoop.MainDeck.Cards.get(0).ColorValue)
			{
				case "Red":
					MainGameLoop.Frame.reset(Color.red, 			
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Blue":	
					MainGameLoop.Frame.reset(Color.blue, 		
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Green":
					MainGameLoop.Frame.reset(Color.green, 			
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":
					MainGameLoop.Frame.reset(new Color(255, 206, 71),
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":
					MainGameLoop.Frame.reset(Color.magenta,	 		
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":
					MainGameLoop.Frame.reset(Color.cyan,	 			
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Orange":
					MainGameLoop.Frame.reset(new  Color(252, 148, 20),	
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
				case "Black":
					MainGameLoop.Frame.reset(Color.black,	 			
							Integer.toString(MainGameLoop.MainDeck.Cards.get(0).numberValue));
				break;
					
			}
		}
		else
		{
			switch(MainGameLoop.MainDeck.Cards.get(0).ColorValue)
			{
				case "Red":
					MainGameLoop.Frame.reset(Color.red, 				
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":
					MainGameLoop.Frame.reset(Color.blue, 			
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":
					MainGameLoop.Frame.reset(Color.green, 			
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":
					MainGameLoop.Frame.reset(new Color(255, 206, 71),
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":
					MainGameLoop.Frame.reset(Color.magenta,			
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":
					MainGameLoop.Frame.reset(Color.cyan,				
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Orange":
					MainGameLoop.Frame.reset(new  Color(252, 148, 20),	
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Black":
					MainGameLoop.Frame.reset(Color.black,			
							MainGameLoop.MainDeck.Cards.get(0).SpecialEffect);
				break;		
				
					
			}
		}
		

	}
	
	
	/**
	 * Updates the graphics for the players hand
	 */
	public static void UpdateGraphicsPlayer()
	{
		if(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).ColorValue)
			{
				case "Red":		MainGameLoop.Frame.resetPlayerhand(Color.red, 
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Blue":	MainGameLoop.Frame.resetPlayerhand(Color.blue, 		
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Green":	MainGameLoop.Frame.resetPlayerhand(Color.green,	 	
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":	MainGameLoop.Frame.resetPlayerhand(new Color(255, 206, 71), 
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":	MainGameLoop.Frame.resetPlayerhand(Color.magenta,
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":	MainGameLoop.Frame.resetPlayerhand(Color.cyan, 	
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Orange":	MainGameLoop.Frame.resetPlayerhand(new  Color(252, 148, 20), 
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Black":	MainGameLoop.Frame.resetPlayerhand(Color.black, 	
						Integer.toString(
								MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
			}
		}
		else
		{
			
			switch(MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).ColorValue)
			{
				case "Red":		MainGameLoop.Frame.resetPlayerhand(Color.red, 	
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":	MainGameLoop.Frame.resetPlayerhand(Color.blue, 	
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":	MainGameLoop.Frame.resetPlayerhand(Color.green, 		
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":	MainGameLoop.Frame.resetPlayerhand(new Color(255, 206, 71), 
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta": MainGameLoop.Frame.resetPlayerhand(Color.magenta, 	
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":	MainGameLoop.Frame.resetPlayerhand(Color.cyan, 			
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;	
				case "Orange":	MainGameLoop.Frame.resetPlayerhand(new  Color(252, 148, 20), 
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;	
				case "Black":	MainGameLoop.Frame.resetPlayerhand(Color.black, 		
						MainGameLoop.CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
			}
		}
	
	}
}
