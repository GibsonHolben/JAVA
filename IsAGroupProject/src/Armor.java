import java.time.LocalDate;

public class Armor 
{
		/**
		 * The armor type for the clones.
		 * Default is Flight.
		 */
		public String ArmorType 		= "Flight";
		
		/**
		 * Let's you know if the armor they are wearing is bulletproof or not.
		 * Default is false.
		 */
		public boolean isBulletProof 	= false;
		
		/**
		 * Tells you the date the armor was created.
		 */
		public LocalDate				DateCreated;
		
		/**
		 * Tells you the protection level of the armor.
		 * Default is 1.
		 */
		public int protectionlevel 		= 1;
		
		/**
		 * The type of material of the armor.
		 * Default is Plastic.
		 */
		public String material 			= "Plastic";
		
		//1
		/**
		 * Default Constructor
		 */
		Armor()
		{
			
		}
		
		//2
		/**
		 * Overload constructor with all variables being 
		 * passed in.
		 * @param ArmorType
		 * @param isBulletProof
		 * @param protectionlevel
		 * @param material
		 */
		Armor(String ArmorType, boolean isBulletProof, int protectionlevel, String material)
		{
			this.ArmorType 			= ArmorType;
			this.isBulletProof 		= isBulletProof;
			this.protectionlevel 	= protectionlevel;
			this.material 			= material;
		}
	

}
