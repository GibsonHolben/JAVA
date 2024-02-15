import java.awt.*;
import javax.swing.JPanel;

/**
 * Used for drawing the low level graphics and
 *  controlling the overall look of the game
 * @author CTEHolbenG46
 * @version 5.2.9
 */

@SuppressWarnings("serial")
public class MyPannel extends JPanel
{
	/**
	 * Has the scene been drawn
	 * Default = false
	 */
	public boolean  doneOnce 		= false;
	
	/**
	 * The graphics handler, Used to paint everything on the panel
	 */
	Graphics2D 		G2D;
	
	//Main Deck
	/**
	 * The color of the main deck
	 * Default = red
	 */
	public Color 	MainDeckColor 	= Color.red;
	
	/**
	 * The text on the main deck
	 * Default = 0
	 */
	public String 	MainDeckText	= "0";
	
	//Player Deck
	/**
	 * The color of the active players deck
	 * Default = red
	 */ 
	public Color 	PlayerDeckColor = Color.red;
	
	/**
	 * The text on the main deck
	 * Default = 0
	 */
	public String 	PlayerDeckText  = "0";
	
	
	/**
	 * Creates a Panel with color and text settings
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyPannel(Color newColor, String newText)
	{
		MainDeckColor = newColor;
		MainDeckText = newText;
		this.setPreferredSize
				(
						Toolkit.getDefaultToolkit().getScreenSize()
				);
	}
	
	/**
	 * Gets the background color setting
	 * @return the color of the background from setting
	 */
	public static Color BackgroundColor()
	{
		return Setup.GetColor(MainGameLoop.Settings[4]);
	}

	/**
	 * Draws the middle number of the UNO card (main deck and player)
	 * @param x the x cords
	 * @param y the y cords
	 * @param Card the card to draw
	 */

	/**
	 * Paints all the games graphics on the screen
	 * @param g the graphics component used to  draw everything
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		G2D = (Graphics2D) g;
		RenderingHints AntiAliasing = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON );
		AntiAliasing.put(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY );
		G2D.setRenderingHints(AntiAliasing);
		
		//If the game is running
		if(MainGameLoop.isRunning)
		{
			//If this is not the first paint call
			if(doneOnce)
			{
				G2D.setFont(new Font("URW Grotesk", Font.BOLD, 20));
				G2D.drawString(Integer.toString(MainGameLoop.CurentPlayer.curentCardIndex + 1) + 
						"/" + Integer.toString(MainGameLoop.CurentPlayer.MyDeck.Cards.size()), 1439, 1001);
				G2D.setPaint(Color.white);
				G2D.drawString(Integer.toString(MainGameLoop.CurentPlayer.curentCardIndex + 1) + 
						"/" + Integer.toString(MainGameLoop.CurentPlayer.MyDeck.Cards.size()), 1440, 1000);
				
				//Enables Anti-aliasing on the graphics component
				G2D.setStroke(new BasicStroke(10));
				G2D.setPaint(Color.white);
				Paint.Card(1500, 615, 200, 400, PlayerDeckColor, MainGameLoop.CurentPlayer.MyDeck.Cards.get(0), G2D);
				Paint.Card(100, 5, 200, 400, MainDeckColor, MainGameLoop.MainDeck.Cards.get(0), G2D);
				
				if(MainGameLoop.CurentPlayer.MyDeck.Cards.size() <= 9)
				{
					
					for(int i = 1; i < MainGameLoop.CurentPlayer.MyDeck.Cards.size(); i ++)
					{

						Paint.Card(i * 100, 615, 200, 400,
								Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(i).ColorValue), MainGameLoop.CurentPlayer.MyDeck.Cards.get(i), G2D);
					}
				}
				else
				{
					int startIndex = MainGameLoop.CurentPlayer.MyDeck.Cards.size() - 9;
					
					if((startIndex - 1 != 0))
					{
						G2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
						G2D.setPaint(Color.black);
						G2D.drawString("+" + Integer.toString(startIndex - 1), 1119, 626);
						G2D.setPaint(Color.white);
						G2D.drawString("+" + Integer.toString(startIndex - 1), 1120, 625);
					}
					
					
					for(int i = startIndex; i < MainGameLoop.CurentPlayer.MyDeck.Cards.size(); i ++)
					{

						Paint.Card(((i + 1) - startIndex) * 100, 615, 200, 400,
								Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(i).ColorValue), MainGameLoop.CurentPlayer.MyDeck.Cards.get(i), G2D);
					}
				}				
				
				
				//Main deck draw
				G2D.setPaint(Color.black);
				G2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				G2D.setFont(new Font(null, Font.BOLD,40));
				G2D.setPaint(PlayerDeckColor);

				//Player card draw
				G2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
				G2D.setPaint(Color.black);
				G2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + 
												"'s turn", 318.5f, 21.5f);
				G2D.setPaint(Color.white);
				G2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + 
														"'s turn", 320, 20);
				
			}
			
			//If it is the first call of paint then show the main menu
			if(!doneOnce)
			{
				G2D.setPaint(Color.black);
				G2D.fillRect(0, 0, 2000, 1200);
				G2D.setPaint(Color.white);
				G2D.setFont(new Font("URW Grotesk", Font.BOLD,300));
				G2D.drawString("UNO", 675, 600);
				G2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				G2D.drawString("By Gibson Holben", 825, 700);
				doneOnce = true;
			}
		}
		else
		{
			G2D.setPaint(Color.black);
			G2D.fillRect(0,0, 5000, 5000);
			G2D.setPaint(Color.white);
			G2D.setFont(new Font(null, Font.BOLD,100));
			G2D.drawString(MainGameLoop.CurentWinPlayer.Name +
											" Wins!", 600, 400);
		}
	}

	/**
	 * returns the object as a string
	 * Deliminator = ,
	 */
	public String toString()
	{
        return  MainDeckColor.toString() + "," +
        		MainDeckText + "," +
				PlayerDeckColor.toString()  + "," +
				PlayerDeckText;
	}
}
