import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MainGameLoop
{
	static Deck MainDeck;

	public static void main(String[] args) 
	{
		initGame();
	}
	
	
	public static void initGame()
	{
		MainDeck = new Deck(CreateCards());
		
		System.out.println("End");
	}
	
	
		
	
	
	
	/**Creates a ArrayList of cards and returns them
	 * @return An ArrayList of cards */
	public static ArrayList<Card> CreateCards()
	{
		try 
		{
			//Creates the Readers
			FileReader fileReader = new FileReader("C:/Users/CTEHolbenG46/Documents/Uno/NumberCards.txt");
			BufferedReader bfr = new BufferedReader(fileReader);
			try
			{
				//Splits the data from the save
				String Numb = bfr.readLine();
				String NewNumb[] = Numb.split(",");
				
				//Builds the arraylist
				ArrayList<Card> Cards = new ArrayList<Card>();
				for(int i = 0; i < NewNumb.length; i++)
				{
					Cards.add(new Card( Integer.parseInt(NewNumb[i]), "Red"));
				}
				for(int i = 0; i < NewNumb.length; i++)
				{
					Cards.add(new Card( Integer.parseInt(NewNumb[i]), "Blue"));
				}
				for(int i = 0; i < NewNumb.length; i++)
				{
					Cards.add(new Card( Integer.parseInt(NewNumb[i]), "Green"));
				}
				for(int i = 0; i < NewNumb.length; i++)
				{
					Cards.add(new Card( Integer.parseInt(NewNumb[i]), "Yellow"));
				}
				
				
				return Cards;

				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return null;
	
		
		
	}
}
