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
		//16	17	 9	 11	  17   19 ; temp deleted
		
		
		int myAge = 16;		//primative	gets sent rather that mem address
		printAll(16);		//printAll String reject
							//printAll int accept
		//23	24	48	50	24	27
		System.out.println("stop");
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
		System.out.println("age: " + age);
	}
}
	