/**
 * A simple example of how to use the Computer class
 * @author Gibson Holben
 * @version 0.1
 */
public class ComputerDriver 
{	 
	public static void main(String[] args)
	{
		//Creates an empty computer
		Computer PcEmpty = new Computer();
		PcEmpty.PrintSpecs();
		
		System.out.println("**************************");
		System.out.println("Pre Built PC");
		System.out.println("**************************");
		
		
		//Creates a pre built pc
		Computer PreBuiltPc = new Computer("AMD");
		PreBuiltPc.PrintSpecs();
		
		System.out.println("**************************");
		System.out.println("Regular PC");
		System.out.println("**************************");
		
		//Create a computer with all the specs
		Computer Pc = new Computer("Intel i9", "NVIDEA RTX 3090", 
				"Seagate", "Samsung", "Crucial", "ASUS B550+", 
				"Lian Li Lancool", (byte) 64, (short) 1000,(short) 5000);
		
		//Change the specs of a string variable 
		Pc.ChangeSpecs("CPU", "Intel i3 ");
		
		//Change the specs of a byte or a short variable
		Pc.ChangeSpecs("RAM", (short) 32);
		
		//Print the specs to the console
		Pc.PrintSpecs();
		
		System.out.println("**************************");
		
		//The default method to save the specs to a txt file
		Pc.SaveSpecs("Simple Computer");
		
		System.out.println("**************************");
		System.out.println("User Entered");
		System.out.println("**************************");
		
		//Tests the method that asks the user the specs that they want
		Computer PcUserEnter = new Computer();
		PcUserEnter.askSpecs();
		PcUserEnter.PrintSpecs();
		//The method to save the txt file to the specified path
		PcUserEnter.SaveSpecs("user entered","C:/Users/CTEHolbenG46/Documents/" );
		
		//Tests the derived method getMb;
		int ramMB = PcUserEnter.getMb("RAM");
		System.out.println("User entered Computer ram is "
									+ PcUserEnter.RAM + " " + ramMB + "(mb)");
	}
}
