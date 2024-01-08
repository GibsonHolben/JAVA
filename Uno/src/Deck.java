import java.util.ArrayList;
import java.util.Collections;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Deck 
{
	/**An arraylist of cards*/
	public ArrayList<Card> Cards = new ArrayList<Card>();
	
	Deck(ArrayList<Card> newCards)
	{
		Cards = newCards;
	}
	
	public void Shuffle()
	{
		Collections.shuffle(Cards);
	}
	
	/**Prints the contents of the deck to the console*/
	public void PrintDeck()
	{
		for(int i = 0; i < Cards.size(); i++)
		{
			System.out.println(Cards.get(i).colorValue + " " + Cards.get(i).numberValue);
		}
	}
}
