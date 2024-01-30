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
	 * Updates the graphics for the main deck
	 */
	public static void UpdateGraphicsFlip(Deck MainDeck, MyFrame Frame)
	{
		if(MainDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(MainDeck.Cards.get(0).ColorValue)
			{
				case "Red":
					Frame.reset(Color.red, 			
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Blue":
					Frame.reset(Color.blue, 		
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Green":
					Frame.reset(Color.green, 			
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":
					Frame.reset(new Color(255, 206, 71),
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":
					Frame.reset(Color.magenta,	 		
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":
					Frame.reset(Color.cyan,	 			
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Orange":
					Frame.reset(new  Color(252, 148, 20),	
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
				case "Black":
					Frame.reset(Color.black,	 			
							Integer.toString(MainDeck.Cards.get(0).numberValue));
				break;
					
			}
		}
		else
		{
			switch(MainDeck.Cards.get(0).ColorValue)
			{
				case "Red":
					Frame.reset(Color.red, 				
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":
					Frame.reset(Color.blue, 			
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":
					Frame.reset(Color.green, 			
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":
					Frame.reset(new Color(255, 206, 71),
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":
					Frame.reset(Color.magenta,			
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":
					Frame.reset(Color.cyan,				
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Orange":
					Frame.reset(new  Color(252, 148, 20),	
							MainDeck.Cards.get(0).SpecialEffect);
				break;
				case "Black":
					Frame.reset(Color.black,			
							MainDeck.Cards.get(0).SpecialEffect);
				break;		
				
					
			}
		}
		

	}
	
	/**
	 * Sets up the graphics and creates a frame
	 */
	public static void SettupGraphics(Deck MainDeck, MyFrame Frame)
	{
		switch(MainDeck.Cards.get(0).ColorValue)
		{
			case "Red":		Frame = new MyFrame(Color.red, 		
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;			
			case "Blue":	Frame = new MyFrame(Color.blue, 	
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Green":	Frame = new MyFrame(Color.green, 	
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			
			case "Yellow":	Frame = new MyFrame(new Color(255, 206, 71), 
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Magenta":	Frame = new MyFrame(Color.magenta, 	
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Cyan":	Frame = new MyFrame(Color.cyan, 	
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Orange":	Frame = new MyFrame(new  Color(252, 148, 20), 
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
			case "Black":	Frame = new MyFrame(Color.black, 	
					Integer.toString(MainDeck.Cards.get(0).numberValue));
			break;
				
		}
	}

	
	
	/**
	 * Updates the graphics for the players hand
	 */
	public static void UpdateGraphicsPlayer(Player CurentPlayer, MyFrame Frame)
	{
		if(CurentPlayer.MyDeck.Cards.get(0).SpecialEffect.isEmpty())
		{
			switch(CurentPlayer.MyDeck.Cards.get(0).ColorValue)
			{
				case "Red":		Frame.resetPlayerhand(Color.red, 
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Blue":	Frame.resetPlayerhand(Color.blue, 		
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Green":	Frame.resetPlayerhand(Color.green,	 	
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Yellow":	Frame.resetPlayerhand(new Color(255, 206, 71), 
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Magenta":	Frame.resetPlayerhand(Color.magenta,
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Cyan":	Frame.resetPlayerhand(Color.cyan, 	
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Orange":	Frame.resetPlayerhand(new  Color(252, 148, 20), 
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
				case "Black":	Frame.resetPlayerhand(Color.black, 	
						Integer.toString(
								CurentPlayer.MyDeck.Cards.get(0).numberValue));
				break;
			}
		}
		else
		{
			
			switch(CurentPlayer.MyDeck.Cards.get(0).ColorValue)
			{
				case "Red":		Frame.resetPlayerhand(Color.red, 	
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Blue":	Frame.resetPlayerhand(Color.blue, 	
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Green":	Frame.resetPlayerhand(Color.green, 		
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Yellow":	Frame.resetPlayerhand(new Color(255, 206, 71), 
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Magenta":	Frame.resetPlayerhand(Color.magenta, 	
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
				case "Cyan":	Frame.resetPlayerhand(Color.cyan, 			
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;	
				case "Orange":	Frame.resetPlayerhand(new  Color(252, 148, 20), 
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;	
				case "Black":	Frame.resetPlayerhand(Color.black, 		
						CurentPlayer.MyDeck.Cards.get(0).SpecialEffect);
				break;
			}
		}
	
	}
}
