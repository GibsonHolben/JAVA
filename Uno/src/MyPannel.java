import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	Graphics2D g2D;
	
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
	public boolean doneOnce = false;
	
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
	 * Paints the game window
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(10));
		g2D.setPaint(Color.black);
		g2D.drawRect(400, 300, 100, 200);
		g2D.drawRect(0, 0, 100, 200);
		g2D.setStroke(new BasicStroke(1));
		g2D.setPaint(MainDeckColor);
		g2D.fillRect(0, 0, 100, 200);
		g2D.setPaint(Color.black);
		g2D.setFont(new Font(null, Font.BOLD,40));
		g2D.drawString(MainDeckText, 0, 45);
		g2D.setPaint(PlayerDeckColor);
		g2D.fillRect(400, 300, 100, 200);
		g2D.setPaint(Color.black);
		g2D.setFont(new Font(null, Font.BOLD,40));
		g2D.drawString(PlayerDeckText, 400, 350);
		g2D.drawString(MainGameLoop.CurentPlayer.Name, 300, 100);
		
		if(!doneOnce)
		{
			g2D.fillRect(0, 0, 500, 500);
			doneOnce = true;
		}
		else
		{
			
		}
			
		
		
	}
	
}
