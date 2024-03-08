
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public abstract class Animal 
{
	//Never create an instance of Animal
	/*
	 * Animal myAnimal = new Animal(); will error never never
	 */
	
	/**Abstract instance variables*/
	public String name;
	
	
	//No body of function
	//All animals have the differant sound
	//No default
	//method header declersation
	public abstract void animalSound();
	public abstract void animalSound(int numberOfTimes);

	
	//Not abstract (void instead)
	//All animals sleep
	public void sleep(){
		System.out.println("Zzz");
	}
}

