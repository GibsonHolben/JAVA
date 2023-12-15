import java.util.Scanner;

public class DoWhileExample 
{

	public static void main(String[] args)
	{

		//YN	N
		//N
		
		Scanner Input2 = new Scanner(System.in);
		String answer = "";
		
		do
		{
			System.out.println("ok have fun");	
			System.out.println("Would you like to continue Y/N ");
			answer = Input2.nextLine();
			answer = answer.toUpperCase();
			
		}while(answer.equals("Y"));
		
		System.out.println("ok bye");
		
		
		System.out.println("****************************************************");
		
		int executeTimesStatic = 0;
		
		do
		{
			System.out.println("Keep going do While: " + executeTimesStatic);
			executeTimesStatic--;
			
		}while(executeTimesStatic > 0);
	

		
		System.out.println("****************************************************");
		int executeTimesStatic1 = 0;
		
		
		while(executeTimesStatic1 > 0)	
		{
			System.out.println("Keep going while: " + executeTimesStatic1);
			executeTimesStatic1--;
		}
		

		
		
//		while(executeTimesStatic1 > 0);	// < NO SEMICOLEN...hjmm	 Most common mistake... will run... logic error...
//		{
//			System.out.println("Keep going while: " + executeTimesStatic1);
//			executeTimesStatic1--;
//		}
	}

}
