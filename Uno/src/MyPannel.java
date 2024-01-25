import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Used for drawing the low level graphics and controlling the overall look of the game
 * @author CTEHolbenG46
 * @version 5.2.4
 */

@SuppressWarnings("serial")
public class MyPannel extends JPanel 
{
	/**
	 * The graphics handler
	 */
	Graphics2D 		g2D;
	
	//Main Deck
	/**
	 * The color of the main deck
	 * Default = red
	 */
	public Color 	MainDeckColor = Color.red;
	
	/**
	 * The text on the main deck
	 * Default = 0
	 */
	public String 	MainDeckText= "0";
	
	//Player Deck
	/**
	 * The color of the main deck
	 * Default = red
	 */ 
	public Color 	PlayerDeckColor = Color.red;
	
	/**
	 * The text on the main deck
	 * Default = 0
	 */
	public String 	PlayerDeckText = "0";
	
	/**
	 * Has the scene been drawn
	 * Default = false
	 */
	public boolean  doneOnce = false;
	
	
	/**
	 * Creates a Panel
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyPannel(Color newColor, String newText)
	{
		MainDeckColor = newColor;
		MainDeckText = newText;
		this.setPreferredSize(new Dimension(500, 500));
	}
	
	
	
	/**
	 * Paints the games graphics on the screen
	 * @param g the graphics component
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2D = (Graphics2D) g;
		
		if(MainGameLoop.isRunning == true)
		{
			if(doneOnce)
			{
				g2D.setRenderingHint(
				        RenderingHints.KEY_TEXT_ANTIALIASING,
				        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				
				URL url = MyPannel.class.getResource("Wood.jpg");
				Image img = new ImageIcon(url).getImage();
				g2D.drawImage(img, 0, 0, null);
				g2D.setStroke(new BasicStroke(10));
				g2D.setPaint(Color.white);
				g2D.drawRoundRect(395, 300, 100, 200, 20,20);
				g2D.drawRoundRect(5, 0, 100, 200, 20,20);
				g2D.setStroke(new BasicStroke(1));
				g2D.setPaint(MainDeckColor);
				g2D.fillRoundRect(5, 0, 100, 200, 20,20);
				
				
				//Main deck draw
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				g2D.drawString(MainDeckText, 5, 37);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, 7, 35);
				
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,-40));
				g2D.setPaint(Color.black);
				g2D.drawString(MainDeckText, 100, 160);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, 98, 158);
				
				g2D.setFont(new Font(null, Font.BOLD,40));
				g2D.setPaint(PlayerDeckColor);
				g2D.fillRoundRect(395, 300, 100, 200, 20,20);
				
				CardDecals();

				//Player card draw
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				g2D.drawString(PlayerDeckText, 398, 342);
				g2D.setPaint(Color.white);
				g2D.drawString(PlayerDeckText, 400, 340);
				
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,-40));
				g2D.drawString(PlayerDeckText, 490, 460);
				g2D.setPaint(Color.white);
				g2D.drawString(PlayerDeckText, 488, 462);
				
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
				g2D.drawString("You have " + Integer.toString(MainGameLoop.CurentPlayer.MyDeck.Cards.size()) + " Cards in you hand", 110, 40);
				g2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + "'s turn", 110, 20);
				
				DrawMiddleNumber();
			}
			
			
			if(!doneOnce)
			{

				g2D.setPaint(Color.black);
				g2D.fillRect(0, 0, 550, 550);
				g2D.setPaint(Color.white);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,100));
				g2D.drawString("UNO", 145, 250);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
				g2D.drawString("By Gibson Holben", 170, 300);
				doneOnce = true;
			}
		}
		else
		{
			URL url = MyPannel.class.getResource("Party.jpg");
			Image img = new ImageIcon(url).getImage();

			g2D.drawImage(img , 0, 0, null);
			
			g2D.setPaint(Color.black);
			g2D.setFont(new Font(null, Font.BOLD,40));
			g2D.drawString(MainGameLoop.CurentWinPlayer.Name + " Wins!", 120, 250);
		}
		
			
		
		
	}
	
	/**
	 * Draws the middle number of the UNO card
	 */
	public void DrawMiddleNumber()
	{
		//Draws the middle number on the player deck
		if(PlayerDeckText.length() == 2)
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD, 50));
			g2D.drawString(PlayerDeckText, 415, 417);
			g2D.setPaint(Color.white);
			g2D.drawString(PlayerDeckText, 417, 415);
		}
		else if(PlayerDeckText.equals("W")|| PlayerDeckText.equals("W+4")|| PlayerDeckText.equals("S"))
		{
			
		}
		else
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD,60));
			g2D.drawString(PlayerDeckText, 428, 417);
			g2D.setPaint(Color.white);
			g2D.drawString(PlayerDeckText, 430, 415);
		}
		
		g2D.setPaint(Color.black);
		
		
		//Draws the middle number on the main deck
		if(MainDeckText.length() == 2)
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD, 50));
			g2D.drawString(MainDeckText, 23, 122);
			g2D.setPaint(Color.white);
			g2D.drawString(MainDeckText, 25, 120);
		}
		else if(MainDeckText.equals("W")|| MainDeckText.equals("W+4")|| MainDeckText.equals("S"))
		{
			
		}
		else
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD,60));
			g2D.drawString(MainDeckText, 38, 122);
			g2D.setPaint(Color.white);
			g2D.drawString(MainDeckText, 40, 120);
		}
	}
	
	
	/**
	 * Draws the image on the cards
	 */
	public void CardDecals()
	{
		if(PlayerDeckText.equals("W")||PlayerDeckText.equals("W+4"))
		{
			g2D.setPaint(Color.white);
			Image img = new ImageIcon("src/Uno3.png").getImage();
			g2D.drawImage(img, 387, 320, null);
			
		}
		else
		{
			g2D.setPaint(Color.white);
			Image img = new ImageIcon("src/Uno2.png").getImage();
			g2D.drawImage(img, 387, 320, null);
		}
		
		if(MainDeckText.equals("W")||MainDeckText.equals("W+4"))
		{
			Image img = new ImageIcon("src/Uno3.png").getImage();
			g2D.drawImage(img, -2, 20, null);
		}
		else
		{
			Image img = new ImageIcon("src/Uno2.png").getImage();
			g2D.drawImage(img, -2, 20, null);
		}
	
		
	}
	
	/**
	 * returns the object as a string
	 */
	public String toString()
	{
		String s = MainDeckColor.toString() + "," + MainDeckText + "," + PlayerDeckColor.toString()  + "," + PlayerDeckText;
				
		return s;
	}
	
}
