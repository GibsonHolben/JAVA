public class JavaDocumentDriver 
{
	
/*
	1.  What are the two categories of comments?
		Documentation Comments (Access to the code but you cannot see the code behind it)
		
 		Implementation Comments (Provide details to the programmer about what the code is designed to do) and are important for maintenance purposes 
 		
	
	2.   What are the two types of Implementation comments?
		 Single line (AKA end of line comment) and multi line (Or block comments) 
	
	
	3.  What character identifies the start of a implementation comment? 
		/ The forward slash is the escape character used for commenting (not the backward slash \ )
		
	
	4. When should you add comments?  What is industry standards? See below...
		
	
	5.  Provide an example of a single line comment.
		on line 33 and line 35 and they start with a //
		
	
	6.  Provide an example of a multi line comment:
		Starts on line 37 and ends on line 39
	
*/
	
	public static void main(String[] args)
	{
		//single line comment 
		
		System.out.println("Gibson Holben");  //end of line comment 
		
		/*
		 * This is an example of a block comment aka a multi line comment
		 */
		
		
		//Test questions Advanced Java
		
		//Will this work?
		//test case 1: comment after the dot operator 
		//A) Compile Error
		//b) Run       Answer...
		System./*Hello*/out.println("Test Case 1");
		
		
		//Will this work?
		//test case 2: comment inside of the class name
		//A) Compile Error    Syntax Error...
		//b) Run
		//System.o/*Hello*/ut.println("Test Case 2"); // (. is a dot operator)
		

		//Will this work?
		//test case 3: comment before the dot operator 
		//A) Compile Error    
		//b) Run            Answer...
		System/*Hello*/.out.println("Test Case 3");
		
		
		//Will this work?
		//test case 4: comment inside the arguments of the function call
		//A) Compile Error    
		//b) Run                Answer...
		System.out.println(/*Hello*/"Test Case 4");
		
		
		/*
		 * 4. When should you add comments?  What is industry standards?
		 * When you make a function you must add documentation comments at the beginning of the function
		 * and inside the function you should add implementation comments to explain the purpose of the code
		 * 
		 * All class files must have comments: Documentation comments
		 * All instance instance variables (Capitalized variables are constant)
		 */
		
	}
}
