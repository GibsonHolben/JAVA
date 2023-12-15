import java.util.Calendar;

public class CalanderFormat
{
	public static void main(String[] args) 
	{
		
		Calendar Today = Calendar.getInstance();
		System.out.println(Today);
		
		System.out.println("*******************************************************************");
		
		//Month
		System.out.format("%tB %n", Today);	//December	//tB
		System.out.format("%tb %n", Today);	//Dec	//tb
		System.out.format("%tD %n", Today);	//tD	//Day/Month/Year
		System.out.format("%tm %n", Today);	//12	//tm
		
		System.out.println("*******************************************************************");
		
		//Day
		System.out.format("%td %n", Today);	//15 // td has leading zeroes as needed, te does not.	//td
		System.out.format("%te %n", Today);	//15 // td has leading zeroes as needed, te does not.	//te
		
		System.out.println("*******************************************************************");
		
		//Year
		System.out.format("%ty %n", Today);	//23	2 digit year	//ty
		System.out.format("%tY %n", Today);	//2023	4 diget year	//tY
				
		System.out.println("*******************************************************************");
		
		//Time
		System.out.format("%tl %n", Today);		//tl	//Hour
		System.out.format("%tM %n", Today);		//tM	//Munute
		System.out.format("%tS %n", Today);		//tS	//seconds
		System.out.format("%tp %n", Today);		//tp	//am/pm
						
		System.out.println("*******************************************************************");

		System.out.format("%tj %n", Today);	//tj	number of days scince the start of the year
				
		System.out.println("*******************************************************************");
		
		//Combo
		System.out.format("%tl:%tM.%tS%tp %n", Today, Today, Today, Today);
		System.out.format("%tp  %tD  %s  %n", Today, Today, Today);

								
		System.out.println("*******************************************************************");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
//		int num1 = 10;
//		int num2 = 4;
//		
//		int sum = ++num1  - num2++ % 1 - ++num1 * num2;
//		
//		
//		int sum2 = 10/3;  		 //int  int  = int             3 
//		float sum3 = 10.0f/3;     //int float   float....3.333		
	}
	

}
