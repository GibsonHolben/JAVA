import java.util.ArrayList;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Player
{
	/**An arraylist of cards*/
	public Deck MyDeck;
	
	
	Player()
	{
		MyDeck = new Deck(new ArrayList<Card>());
	}

}
