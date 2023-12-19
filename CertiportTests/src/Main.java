import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		String s = "Gibson Holben";
		String s2 = s.substring(7, 13);
		ArrayList<String> users = new ArrayList<String>();
		
		//nestd if statments
		print(s2);
		if(s.length() > 6)
		{
			if(s.equals("Gibson Holben"))
			{
				print("Good");
			}
		}
		
		//hex with String.format
		int x = 1886;
		print(String.format("%x", x)); 
		
		//array looping
		print("How many users are you adding?");
		Scanner scnr = new Scanner(System.in);
		int loopTime = scnr.nextInt();
		
		for(int i = 0; i < loopTime; i++)
		{
			if(i != 0)
				print("Please enter the name");
			String name = scnr.nextLine();
			users.add(name);
			
			print("");	
		}
		scnr.close();
		
		//array printing
		for(int i = 0; i < users.size(); i++)
		{
			String ss = users.get(i);
			print(ss);
		}
		
		
		
		
		//++X 	 and	X++
		int numA 	 = 5;
		int numC 	 = 2;
		int resaultA = 0;
		
		
		resaultA = ++numA + numC - numA++;		//2
			//		num10A + num10C - num10A++
			//		 6	   +   2	- num10A++
			//			   8	    -    6  ++
			//			       		2	
		print("ResaultA: " + Integer.toString(resaultA));
		
		print("stop");
		
	}
	public static void print(String p)
	{
		System.out.println(p);
	}
	
	
	
}
