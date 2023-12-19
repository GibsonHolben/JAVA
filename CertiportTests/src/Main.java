import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		String s = "Gibson Holben";
		
		String s2 = s.substring(7, 13);
		
		ArrayList<String> users = new ArrayList<String>();
		
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
		
		print("How many users are you adding?");
		Scanner scnr = new Scanner(System.in);
		int loopTime = scnr.nextInt();
		scnr.close();
		
		for(int i = 0; i < loopTime; i++)
		{
			print("Please enter the name");
			Scanner scnr2 = new Scanner(System.in);
			String name = scnr2.nextLine();
			users.add(name);
			scnr2.close();
		}
		
		for(int i = 0; i < users.size(); i++)
		{
			String ss = users.get(i);
			print(ss);
		}
		
		
		
	}
	public static void print(String p)
	{
		System.out.println(p);
	}
	
	
	
}
