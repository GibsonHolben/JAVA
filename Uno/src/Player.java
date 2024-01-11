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
		DrawCard(1);
		MainGameLoop.nextPlayer();
	}
	
	/**
	 * Players the curent active card and goes to the next player
	 */
	public void play()
	{
		String sf = MyDeck.Cards.get(0).SpecialEffect;
		if(MyDeck.Cards.get(0).colorValue.equals(MainGameLoop.CurentColor) || 
				MyDeck.Cards.get(0).numberValue == MainGameLoop.MainDeck.Cards.get(0).numberValue||
				MyDeck.Cards.get(0).colorValue.equals("Black"))
				
				
		{
			System.out.println("Played card");
			MyDeck.Cards.get(0).onPlay();
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
			
			if(!sf.equals("W+4")||!sf.equals("W"))
			{
				MainGameLoop.nextPlayer();
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

}
