
public class CalculationsMath 
{
	public static void main(String[] args) 
	{
		int num2A 	 = 5;
		int num2B 	 = 3;
		int num2C 	 = 2;
		int num2D 	 = 1;
		int resault2 = 0;
		
		
		resault2 = 			num2C * num2A + num2B;	//13	I was Right!
		//num2C * num2A
		//10 + num2B
		//13
		
		print("resault1 = num2A + num2B;");
		print("resault2: "   	+ resault2);
		print("num2A: " 		+ num2A);
		print("num2B: " 		+ num2B);
		print("num2C: " 		+ num2C);
		print("num2D: " 		+ num2D);
		
		
		print("**************************************************");
		
		int num1A 	 = 5;
		int num1B 	 = 3;
		int num1C 	 = 2;
		int num1D 	 = 1;
		int resault1 = 0;
		
		
		resault1 = num1A + num1B;
		
		print("resault1 = num1A + num1B;");
		print("resault: "   	+ resault1);
		print("num1A: " 		+ num1A);
		print("num1B: " 		+ num1B);
		print("num1C: " 		+ num1C);
		print("num1D: " 		+ num1D);
	}
	
	
	public static void print(String string)
	{
		System.out.println(string);
	}
}
