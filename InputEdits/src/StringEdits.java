import java.util.Scanner;

/**
 * Testing editing Strings from the args and the console
 * @author Gibson Holben
 * @version 0.0.6
 */
public class StringEdits 
{
	/**
	 * Main Testing Method
	 * @param args the user passed in arguments
	 */
	public static void main(String[] args)
	{
		//Ways to get input
		//args
		//file
		//database
		//console/other
		
		//right or wrong data will be passed in
		//wrong - reject
		//right - accept
		//multiple errors > ping ponging
		
		//Common edits
		//1. null check... do on all obejcts
		//2. equals		- length 
		//				- format (Capital, @, .com, etc...)
		//				- valid options (size must be XS S M L XL XXL, State must be MI not ZZ)
		//3. spaces		- " ", "       " 
		//4. blank		- ""
		
		//No spaces allowed
		//1. " " error
		//2. "  " error
		//3. "   Gibson Holben" remove leaing spaces (good)
		//4. "	 Gibson Holben	" remove trailing spaces (good)
		
		
		
		//Corect way
		args[4] = args[4].trim();
		
		if(args[4].isEmpty())
		{
			System.out.println("args[4] length: " + args[4].length());
			System.out.println("args[4]: " + args[4] + "error");

		}
		else
		{
			System.out.println("args[4]: " + args[4].trim() + " (good)");
			System.out.println("args[4] length: " + args[4].length());
		}
		
	
		
		//Better way above ^^^^^
		
		//if(args[3].trim().isEmpty()): "	 Gibson Holben	" >>> "Gibson Holben" >>> if("Gibson Holben".isEmpty()) >>> if(false)
		if(args[3].trim().isEmpty())
		{
			System.out.println("args[3] length: " + args[3].length());
			System.out.println("args[3]: " + args[3] + "error");

		}
		else
		{
			System.out.println("args[3]: " + args[3].trim() + " good");
			System.out.println("args[3] length: " + args[3].length());
		}
		
		
		
		System.out.println("***********************************************************************");
		//	"" 			error
		//	" " 			good
		//	" a"			 good
		Scanner Input4 = new Scanner(System.in);
		System.out.println("Please enter test data: ");
		String Value = Input4.nextLine();
		Input4.close();
		
		
		if(Value.isEmpty())
		{
			System.out.println("Value length: " + Value.length());
			System.out.println("Value: " + Value + " Error: Length must be a value greater that 0");
		}
		else
		{
			System.out.println("Value: " + Value + " (good)");
			System.out.println("Value length: " + Value.length());
		}
		
		
		
		
		//System.out.println("***********************************************************************");
		
		
		
		
		
		System.out.println("***********************************************************************");
		if(args[0].isEmpty()) //length = 0 (wrong)
		{
			System.out.println("args[0]: " + args[0] + "Length must be a value greater that 0");
			System.out.println("args[0] length: " + args[0].length());
		}
		else
		{
			System.out.println("args[0]: " + args[0] + "good");
			System.out.println("args[0] length: " + args[0].length());
		}
		
		
		

		
		
		System.out.println("***********************************************************************");
		
		if(args[1].isEmpty()) //length = 1 (right)
		{
			System.out.println("args[1] length: " + args[1].length());
			System.out.println("args[1]: " + args[1] + "error");

		}
		else
		{
			System.out.println("args[1]: " + args[1] + "good");
			System.out.println("args[1] length: " + args[1].length());
		}
		
		
		
		
		
		
		System.out.println("***********************************************************************");
		
		if(args[2].isEmpty()) // "a " length = 2 (right)
		{
			System.out.println("args[2] length: " + args[2].length());
			System.out.println("args[2]: " + args[2] + "error");

		}
		else
		{
			System.out.println("args[2]: " + args[2] + " good");
			System.out.println("args[2] length: " + args[2].length());
		}
		
		System.out.println("Gibson");
	}

	
	
	
	//https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
	//https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
}
