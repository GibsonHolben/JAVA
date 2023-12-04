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
		//https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
		//https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
		//2. equals		valid options....

		
		
		
		//****************************************************************************
		// THE BEST THERE IS
		//****************************************************************************
		//Size
		//Valid: 	S	M	L	XL	XS	XXL			Valid
		//			s	m	l	xl	xs	xxl			Valid but you will have to change it in code (Use toUpper);
		//						xL	Xs	XxL			Valid but use toUpper			
		//						" XL"				Valid (Remove leading and trailing spaces)
		//
		//Invalid:  
		//								LXX			Fail	Not Valid Selection Please Try Again
		//						"X L"				Fail	Not Valid Selection Please Try Again
		//			""								Fail 	empty	(Please enter a selection)	just press enter
		//			B								Fail 	Not Valid Selection Please Try Again
		//			" " 							Fail 	empty	(Please enter a selection)	hit space once to test
		
		//Rules	- no if structures greater that 3 deep

		
		Scanner Input8 = new Scanner(System.in);
		System.out.println("Please enter test data");
		String  Size4 = Input8.nextLine();
		Size4 = Size4.trim().toUpperCase();
		
		if(Size4.isEmpty())
		{
			System.out.println("Please enter a selection. " + Size4);
		}
		else
		{
			//breaks is switch statments
			switch(Size4)
			{
				case "S": 	
				case "XS": 
				case "M": 	
				case "L": 	
				case "XL": 	
				case "XXL": System.out.println("Good. Size: " + Size4);
							break;
				default: 	System.out.println("Not Valid Selection Please Try Again. " + Size4);
							break;
			}
		}		
		
		//***************************************************************************************************
		
		
		
		//****************************************************************************
		// Better but there are even better
		//****************************************************************************
		//Size
		//Valid: 	S	M	L	XL	XS	XXL			Valid
		//			s	m	l	xl	xs	xxl			Valid but you will have to change it in code (Use toUpper);
		//						xL	Xs	XxL			Valid but use toUpper			
		//						" XL"				Valid (Remove leading and trailing spaces)
		//
		//Invalid:  
		//								LXX			Fail	Not Valid Selection Please Try Again
		//						"X L"				Fail	Not Valid Selection Please Try Again
		//			""								Fail 	empty	(Please enter a selection)	just press enter
		//			B								Fail 	Not Valid Selection Please Try Again
		//			" " 							Fail 	empty	(Please enter a selection)	hit space once to test
		
		//Rules	- no if structures greater that 3 deep

		
//		Scanner Input7 = new Scanner(System.in);
//		System.out.println("Please enter test data");
//		String  Size3 = Input7.nextLine();
//		Size3 = Size3.trim().toUpperCase();
//		
//		if(Size3.isEmpty())
//		{
//			System.out.println("Please enter a selection. " + Size3);
//		}
//		else
//		{
//			//breaks is switch statments
//			switch(Size3)
//			{
//				case "S": 	System.out.println("Good");
//							break;
//				case "XS": 	System.out.println("Good");
//							break;
//				case "M": 	System.out.println("Good");
//							break;
//				case "L": 	System.out.println("Good");
//							break;
//				case "XL": 	System.out.println("Good");
//							break;
//				case "XXL": System.out.println("Good");
//							break;
//				default: 	System.out.println("Not Valid Selection Please Try Again. " + Size3);
//							break;
//			}
//		}
		
		
		
		
		
//***************************************************************************************************
		
		//****************************************************************************
		// Better but can be the best
		//****************************************************************************
		//Size
		//Valid: 	S	M	L	XL	XS	XXL			Valid
		//			s	m	l	xl	xs	xxl			Valid but you will have to change it in code (Use toUpper);
		//						xL	Xs	XxL			Valid but use toUpper			
		//						" XL"				Valid (Remove leading and trailing spaces)
		//
		//Invalid:  
		//								LXX			Fail	Not Valid Selection Please Try Again
		//						"X L"				Fail	Not Valid Selection Please Try Again
		//			""								Fail 	empty	(Please enter a selection)	just press enter
		//			B								Fail 	Not Valid Selection Please Try Again
		//			" " 							Fail 	empty	(Please enter a selection)	hit space once to test
		
		//Rules	- no if structures greater that 3 deep

		
//		Scanner Input6 = new Scanner(System.in);
//		System.out.println("Please enter test data");
//		String  Size2 = Input6.nextLine();
//		Size2 = Size2.trim().toUpperCase();
//		
//		
//		//| or & is a logical opirator
//		//|| or && is a logical opirator (short circit) < Use this... stops the if statemnt after one is true or false
//		
//		//(!) WARNING (!) Never use == with a String
//		if(Size2.isEmpty())
//		{
//			System.out.println("Please enter a selection. " + Size2);
//		}
//		else if(Size2.equals("S")   || 
//				Size2.equals("XS")  || 
//				Size2.equals("M")   || 
//				Size2.equals("L")   || 
//				Size2.equals("XL")  || 
//				Size2.equals("XXL"))
//		{
//			System.out.println("Good. Size2: " + Size2);
//		}
//		else 
//		{
//			System.out.println("Not Valid Selection Please Try Again. " + Size2);
//		}
		
//***************************************************************************************************
		
		
		
		//****************************************************************************

		
		//****************************************************************************
		//Good but can be better
		//****************************************************************************
		//Size
		//Valid: 	S	M	L	XL	XS	XXL			Valid
		//			s	m	l	xl	xs	xxl			Valid but you will have to change it in code (Use toUpper);
		//						xL	Xs	XxL			Valid but use toUpper			
		//						" XL"				Valid (Remove leading and trailing spaces)
		
		//Invalid:  
		//								LXX			Fail	Not Valid Selection Please Try Again
		//						"X L"				Fail	Not Valid Selection Please Try Again
		//			""								Fail 	empty	(Please enter a selection)	just press enter
		//			B								Fail 	Not Valid Selection Please Try Again
		//			" " 							Fail 	empty	(Please enter a selection)	hit space once to test
		
		//Rules	- no if structures greater that 3 deep

		
//		Scanner Input5 = new Scanner(System.in);
//		System.out.println("Please enter test data");
//		String  Size = Input5.nextLine();
//		//String  Size = Input5.nextLine().trim().toUpperCase();	<	Option works
//		
//		//Data Changes....
//		//Size = Size.toUpperCase();	//2 steps...		good...
//		//Size = Size.trim();			//2 steps...		good...
//		
//		//Combine.....	save steps.....	limit is 3.....	
//		//Size = Size.toUpperCase().trim();	//3 steps...	better...	20 loops
//		//three steps
//		//1.	Size.trim();		"		x		"
//		//2.	"x".toUpperCase();	"X"
//		//3.	Size = "X";
//		Size = Size.trim().toUpperCase();	//3 steps...	best...		11 loops
//		
//		
//		
//		//(!) WARNING (!) Never use == with a String
//		if(Size.isEmpty())
//		{
//			System.out.println("Please enter a selection. " + Size);
//		}
//		else if(Size.equals("S"))
//		{
//			System.out.println("Good. Size: " + Size);
//		}
//		else if(Size.equals("XS"))
//		{
//			System.out.println("Good. Size: " + Size);
//		}
//		else if(Size.equals("M"))
//		{
//			System.out.println("Good. Size: " + Size);
//		}
//		else if(Size.equals("L"))
//		{
//			System.out.println("Good. Size: " + Size);
//		}
//		else if(Size.equals("XL"))
//		{
//			System.out.println("Good. Size: " + Size);
//		}
//
//		else if(Size.equals("XXL"))
//		{
//			System.out.println("Good. Size: " + Size);
//		}
//		else 
//		{
//			System.out.println("Not Valid Selection Please Try Again. " + Size);
//		}
//		//****************************************************************************
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//#2 .equals() 	vs 	==
//		
//		System.out.println("***********************************************************************");
//		//Corect way to do it (checks the length and if that is good then it loops through the arrays of chars to compare them)
//		String Value13S = new String("Mastermind");		//explicit. Creates a new object. memory = 18
//		String Value14S = Value13S;						//just the memory address gets moved
//		Value13S 		= "Mastermind";					//Literal/Implied
//		
//		System.out.println("Value11S: " + Value13S);
//		System.out.println("Value12S: " + Value14S);
//			  
//		//Guess: true 80%
//		if(Value13S.equals(Value14S))
//		{
//			System.out.println("(Using .Equals) equal ya");
//		
//		}
//		else
//		{
//			System.out.println("(Using .Equals) not Equal ");
//		}
//		
//		
//		//ANYTIME YOU SEE A == WITH ANY OBJECT BE CONCERNED
//		//NEVER USE IT WITH A STRING...
//		//These only compare the mem addresses. Not the values themselves. See above for the right way ^^^^^^
//		System.out.println("***********************************************************************");
//		
//		String Value11S = new String("Mastermind");		//explicit. Creates a new object. memory = 18
//		String Value12S = Value11S;						//just the memory address gets moved
//		Value12S 		= "Mastermind";					//Literal/Implied
//		
//		System.out.println("Value11S: " + Value11S);
//		System.out.println("Value12S: " + Value12S);
//			  
//		
//		//Guess: true, 55%
//		if(Value11S == Value12S)
//		{
//			System.out.println("equal ya");
//		
//		}
//		else
//		{
//			System.out.println("not Equal ");
//		}
//		
//		
//		
//		
//		System.out.println("***********************************************************************\n");
//		
//		System.out.println("***********************************************************************");
//		
//		String Value9S = new String("Mastermind");
//		String Value10S = Value9S;
//		
//		System.out.println("Value9S: " + Value9S);		//explicit
//		System.out.println("Value10S: " + Value10S);	//moved the memory address
//			  
//		
//		//Guess: true, 90%
//		if(Value9S == Value10S)		//Compares memory addresses not values
//		{
//			System.out.println("equal ya");
//		
//		}
//		else
//		{
//			System.out.println("not Equal ");
//		}
//		
//		
//		
//		
//		System.out.println("***********************************************************************\n");
//		
//		String Value7S = new String("Mastermind"); //mem: 25 explicit
//		String Value8S = new String("Mastermind"); //mem: 26 explicit
//		 
//		//Guess: false, 80%
//		if(Value7S == Value8S)
//		{
//			System.out.println("Value7S: " + Value7S + "\n" + 
//							    " Value8S: " + Value8S + "\nequal ya");
//		}
//		else
//		{
//			System.out.println("Value7S: " + Value7S + "\n" + 
//								" Value8S: " + Value8S+ "\nnot Equal ");
//		}
//		
//		
//		
//		
//		
//		System.out.println("***********************************************************************");
//		
//		String Value5S = "Mastermind";
//		String Value6S = new String("Mastermind");
//		
//		
//		//Guess: false, 90%
//		if(Value5S == Value6S)
//		{
//			System.out.println("Value5S: " + Value5S + "\n" + 
//							    " Value6S: " + Value6S + "\nequal ya");
//		}
//		else
//		{
//			System.out.println("Value5S: " + Value5S + "\n" + 
//								" Value6S: " + Value6S+ "\nnot Equal ");
//		}
//		
//		System.out.println("***********************************************************************\n");
//		
//		String Value3S = "Mastermind";
//		String Value4S = Value3S;
//		
//		//Guess: true, 100%
//		if(Value3S == Value4S)
//		{
//			System.out.println("Value3S: " + Value3S + "\n" + 
//							    " Value4S: " + Value4S + "\nequal ya");
//		}
//		else
//		{
//			System.out.println("Value3S: " + Value3S + "\n" + 
//								" Value4S: " + Value4S+ "\nnot Equal ");
//		}
//		
//		System.out.println("***********************************************************************");
//		
//		String Value1S = "Mastermind";
//		String Value2S = "Mastermind2";
//		
//		//Guess: false, 100%
//		if(Value1S == Value2S)
//		{
//			System.out.println("Value1S: " + Value1S + "\n" + 
//							    " Value2S: " + Value2S + "\nEqual Ya");
//		}
//		else
//		{
//			System.out.println("Value1S: " + Value1S + "\n" + 
//								" Value2S: " + Value2S+ "\nnot Equal ");
//		}
//		
//
//		System.out.println("***********************************************************************\n");
//		
//		
//		
//		
//		//No spaces allowed
//		//1. " " error
//		//2. "  " error
//		
//		//3. "   Gibson Holben" remove leaing spaces (good)
//		//4. "	 Gibson Holben	" remove trailing spaces (good)
//		
//		
//		//#3 spaces
//		
//		//Corect way
//		args[4] = args[4].trim();
//		
//		if(args[4].isEmpty())
//		{
//			System.out.println("args[4] length: " + args[4].length());
//			System.out.println("args[4]: " + args[4] + "error");
//
//		}
//		else
//		{
//			System.out.println("args[4]: " + args[4].trim() + " (good)");
//			System.out.println("args[4] length: " + args[4].length());
//		}
//		
//	
//		System.out.println("***********************************************************************\n");
//		//Better way above ^^^^^
//		
//		//if(args[3].trim().isEmpty()): "	 Gibson Holben	" >>> 
//		//>>> "Gibson Holben" >>> if("Gibson Holben".isEmpty()) >>> if(false)
//		if(args[3].trim().isEmpty())
//		{
//			System.out.println("args[3] length: " + args[3].length());
//			System.out.println("args[3]: " + args[3] + "error");
//
//		}
//		else
//		{
//			System.out.println("args[3]: " + args[3].trim() + " good");
//			System.out.println("args[3] length: " + args[3].length());
//		}
//		
//		
//
//		
//		
//		
//		
//		
//		//#4 Blank
//		
//		System.out.println("***********************************************************************\n");
//		//	"" 			error
//		//	" " 			good
//		//	" a"			 good
//		Scanner Input4 = new Scanner(System.in);
//		System.out.println("Please enter test data: ");
//		String Value = Input4.nextLine();
//		Input4.close();
//		
//		System.out.println("***********************************************************************");
//		if(Value.isEmpty())
//		{
//			System.out.println("Value length: " + Value.length());
//			System.out.println("Value: " + Value + " Error: Length must be a value greater that 0");
//		}
//		else
//		{
//			System.out.println("Value: " + Value + " (good)");
//			System.out.println("Value length: " + Value.length());
//		}
//		
//		
//		
//		
//		
//		System.out.println("***********************************************************************");
//		if(args[0].isEmpty()) //length = 0 (wrong)
//		{
//			System.out.println("args[0]: " + args[0] + "Length must be a value greater that 0");
//			System.out.println("args[0] length: " + args[0].length());
//		}
//		else
//		{
//			System.out.println("args[0]: " + args[0] + "good");
//			System.out.println("args[0] length: " + args[0].length());
//		}
//		
//		
//	
//		
//		System.out.println("***********************************************************************");
//		
//		if(args[1].isEmpty()) //length = 1 (right)
//		{
//			System.out.println("args[1] length: " + args[1].length());
//			System.out.println("args[1]: " + args[1] + "error");
//
//		}
//		else
//		{
//			System.out.println("args[1]: " + args[1] + "good");
//			System.out.println("args[1] length: " + args[1].length());
//		}
//		
//		
//
//		System.out.println("***********************************************************************");
//		
//		if(args[2].isEmpty()) // "a " length = 2 (right)
//		{
//			System.out.println("args[2] length: " + args[2].length());
//			System.out.println("args[2]: " + args[2] + "error");
//
//		}
//		else
//		{
//			System.out.println("args[2]: " + args[2] + " good");
//			System.out.println("args[2] length: " + args[2].length());
//		}
//		
//		System.out.println("***********************************************************************");
//		System.out.println("Gibson");
	}

	
	
	

}
