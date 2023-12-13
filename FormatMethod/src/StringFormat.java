public class StringFormat
{
	public static void main(String[] args) 
	{
		//why .format	system.out	--	reports		column		center
		//	  print	 or	 println	
		//println	-	caradge return		-		2 lines
		System.out.println("Gibson");	//6 charecters
		System.out.println("Kids");		//4 charecters
		System.out.println("***********************************************************");
		//all on the same line
		System.out.print("Gibson");	//6 charecters
		System.out.println("Kids");		//4 charecters
		
		System.out.println("***********************************************************");
		System.out.println("**Format 1 String, 2 format calls**");
		
		//%		escape charecter... seperates formatting
		//s		String
		//	%n to make a new line
		System.out.format("%s", "Gibson");	//6 charecters
		System.out.format("%s%n", "Kids");	//4 charecters
		
		System.out.println("***********************************************************");
		
		System.out.format("%s", "Gibson");	//6 charecters
		System.out.format("%s   %n", "Kids");	//4 charecters
		
		System.out.println("***********************************************************");
		
		//If you put charecters in the first argument then they will show up after the string
		System.out.format("%s", "Gibson");	//6 charecters
		System.out.format("%s$$$$$%n", "Kids");	//4 charecters
		
		System.out.println("***********************************************************");
		
		System.out.format("%s", "Gibson");	//6 charecters
		System.out.format("%s%n", "Kids");	//4 charecters
		

		System.out.println("***********************************************************");
		
		System.out.println("**Format 1 String, 1 format calls**");
		System.out.format("%s%s%n", "Gibson", "Kids");	
		

		System.out.println("***********************************************************");
		
		System.out.println("**Right allignment concerns**");
		//warning 	mac length of string + exra space
		//max 25 + 2 = 27
		System.out.format("%9s%s%n", "Gibson", "Kids");	
		System.out.format("%9s%s%n", "Gib", "Kids");	//right alignment
		System.out.format("%9s%s%n", "1234567890", "Kids");	
		

		System.out.println("***********************************************************");
		
		System.out.format("%12s%9s%n", "Gibson", "Kids");	
		System.out.format("%12s%9s%n", "Gib", "7890123");	//right alignment
		System.out.format("%12s%9s%n", "1234567890", "99999999");	
		

		System.out.println("***********************************************************");
				
		System.out.println("**Left allignment concerns**");
		//warning 	mac length of string + exra space
		//max 25 + 2 = 27
		System.out.format("%-12s%-9s%n", "Gibson", "Kids");	
		System.out.format("%-12s%-9s%n", "Gib", "7890123");	//right alignment
		System.out.format("%-12s%-9s%n", "1234567890", "99999999");	
		
		
		//sending a number in
		System.out.println("***********************************************************");
		
		System.out.format("%-12s%-9s%n", 11111, 222222);
		
		System.out.format("%-12s%-9s%n", 10.5f, 11.5f);	

		
		System.out.println("stop");
	}
}
