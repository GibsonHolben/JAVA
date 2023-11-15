public class HeadphonesDriver 
{
	public static void main(String[] args)
	{
		
		System.out.println("Gibson Holben");
		/**Creates an empty headphon*/
		Headphones HP1 = new Headphones();  
		/**Creates a headphone with the color blue*/
		Headphones HP2 = new Headphones("blue");
		/**Creates  headphone with the color red and the material plastic*/
		Headphones HP3 = new Headphones("red", "plastic");
		/**Prints the color*/
		System.out.println(HP1.Color);
		
		System.out.println(HP2.Color);
		
		System.out.println(HP3.Color + " " + HP3.Material);
		
		
		//Test Question
		String Color = "orange";
		
		String Material = "metal";
		
		Headphones HP4 = new Headphones(Color, Material);
		
		//Mutation, changing the original without creating a nw one
		//all public instances are accessed via a dot operator
		//in contrast, private variables cannot be accessed by a dot operator
		HP4.Color = "purple";
		
		//*****************************************************************
		//public void increaseVolume()
		//*****************************************************************
		
		//Tests if volume is 0;
		HP4.volume = 0;
		System.out.println(HP4.volume);
		HP4.increaseVolume();
		System.out.println(HP4.volume);
		
		//tests if volume is not 0
		HP4.volume = 2;
		System.out.println(HP4.volume);
		HP4.increaseVolume();
		System.out.println(HP4.volume);
		
		
		System.out.println("**************************************************************************************");
		//*****************************************************************
		//public void increaseVolume(int increese)
		//*****************************************************************
		//Tests if volume is 0;
		HP4.volume = 0;
		System.out.println(HP4.volume);
		HP4.increaseVolume(3);
		System.out.println(HP4.volume);
		
		//tests if volume is not 0
		HP4.volume = 2;
		System.out.println(HP4.volume);
		HP4.increaseVolume(3);
		System.out.println(HP4.volume);
		
		//Test question
		Color = "green";
		//will HP4 change?
		//No it will not. It will create a new memory adress and assign "green" to it
		System.out.println(HP4.Color + " " + HP4.Material);
	}
}
