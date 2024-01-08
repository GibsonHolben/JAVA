import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	/**console colors*/
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	/**Variables*/
	public ArrayList<Card> Cards = new ArrayList<Card>();
	
	public void Shuffle()
	{
		Collections.shuffle(Cards);
	}
	
	
	public void printCards()
	{
		for(int i = 0; i < Cards.size(); i++)
		{
			System.out.println(CYAN+Cards.get(i).Color + " " + Cards.get(i).number+RESET);
		}
	}
}
