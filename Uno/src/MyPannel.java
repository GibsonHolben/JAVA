import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
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
	public boolean  doneOnce = false;
	
	/**
	 * The graphics handler, Used to paint everything on the panel
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
	 * The color of the active players deck
	 * Default = red
	 */ 
	public Color 	PlayerDeckColor = Color.red;
	
	/**
	 * The text on the main deck
	 * Default = 0
	 */
	public String 	PlayerDeckText = "0";
	
	/**
	 * How much the cards differ
	 */
	public int change = 0;
	

	
	
	/**
	 * Creates a Panel with color and text settings
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyPannel(Color newColor, String newText)
	{
		
		MainDeckColor = newColor;
		MainDeckText = newText;
		
		this.setPreferredSize(
					Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	/**
	 * Gets the background color setting
	 * @return the color of the background from setting
	 */
	public static Color BackgroundColor()
	{
		switch(MainGameLoop.Settings[4])
		{
			case "Red": 
				return Visuals.RED;
			case "Blue": 
				return Visuals.BLUE;
			case "Green":
				return Visuals.GREEN;
			case "Yellow": 
				return Visuals.YELLOW;
			case "Magenta": 
				return Visuals.MAGENTA;
			case "Cyan": 
				return Visuals.CYAN;
			case "Orange": 
				return Visuals.ORANGE;
			case "Grey": 
				return Visuals.GREY;
			default: 
				return Visuals.RED;
		}
	}

	/**
	 * Draws the middle number of the UNO card (main deck and player)
	 * @param type the type of card being drawn
	 * @param x the x cords
	 * @param y the y cords
	 * @param Card the card to draw
	 */
	public void DrawMiddleNumber(String type, int x, int y, Card Card)
	{
		g2D.setPaint(Color.black);
		//Draws the middle number on the player deck
		if(type.equals("Player"))
		{
			if(Integer.toString(Card.numberValue).length() == 2)
			{
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
						100));
				g2D.drawString(Integer.toString(Card.numberValue), x + 50 - 2, y + 230 + 2);
				g2D.setPaint(Color.white);
				g2D.drawString(Integer.toString(Card.numberValue), x + 50 , y + 230);
			}
			else if(Card.SpecialEffect.equals("+2"))
			{
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
						100));
				g2D.drawString(Card.SpecialEffect, x + 40 - 2, y + 230 + 2);
				g2D.setPaint(Color.white);
				g2D.drawString(Card.SpecialEffect, x + 40 , y + 230);
			}
			else if (!Card.SpecialEffect.equals("W")&&
					!Card.SpecialEffect.contains("W+")&&
					!Card.SpecialEffect.equals("S"))
			{
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
										150));
				g2D.drawString(Integer.toString(Card.numberValue), x + 60 - 2, y + 250 + 2);
				g2D.setPaint(Color.white);
				g2D.drawString(Integer.toString(Card.numberValue), x + 60, y + 250);
			}

		}
		else
		{
			g2D.setPaint(Color.black);
			//Draws the middle number on the main deck
			if(MainDeckText.length() == 2)
			{
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
						100));
				g2D.drawString(MainDeckText, x + 40 - 2, y + 230 + 2);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, x + 40 , y + 230);
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
				g2D.drawString(MainDeckText, x + 60 - 2, y + 250 + 2);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, x + 60, y + 250);
			}
		}
		
		


		
	}
	
	/**
	 * Paints a card
	 * @param Type the type of card being painted (Player or main)
	 * @param x the x position
	 * @param y the y position
	 * @param w the width
	 * @param h the height
	 * @param Color the color of the card
	 * @param Card the card to draw
	 */
	@SuppressWarnings("static-access")
	public void PaintCard(String Type, int x, int y, int w, int h, Color Color, Card Card)
	{
		this.setBackground(BackgroundColor());
		g2D.setStroke(new BasicStroke(10));
		g2D.setPaint(Color.black);
		g2D.drawRoundRect(x- 2, y + 2, w, h, 20, 20);
		g2D.setPaint(Color.white);
		g2D.drawRoundRect(x, y, w, h, 20, 20);
		g2D.setStroke(new BasicStroke(1));
		g2D.setPaint(Color);
		g2D.fillRoundRect(x, y, w, h, 20,20);

		if(Type.equals("Main"))
		{
			
			DrawMiddleNumber("Main", x, y, Card);
			if(Card.SpecialEffect.equals("W"))
			{
				g2D.setPaint(Setup.GetColor(MainGameLoop.CurentColor));
				g2D.fillRoundRect(x, y, w, h, 20,20);
				Image img = new ImageIcon("src/img/Uno3.png").getImage();
					
				g2D.drawImage(img, x + -2, y + 10, null);
				g2D.setPaint(Color.black);
			}
			else if(Card.SpecialEffect.equals("S"))
			{
				URL url2 = MyPannel.class.getResource("img/Uno5.png");
				Image img2 = new ImageIcon(url2).getImage();
				g2D.drawImage(img2, x + -2, y  + -7	, null);
				g2D.setPaint(Color.white);
			}
			else if(Card.SpecialEffect.equals("+2"))
			{
				
				Image img = new ImageIcon
						(
							"src/img/Uno2.png"
						).getImage();
				g2D.drawImage(img, x + -2, y + 20, null);
				
				g2D.setPaint(Color.black);
				g2D.setFont(new Font(null, Font.BOLD,80));
				g2D.drawString(MainDeckText, x - 1 + 5, y + 27+ 50);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, x - 1 + 7, y + 25+ 50);

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														-80));
				g2D.setPaint(Color.black);
				g2D.drawString(MainDeckText, x + 200, y + 160+ 155);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, x + 198, y + 158+ 155);
			}
			else if(Card.SpecialEffect.contains("W+"))
			{
				g2D.setPaint(Setup.GetColor(MainGameLoop.CurentColor));
				g2D.fillRoundRect(x, y, w, h, 20,20);
				Image img = new ImageIcon
						(
							"src/img/Uno4.png"
						).getImage();
				g2D.drawImage(img, x + -2, y + 20, null);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														100));
				g2D.drawString("+" + MainGameLoop.Settings[1],
											x + 5, y + 37 + 50);
				g2D.setPaint(Color.white);
				g2D.drawString("+" + MainGameLoop.Settings[1],
											x + 7, y + 35+ 50);

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														-100));
				g2D.setPaint(Color.black);
				g2D.drawString("+" + MainGameLoop.Settings[1],
										x + 200, y + 160+ 170);
				g2D.setPaint(Color.white);
				g2D.drawString("+" + MainGameLoop.Settings[1],
										x + 198, y + 158+ 170);
			}
			else
			{
				Image img = new ImageIcon
						(
							"src/img/Uno2.png"
						).getImage();
				g2D.drawImage(img, x + -2, y + 20, null);
				
				g2D.setPaint(Color.black);
				g2D.setFont(new Font(null, Font.BOLD,100));
				g2D.drawString(MainDeckText, x + 5, y + 37+ 50);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, x + 7, y + 35+ 50);

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														-100));
				g2D.setPaint(Color.black);
				g2D.drawString(MainDeckText, x + 200, y + 160+ 155);
				g2D.setPaint(Color.white);
				g2D.drawString(MainDeckText, x + 198, y + 158+ 155);
			}
		}
		else if(Type.equals("Player"))
		{
			y = y + change;
			DrawMiddleNumber("Player", x, y, Card);
			if(Card.SpecialEffect.equals("S"))
			{
				URL url2 = MyPannel.class.getResource("img/Uno5.png");
				Image img2 = new ImageIcon(url2).getImage();
				g2D.drawImage(img2, x + -2, y + 20, null);
				g2D.setPaint(Color.white);
			}
			else if(Card.SpecialEffect.equals("+2"))
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/img/Uno2.png"
												).getImage();
				g2D.drawImage(img, x + -2, y + 20, null);
				
				g2D.setPaint(Color.black);
				g2D.setFont(new Font(null, Font.BOLD,80));
				g2D.drawString(Card.SpecialEffect, x - 1 + 5, y + 27+ 50);
				g2D.setPaint(Color.white);
				g2D.drawString(Card.SpecialEffect, x - 1 + 7, y + 25+ 50);

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														-80));

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
						-100));
				g2D.setPaint(Color.black);
				g2D.drawString(Card.SpecialEffect, x + 200, y + 160+ 155);
				g2D.setPaint(Color.white);
				g2D.drawString(Card.SpecialEffect, x + 198, y + 158+ 155);
			}
			else if(Card.SpecialEffect.contains("W+"))
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/img/Uno4.png").getImage();
											
				g2D.drawImage(img, x + -2, y + 20, null);
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														100));
				g2D.drawString("+" + MainGameLoop.Settings[1],
										  x + 5, y + 37 + 50);
				g2D.setPaint(Color.white);
				g2D.drawString("+" + MainGameLoop.Settings[1],
										   x + 7, y + 35+ 50);

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
														-100));
				g2D.setPaint(Color.black);
				g2D.drawString("+" + MainGameLoop.Settings[1],
										x + 200, y + 160+ 170);
				g2D.setPaint(Color.white);
				g2D.drawString("+" + MainGameLoop.Settings[1],
										x + 198, y + 158+ 170);
			}
			else if(Card.SpecialEffect.equals("W"))
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/img/Uno3.png"
											).getImage();
				g2D.drawImage(img, x + -2, y + 10, null);
			}
			else
			{
				g2D.setPaint(Color.white);
				Image img = new ImageIcon("src/img/Uno2.png"
												).getImage();
				g2D.drawImage(img, x + -2, y + 20, null);
				
				g2D.setPaint(Color.black);
				g2D.setFont(new Font(null, Font.BOLD,100));
				g2D.drawString(Integer.toString(Card.numberValue), x + 5, y + 37+ 50);
				g2D.setPaint(Color.white);
				g2D.drawString(Integer.toString(Card.numberValue), x + 7, y + 35+ 50);

				g2D.setFont(new Font("URW Grotesk", Font.BOLD,
						-100));
				g2D.setPaint(Color.black);
				g2D.drawString(Integer.toString(Card.numberValue), x + 200, y + 160+ 155);
				g2D.setPaint(Color.white);
				g2D.drawString(Integer.toString(Card.numberValue), x + 198, y + 158+ 155);
			}
		}
	}
	
	/**
	 * Paints all the games graphics on the screen
	 * @param g the graphics component used to  draw everything
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g2D = (Graphics2D) g;
		RenderingHints AntiAliasing = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON );
		AntiAliasing.put(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY );
		g2D.setRenderingHints(AntiAliasing);
		
		//If the game is running
		if(MainGameLoop.isRunning)
		{
			//If this is not the first paint call
			if(doneOnce)
			{
				g2D.setFont(new Font("URW Grotesk", Font.BOLD, 20));
				g2D.drawString(Integer.toString(MainGameLoop.CurentPlayer.curentCardIndex + 1) + 
						"/" + Integer.toString(MainGameLoop.CurentPlayer.MyDeck.Cards.size()), 1439, 1001);
				g2D.setPaint(Color.white);
				g2D.drawString(Integer.toString(MainGameLoop.CurentPlayer.curentCardIndex + 1) + 
						"/" + Integer.toString(MainGameLoop.CurentPlayer.MyDeck.Cards.size()), 1440, 1000);
				
				//Enables Anti-aliasing on the graphics component
				g2D.setStroke(new BasicStroke(10));
				g2D.setPaint(Color.white);
				PaintCard("Player", 600+ 900, 295 + 320, 200, 400, PlayerDeckColor, MainGameLoop.CurentPlayer.MyDeck.Cards.get(0));
				PaintCard("Main",100, 5, 200, 400, MainDeckColor, MainGameLoop.MainDeck.Cards.get(0));
				
				if(MainGameLoop.CurentPlayer.MyDeck.Cards.size() <= 9)
				{
					
					for(int i = 1; i < MainGameLoop.CurentPlayer.MyDeck.Cards.size(); i ++)
					{	
						
						PaintCard("Player", i * 100, 295 + 320, 200, 400, Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(i).ColorValue), MainGameLoop.CurentPlayer.MyDeck.Cards.get(i));
					}
				}
				else
				{
					int startIndex = MainGameLoop.CurentPlayer.MyDeck.Cards.size() - 9;
					
					if((startIndex - 1 != 0))
					{
						g2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
						g2D.setPaint(Color.black);
						g2D.drawString("+" + Integer.toString(startIndex - 1), 1119, 626);
						g2D.setPaint(Color.white);
						g2D.drawString("+" + Integer.toString(startIndex - 1), 1120, 625);
					}
					
					
					for(int i = startIndex; i < MainGameLoop.CurentPlayer.MyDeck.Cards.size(); i ++)
					{	
						
						PaintCard("Player", ((i + 1) - startIndex) * 100, 295 + 320, 200, 400, 
								Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(i).ColorValue), MainGameLoop.CurentPlayer.MyDeck.Cards.get(i));
					}
				}				
				
				
				//Main deck draw
				g2D.setPaint(Color.black);
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,40));
				g2D.setFont(new Font(null, Font.BOLD,40));
				g2D.setPaint(PlayerDeckColor);

				//Player card draw
				g2D.setFont(new Font("URW Grotesk", Font.BOLD,20));
				g2D.setPaint(Color.black);
				g2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + 
						"'s turn", 318.5f, 21.5f);
				g2D.setPaint(Color.white);
				g2D.drawString("It is " + MainGameLoop.CurentPlayer.Name + 
														"'s turn", 320, 20);
				
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
			g2D.setPaint(Color.black);
			g2D.fillRect(0,0, 5000, 5000);
			g2D.setPaint(Color.white);
			g2D.setFont(new Font(null, Font.BOLD,100));
			g2D.drawString(MainGameLoop.CurentWinPlayer.Name +
											" Wins!", 600, 400);
		}
	}

	/**
	 * returns the object as a string
	 * Deliminator = ,
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
