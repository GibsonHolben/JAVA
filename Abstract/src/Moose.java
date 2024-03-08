
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Moose extends Animal
{
	int age = 0;

	//any abstract methods must have a body in the inherited class
	public void animalSound()
	{
		System.out.println("The Moose says: Eerughhh");
	}

	public void animalSound(int numberOfTimes) 
	{
		for(int i = 0; i < numberOfTimes; i++)
		{
			System.out.println("The Moose says: Eerughhh");
		}
	}
	
	@Override
	public void sleep()
	{
		System.out.println("Mmm");
		super.sleep();  //calls animal.sleep
	}
}
