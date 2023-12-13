public class StaticMethodsOverload 
{
	//static 	class owns all instance variables and methods that are static
	//StaticMethodsOverload  owns main(String[] args)
	//Shared by the other objects
	
	//overloading
	
	//signature
	//signature must be unique	printAll + String 
	public static void printAll(String Name)
	{
		System.out.println("Name: " + Name);
	}
	
	public static void main(String[] args)
	{
		String Name= "Gibson";
		printAll(Name);	//passed the mem address not the name
		//18	19	 11	 13	  19 ; temp deleted
		
		
		int myAge = 16;		//primative	gets sent rather that mem address
		printAll(16);		//printAll String reject
							//printAll int accept
		//23	24	53	55	24	 ; terminate
		
		byte myAgeB = (byte)18;					//Goes to the printAll short
		printAll(myAgeB);	//implied cast
							//printAll String reject
							//PrintAll int implied cast byte to int
		//28	29	57	59	29 ; terminate
		//byte > short > int 	backwards compatable
		//Long will not work	(compile error)
		//long MyAgeL 23;
		//printAll(MyAgeL);
		
		short myAgeS = (short) 17;
		printAll(myAgeS);
		//38	39	57	58	39 ; terminate
		printAll(myAgeS, Name);
		printAll(Name, myAgeS);
	}

//	Will not work	printAll + String  			< 			Illigal
//	public static void printAll(String Address)
//	{
//		System.out.println(Address);
//	}
	
	//Will work 	printAll + int 	
	//Overloading
	public static void printAll(int age)
	{
		System.out.println("int age: " + age);
	}
	public static void printAll(short age)
	{
		System.out.println("short age: " + age);
	}
	
	
	//1) exact match 
	//2) closest match	(byte goes to short)
	//3) 

	//printAll short String
	public static void printAll(short age, String Name)
	{
		System.out.println("short age: " + age + "\nString Name: " + Name);
	}
	
	//printAll String short
	public static void printAll(String Name, short age)
	{
		System.out.println("String Name: " + Name + "\nshort age: " + age);
	}
}	
	