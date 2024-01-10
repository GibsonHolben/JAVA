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
	 * The main panel
	 */
	MyPannel panel;
	
	/**
	 * A JButton that calls flip
	 */
	static JButton FlipMainDeck = new JButton("Flip");
	
	/**
	 * A JButton that calls start
	 */
	static JButton Start = new JButton("Start");
	
	/**
	 * A JButton that calls flipTheCurentDeck
	 */
	static JButton FlipCurentHand = new JButton("Flip Hand");
	
	/**
	 * A JButton that calls play on the curent player
	 */
	static JButton Play = new JButton("Play");
	
	/**
	 * 
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 
		panel = new MyPannel(newColor, newText);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setName("UNO");
		FlipMainDeck.addActionListener(this);
		FlipCurentHand.addActionListener(this);
		Play.addActionListener(this);
		Start.addActionListener(this);
		panel.setLayout(null);
		SetupButton(Start);
		this.setVisible(true);
	}
	
	/**
	 * Redraws the JFrame 
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void reset(Color newColor, String newText)
	{
		panel.MainDeckColor = newColor;
		panel.MainDeckText = newText;
		panel.setLayout(null);
		panel.remove(Start);
		SetupButton(FlipMainDeck);
		SetupButton(Play,100,400);
		SetupButton(FlipCurentHand,300,400);
		this.setVisible(true);
		panel.repaint();
	}
	
	/**
	 * Redraws the JFrame 
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void resetPlayerhand(Color newColor, String newText)
	{
		panel.PlayerDeckColor = newColor;
		panel.PlayerDeckText = newText;
		panel.setLayout(null);
		panel.remove(Start);
		SetupButton(FlipMainDeck);
		SetupButton(Play,100,400);
		SetupButton(FlipCurentHand,300,400);
		this.setVisible(true);
		panel.repaint();
	}
	
	/**
	 * Is called the button is clicked
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == FlipMainDeck)
		{
			MainGameLoop.Flip();
			FlipMainDeck.setVisible(true);
			this.setVisible(true);
		}
		if(e.getSource() == Start)
		{
			MainGameLoop.Start();
			Start.setVisible(true);
			this.setVisible(true);
		}
		if(e.getSource() == FlipCurentHand)
		{
			MainGameLoop.FlipCurentHand();
			this.setVisible(true);
		}
		if(e.getSource() == Play)
		{
			MainGameLoop.CurentPlayer.play();
			this.setVisible(true);
		}
		
	}
	
	/**
	 * Sets up the button 
	 */
	public void SetupButton(JButton Button)
	{
		
		panel.setLayout(null);
		Button.setBounds(200,400,100,60);
		panel.add(Button);
		Button.setVisible(true);
		this.setVisible(true);
		panel.setComponentZOrder(Button, 0);
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
	}
	
	
}
