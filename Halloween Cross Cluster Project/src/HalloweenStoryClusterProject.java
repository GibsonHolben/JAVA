import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple program that fills in the blanks of a story 
 * @author Gibson Holben
 * @version 0.4.2
 *
 */
public class HalloweenStoryClusterProject
{
	
	
	/**
	 * Generates a story by asking the user in the consone and printing it out
	 * @param args
	 */
	public static void main(String[] args)
	{
		//*******************************************
		//Asks the user what they want in the console
		//*******************************************
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			System.out.println("Please enter an adjective:");
			String Adjective1 	= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String Adjective2	= br.readLine();
			
			System.out.println("Please enter a verb:");
			String Verb1 		= br.readLine();
			
			System.out.println("Please enter a noun:");
			String Noun1 		= br.readLine();
			
			System.out.println("Please enter an adverb:");
			String Adverb1 		= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String Adjective3	= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String Adjective4	= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String Adjective5 	= br.readLine();
			
			System.out.println("Please enter a noun:");
			String Noun2 		= br.readLine();
			
			System.out.println("Please enter a noun:");
			String Noun3 		= br.readLine();
			
			System.out.println("Please enter a verb (past tense):");
			String Verbed1 		= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String Adjective6 	= br.readLine();
			
			System.out.println("Please enter a verb (past tense):");
			String Verbed2 		= br.readLine();
			
			System.out.println("Please enter a verb (past tense):");
			String Verbed3 		= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String Adjective7   = br.readLine();
			
			System.out.println("Please enter a verb (past tense):");
			String Verbed4 		= br.readLine();
			
			System.out.println("Please enter an adjective:");
			String	Adjective8  = br.readLine();
			
			System.out.println("Please enter a verb (past tense):");
			String	Verbed6 	= br.readLine();
			
			System.out.println("Please enter a verb:");
			String	Verb2		= br.readLine(); 
			
			System.out.println("Please enter a verb:");
			String Verb3 		= br.readLine();
			
			System.out.println("Please enter a verb (past tense):");
			String	Verbed7		= br.readLine();
			
			System.out.println("Please enter a noun:");
			String Noun4 		= br.readLine();
			
			System.out.println("Please enter a verb:");
			String Verb4 		= br.readLine();
			
			System.out.println("************************************************"
					+ "*****************************************************");
			System.out.print("	In the " + Adjective1 + 
					" town of Willowbrook, Halloween was no " + Adjective2 + "\n");
			System.out.print("occasion. It was a time when the whole community " 
					+ Verb1 + " " + Noun1 + " with decorations, \n");
			System.out.print("themed events, and, most " + Adverb1 +
					", the annual Halloween Costume Contest. Folks were \n");
			System.out.println("passionate about their costumes, and the"
					+ " grand prize was the ultimate prize.\n");
			
			System.out.print("	This year, a " + Adjective3 + 
					" costume shop named"	+ " \"Wicked Wonders Costumes\" \n ");
			System.out.print("appeared on the town's outskirts. The shop,"
					+ " owned by the " 	+ Adjective4 + " Madame Zara, \n");
			System.out.println("was rumored to have " + Adjective5 + 
					" knowledge about costumes.\n");
			
			System.out.print("	As Halloween grew close, rumors of"
					+ " Madame Zara's shop spread like " + Noun2 + "\n");
			System.out.print("The costumes there were said to possess " 
					+ Noun3 + ", capable of turning the wearer into \n");
			System.out.print("anything they desired. To win the costume "
					+ " contest, all you had to do was get a costume \n");
			System.out.println("from Wicked Wonders \n");
			
			System.out.print("	Two friends, Jenna and Alex, who both"
					+ " were studying to be costume designers, \n");
			System.out.print("decided to check out the shop. They " +  Verbed1  
					+ " and met Madame Zara, who told them \n");
			System.out.print("they needed to trade something " + Adjective6 + 
					"  for the costumes. Jenna gave up her \n");
			System.out.println("grandmother's locket, and Alex parted with"
					+ " his beloved childhood comic book collection.\n");
			
			System.out.print("	Once they " + Verbed2 + 
					" their costumes, Jenna became a mermaid, "
					+ "and Alex "+ Verbed3 + "\n");
			System.out.print("into a pirate. The costumes felt like a " 
					+ Adjective7 + " skin, and they sensed new powers \n");
			System.out.println("coursing through them.\n");
			System.out.print("	At the Halloween Costume Contest, "
					+ " Jenna and Alex " + Verbed4 + " everyone. Jenna's \n");
			System.out.println("mermaid tail looked real, and Alex "
					+ " embodied a true swashbuckler in his pirate attire. \n");
			
			System.out.print("	But as the contest " + Verbed4 +
					", the other contestants grew " + Adjective8 + 
					". Jenna and \n");
			System.out.print("Alex's advantage was obvious. "
					+ " However, their powers came at a cost."
					+ " They began to lose \n");
			System.out.println("control of themselves, and their "
					+ " costumes seemed to have a will of their own. \n");
			
			System.out.print("	As the contest " + Verbed6 +
					", they had to " + Verb2 + " Madame Zara and " 
					+ Verb3 + " the \n");
			System.out.print("enchantment. As Jenna and Alex " + 
					Verbed7 + " closer towards Wicked Wonders Costumes.\n");
			System.out.print("They felt their powers begin to fade. "
					+ " Suddenly, Madame Zara emerged from the entrance \n");
			System.out.print("of the " + Noun4 +	". “Power comes"
					+ " at a cost,” Madame Zara said.They felt the"
					+ " costumes began\n");
				
			System.out.println("to " + Verb4 + " off of"
					+ " them. Then they blacked out.\n");
			System.out.println("******************************************"
					+ "***********************************************************");
			
			
		}
		catch (IOException e) 
		{
			System.out.println("Cound not assign the variable");
		}	
	}
}
