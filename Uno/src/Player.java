import java.util.ArrayList;

/**
 * A player in the game, contains the basic functions for playing the game
 * @author CTEHolbenG46
 * @version 1.4.2
 */
public class Player
{
	/**The index of the card*/
	public int 		curentCardIndex;
	
	/**An ArrayList of cards*/
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
	 * Determines weather the card in the active players hand match the top card in the main deck
	 * @return true if the cards match, false if they do not
	 */
	public boolean cardMatch()
	{
		if(MyDeck.Cards.get(0).ColorValue.equals(MainGameLoop.CurentColor) || 
				MyDeck.Cards.get(0).numberValue == 
				MainGameLoop.MainDeck.Cards.get(0).numberValue||
				MyDeck.Cards.get(0).ColorValue.equals("Black"))
		{
			return true;
		}
		else
		{
			return false;
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
			MyDeck.Cards.add(MainGameLoop.MainDeck.Cards.get(
					MainGameLoop.MainDeck.Cards.size() - 1));
			MainGameLoop.MainDeck.Cards.remove(
					MainGameLoop.MainDeck.Cards.size() - 1);
		}
	}
	
	
	
	/**
	 * Players the current active card and goes to the next player
	 */
	public void play()
	{
		//Gets the special effect of the card
		String SpecialEffect = MyDeck.Cards.get(0).SpecialEffect;
		
		//Checks if the card is playable
		if(cardMatch())	
		{
			
			//Sets the main deck color if not a wild card
			if(!SpecialEffect.contains("W"))
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
				Visuals.UpdateGraphicsFlip();
				Visuals.UpdateGraphicsPlayer();
			}
			
			//Runs next player becuase main game loop doesnt run
			//it if its a wild card
			if(!SpecialEffect.equals("W+" + 
					MainGameLoop.Settings[1]) &&
					!SpecialEffect.equals("W"))
			{
				MainGameLoop.NextPlayer();
			}
			
		}
	}
	
	/**
	 * Skips the players turn and adds 1 card to their deck
	 */
	public void Skip()
	{
		Visuals.UpdateGraphicsFlip();
		Visuals.UpdateGraphicsPlayer();
		DrawCard(1);
		MainGameLoop.NextPlayer();
	}
	
	
	
	
	/**
	 * Returns the object as a string
	 */
	public String toString()
	{
		String s = Name + "," + MyDeck.toString();
		return s;
 	}

}
