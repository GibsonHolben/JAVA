import java.math.BigDecimal;

public class JavaPrimativeDataTypesDriver 
{		
		
	public static void main(String[] args) 
	{	
		System.out.println("Start");
		
				
		//The three parts of memory are: 		Stack		Heap		Temp
		//		  
		//Primitive data types are  store in:     X
		//		  
		//Primitive data types can be stored in the heap if they are tied to a class
		 
		
		
		//How to delare - declaring that you need space in memory of a certan size
		//				  declaring that I want you call that space this name...
		//int age;
		// =	assignment operator		assign a value.
		
		
		//boolean		Reserved word that tells the compiller I want 1 bit of memory
		//					0	false
		//					1	true
		// don't use False or True. Use false or true instead
		//Could be used as for a while(true) or while(false)
		//naming: graduated 	=	isGraduated
		
		boolean isGraduated = true;
		System.out.println(isGraduated);
		
		
		isGraduated = false;
		System.out.println(isGraduated);
		
		//Test Question: 
		//	boolean isGraduated = True;		 Compiller error: Unresolved compilation problem: True cannot be resolved to a variable
		//	System.out.println(isGraduated);
		
		
		
		//Number primitive datatypes		Base 2 complement
		//byte	8 bits	range	0000 0000 = 0
		//						1111 1111 = -1
		//						1000 0000 = -128		lowest
		//						0111 1111 = 127			highest
		// Range -128 - 127
		//low number items such as age
		byte age = 16;		//00010000
		//	128	64	32	16	8	4	2	1
		//	 0	 0	 0	 1	0	0	0	0 = 16
		System.out.println("age is " + age);
		age = -16;		
		System.out.println("age is " + age); //age is byte but println takes in an int so it uses auto casting...
								 //										   			  implicit casting
		
		//Test Question
		//byte age3 = 127;
		//age3 = age3  + 1; //Type mismatch: cannot convert from int to byte
		//0
		//-128
		//age2 to integer
		//Error
		
		byte money = 127;
		money = (byte) (money  + 1); 
		System.out.println("money is " + money);     //128
		
		byte money2 = 126;
		money2 = (byte) (money2  + 1); 
		System.out.println("money2 is " + money2);   //127
		
		byte money3 = -128;
		money3 = (byte) (money3  + -1);		//explicit cast... stating as a fact waht you want to take place
		System.out.println("money3 is " + money3);	//127
		
		
		//Work around to stop roll over? if you know you data and you suspect 
		//You reach the edges of a datatype what should you do
		//1. Move to  larger data type
		//2. Math - before you do and calculations... if else and warn
		
		//Whole numbers only				Decimal numbers
		//Integer numbers					floating decimal point
		//--------------------------------------------------------
		//byte		8 bits					
		//short		16 bits				
		//int		32 bits					float		low precision .00000
		//long		64 bits					double		high precision .000000000000
		
		byte am01 = 100;
		short am02 = am01;   	 //implied cast
		//	  AM01 = Am02;       //Compialer error   	
		am01 = (byte) am02; 	 //explicit cast

		float am03 = am01;
		//byte to a short is implied
		//short to a byte is explicit
		
		//byte>short>int>long>float>double... Implied
		//double>float>long>int>short>byte... Explicit
		
		//float>int float>short float>long float>byte... Explicit		even though they are the same value
		//float>double...  Implied
		
		
		
		
		byte am04 = 121;	//121 literal
		String amS01 = "Happy";  //literal String
		
		//what is the default datatype for ant Intager number literal?
		//1) byte
		//2) short
		//3) int (Corect)
		//4) double
		
		int am05 = 121;		//literal whole numbers are by default an int
		long am06 = 121;
		//long am07 = 2147483648; //The literal 2147483648 of type int is out of range
		long am07 = 2147483648L;	//use an upercase or lowercase L to cast to a long
		
		
		//10.2 default float or double? it is a double
		//float am07 = 10.2;
		float am08 = 10.2f;
		
		
		//precision errors
		float precision1 = 10.3f;
		float precision2 = 10.3f;
		float precision3 = precision1 + precision2;
		System.out.println("Presision 3 is " + precision3);
		
		float precision4 = 1.32588888888888f;
		float precision5 = 1.12322222222222f;
		float precision6 = precision4 + precision5;
		System.out.println("Presision 6 is " + precision6); //logic error = runs but does not produce the corect resaults
		
		
		//soulution for precision errors
		BigDecimal Precision7  = new BigDecimal(1.32588888888888);
		System.out.println("Presision 7 (first) is " + Precision7);
		BigDecimal Precision8  = new BigDecimal(1.12322222222222);
		BigDecimal Precision9  = Precision7.add(Precision8);
		//did precision 7 change?
		System.out.println("Presision 7 (second) is " + Precision7);
		System.out.println("Presision 9 is " + Precision9);
		
		
		
		
		System.out.println("Gibson Holben");
	}	
		
	//	1.  What is the range for a boolean? true to false
	
	//	2.  What is the range for a byte? -128 to 127
	
	//	3.  What is the range for a char?  0 to 65,535
	
	//	4.  What is the range  for a short?  -32,768 to 32,767
	
	//	5.  What is the range  for a int?    -2147483648 to 2147483647
	
	//	6.  What is the range for a float?	-3.40282347E+38 to -1.17549435E-38
	
	//	7.  What is the range for a double?   1.7E +/- 308
	
	//	8.  What is the range for a long?  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	
	//	9.  Why is it important that use the right privative data type when declaring a variable? 	So that you are as efficient as posible with memory
	
	//	10.  Provide an example on how to declare space in memory that will hold a decimal point.	float amTest;
	
	//	11. Provide an example of how you initialize the value in memory.	amTest = 1.5f;
	
	//	12. The term widening is used to describe ______________________________________?   to change to a larger datatype
	
	//	13.  The term narrowing is used to describe _____________________________________?  to change to a smaller datatype
	
	//	14.  Describe what happens when you add 1 to a datatype that has reached the top of its range. It will roll over to negative
	
	//	14.  Describe what happens when you add -1 to a datatype that has reached the bottom of its range. It will roll over to positive
	
	//	15.  What is the difference between explicit and implicit data conversion?	implicit is automatic and explicit you must specift
	
	//	16.  What area of memory are primitive data types stored?  They are stored in the stack
		
		
}		