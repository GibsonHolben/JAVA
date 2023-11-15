import java.util.Scanner;
/**
 * A test case for the Shoe class
 * @author Gibson Holben
 * @version 0.1.2
 */
public class ShoeDriver
{
	public static void main(String[] args) 
	{
		System.out.println(Shoe.amountOfShoes);
		
		//This is the default shoe
		Shoe S1 = new Shoe();
		System.out.println(Shoe.amountOfShoes);
		
		//This is the shoe that has the variables set
		Shoe S2 = new Shoe(79.99f, 13.5f, "Leather");
		System.out.println(Shoe.amountOfShoes);

		//************************************************************************
		
		//Catch the value returned
		float price1 = S2.getPrice();
		
		//Setter needs to have a value to pass in
		float newPrice = 12.31f;
		System.out.println("$" + S2.getPrice());
		S2.setPrice(newPrice);
		System.out.println("$" + S2.getPrice());
		
		//************************************************************************
		
		Scanner Input = new Scanner(System.in);
		System.out.println("What is the new price: ");
		
		try
		{
			float Input1F = Input.nextFloat();
			S1.setPrice(Input1F);
		}
		catch (Exception e)
		{
			System.out.println("Invalid Input");
		}	
		
		System.out.println("Price is: $" + S1.getPrice());
		
//		Reads the console
//		Scanner Input = new Scanner(System.in);
//		System.out.println("What is the new price: ");
//		//Next reads until it hits a space
//		//To change the delimenator use > Input.useDelimiter("2");
//		String Input1 = Input.next();
//		String Input2 = Input.next();
//		Input.nextLine();		//dummy call
//		
//		System.out.println("Example of a whole line: ");
//		String Input3 = Input.nextLine();
//		System.out.println("$" + Input3);

		System.out.println("Gibson");
	}
}
