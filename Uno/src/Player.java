import java.util.ArrayList;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Player
{
	/**An arraylist of cards*/
	public Deck 	MyDeck;
	
	/**
	 * The name of the player
	 * Default = blank
	 */
	public String 	Name = "";
	
	/**
	 * Creates a player with an empty deck
	 */
	Player()
	{
		MyDeck = new Deck(new ArrayList<Card>());
	}
	
	/**
	 * Skips the players turn and adds 1 card to their deck
	 */
	public void Skip()
	{
		MainGameLoop.UpdateGraphicsFlip();
		MainGameLoop.UpdateGraphicsPlayer();
		DrawCard(1);
		MainGameLoop.NextPlayer();
	}
	
	/**
	 * Players the curent active card and goes to the next player
	 */
	public void play()
	{
		//Gets the special effect of the card
		String sf = MyDeck.Cards.get(0).SpecialEffect;
		
		//Checks if the card is playable
		if(MyDeck.Cards.get(0).ColorValue.equals(MainGameLoop.CurentColor) || 
				MyDeck.Cards.get(0).numberValue == MainGameLoop.MainDeck.Cards.get(0).numberValue||
				MyDeck.Cards.get(0).ColorValue.equals("Black"))
				
				
		{
			
			//Sets the main deck color if not a wild card
			if(sf != "W" && sf != "W+4")
			{
				MainGameLoop.CurentColor = MyDeck.Cards.get(0).ColorValue;
			}
			
			//Plays the card
			System.out.println("Played card");
			MyDeck.Cards.get(0).onPlay();
			MainGameLoop.MainDeck.Cards.add(0, MyDeck.Cards.get(0));
			MyDeck.Cards.remove(0);
			
			//Checks the win condition
			if(MyDeck.Cards.size() < 1)
			{
				MainGameLoop.CurentWinPlayer = MainGameLoop.CurentPlayer;
				System.out.println("Game over");
				System.out.println(Name + " Wins");
				MainGameLoop.isRunning = false;
			}
			else 
			{
				//Updates the graphics
				MainGameLoop.UpdateGraphicsFlip();
				MainGameLoop.UpdateGraphicsPlayer();
			}
			
			//Runs next player becuase main game loop doesnt run it if its a wild card
			if(!sf.equals("W+" + MainGameLoop.Settings[1]) &&!sf.equals("W"))
			{
				MainGameLoop.NextPlayer();
			}
			
		}
	}
	
	/**
	 * Caused the player to draw the amout of cards specifed
	 * @param toDraw the amount of cards to draw
	 */
	public void DrawCard(int toDraw)
	{
		for(int i = 0; i < toDraw; i++)
		{
			MyDeck.Cards.add(MainGameLoop.MainDeck.Cards.get(MainGameLoop.MainDeck.Cards.size() - 1));
			MainGameLoop.MainDeck.Cards.remove(MainGameLoop.MainDeck.Cards.size() - 1);
		}
		
	}
	
	
	/**
	 * Prints the variables on the object
	 */
	public String toString()
	{
		String s = Name + "," + MyDeck.toString();
		return s;
 	}

}
