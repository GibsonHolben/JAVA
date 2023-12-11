
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class StringFormat
{
	public static void main(String[] args) 
	{
		//why .format	system.out	--	reports		column		center
		//	  print	 or	 println	
		//println	-	caradge return		-		2 lines
		System.out.println("Gibson");	//6 charecters
		System.out.println("Kids");		//4 charecters
		//all on the same line
		System.out.print("Gibson");	//6 charecters
		System.out.println("Kids");		//4 charecters
		
		
		System.out.println("**Format 1 String**");
		
		//%		escape charecter... seperates formatting
		System.out.format("%s", "Gibson");	//6 charecters
		System.out.format("%s", "Kids");	//4 charecters
		
		
		
		
		System.out.println("stop");
	}
}
