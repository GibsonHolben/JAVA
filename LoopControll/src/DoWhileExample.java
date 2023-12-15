import java.util.Scanner;

public class DoWhileExample 
{

	public static void main(String[] args)
	{
		
		//Y	  S	  N
		//Y	  N
		//S	  N
		//N
		//B
		//y
		//y s n
		//y n
		
		Scanner Input2 = new Scanner(System.in);
		
		String answer2 = "";
		
		do
		{
			System.out.println("ok have fun");	
			System.out.println("Would you like to continue Y/N ");
			answer2 = Input2.nextLine();
			answer2 = answer2.toUpperCase();
			
		}while(answer2.equals("Y") || answer2.equals("S"));	
		
		
//		String answer = "";
		
		//Y	  N
		//N
//		
//		do
//		{
//			System.out.println("ok have fun");	
//			System.out.println("Would you like to continue (second Loop Y/N ");
//			answer = Input2.nextLine();
//			answer = answer.toUpperCase();
//			
//		}while(answer.equals("Y"));	//dont forgt terminator
//		
//		System.out.println("ok bye");
//		
//		
//		System.out.println("****************************************************");
//		
//		int executeTimesStatic = 0;
//		
//		do
//		{
//			System.out.println("Keep going do While: " + executeTimesStatic);
//			executeTimesStatic--;
//			
//		}while(executeTimesStatic > 0);
	

		
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
