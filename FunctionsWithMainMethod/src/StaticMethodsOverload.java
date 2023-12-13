public class StaticMethodsOverload 
{
	//static 	class owns all instance variables and methods that are static
	//StaticMethodsOverload  owns main(String[] args)
	//Shared by the other objects
	
	//overloading
	
	//signature
	public static void printAll(String Name)
	{
		System.out.println(Name);
	}
	
	public static void main(String[] args)
	{
		String Name= "Gibson";
		printAll(Name);	//passed the mem address not he name
		//16	17	 9	 11	  17   19 ; temp deleted
		System.out.println("stop");
	}
}
	