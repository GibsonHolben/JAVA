/**
 * <h1 style= "color: #FF7F50"> Fill in the blank </h1>
 * <p> Used to fill in the blank words in the following story </p>
 * <b>------------------------------------------------------------
 * ------------------------------------------------------------------
 * -------------------------------------------------------------------
 * ------------</b>
 * <p> One day [Name1] and [Name2] wanted to cook [Food] for 
 * [Name 3]. They wanted to</p>
 * <p>make the meal very [ADJECTIVE1] so they went to the [Noun1] store.</p>
 * <p>When they got there they saw a shelf full of [Advective2] 
 * [Plural Noun1]  and</p>
 * <p>[advective3] [Plural Noun2]. "This [advective4] [Noun2] would go
 *  [adverb] with the [Advective5] [Plural Noun2]" [name 1] Explained</p>
 * <p>Once back in the kitchen, [Name2] pulled out a [Adjective6]
 *  [Noun3] and began</p>
 * <p>[Verb ending in ING 1] the [Plural Noun2]. "Preparing 
 * [Plural Noun4] always makes my</p>
 * <p>[Plural Noun5] [Verb1]" [name 1] said. Finally the [noun4] was 
 * done [Verb ending in ING 2] in the oven and [Name 3] came home from [Location]</p>
 * <p>"[Exclamation!] something smells [adjective7] in here," said [Name 3].
 *  Everyone [Past tense verb] and started [Verb Ending in ING 3] the [Food]</p>
 * <p>complete with sides of [Adjective8] [Plural Noun2] and [Plural Noun3]!</p>
 * <b>-----------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 * ---------------------------------------------------------</b>
 * 
 * @author Gibson Holben
 * @version 1.0 New Release
**/
public class fillInTheBlank
{
	
	/**
	 *�The main takes in 28 arguments and merges them with the above 
	 * story before printing them out to the console.
	 * @param args
	 * <b> args 0-28 are merged into the above story.</b>
	 * <b style= "color: red">*Red text is for required args </b>
	 * 	<p style="color: red">args[0] name1</p>
	 * 	<p style="color: red">args[1] name2</p>
	 * 	<p style="color: red">args[2] food</p>
	 * 	<p style="color: red">args[3] name3</p>
	 * 	<p style="color: red">args[4] adjective1</p>
	 * 	<p style="color: red">args[5] noun1</p>
	 * 	<p style="color: red">args[6] adjective2</p>
	 * 	<p style="color: red">args[7] plural noun1</p>
	 * 	<p style="color: red">args[8] adjective3</p>
	 * 	<p style="color: red">args[9] plural noun2</p>
	 * 	<p style="color: red">args[10] adjective4</p>
	 * 	<p style="color: red">args[11] noun2</p>
	 * 	<p style="color: red">args[12] adverb</p>
	 * 	<p style="color: red">args[13] adjctive5</p>
	 *  <p style="color: red">args[14] adjetive6</p>
	 * 	<p style="color: red">args[15] noun3</p>
	 * 	<p style="color: red">args[16] verb-in1g</p>
	 * 	<p style="color: red">args[17] plural noun4</p>
	 * 	<p style="color: red">args[18] plural noun5</p>
	 * 	<p style="color: red">args[19] verb1</p>
	 * 	<p style="color: red">args[20] noun4</p>
	 * 	<p style="color: red">args[21] verb-ing2</p>
	 * 	<p style="color: red">args[22] location</p>
	 * 	<p style="color: red">args[23] exclamation</p>
	 * 	<p style="color: red">args[24] adjective7</p>
	 * 	<p style="color: red">args[25] past-tense-verb</p>
	 * 	<p style="color: red">args[26] verb-ing3</p>
	 * 	<p style="color: red">args[27] adjective8</p>
	 *  <p style="color: red">args[28] plural noun3 </p>
	 */
	
	
	public static void main(String[] args)
    {
		//Merges the arguments with the main story 
		//Prints the merged story to the console
		System.out.print("One day " + args[0] + " and " + args[1]);
		System.out.print(" wanted to cook " + args[2] + " for ");
		System.out.print(args[3] + ". They wanted to ");
		System.out.print("make the meal very " + args[4]);
		System.out.println(" so they went to the " + args[5] +" store.");
		System.out.print("When they got there they saw a shelf ");
		System.out.print("full of " +  args[6] + " " + args[7] + " and ");
		System.out.println(args[8] + " " + args[9] + " \"This ");
		System.out.print(args[10]+ " " + args[11] + " would go ");
		System.out.print( args[12] +  " with the " + args[13]);
		System.out.print(" " +  args[14] + "\" ");
		System.out.print(args[0] + " Explained. ");
		System.out.println("Back in the kitchen " +	args[1] + " took out a ");
		System.out.print(args[15] + " "  + args[16] + " and began ");
		System.out.print(args[17] + " the " + args[9]);
		System.out.print(". \"Preparing " + args[18] + " always makes my ");
		System.out.println(args[19] + " " + args[20] + " ");
		System.out.print(args[0] + "\" said. Finally the "+ args[21] + " was done ");
		System.out.print(args[22] + " in the oven and ");
		System.out.print(args[3] + " came home from " + args[23] + ". ");
		System.out.println("\"" + args[24] + "! something smells ");
		System.out.print(args[25] +  " in here,\" said " + args[3]);
		System.out.print(". Everyone " + args[26] + " down ");
		System.out.println(" and started " + args[27] + " the " + args[2] + " ");
		System.out.print( "complete with sides of " + args[28]);
		System.out.print(" " + args[9] + " and " + args[14] + "! ");			
    }
}