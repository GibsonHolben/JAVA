import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MyPannel extends JPanel 
{
	/**
	 * The graphics handeler
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
	 * Creates a Panel with 2 cards
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
	 * Paints the graphics on the screen
	 * @param g the graphics 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2D = (Graphics2D) g;
		
		if(MainGameLoop.isRunning == true)
		{
			Image img = new ImageIcon("src/Wood.jpg").getImage();
			g2D.drawImage(img, 0, 0, null);
			g2D.setStroke(new BasicStroke(10));
			g2D.setPaint(Color.black);
			g2D.drawRoundRect(395, 300, 100, 200, 20,20);
			g2D.drawRoundRect(0, 0, 100, 200, 20,20);
			g2D.setStroke(new BasicStroke(1));
			g2D.setPaint(MainDeckColor);
			g2D.fillRoundRect(0, 0, 100, 200, 20,20);
			
			
			//Main deck tet
			g2D.setPaint(Color.black);
			g2D.setFont(new Font(null, Font.BOLD,40));
			g2D.drawString(MainDeckText, 0, 47);
			g2D.setPaint(Color.white);
			g2D.drawString(MainDeckText, 2, 45);
			
			g2D.setFont(new Font(null, Font.BOLD,-40));
			g2D.setPaint(Color.black);
			g2D.drawString(MainDeckText, 95, 150);
			g2D.setPaint(Color.white);
			g2D.drawString(MainDeckText, 93, 148);
			
			g2D.setFont(new Font(null, Font.BOLD,40));
			g2D.setPaint(PlayerDeckColor);
			g2D.fillRoundRect(395, 300, 100, 200, 20,20);
			
			CardDecals();

			//Player card test
			g2D.setPaint(Color.black);
			g2D.setFont(new Font(null, Font.BOLD,40));
			g2D.drawString(PlayerDeckText, 398, 352);
			g2D.setPaint(Color.white);
			g2D.drawString(PlayerDeckText, 400, 350);
			
			g2D.setPaint(Color.black);
			g2D.setFont(new Font(null, Font.BOLD,-40));
			g2D.drawString(PlayerDeckText, 490, 450);
			g2D.setPaint(Color.white);
			g2D.drawString(PlayerDeckText, 488, 452);
			
			g2D.setFont(new Font(null, Font.BOLD,40));
			
			g2D.setPaint(Color.black);
			g2D.setFont(new Font(null, Font.BOLD,20));
			g2D.drawString("You have " + Integer.toString(MainGameLoop.CurentPlayer.MyDeck.Cards.size()) + " Cards in you hand", 110, 40);
			g2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + "'s turn", 110, 20);
			
			g2D.setFont(new Font(null, Font.BOLD,40));
			
			if(!doneOnce)
			{

				g2D.setPaint(Color.black);
				g2D.fillRect(0, 0, 550, 550);
				g2D.setPaint(Color.white);
				g2D.setFont(new Font(null, Font.BOLD,100));
				g2D.drawString("UNO", 130, 250);
				doneOnce = true;
			}
			else
			{
				
			}
		}
		else
		{
			Image img = new ImageIcon("src/Party.jpg").getImage();
			g2D.drawImage(img, 0, 0, null);
			
			g2D.setPaint(Color.black);
			g2D.setFont(new Font(null, Font.BOLD,40));
			g2D.drawString(MainGameLoop.CurentWinPlayer.Name + " Wins!", 120, 250);
		}
		
			
		
		
	}
	
	public void CardDecals()
	{
		g2D.setPaint(Color.white);
		Image img = new ImageIcon("src/Uno2.png").getImage();
		g2D.drawImage(img, 387, 320, null);

		g2D.drawImage(img, -7, 20, null);
	}
	
	public String toString()
	{
		String s = MainDeckColor.toString() + "," + MainDeckText + "," + PlayerDeckColor.toString()  + "," + PlayerDeckText;
				
		return s;
	}
	
}
