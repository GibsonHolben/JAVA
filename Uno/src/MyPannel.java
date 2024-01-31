import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Used for drawing the low level graphics and
 *  controlling the overall look of the game
 * @author CTEHolbenG46
 * @version 5.2.4
 */

@SuppressWarnings("serial")
public class MyPannel extends JPanel
{
	
	
	/**
	 * Has the scene been drawn
	 * Default = false
	 */
	public boolean  doneOnce = false;
	
	/**The X size of the panel*/
	public short panelXSize = 1000;
	
	/**The Y size of the panel*/
	public short panelYSize = 500;
	
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
	 * Creates a Panel
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyPannel(Color newColor, String newText)
	{
		MainDeckColor = newColor;
		MainDeckText = newText;
		
		this.setPreferredSize(Toolkit. getDefaultToolkit(). getScreenSize());
	}
	
	
	/**
	 * Draws the image on the cards
	 */
	public void CardDecals()
	{
		if(!PlayerDeckText.equals("S"))
		{
			if(PlayerDeckText.equals("W"))
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/Uno3.png"
											).getImage();
				g2D.drawImage(img, 600+ 900, 295 + 320, null);
				
			}
			else if(PlayerDeckText.contains("W+"))
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/Uno4.png"
											).getImage();
				g2D.drawImage(img, 600+ 900, 295 + 330, null);
			}
			else
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/Uno2.png"
												).getImage();
				g2D.drawImage(img, 595+ 900, 295 + 348, null);
			}
		}
		
		if(!MainDeckText.equals("S"))
		{
			if(MainDeckText.equals("W"))
			{
				Image img = new ImageIcon("src/Uno3.png"
											).getImage();
				g2D.drawImage(img, -2, 20, null);
			}
			else if(MainDeckText.contains("W+"))
			{
				Image img = new ImageIcon("src/Uno4.png"
						).getImage();
					g2D.drawImage(img, -2, 20, null);
			}
			else
			{
				Image img = new ImageIcon("src/Uno2.png"
											).getImage();
				g2D.drawImage(img, -2, 20, null);
			}
		}
	}
	
	
	/**
	 * Paints the games graphics on the screen
	 * @param g the graphics component
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2D = (Graphics2D) g;
		RenderingHints qualityHints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON );
		qualityHints.put(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY );
		g2D.setRenderingHints( qualityHints );
		
		if(MainGameLoop.isRunning)
		{
			if(doneOnce)
			{
				//Enables anti aliasing on the graphics component

				
				PaintBackground();
				g2D.setStroke(new BasicStroke(10));
				g2D.setPaint(Color.white);
				g2D.drawRoundRect(600+ 900, 295 + 320, 200, 400, 20,20);
				g2D.drawRoundRect(5, 5,200, 400, 20,20);
				g2D.setStroke(new BasicStroke(1));
				g2D.setPaint(MainDeckColor);
				g2D.fillRoundRect(5, 5, 200, 400, 20,20);
				
				
				//Main deck draw
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				
				
				
				if(MainDeckText.equals("W"))
				{
				
				}
				else if(MainDeckText.equals("S"))
				{
					URL url2 = MyPannel.class.getResource("Uno5.png");
					Image img2 = new ImageIcon(url2).getImage();			
					g2D.drawImage(img2, -2, -7	, null);
					g2D.setPaint(Color.white);
				}
				else if(MainDeckText.contains("W+"))
				{
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
											100));
					g2D.drawString("+" + MainGameLoop.Settings[1], 
							5, 37 + 50);
					g2D.setPaint(Color.white);
					g2D.drawString("+" + MainGameLoop.Settings[1], 
							7, 35+ 50);
					
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
											-100));
					g2D.setPaint(Color.black);
					g2D.drawString("+" + MainGameLoop.Settings[1],
							200, 160+ 155);
					g2D.setPaint(Color.white);
					g2D.drawString("+" + MainGameLoop.Settings[1],
							198, 158+ 155);
				}
				else
				{
					g2D.setFont(new Font(null, Font.BOLD,100));
					g2D.drawString(MainDeckText, 5, 37+ 50);
					g2D.setPaint(Color.white);
					g2D.drawString(MainDeckText, 7, 35+ 50);
					
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
							-100));
					g2D.setPaint(Color.black);
					g2D.drawString(MainDeckText, 200, 160+ 155);
					g2D.setPaint(Color.white);
					g2D.drawString(MainDeckText, 198, 158+ 155);
				}
			
				
				g2D.setFont(new Font(null, Font.BOLD,40));
				g2D.setPaint(PlayerDeckColor);
				g2D.fillRoundRect(600+ 900, 295 + 320, 200, 400, 20,20);
				
				CardDecals();

				//Player card draw
				

				if(PlayerDeckText.equals("S"))
				{
					URL url2 = MyPannel.class.getResource(
							"Uno5.png");
					Image img2 = new ImageIcon(url2).getImage();
					g2D.drawImage(img2, 600+ 900, 295 + 320, null);
					g2D.setPaint(Color.white);
				}
				else if(PlayerDeckText.contains("W+"))
				{
					g2D.setPaint(Color.black);
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
							100));
					g2D.drawString("+"+ MainGameLoop.Settings[1],
							1497, 705);
					g2D.setPaint(Color.white);
					g2D.drawString("+"+ MainGameLoop.Settings[1], 
							1499, 700);
					
					g2D.setPaint(Color.black);
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
							-100));
					g2D.drawString("+"+ MainGameLoop.Settings[1],
							1697, 930);
					g2D.setPaint(Color.white);
					g2D.drawString("+"+ MainGameLoop.Settings[1],
							1699, 932);
				}
				else if(PlayerDeckText.equals("W"))
				{

				}
				else
				{
					
					g2D.setPaint(Color.black);
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
							90));
					g2D.drawString(PlayerDeckText, 1507, 702);
					g2D.setPaint(Color.white);
					g2D.drawString(PlayerDeckText, 1509, 700);
					
					g2D.setPaint(Color.black);
					g2D.setFont(new Font("URW Grotesk", Font.BOLD,
							-100));
					g2D.drawString(PlayerDeckText, 1697, 930);
					g2D.setPaint(Color.white);
					g2D.drawString(PlayerDeckText, 1699, 932);
				}
				
				
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
				
				g2D.setPaint(Color.black);
				if(MainGameLoop.CurentPlayer.MyDeck.Cards.size() < 2)
				{
					g2D.drawString("You have " + Integer.toString(
							MainGameLoop.CurentPlayer.MyDeck.Cards.size()) + " "
									+ "Card in you hand", 118.5f, 41.5f);
				}
				else
				{
					g2D.drawString("You have " + Integer.toString(
							MainGameLoop.CurentPlayer.MyDeck.Cards.size()) + " "
									+ "Cards in you hand", 118.5f, 41.5f);
				}
			
				g2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + 
						"'s turn", 118.5f, 21.5f);
				
				g2D.setPaint(Color.white);
				if(MainGameLoop.CurentPlayer.MyDeck.Cards.size() < 2)
				{
					g2D.drawString("You have " + Integer.toString(
							MainGameLoop.CurentPlayer.MyDeck.Cards.size()) + " "
									+ "Card in you hand", 120, 40);

				}
				else
				{
					g2D.drawString("You have " + Integer.toString(
							MainGameLoop.CurentPlayer.MyDeck.Cards.size()) + " "
									+ "Cards in you hand", 120, 40);

				}
				g2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + 
						"'s turn", 120, 20);
				
				DrawMiddleNumber();
			}
			
			//If it is the first call of paint then show the main menu
			if(!doneOnce)
			{

				g2D.setPaint(Color.black);
				g2D.fillRect(0, 0, 2000, 1200);
				g2D.setPaint(Color.white);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,300));
				g2D.drawString("UNO", 675, 600);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				g2D.drawString("By Gibson Holben", 825, 700);
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
			g2D.drawString(MainGameLoop.CurentWinPlayer.Name + 
					" Wins!", 120, 250);
		}
		
			
		
		
	}
	
	/**
	 * Draws the middle number of the UNO card
	 */
	public void DrawMiddleNumber()
	{
		g2D.setPaint(Color.black);
		//Draws the middle number on the player deck
		if(PlayerDeckText.length() == 2)
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD,
					100));
			g2D.drawString(PlayerDeckText, 1538, 857);
			g2D.setPaint(Color.white);
			g2D.drawString(PlayerDeckText, 1540, 855);
		}

		else if (!PlayerDeckText.equals("W")&&
				!PlayerDeckText.contains("W+")&&
				!PlayerDeckText.equals("S"))
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD,
					150));
			g2D.drawString(PlayerDeckText, 1558, 872);
			g2D.setPaint(Color.white);
			g2D.drawString(PlayerDeckText, 1560, 870);
		}
		
		g2D.setPaint(Color.black);
		
		
		//Draws the middle number on the main deck
		if(MainDeckText.length() == 2)
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD, 
					100));
			g2D.drawString(MainDeckText, 43, 232);
			g2D.setPaint(Color.white);
			g2D.drawString(MainDeckText, 45, 230);
		}
		else if(MainDeckText.equals("W")||
				MainDeckText.contains("W+")|| 
				MainDeckText.equals("S"))
		{
			
		}
		else
		{
			g2D.setFont(new Font("URW Grotesk", Font.BOLD,
					150));
			g2D.drawString(MainDeckText, 58, 252);
			g2D.setPaint(Color.white);
			g2D.drawString(MainDeckText, 60, 250);
		}
	}
	
	void PaintBackground()
	{
		this.setBackground(Color.red);
	}
	

	/**
	 * returns the object as a string
	 */
	public String toString()
	{
		String s = MainDeckColor.toString() + "," +
				MainDeckText + "," + 
				PlayerDeckColor.toString()  + "," + 
				PlayerDeckText;
				
		return s;
	}
	
	
}
