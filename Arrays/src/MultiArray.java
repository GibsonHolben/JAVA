public class MultiArray
{
	//Testing my code
	public static void main(String[] args) 
	{
		//Most common error
		//for(int j = 0;j < mArray1.length; j++);	do not have a terminator at the end
		
		int[] sArray1 = {1,2,3};	//single dimentional array {} row 	3
		
		for(int j = 0; j< sArray1.length; j++)
		{
			
		}

		
		int[][] mArray1 =  {{1,2,3},		//{} is a new row	, is a new column
							{4,5,6},	
							{7,8,9},
							{10,11,12}};	
		
		//int[][] mArray1 =  {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};	
 		//		Correct							Wrong
		//		columns	K
		//J			0		1	 2				0	1	2	3
		//r	0		1		2	 3			0	1	4	7	10
		//o	1		4		5	 6			1	2	5	8	11
		//w	2		7		8	 9			2	3	6	9	12
		//s	3		10		11	 12
		
		
		
		
		
		
		//printouts
		System.out.println("mArray rows only printout");
						// mArray1.length 4
		for(int j = 0;j < mArray1.length; j++)
		{
			System.out.println(mArray1[j]);		//memory addres of the row
		}
		
		
		System.out.println("\n");
		System.out.println("for loop within a for loop");
		System.out.println("*****************************************");
		
		

		for(int j = 0;j < mArray1.length; j++)	//outer loop
		{
			for(int k = 0;k < mArray1[j].length; k++)	//inner row
			{
				System.out.println(mArray1[j][k]);	
				
			}
		}
		
		
		
		System.out.println("\n");
		System.out.println("for each within a for each");
		System.out.println("*****************************************");
		
		for(int singleIntRow[] : mArray1)	//one row at a time
		{
			for(int singleIntColomn: singleIntRow)	
			{
				System.out.println("mArray: " + singleIntColomn);
			}
		}
		//SingleIntRow[]
		//1) {1,2,3}		singleInt
		//						1
		//						2
		//						3
		//2) {4,5,6}		singleint
		//						4
		//						5
		//						6
		//3) {7,8,9}		singleint
		//						7
		//						8
		//						9
		//4) {10,11,12}		singleint
		//						10
		//						11
		//						12		
		
		
		
		
		
		System.out.println("\n");
		System.out.println("print by column");
		System.out.println("*****************************************");
		int row = 0;
		for(int k = 0; k < mArray1[row].length;  k++)
		{
			row = row + 1;        
			for(int j = 0; j < mArray1.length;  j++)
			{	
		                              		
			    System.out.println(mArray1[j][k]);    
			}
		}
//		1
//		4
//		7
//		10
//		2
//		5
//		8
//		11
//		3
//		6
//		9
//		12
//		
		
		
		
		
		
		//Common test questiions:
		
		//how many times did it loop
		//j            k              output
        //0            0                1
		//             1                2
		//             2                3
		//             3 stop         3 <3  stop 
		//1            0                4
		//             1                5
		//             2                6
		//             3 stop             
		//2            0                7
		//             1                8
		//             2                9
		//             3 stop
		//3            0               10
		//             1               11
		//             2               12
		//             3 stop
		//4   stop          4 < 4		
		
		
		
		
		//change
		
		
		//loading one at a time
		System.out.println("stop");
	}
}
