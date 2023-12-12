import java.util.IllegalFormatConversionException;

public class IntegerFormat 
{
	public static void main(String[] args) 
	{
		/*
		 * whole number	//ex: 1, 2, and 3 	//can be negative
		 *	byte	//short	//int	//long
		 *	Wrapper classes work to
		 *	Byte	//Short	//Integer	//Long
		 *
		 *	numbers line up
		 *	% escape charcter
		 *	d stands for digit
		 *	+ will show the negative and positive symbeles
		 *
		 **************************************************************
		 *	The number that you use must be >= the length of the 
		 *	greatest + 2 + spaces + commas + sign
		 */
		
		
		
		long positiveNumber = 147091L;
		long negativeNumber = -7857L;
		System.out.println("Gibson Holben");
		System.out.println("******************************************************");
		System.out.println("Println");
		System.out.println(positiveNumber);
		System.out.println(negativeNumber);
		
		System.out.println("******************************************************");
		System.out.println("Format (%d %n)");
		System.out.format("%d %n", positiveNumber);
		System.out.format("%d %n", negativeNumber);
		
		System.out.println("******************************************************");
		System.out.println("Format (%7d %n)");
		System.out.format("%7d %n", positiveNumber);
		System.out.format("%7d %n", negativeNumber);
		
		System.out.println("******************************************************");
		System.out.println("padding 0s");
		System.out.format("%07d %n", positiveNumber);
		System.out.format("%07d %n", negativeNumber);
		
		System.out.println("******************************************************");
		System.out.println("showing symbles");
		System.out.format("%+07d %n", positiveNumber);
		System.out.format("%+07d %n", negativeNumber);

		
		System.out.println("******************************************************");
		System.out.println("commas");
		System.out.format("%+,10d %n", positiveNumber);
		System.out.format("%+,10d %n", negativeNumber);
		
		System.out.println("******************************************************");
		System.out.println("One line");
		System.out.format("%+,10d %+,10d\n", positiveNumber, negativeNumber);
		
		System.out.println("******************************************************");
		
		System.out.println("String in?");
		try
		{
			System.out.format("%+,10d %+,10d", "happy", negativeNumber);
		}
		catch(IllegalFormatConversionException e)
		{
			System.out.println("Error: IllegalFormatConversion: d != java.lang.String");
		}
		
	}
}
