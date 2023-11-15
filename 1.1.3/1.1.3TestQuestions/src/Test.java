
public class Test
{

	public static void main(String[] args)
	{
		//Question A
		//Integer num = Integer.parseInt(args[1]);
		//System.out.println("Number is:  " +  num);
//		If the following commands lines were entered, what could be the result?
//				javac Test.java
//				java Test 12345
//
//				a) Number is:  12345
//				b) Number is:  1
//				c) A NullPointer Exception is thrown at runtime
//				d) A NullPointer Exception is thrown at compile time
//				e) An ArrayIndexOutOfBoundsException is thrown at runtime
//				f) An ArrayIndexOutOfBoundsException is thrown at compile time
//				g) A NumberFormatException is thrown at runtime
//				h) A NumberFormatException is thrown at compile time 
//				i) Does not compile 
	//guess: E
	//answer: E		
		/* Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
		 * 		at Test.main(Test.java:8)
		 * Attempts to convert args[1] to an integer, but it is null.
		 * To fix, change [1] to [0]	 */
		
		//Question B
		
		//Integer num = Integer.parseInt(args[0]);
		//System.out.println("Number is:  " + num);
		
//			If the following commands lines were entered, what could be the result?
//				javac Test.java
//				java Test 12345
//
//				a) Number is:  12345
//				b) Number is:  1
//				c) A NullPointer Exception is thrown at runtime
//				d) A NullPointer Exception is thrown at compile time
//				e) An ArrayIndexOutOfBoundsException is thrown at runtime
//				f) An ArrayIndexOutOfBoundsException is thrown at compile time
//				g) A NumberFormatException is thrown at runtime
//				h) A NumberFormatException is thrown at compile time 
//				i) Does not compile 
//			Guess: A
//			Answer: A
//			When you run the command it converts args[0] to an integer called num
		//	then prints "Number is: " and num
		
		//Question C
		//Integer num = Integer.parseInt(args[0]);
		//System.out.println("Number is:  " + num);
		
//		If the following commands lines were entered, what could be the result?
//				javac Test.java
//				java Test  happy
//
//				a) Number is:  happy
//				b) A NullPointer Exception is thrown at runtime
//				c) A NullPointer Exception is thrown at compile time
//				d) An ArrayIndexOutOfBoundsException is thrown at runtime
//				e) An ArrayIndexOutOfBoundsException is thrown at compile time
//				f) A NumberFormatException is thrown at runtime
//				g) A NumberFormatException is thrown at compile time 
//				h) Does not compile
		//Guess: f
		//ans: f
	/*	Exception in thread "main" java.lang.NumberFormatException: For input string: "happy"
	 *		at java.lang.NumberFormatException.forInputString(Unknown Source)
	 *		at java.lang.Integer.parseInt(Unknown Source)
	 *		at java.lang.Integer.parseInt(Unknown Source)
	 *		at Test.main(Test.java:56)
	 *		
	 *		Because the argument is not a number, the file can't convert it to an integer, causing a crash
	 *		To fix, make sure the argument is a number	 */
		
		//Question D
//		System.out.println(1);
		 
//		a) 1
//		b) runtime error
//		c) compile error
	//guess: B
	//ans: A
		//Java automatically converts an integer to a string with println if it isn't already a string
	}

}
