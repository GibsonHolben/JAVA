public class CounsumingClassFunctions 
{
	
	//coumsume part
	public void addNumbers(int numb1, int numb2)
	{
		
		System.out.println(numb1 + numb2);
	}
	
	public static void printAll(String presant)
	{
		System.out.println("I want a " + presant);
	}
	
	public static void main(String[] args) 
	{
		//statc main 	owner:  CounsumingClassFunctions 
		//static printAll owner: CounsumingClassFunctions
		
		printAll("RTX 4090");
		//addNumber(1, 3); //Will not work
		
		//void addNumbers(int numb1, int numb2) 	object ultiple copies
		
		CounsumingClassFunctions obj1 = new CounsumingClassFunctions();
		CounsumingClassFunctions obj2 = new CounsumingClassFunctions();
		//Add number obj1 		2 total add number
		//Add number obj2
		obj1.addNumbers(1, 2);
		obj2.addNumbers(3, 4);
		
		obj2.printAll("Legos");

	}

}
