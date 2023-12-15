import java.util.Scanner;

public class LoopControllDoWhile 
{

	
	public static int printAll(int  executeTimesStatic)

	{
		System.out.println("Keep going static function: " + executeTimesStatic);
		executeTimesStatic--;
		return executeTimesStatic;
	}

	public static void main(String[] args) 
	{
		//while execute how many times?		//0 to condition...		may not ever excute
		//		condition is checked first	- if true go again
		
		//do whiles execute how many times?		//once even it condition...		always execute once	- till condition is false
		//			executes that condition is checked	- if true go again
		
		//for loops turn into while statments
		
		

		
		Scanner Input2 = new Scanner(System.in);
		System.out.println("Would you like to execute Y/N ");
		String answer = Input2.nextLine();
		answer = answer.toUpperCase();
		
		while(answer.equals("Y"))
		{
			System.out.println("ok have fun");
			
			System.out.println("Would you like to continue Y/N ");
			answer = Input2.nextLine();
			answer = answer.toUpperCase();
		}
		
		
		int executeTimesStatic3 = 10;
		
		while(executeTimesStatic3 > 0 && executeTimesStatic3 < 10 )	//static
		{
			executeTimesStatic3 = printAll(executeTimesStatic3);
		}	
				
		System.out.println("****************************************************");
		
		
		int executeTimesStatic2 = 3;
		while(executeTimesStatic2 > 0)	//static
		{
			executeTimesStatic2 = printAll(executeTimesStatic2);
			
			if(executeTimesStatic2 > 2)
			{
				
			}
		}	
				
		System.out.println("****************************************************");
				
		
		
		//Required to be done x amount times
		int executeTimesStatic = 3;
		while(executeTimesStatic > 0)	//static
		{
			//Only execute if true
			System.out.println("Keep going static: " + executeTimesStatic);
			executeTimesStatic--;
		}
		
		System.out.println("****************************************************");
		
		
		Scanner Input = new Scanner(System.in);
		System.out.println("How many time would you like to execute: ");
		int executeTimes = Input.nextInt();
		
		//0
		//1
		//-1
		//3
		while(executeTimes > 0)	//dynamic
		{
			//Only execute if true
			System.out.println("Keep going: " + executeTimes);
			executeTimes--;
		}
		//false here..
	}

}
