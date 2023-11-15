//Documentation code

/**
 * <img src= "logo.png" alt = "logo"> 
 * 
 * <h1 style= "color: #FF7F50"> Today is a good day </h1>
 * 
 * <p>  This is a new line </p>
 * 
 * 
 * <p> test </p>
 * 
 *
 * 
 * @author Gibson Holben
 * @version 1.0 New Release
**/

public class JavaDocDriver
{
	/**
	 * <p>Full year age</p>
	 */
	public int age;
	
	/**
	 * <p>How much money is deposited in their bank account</p>
	 */
	public double money;
	
	/* TEST QUESTIONS
	 * 
	 * What areas need JAVA documentation comments
	 * 1. all class files
	 * 2. all functions / methods 
	 * 3. all instance variables
	 * 
	 * 
	 * What will happen if I have a param for a variable that is not in my signature
	 * a. does not change index.html
	 * (b). change index.html and displays an error
	 * 
	 * it will run and change but give you this error:
	 * 		H:\JAVA\1.4.2JavaDoc\src\JavaDocDriver.java:40: error: @param name not found
	 * 		@param totalPeople the amount of people
	 * 
	 * @param totalPeople the amount of people
	 */
	
	
	
	//Documentation code
	
	/**
	 * The main prints my name Gibson Holben
	 * 
	 * <p> (!) Hint Create the signature line first so it auto generates for you (!) </p>
	 * 
	 * @param args
	 * 	<p style="color: red">args[0] name1</p>
	 * 	<p style="color: red">args[1] name2</p>
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args)
	{
		System.out.println("Gibson Holben");	
	}
}