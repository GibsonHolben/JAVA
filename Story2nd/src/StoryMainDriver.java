/**
 * <b>Takes the given arguments and merges them with the story below 
 * before printing them to the console</b>
 * <p>The Story </p> 
 * <p>There once was a [adjective] [animal] from [country].</p>
 * <p>Nobody knew he was a [animal] </p>
 * <p>because he had [color] fur and ate [number] [plural food]</p>
 * <p>	each day. He liked to [action word] and sing [song] whenever he was </p>
 * <p>[feeling] he would start speaking [language]. Then he would feel [feeling2]</p>
 * @author Gibson Holben
 * @version 1.0.0 
 */
public class StoryMainDriver 
{
	/**
	 *<p>Takes in 11 arguments and merges them with the story above.</p>
	 * <p> Then prints them to the console </p>  
	 * @param args 11 (0-10) arguments that are used by main and merged into the story
	 * ***********************************************************
	 */
	public static void main(String[] args)
	{
		
		String adjective = args[0]; //an adjective to be merged
		String animal = args[1]; //an animal to be merged
		String country = args[2];//a country to be merged
		String color = args[3];// a color to be merged
		String number = args[4]; //a number to be merged
		String pluralFood = args[5]; //a plural food to be merged
		String actionWord =  args[6]; //a verb to be merged
		String song =  args[7]; //a song (Use qoutes for multiple words) to be merged
		String feeling1 =  args[8]; //feeling 1 to be merged
		String language =  args[9]; // a launguage to be merged
		String feeling2 =  args[10]; //feeling2 to be merged
		
		print("There once was a " + adjective + " ");
		println(animal +" from " + country + "."); 
		print("Nobody knew he was a " + animal );
		print(" because he had "+ color +" fur and ate ");
		println(number + " " +  pluralFood);
		println("each day. He liked to " + actionWord + " and sing "
				+ song + " whenever he was");
		println(feeling1 + ". Then he would start speaking " 
				+ language + ". Then he would feel " + feeling2 + ".");
	}
	
	/**
	 * <p>Prints the input to the console, then creats a new line  </p>
	 * @param print A string that is printed
	 */
	public static void println(String print) 
	{
		//Prints the input to the console, then creats a new line
		System.out.println(print);
	}
	
	/**
	 * <p>Prints the input to the console</p>
	 * @param print A string that is printed
	 */
	public static void print(String print) 
	{
		//Prints the input to the console
		System.out.print(print);
	}
}