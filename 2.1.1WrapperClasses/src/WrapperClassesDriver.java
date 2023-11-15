import java.math.BigDecimal;

public class WrapperClassesDriver
{
	public static void main(String[] args) 
	{	
		System.out.println("Start");
		
		//Wraper classes
		//All wraper classses are Objects and are stored in the heap
		//Some classes are mutable an some are immutable
		//Mutable: instance variables can change but the memory location stays the same
		//Immutable: cannot change... create a new one and destroy the old one to change it... maybe...
		
		
		//				  calling the constructer
		//							  build
		BigDecimal Am01 = new BigDecimal("12.11");
		BigDecimal Am02 = new BigDecimal("10");  //explicit creation of object
		
		//
		BigDecimal Am03 = new BigDecimal("12.11"); //27
		//do I have 2 objects or one
		BigDecimal Am07 = new BigDecimal("12");  //Both have the same memory adress (28)
		BigDecimal Am08 = Am07;  //Both have the same memory adress (28)
		
		//are they the same memory adress
		BigDecimal Am09 = new BigDecimal("11");  //ma (29)
		BigDecimal Am10 = new BigDecimal("11");  //ma (30)
		
		
		
		BigDecimal Am11a = new BigDecimal("11");
		BigDecimal Am11 = new BigDecimal("12");  //ma 31
		BigDecimal Am12 = Am11;  //ma 32			Only one object exists but three variables exist
		Am11 = Am11.add(Am09);  //Only one memory adress changes		3 objects
		
		
		
		
		
		
		
		//Wapper class is an object tied to a primitive data type
		//Primitive		Wrapper class
		//--------------------------
		//byte			Byte	
		//int			Integer
		//float			Float
		
		
		int num01 = 10;						//no object... 10 is stored as a primitive datatype
		Integer Num01 = new Integer(10);	//creates one object... Explicit... 
	
		Integer Num02 = 20;  				//creates an object... Implied...
		
		Integer Num03 = 20;
		Integer Num04 = 20;    //Num02, Num03, and Num04 all share the same memory adress
		
		
		
		//what will this output?
		//1) compile error
		//2) Values match
		//3) Values don't match  *Correct
		
		Integer Num05 =  new Integer(20); //37
		Integer Num06 =  new Integer(20); //38
		//if(27 == 38)		this is a logic error
		if(Num05 == Num06) 
		{
			System.out.println("(1st) Values match");
		}
		else
		{
			System.out.println("(1st) Values don't match");
		}
		
		
		//outputs right
		Integer Num07 = 20;
		Integer Num08 = 20;
		if(Num07 == Num08) 
		{
			System.out.println("(2nd)Values match");
		}
		else
		{
			System.out.println("(2nd)Values don't match");
		}
		
		//fixes the logic error
		Integer Num09 =  new Integer(20);
		Integer Num10 =  new Integer(20);
		if(Num09.intValue() == Num10.intValue()) 
		{
			System.out.println("(3rd) Values match");
		}
		else
		{
			System.out.println("(3rd) Values don't match");
		}
		
		
		
		//Yet another test
		
		Integer Num11 =  new Integer(20);
		Long Num12 = (long) 20;
		//	if(Num11.intValue() == Num12.longValue()) is one option
		//
		if(Num11.intValue() == Num12.longValue())
		{
			System.out.println("(4th) Values match");
		}
		else
		{
			System.out.println("(4th) Values don't match");
		}
		
		
		
		int numInt = Num11;
		Integer NumInt = new Integer(numInt);
		
		long numLong = Num11;
		
		
		System.out.println("Gibson Holben");
		System.out.println("Stop");
	}
	
//	1. What are the eight wrapper classes.  
	
	//Boolean, Byte, Short, Character, Integer, Long, Float, Double
	
//	2.  Converting a wrapper class value to a String. 
	
	//.ToString();
	
//	3. Determining digit length of a Wrapper class value 
	
	//I could not find anything on this question
	
//	4.  Converting from a primitive to a Wrapper and back again.
	
	// make a wraper an int: int numInt = Num11; Make an int a wraper Integer NumInt = new Integer(numInt);
	
//	5.  What is autoboxing and unboxing
	
	//autoboxing is when you go from a primitive to a Objet EX: Integer Num07 = 20; and Unboxing is the reverse EX: int num20 = 20
	
//	6.  Will a Integer wrapper unbox automatically  to a primitive integer?
	
	// yes
	
//	7   Will a Integer wrapper unbox automatically  to a primitive long?
	
	//yes but you might lose data
	
	
	
}
