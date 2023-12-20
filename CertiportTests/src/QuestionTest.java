import java.util.*;

public class QuestionTest 
{
	public static void main(String[] args) 
	{
		String[] locations = {"North", "SOuth", "East", "West", null};
		System.out.println(locations.length);
		
		
		ArrayList<String> levels = new ArrayList<>();
		levels.add("Gold");
		levels.add("Silver");
		levels.add("Bronze");
		levels.add("Platium");
		
		Iterator levelsList = levels.iterator();
		
		while(levelsList.hasNext())
		{
			System.out.println(levelsList.next());
		}
		
		int tempVar, num;
		String numbersString;
		int[] numbers = {4, 11, 13, 12, 17, 35, 15, 7, 19, 3, 45};

		for (int i = 0; i < numbers.length; i++) {
		    for (int j = i; j < numbers.length; j++) {
		        if (numbers[i] < numbers[j]) {
		            tempVar = numbers[i];
		            numbers[i] = numbers[j];
		            numbers[j] = tempVar;
		        }
		    }
		}

		numbersString = Arrays.toString(numbers);

		System.out.println(numbersString);
		
	}
}
