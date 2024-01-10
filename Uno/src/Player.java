import java.util.ArrayList;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Player
{
	/**An arraylist of cards*/
	public Deck MyDeck;
	
	/**
	 * The name of the player
	 * Default = blank
	 */
	public String Name = "";
	
	/**
	 * Creates 
	 */
	Player()
	{
		MyDeck = new Deck(new ArrayList<Card>());
	}
	
	/**
	 * Skips the players turn
	 */
	public void Skip()
	{
		MainGameLoop.UpdateGraphicsFlip();
		MainGameLoop.UpdateGraphicsPlayer();
		MainGameLoop.nextPlayer();
	}
	
	/**
	 * Players the curent active card and goes to the next player
	 */
	public void play()
	{
		
		if(MyDeck.Cards.get(0).colorValue == MainGameLoop.MainDeck.Cards.get(0).colorValue ||
				MyDeck.Cards.get(0).numberValue == MainGameLoop.MainDeck.Cards.get(0).numberValue)
		{
			MainGameLoop.MainDeck.Cards.add(0, MyDeck.Cards.get(0));
			MyDeck.Cards.remove(0);
			
			if(MyDeck.Cards.size() < 1)
			{
				System.out.println("Game over");
				System.out.println(Name + " Wins");
				MainGameLoop.isRunning = false;
				System.exit(0);
			}
			else 
			{
				MainGameLoop.UpdateGraphicsFlip();
				MainGameLoop.UpdateGraphicsPlayer();
			}
			
			MainGameLoop.nextPlayer();
		}
	}

}
