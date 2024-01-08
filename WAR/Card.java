
public class Card 
{
	public int number;
	public String Color;
	
	Card(int n, String c)
	{
		number = n;
		Color = c;
	}
	
	
	public String toString()
	{
		return Integer.toString(number) + " of " + Color;
	}
}
