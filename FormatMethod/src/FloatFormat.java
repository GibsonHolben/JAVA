public class FloatFormat
{
	public static void main(String[] args) 
	{
		/*
		 * float and double
		 *	rounding issue	are they there
		 *	>= 5 or 
		 *	> 5 or
		 *	no rounding
		 *	Do not use like example 2 it will be wrong
		 *
		 *
		 */
		
		
		
		float float1 =  10000.001f;
		float float2 =   1000.004f;
		float float3 =    100.005f;
		float float4 =     10.006f;
		float float5 =      0.009f;
		float float6 = -10000.001f;
		
		System.out.println("Gibson Holben");
		System.out.println("******************************************************");
		System.out.println("Println");
		System.out.println(float1);
		System.out.println(float2);
		System.out.println(float3);
		System.out.println(float4);
		System.out.println(float5);
		System.out.println(float6);
		
		System.out.println("******************************************************");
		System.out.println("Format");
		System.out.format("%f	%n", float1);
		System.out.format("%f	%n", float2);
		System.out.format("%f	%n", float3);
		System.out.format("%f	%n", float4);
		System.out.format("%f	%n", float5);
		System.out.format("%f	%n", float6);
		
		System.out.println("******************************************************");
		System.out.println("Attempting to line up");
		System.out.format("%10f	%n", float1);
		System.out.format("%10f	%n", float2);
		System.out.format("%10f	%n", float3);
		System.out.format("%10f	%n", float4);
		System.out.format("%10f	%n", float5);
		System.out.format("%10f	%n", float6);
		
		System.out.println("******************************************************");
		System.out.println("Attempting to line up");
		System.out.format("%13f	%n", float1);
		System.out.format("%13f	%n", float2);
		System.out.format("%13f	%n", float3);
		System.out.format("%13f	%n", float4);
		System.out.format("%13f	%n", float5);
		System.out.format("%13f	%n", float6);
		
		System.out.println("******************************************************");
		System.out.println("positive sign");
		String prefix5 = "%+13f	%n";	//switched to a variable for the formating code
		System.out.format(prefix5, float1);
		System.out.format(prefix5, float2);
		System.out.format(prefix5, float3);
		System.out.format(prefix5, float4);
		System.out.format(prefix5, float5);
		System.out.format(prefix5, float6);
		
		System.out.println("******************************************************");
		System.out.println("comma");
		String prefix6 = "%+,14f	%n";
		System.out.format(prefix6, float1);
		System.out.format(prefix6, float2);
		System.out.format(prefix6, float3);
		System.out.format(prefix6, float4);
		System.out.format(prefix6, float5);
		System.out.format(prefix6, float6);
		
		System.out.println("******************************************************");
		System.out.println("decimals");
		String prefix7 = "%+,14.3f	%n";
		System.out.format(prefix7, float1);
		System.out.format(prefix7, float2);
		System.out.format(prefix7, float3);
		System.out.format(prefix7, float4);
		System.out.format(prefix7, float5);
		System.out.format(prefix7, float6);
		
		System.out.println("******************************************************");
		System.out.println("rounding");		//Format will round numbers greather than 5
		String prefix8 = "%+,14.2f	%n";
		System.out.format(prefix8, float1);	//   10000.101f;	= 		+10,000.00	
		System.out.format(prefix8, float2);	//	  1000.401f;	= 		 +1,000.00	
		System.out.format(prefix8, float3);	//	   100.051f;	= 		   +100.00	
		System.out.format(prefix8, float4);	//	    10.006f;	=  		    +10.01	//Round up 
		System.out.format(prefix8, float5);	//	     9.009f;	=		     +0.01	//Round up 
		System.out.format(prefix8, float6);

	}
}
