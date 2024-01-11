import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MyFrame extends JFrame implements ActionListener
{
	/**
	 * A JButton that calls flipTheCurentDeck
	 */
	static JButton 			FlipCurentHand = new JButton("Flip >");
	/**
	 * A JButton that calls flipTheCurentDeck backwards
	 */
	static JButton 			FlipCurentHandBack = new JButton("Flip <");
	
	/**
	 * A JButton that calls flip
	 */
	static JButton 			SkipTurn = new JButton("Skip");
	
	/**
	 * The main panel
	 */
	MyPannel 				panel;
	
	/**
	 * A JButton that calls play on the curent player
	 */
	static JButton 			Play = new JButton("Play");
	
	/**
	 * A JButton that calls start
	 */
	static JButton 			Start = new JButton("Start");
	
	//ColorChanges
	/**
	 * Changes the color of the main deck to red
	 */
	static JButton 			Red = new JButton("Red");
	
	/**
	 * Changes the color of the main deck to blue
	 */
	static JButton 			Blue = new JButton("Blue");
	
	/**
	 * Changes the color of the main deck to green
	 */
	static JButton 			Green = new JButton("Green");
	
	/**
	 * Changes the color of the main deck to yellow
	 */
	static JButton 			Yellow = new JButton("Yellow");
	
	/**
	 * Can the user play
	 * default = true
	 */
	boolean canPlay = true;
	
	/**
	 * Creates the frame
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 
		//Sets the image 
		ImageIcon img = new ImageIcon("src/Uno.png");
		this.setIconImage(img.getImage());
		
		panel = new MyPannel(newColor, newText);
		windowSettup();
		this.setResizable(false);
		panel.setLayout(					  null);
		Play.addActionListener(			   	  this);
		Start.addActionListener(			  this);
		SkipTurn.addActionListener(			  this);
		FlipCurentHand.addActionListener(	  this);
		FlipCurentHandBack.addActionListener( this);
	
		Start.setFocusPainted(false);
		Start.setBackground(Color.white);
		SetupButton(Start);
	}
	
	//Resets ************************************************************
	/**
	 * Redraws the JFrame (start of the game)
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void reset(Color newColor, String newText)
	{
		windowSettup();
		panel.repaint();
		panel.MainDeckColor = newColor;
		panel.MainDeckText = newText;
		panel.setLayout(null);
		panel.remove(Start);
		SetupButton(SkipTurn);
		SetupButton(Play,90,400);
		SetupButton(FlipCurentHand,290,400);
		SetupButton(FlipCurentHandBack,0,400);
		this.setVisible(true);
	}
	
	/**
	 * Redraws the JFrame 
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void resetPlayerhand(Color newColor, String newText)
	{
		
		windowSettup();
		panel.repaint();
		panel.PlayerDeckColor = newColor;
		panel.PlayerDeckText = newText;
		panel.setLayout(null);
		panel.remove(Start);
		SetupButton(SkipTurn);
		SetupButton(Play,90,400);
		SetupButton(FlipCurentHand,290,400);	
		SetupButton(FlipCurentHandBack,0,400);
		
		Play.setFocusPainted(				false);
		SkipTurn.setFocusPainted(			false);
		FlipCurentHand.setFocusPainted(		false);
		FlipCurentHandBack.setFocusPainted(	false);
		Play.setBackground(					Color.white);
		SkipTurn.setBackground(				Color.white);
		FlipCurentHand.setBackground(		Color.white);
		FlipCurentHandBack.setBackground(	Color.white);
		this.setVisible(true);
	}
	
	//Settups ****************************************************************
	public void windowSettup()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setName("UNO");
	}
	
	/**
	 * Sets up the wild card buttons
	 */
	public void SettupColorButtons(int position)
	{
		panel.setLayout(null);
		
		//Red
		Red.setBounds(0,position,100,60);
		panel.add(Red);
		Red.addActionListener(this);
		Red.setFocusPainted(false);
		Red.setBackground(Color.red);
		
		//Blue
		Blue.setBounds(90,position,100,60);
		panel.add(Blue);
		Blue.addActionListener(this);
		Blue.setFocusPainted(false);
		Blue.setBackground(Color.blue);
		
		//Green
		Green.setBounds(190,position,100,60);
		panel.add(Green);
		Green.addActionListener(this);
		Green.setFocusPainted(false);
		Green.setBackground(Color.green);
		
		//Yellow
		Yellow.setBounds(290,position,100,60);
		panel.add(Yellow);
		Yellow.addActionListener(this);
		Yellow.setFocusPainted(false);
		Yellow.setBackground(Color.yellow);
		
		Red.setVisible(true);
		Blue.setVisible(true);
		Green.setVisible(true);
		Yellow.setVisible(true);
		this.setVisible(true);
	}
	
	
	/**
	 * Sets up the button 
	 * Button the button to setup
	 */
	public void SetupButton(JButton Button)
	{
		
		panel.setLayout(null);
		Button.setBounds(190,400,100,60);
		panel.add(Button);
		Button.setVisible(true);
		this.setVisible(true);
		panel.setComponentZOrder(Button, 0);
		Play.setVisible(true);
	}
	
	/**
	 * Sets up the button with x and y cordenants
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 */
	public void SetupButton(JButton Button, int x, int y)
	{	
		panel.setLayout(null);
		Button.setBounds(x, y, 100,60);
		panel.add(Button);
		Button.setVisible(true);
		this.setVisible(true);
		panel.setComponentZOrder(Button, 0);
		Play.setVisible(true);
	}
	
	
	
	//Actions **********************************************************************************
	/**
	 * Is called the button is clicked
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(FlipCurentHand))
		{
			MainGameLoop.FlipCurentHand();
			this.setVisible(true);
		}
		if(e.getSource().equals(FlipCurentHandBack))
		{
			MainGameLoop.FlipCurentHandBack();
			this.setVisible(true);
		}
		if(canPlay == true)
		{
			if(e.getSource().equals(SkipTurn))
			{
				MainGameLoop.CurentPlayer.Skip();
				SkipTurn.setVisible(true);
				this.setVisible(true);
				
			}
			if(e.getSource().equals(Start))
			{
				MainGameLoop.Start();
				Start.setVisible(true);
				this.setVisible(true);
			}
			if(e.getSource().equals(Play))
			{
				MainGameLoop.CurentPlayer.play();
				this.setVisible(true);
				Play.setVisible(true);
			}
		}
		else
		{
			if(e.getSource().equals(Red))
			{
				//System.out.println("RED");
				MainGameLoop.CurentColor = "Red";
				canPlay = true;
				MainGameLoop.nextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Blue))
			{
				MainGameLoop.CurentColor = "Blue";
				canPlay = true;
				MainGameLoop.nextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Green))
			{
				MainGameLoop.CurentColor = "Green";
				canPlay = true;
				MainGameLoop.nextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Yellow))
			{
				MainGameLoop.CurentColor = "Yellow";
				canPlay = true;
				MainGameLoop.nextPlayer();
				SettupColorButtons(-1000);
			}	
		}
	}
}
