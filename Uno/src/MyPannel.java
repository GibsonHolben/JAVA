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
		
		this.setPreferredSize(
					Toolkit.getDefaultToolkit().getScreenSize());
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
	public void DrawMiddleNumber(int x, int y, Card Card)
	{
		G2D.setPaint(Color.black);
		if(Integer.toString(Card.numberValue).length() == 2)
		{
			G2D.setFont(new Font("URW Grotesk", Font.BOLD,
													100));
			G2D.drawString(Integer.toString(Card.numberValue), x + 50 - 2, y + 230 + 2);
			G2D.setPaint(Color.white);
			G2D.drawString(Integer.toString(Card.numberValue), x + 50 , y + 230);
		}
		else if(Card.SpecialEffect.equals("+2"))
		{
			G2D.setFont(new Font("URW Grotesk", Font.BOLD,
													100));
			G2D.drawString(Card.SpecialEffect, x + 40 - 2, y + 230 + 2);
			G2D.setPaint(Color.white);
			G2D.drawString(Card.SpecialEffect, x + 40 , y + 230);
		}
		else if (!Card.SpecialEffect.equals("W")&&
				!Card.SpecialEffect.contains("W+")&&
				!Card.SpecialEffect.equals("S"))
		{
			G2D.setFont(new Font("URW Grotesk", Font.BOLD,
													150));
			G2D.drawString(Integer.toString(Card.numberValue), x + 60 - 2, y + 250 + 2);
			G2D.setPaint(Color.white);
			G2D.drawString(Integer.toString(Card.numberValue), x + 60, y + 250);
		}		
	}
	
	/**
	 * Dynamically updates the wild card decals with the current four colors
	 */
	void PaintCardWildDecals(int x, int y, boolean plusFour)
	{
		//big number
		int x2 = x + 10;
		int y2 = y + 100;
		G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[0]));
		G2D.fillRect(x2 + 105, y2 - 20, 80, 120);
		
		G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[1]));
		G2D.fillRect(x2 + 5, y2 - 10, 100, 160);
		
		G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[2]));
		G2D.fillRect(x2 + 5, y2 + 100, 100, 150);
		
		G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[3]));
		G2D.fillRect(x2 + 105, y2 + 100, 80, 120);

		if(!plusFour)
		{
			//small 2
			for(int i = 0; i < 2; i++)
			{
				G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[0]));
				G2D.fillRect(x + 5 + (i * 115), y  + 20 + (i * 260), 40, 40);
				
				G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[1]));
				G2D.fillRect(x + 45 + (i * 115), y + 20 + (i * 260), 40, 40);
				
				G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[2]));
				G2D.fillRect(x + 5 + (i * 115), y + 60+ (i * 260), 40, 40);
				
				G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[3]));
				G2D.fillRect(x + 45 + (i * 115), y + 60+ (i * 260), 40, 40);
			}
		}
		

	}
	
	/**
	 * Paints a card
	 * @param x the x position
	 * @param y the y position
	 * @param w the width
	 * @param h the height
	 * @param Color the color of the card
	 * @param Card the card to draw
	 */
	@SuppressWarnings("static-access")
	public void PaintCard(int x, int y, int w, int h, Color Color, Card Card)
	{
		this.setBackground(BackgroundColor());
		G2D.setStroke(new BasicStroke(10));
		G2D.setPaint(Color.black);
		G2D.drawRoundRect(x- 2, y + 2, w, h, 20, 20);
		G2D.setPaint(Color.white);
		G2D.drawRoundRect(x, y, w, h, 20, 20);
		G2D.setStroke(new BasicStroke(1));
		G2D.setPaint(Color);
		G2D.fillRoundRect(x, y, w, h, 20, 20);

		DrawMiddleNumber(x, y, Card);

		if(Card.SpecialEffect.contains("W+"))
		{
			G2D.setPaint(Color.white);
			PaintCardWildDecals(x,y, true);
			Image img = new ImageIcon("src/img/Uno4.png").getImage();
			G2D.drawImage(img, x + -2, y + 20, null);
			G2D.setPaint(Color.black);
			G2D.setFont(new Font("URW Grotesk", Font.BOLD,
					100));
			G2D.drawString("+" + MainGameLoop.Settings[1],
					x + 5, y + 37 + 50);
			G2D.setPaint(Color.white);
			G2D.drawString("+" + MainGameLoop.Settings[1],
					x + 7, y + 35+ 50);

			G2D.setFont(new Font("URW Grotesk", Font.BOLD,
					-100));
			G2D.setPaint(Color.black);
			G2D.drawString("+" + MainGameLoop.Settings[1],
					x + 200, y + 150+ 170);
			G2D.setPaint(Color.white);
			G2D.drawString("+" + MainGameLoop.Settings[1],
					x + 198, y + 148+ 170);
		}
		else
		{
			switch(Card.SpecialEffect)
			{
				case "S":
					URL url = MyPannel.class.getResource("img/Uno5.png");
					Image Uno1 = new ImageIcon(url).getImage();
					G2D.drawImage(Uno1, x + -2, y + 20, null);
					G2D.setPaint(Color.white);
					break;
				case "+2":
					G2D.setPaint(Color.white);
					Image Uno2 = new ImageIcon("src/img/Uno2.png"
					).getImage();
					G2D.drawImage(Uno2, x + -2, y + 20, null);

					G2D.setPaint(Color.black);
					G2D.setFont(new Font(null, Font.BOLD,80));
					G2D.drawString(Card.SpecialEffect, x - 1 + 5, y + 27+ 50);
					G2D.setPaint(Color.white);
					G2D.drawString(Card.SpecialEffect, x - 1 + 7, y + 25+ 50);

					G2D.setFont(new Font("URW Grotesk", Font.BOLD,
							-80));

					G2D.setFont(new Font("URW Grotesk", Font.BOLD,
							-100));
					G2D.setPaint(Color.black);
					G2D.drawString(Card.SpecialEffect, x + 200, y + 160+ 155);
					G2D.setPaint(Color.white);
					G2D.drawString(Card.SpecialEffect, x + 198, y + 158+ 155);
					break;
				case "W":
					PaintCardWildDecals(x,y, false);
					G2D.setPaint(Color.white);
					Image img = new ImageIcon("src/img/Uno3.png"
					).getImage();
					G2D.drawImage(img, x + -2, y + 10, null);
					break;
				default:
					G2D.setPaint(Color.white);
					Image Uno3 = new ImageIcon("src/img/Uno2.png"
					).getImage();
					G2D.drawImage(Uno3, x + -2, y + 20, null);

					G2D.setPaint(Color.black);

					G2D.setFont(new Font(null, Font.BOLD,100));
					G2D.drawString(Integer.toString(Card.numberValue), x + 5, y + 37+ 50);
					G2D.setPaint(Color.white);
					G2D.drawString(Integer.toString(Card.numberValue), x + 7, y + 35+ 50);

					G2D.setFont(new Font("URW Grotesk", Font.BOLD,
							-100));
					G2D.setPaint(Color.black);
					G2D.drawString(Integer.toString(Card.numberValue), x + 200, y + 160+ 155);
					G2D.setPaint(Color.white);
					G2D.drawString(Integer.toString(Card.numberValue), x + 198, y + 158+ 155);
					break;

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
				PaintCard(1500, 615, 200, 400, PlayerDeckColor, MainGameLoop.CurentPlayer.MyDeck.Cards.get(0));
				PaintCard(100, 5, 200, 400, MainDeckColor, MainGameLoop.MainDeck.Cards.get(0));
				
				if(MainGameLoop.CurentPlayer.MyDeck.Cards.size() <= 9)
				{
					
					for(int i = 1; i < MainGameLoop.CurentPlayer.MyDeck.Cards.size(); i ++)
					{	
						
						PaintCard(i * 100, 615, 200, 400, 
								Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(i).ColorValue), MainGameLoop.CurentPlayer.MyDeck.Cards.get(i));
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
						
						PaintCard(((i + 1) - startIndex) * 100, 615, 200, 400, 
								Setup.GetColor(MainGameLoop.CurentPlayer.MyDeck.Cards.get(i).ColorValue), MainGameLoop.CurentPlayer.MyDeck.Cards.get(i));
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
        return MainDeckColor.toString() + "," +
				MainDeckText + "," +
				PlayerDeckColor.toString()  + "," +
				PlayerDeckText;
	}
}
