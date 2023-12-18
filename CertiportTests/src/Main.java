
public class Main 
{
	public static void main(String[] args) 
	{
		String s = "Gibson Holben";
		
		String s2 = s.substring(7, 13);
		
		print(s2);	//output = Holben
		
		if(s.length() > 6)
		{
			if(s.equals("Gibson Holben"))
			{
				print("Good");
			}
		}
		
		int x = 1886;
		print(String.format("%x", x)); 
	}
	public static void print(String p)
	{
		System.out.println(p);
	}
	
}
