public class Interfaces
{
    public static void main(String[] args)
    {

        Animal anm = new Animal() {

            @Override
            public void animalSound()
            {
                System.out.println("AAAANNNNMMM");
            }

            @Override
            public void sleep()
            {
                System.out.println("ANMANM");
            }
        };
        Pig myPig = new Pig();  // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}

// interface
interface Animal
{
    public void animalSound(); // interface method (does not have a body)
    public void sleep(); // interface method (does not have a body)

}

class Pig implements Animal
{
    public void animalSound()
    {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
    public void sleep()
    {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }
}