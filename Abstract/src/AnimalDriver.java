
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class AnimalDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 //Animal myAnimal = new Animal(); will error never never
		
		Moose MyMoose = new Moose();
		
		MyMoose.animalSound();	//moose
		MyMoose.animalSound(3);	//moose
		MyMoose.sleep();		
		
		System.out.println("stop");
	}

}
