
public class CalculationsMath 
{
	/**
	 * Used so that I dont have to write System.out
	 * @param string The String that prints
	 */
	public static void print(String string)
	{
		System.out.println(string);
	}
	
	public static void main(String[] args) 
	{
		
		//++X	X++
		int num10A 	 = 5;	//6	//7
		int num10B 	 = 3;
		int num10C 	 = 2;
		int num10D 	 = 1;
		int resault10A = 0;
		int resault10B = 0;
		
		
		resault10A = ++num10A + num10C - num10A++;	//2? Final awnser	I was right!!!!
		//			   num10A + num10C - num10A++
		//				 6	  +   2	   - num10A++
		//				      8	       -    6  ++
		//					  2
		//								 6++ = 7				  
		
		num10A 	 = 5;	
		num10B 	 = 3;
						//6
		resault10B = ++num10A + num10C - ++num10A;	//1 Final awnser	I was right!!!!
		//			 ++num10A
		//			   num10A + num10C - ++num10A
		//			     6    +   2 - ++num10A
		//			          8 	- ++num10A
		//			           		  ++num10A
		//			          8 	- 	  7
		//							1
		
		print("resault10A: "   	+ resault10A);
		print("resault10B: "   	+ resault10B);
		print("num10A: " 		+ num10A);
		print("num10B: " 		+ num10B);
		print("num10C: " 		+ num10C);
		print("num10D: " 		+ num10D);
		
		
		print("**************************************************");			
		
		
		//++X	X++
		int num9A 	 = 5;	//6
		int num9B 	 = 3;	//4
		int num9C 	 = 2;
		int num9D 	 = 1;
		int resault9A = 0;
		int resault9B = 0;
		
		
		resault9A = ++num9A + num9C;	//8?
		//			  num9A + num9C
		//				6	+	2

		resault9B = num9B++ + num9C;	//6?	++ has to be at the begining or the end
		//			  3	++	+ num9C
		//			  3		+ num9C
		//	5 =	  	  3		+ num9C
		
		
		print("resault9A: "   	+ resault9A);
		print("resault9B: "   	+ resault9B);
		print("num9A: " 		+ num9A);
		print("num9B: " 		+ num9B);
		print("num9C: " 		+ num9C);
		print("num9D: " 		+ num9D);
		
		
		print("**************************************************");	
		
		//++X	X++
		int num8A 	 = 5;
		int num8B 	 = 3;
		int num8C 	 = 2;
		int num8D 	 = 1;
		int resault8A = 0;
		int resault8B = 0;
		
		
		resault8A = ++num8A;	//6
		//		6		6
		//				++5
		//		3		4
		
		resault8B = num8B++;	//3		//warning bell
		//		0 = 3++		
		//		3		4
		
		
		
		print("resault8A: "   	+ resault8A);
		print("resault8B: "   	+ resault8B);
		print("num8A: " 		+ num8A);
		print("num8B: " 		+ num8B);
		print("num8C: " 		+ num8C);
		print("num8D: " 		+ num8D);
		
		
		print("**************************************************");	
		
		

		
		
		
		print("MODULO");
		
		//%	   ++	--
		//PEMD%AS

		int num7A 	 = 5;
		int num7B 	 = 3;
		int num7C 	 = 2;
		int num7D 	 = 1;
		int resault7 = 0;

		resault7 = num7B + num7C % num7A;	//5? 
		//					 2	 %   5
		//			3    +		 2 = 5
		//			3	 +   2	 % 	 5	= 0


		print("resault1 = num7B + num7C % num7A");
		print("resault7: "   	+ resault7);
		print("num7A: " 		+ num7A);
		print("num7B: " 		+ num7B);
		print("num7C: " 		+ num7C);
		print("num7D: " 		+ num7D);
		
		
		print("**************************************************");		

		int num6A 	 = 5;
		int num6B 	 = 3;
		int num6C 	 = 2;
		int num6D 	 = 1;
		int resault6 = 0;

		resault6 = num6B * num6C % num6A;	//6? I was wrong multiplication goes first
		//			3	 * 	 2		
		//				 6		 %	 5 	R: 1 
		//					 2   % 	5
		//						 2
		//			 3 	 *	 2 = 6

		print("resault1 = num6B * num6C % num6A");
		print("resault6: "   	+ resault6);
		print("num6A: " 		+ num6A);
		print("num6B: " 		+ num6B);
		print("num6C: " 		+ num6C);
		print("num6D: " 		+ num6D);
		
		
		print("**************************************************");		

		int num5A 	 = 5;
		int num5B 	 = 3;
		int num5C 	 = 2;
		int num5D 	 = 1;
		int resault5 = 0;

		//5 slices of pizza 3 people eating 
		// mom says equal amounts for everyone 
		//how many slices are left?
		resault5 = num5A % num5B * num5C;	//4?	I was Right
		//				 2		 *	 2 : right
		//num5B * num5C;	3	* 2 = 6	: wrong
		print("resault1 = num5A % num5B * num5C");
		print("resault5: "   	+ resault5);
		print("num5A: " 		+ num5A);
		print("num5B: " 		+ num5B);
		print("num5C: " 		+ num5C);
		print("num5D: " 		+ num5D);
		
		
		print("**************************************************");		
		
		
		//% remander	modulus
		int num4A 	 = 5;
		int num4B 	 = 3;
		int num4C 	 = 2;
		int num4D 	 = 1;
		int resault4 = 0;

		//5 slices of pizza 3 people eating 
		// mom says equal amounts for everyone 
		//how many slices are left?
		resault4 = num4A % num4B;	//2?	I was Right? 
		//5 / 3 Remainder is 2 
		print("resault1 = num4A % num4B");
		print("resault4: "   	+ resault4);
		print("num4A: " 		+ num4A);
		print("num4B: " 		+ num4B);
		print("num4C: " 		+ num4C);
		print("num4D: " 		+ num4D);
		
		
		print("**************************************************");
		
		int num3A 	 = 5;
		int num3B 	 = 3;
		int num3C 	 = 2;
		int num3D 	 = 1;
		int resault3 = 0;

		
		resault3 = 			 num3A + num3B * num3C;	//11	I was Right!
		//resault3 = 			 num3A + (num3B * num3C);
		//num3C * num3B
		//6 + num3A
		//5 + 6  = 11
		
		print("resault1 =  num3A + num3B * num3C");
		print("resault3: "   	+ resault3);
		print("num3A: " 		+ num3A);
		print("num3B: " 		+ num3B);
		print("num3C: " 		+ num3C);
		print("num3D: " 		+ num3D);
		
		
		print("**************************************************");
		
		
		int num2A 	 = 5;
		int num2B 	 = 3;
		int num2C 	 = 2;
		int num2D 	 = 1;
		int resault2 = 0;
		
		
		resault2 = 			num2C * num2A + num2B;	//13	I was Right!
		//num2C * num2A
		//10 + num2B
		//13
		
		print("resault1 = num2C * num2A + num2B");
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
		
		print("resault1 = num1A + num1B");
		print("resault: "   	+ resault1);
		print("num1A: " 		+ num1A);
		print("num1B: " 		+ num1B);
		print("num1C: " 		+ num1C);
		print("num1D: " 		+ num1D);
	}
	
	
	
}
