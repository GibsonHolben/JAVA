public class JavaMainDriver
{

	/* 
		1.  What method is the entry point for all programs?
			main in the entry method
		
		2. Each function/method must has its own unique ________________
			Method Signature
		
		3.  Name the three types of access modifiers and briefly describe them.
			1. Public - available to everyone
			2. Private - only the class in which it was created has access to it
			3. Protected - local classes can access but outside can't
		
		
		4.  String - Why is it capitalized - what is it?
			It is an Object
		
		5. String[] - what is it really in memory?
			It is stored in the heap
		
		7.  Why are the variable args  included in the main signature?
			1. Call the program and pass in info
				* Pass in different file names
				* Vins
				* Plant id
				* Dates
		
		8.  In eclipse, where do you enter your arguments?
			
			Run>RunConfiguration>Arguments
			
			if arguments are blank then String will be String[0]
			if we pass in one string then String will be String[1]   args[0] = word
			if we pass in two strings then String will be  String[2]     args[0] = first word & args[1] = second word
			
			If you want 2 words both at args[0] then use double quotation marks ex: "Gibson Holben" like to start and end string
			
			The error for when you ask for a item in an array that does not exist 
			1. your code will compile 
			2. you program will run until it reaches the error
			3. That error will be called a runtime error
			4. 	System.out.println("end");	will not run
			
			the error: 
					Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
					at JavaMainDriver.main(JavaMainDriver.java:58)
					
					
					
		9. If we put a second word on another line then...
			If we put 2 items on 2 different lines it works just fine and is args[1] 
			
		10. if we put an integer in the arguments what will happen...
			it will work just fine and print it as a String from args[0] 
			
			
		11. how do we send in arguments through command line...
			You put the arguments after the class file name like "java JavaMainDriver 123 abc"
					
		
		delimiter: a mark or symbol used to show the beginning
		or end of separate elements in a text, computer program, etc...
		This line of code uses the space as a delimiter.
		(String[] args) Is the parameters
		
	 */	
			
	//args is in the stack	
	//String is in the heap
	//Objects go in the heap
	// ; clears the temp	
	 
	public static void main(String[] args)
	{
		System.out.println("Not Gibson Holben");
		System.out.println(args[0]); // println(args[0]) is calling the function prntln and passing the in the arguments of args[0]
		//System.out.println(args[1]);
		System.out.println("end");		
	}

}
