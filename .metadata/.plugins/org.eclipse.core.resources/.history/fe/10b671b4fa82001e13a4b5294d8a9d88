/**
 * Tests the Address class
 * @author Gibson Holben
 * @version 0.0.2
 */
public class AddressDriver
{

	/**
	 * The main method of the driver
	 * @param args Unused
	 */
	public static void main(String[] args) 
	{
		//Testing the dafualt constructor
		System.out.println("**********************************A1");
		Address A1 = new Address();
		System.out.println("A1");
		System.out.println("************************************\n");
		
		//Testing the overloaded constructor
		System.out.println("**********************************A2");
		Address A2 = new Address("4934 Pear Lane", "Clarckton", "MI", 48353);
		testGettersAndSetters(A2);
		System.out.println("************************************\n");
		
		//Test toString
		System.out.println("**********************************A3");
		Address A3 = new Address("8534 rock Lane", "Orlando", "FL", 47293);
		System.out.println(A3.toString());
		System.out.println("************************************\n");
		
		//Test toString
		System.out.println("**********************************A4");
		Address A4 = new Address("842397 boring road", "Madison Heights", "MI", 58202);
		A4.printAll();
		System.out.println("************************************\n");
		
	}
	
	/**
	 * Tests the getters and setters on a Address
	 * @param a the passed in Address
	 */
	public static void testGettersAndSetters(Address a)
	{
		System.out.println(a.getCity());
		a.setCity("Detroit");
		System.out.println(a.getCity());
		
		System.out.println(a.getStreetAddress());
		a.setStreetAddress("210 Bannana Road");
		System.out.println(a.getStreetAddress());
		
		System.out.println(a.getState());
		a.setState("WA");
		System.out.println(a.getState());
		
		System.out.println(a.getZipCode());
		a.setZipCode(43085);
		System.out.println(a.getZipCode());
	}

}
