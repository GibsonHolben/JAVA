import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of cards and can be shuffled and printed
 * @author CTEHolbenG46
 * @version 0.0.8
 */
public class Deck 
{
	/**An ArrayList of cards*/
	public ArrayList<Card> Cards = new ArrayList<Card>();
	
	/**
	 * Creates a Deck
	 * @param newCards an ArrayList of cards
	 */
	Deck(ArrayList<Card> newCards)
	{
		Cards = newCards;
	}
	
	/**Prints the contents of the deck to the console*/
	public void PrintDeck()
	{
        for (Card card : Cards)
		{
            if ((card.SpecialEffect.isEmpty()))
			{
                System.out.println(card.ColorValue + " " +
                        card.numberValue);
            }
			else
			{
                System.out.println(card.ColorValue + " " +
                        card.SpecialEffect);
            }
        }
	}
	
	/**Returns the deck as a string
	 * @param special does the function print the special cards
	 * @return this deck of cards*/
	public String PrintDeck(boolean special)
	{
		String ret = "";
		for(int i = 0; i < Cards.size(); i++)
		{
			if((Cards.get(i).SpecialEffect.isEmpty()))
			{
				ret = ret + Cards.get(i).ColorValue + " " + 
									Cards.get(i).numberValue + "\n";
			}
			else 
			{
				if(special)
				{
					ret = ret + Cards.get(i).ColorValue + " " + 
							Cards.get(i).SpecialEffect + "\n";
				}
			}
		}
		return ret;
	}
	
	/**Randomizes the order of the cards*/
	public void Shuffle()
	{
		Collections.shuffle(Cards);
		if(!Cards.get(0).SpecialEffect.isEmpty())
		{
			Cards.add(Cards.get(0));
			Cards.remove(0);
		}

	}
	
	
	
	/**
	 * Prints the variables on the object
	 * Deliminator = ,
	 */
	public String toString()
	{
        return Cards.toString();
	}
}
