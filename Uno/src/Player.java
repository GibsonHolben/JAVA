import java.util.ArrayList;

/**
 * A player in the game, contains the basic functions for playing the game
 * @author CTEHolbenG46
 * @version 1.4.8
 */
public class Player
{
	/**The index of the card*/
	public int 		curentCardIndex;
	
	/**An ArrayList of cards*/
	public Deck 	MyDeck;
	

	 /**The name of the player
	 * Default = blank	 */
	public String 	Name = "";
	
	/**
	 * Creates a player with an empty deck
	 */
	Player()
	{
		MyDeck = new Deck(new ArrayList<Card>());
	}
	
	/**
	 * Determines weather the card in the active players 
	 * hand match the top card in the main deck
	 * @return true if the cards match, false if they do not
	 */
	public boolean CardMatch(int index)
	{
		if(MyDeck.Cards.get(index).SpecialEffect.contains("W"))
		{
			return true;
		}
		else if(MainGameLoop.MainDeck.Cards.get(index).numberValue != 0)
		{
			if(MyDeck.Cards.get(index).ColorValue.equals(MainGameLoop.CurentColor) || 
					MyDeck.Cards.get(index).numberValue == 
					MainGameLoop.MainDeck.Cards.get(0).numberValue||
					MyDeck.Cards.get(index).ColorValue.equals("Black"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(MyDeck.Cards.get(index).ColorValue.equals(MainGameLoop.CurentColor) || 
				MyDeck.Cards.get(index).SpecialEffect.equals(MainGameLoop.MainDeck.Cards.get(0).SpecialEffect))
		{	
			return true;	
		}
		else
		{
			return false;
		}
		
	}
	
	
	/**
	 * Caused the player to draw the amount of cards specified
	 * @param toDraw the amount of cards to draw
	 */
	public void PullCard(int toDraw)
	{
		if(MainGameLoop.MainDeck.Cards.size() > 1)
		{
			for(int i = 0; i < toDraw; i++)
			{
				if(MainGameLoop.MainDeck.Cards.size() > 1)
				{
					MyDeck.Cards.add(MainGameLoop.MainDeck.Cards.get(
							MainGameLoop.MainDeck.Cards.size() - 1));
					MainGameLoop.MainDeck.Cards.remove(
							MainGameLoop.MainDeck.Cards.size() - 1);
				}
				else
				{
					System.out.println("MainDeck is at 1, cannot pull more cards");
				}
			}
		}
		else
		{
			System.out.println("MainDeck is at 1, cannot pull more cards");
		}
		
	}
	
	
	
	/**
	 * Checks if the the current active card is good and goes to the next player
	 */
	public void Play(int index)
	{
		//If the game is running
		if(MainGameLoop.isRunning)
		{
			//Gets the special effect of the card
			String SpecialEffect = MyDeck.Cards.get(index).SpecialEffect;

			//Checks if the card is playable
			if(CardMatch(index))
			{
				//Sets the main deck color if not a wild card
				if(!SpecialEffect.contains("W"))
				{
					MainGameLoop.CurentColor = MyDeck.Cards.get(index).ColorValue;
				}

				//Plays the card
				MyDeck.Cards.get(index).onPlay();
				MainGameLoop.MainDeck.Cards.add(0, MyDeck.Cards.get(index));
				MyDeck.Cards.remove(index);

				//Checks the win condition
				if(MyDeck.Cards.size() < 1)
				{
					//Ends the game if condtion is met
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

	}
	
	/**
	 * Skips the players turn and adds 1 card to their deck
	 */
	public void Skip()
	{
		Visuals.UpdateGraphicsFlip();
		Visuals.UpdateGraphicsPlayer();
		PullCard(1);
		MainGameLoop.NextPlayer();
	}

	/**
	 * Returns the object as a string
	 * Deliminator = ,
	 * @return Name,curentCardIndex,MyDeck
	 */
	public String toString()
	{
		String s = Name + "," + curentCardIndex + "," + MyDeck.toString();
		return s;
 	}

}
