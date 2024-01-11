import java.util.ArrayList;
import java.util.Collections;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 * 
 * A deck that can hold cards
 */
public class Deck 
{
	/**An arraylist of cards*/
	public ArrayList<Card> Cards = new ArrayList<Card>();
	
	/**
	 * Creates a Deck
	 * @param newCards an arraylist of cards
	 */
	Deck(ArrayList<Card> newCards)
	{
		Cards = newCards;
	}
	
	/**Randomizes the order of the cards*/
	public void Shuffle()
	{
		Collections.shuffle(Cards);
	}
	
	/**Prints the contents of the deck to the console*/
	public void PrintDeck()
	{
		for(int i = 0; i < Cards.size(); i++)
		{
			if((Cards.get(i).SpecialEffect.equals("")))
			{
				System.out.println(Cards.get(i).colorValue + " " + Cards.get(i).numberValue);
			}
			else 
			{
				System.out.println(Cards.get(i).colorValue + " " + Cards.get(i).SpecialEffect);
			}
			
		}
	}
}
