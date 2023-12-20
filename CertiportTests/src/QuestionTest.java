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
		
		
	}
}
