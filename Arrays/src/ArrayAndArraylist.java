import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayAndArraylist
{

	public static void main(String[] args)
	{
		Scanner Input = new Scanner(System.in);
		
		//constant
		String[] Sizes = {"S","M","L","XL","XS","XXL"};
		String[] Sizes2 = {new String("S"),
							new String("M"),
							new String("L"),
							new String("XL"),
							new String("XS"),
							new String("XXL")}; //object based array
		
		
		
		//arraylist is dynamic grow and shrink objects only
		//overhead
		ArrayList<String> Sizes4 = new ArrayList<String>();
		
		//array lists in diferant languages are not the same
		Sizes4.add("S");
		Sizes4.add("M");
		Sizes4.add("L");
		Sizes4.add("XL");
		Sizes4.add(1, "XS");
		
		
		//print all contents on an array		
		//process through an array
		//ArrayList is an object'
		//top of the array to the bottom without stoping

		
		//ArrayList<String> Sizes4 		
		//only be used with array list
		//top to bottom
		//Irerator		counter		increese by 1	
		
		
		
		System.out.println("Sizes4<> print top to bottom for loop");
		System.out.println("*****************************************************");
		
		Iterator<String> Sizes4Iterator = Sizes4.iterator();
		//while loops always exacute 0 to many times as opposed to a do loop always goes at least once
		while(Sizes4Iterator.hasNext())		//peek
		{
			//can remove items of an array while looping
			//Sizes4Iterator.remove();
			System.out.println("sizes4<>: " + Sizes4Iterator.next());	//read
			
		}
		System.out.println("*****************************************************\n");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//for each
		//top to bottom
		
		//ArrayList<String> Sizes4
		System.out.println("Sizes4<> print top to bottom for loop");
		System.out.println("*****************************************************");
		for(String SingleSizeEntry : Sizes4 )
		{
			System.out.println("sizes4<>: " + SingleSizeEntry);
		}
		System.out.println("*****************************************************\n");
		
		
		
		//String[] Sizes
		System.out.println("Sizes[] print top to bottom for loop");
		System.out.println("*****************************************************");
		for(String SingleSizeEntry : Sizes)
		{
			System.out.println("sizes[]: " +SingleSizeEntry);
		}
		System.out.println("*****************************************************\n");
		
		
		
		
		
		

			
		
				
			
	

				
		

		
		//Common errors
		//ArrayList<String> Sizes4
		//			   i < Sizes4.size;			common error will not work
		//String[] Sizes
		//			   i < Sizes.length();		common error will not work
		
		//using <= instad of < 					error will not work
		
		
		
		System.out.println("Sizes4<> print top to bottom for loop");
		System.out.println("*****************************************************");
		for(int i = 0; i < Sizes4.size(); i++)	//arraylist
		{
			System.out.println("sizes4<" + i + ">: " +  Sizes4.get(i));
		}
		
		System.out.println("*****************************************************");
		System.out.println("Sizes[] print top to bottom for loop");
		System.out.println("*****************************************************");

		
		for(int i = 0; i < Sizes.length; i++)	//array
		{
			System.out.println("sizes[" + i + "]: " +  Sizes[i]);
		}
		System.out.println("*****************************************************");
		
		
		
		
		//********************************************************
		
		//find...
		//do while...
		//delete...
		
		//static array
		//does not grow. declare and init at the same time
		//can use primaive and objects
		//static
		//declare then load
		//outside source prompt, fil, args
		String Sizes3[] = new String[6];
		// i    <  5
		System.out.println("Please enter a size");
		
		// int i = 0; i < Sizes.length; i++) //Very Best
		// int i = 0; i < 6; i++)
		
		
		
		//use this if you want 5 elements
		//to load th array from an input of a file
		for(int i = 0; i <= 5; i++)
		{
			String Size = Input.nextLine();
			Size = Size.trim().toUpperCase();
			//edits
			//duplication restrictions
			//if error them i -= 1 and reloop
			Sizes3[i] = Size;
		
			if(i < 5)
			{
				System.out.println("Please enter next size");
			}
		
		}
		
		System.out.println("end");
		
		
	}

}