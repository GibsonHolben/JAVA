import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import  sun.audio.*;
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MyFrame extends JFrame implements ActionListener
{
	/**
	 * Can the user play
	 * default = true
	 */
	boolean canPlay = true;
	
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
	
	/**
	 * A JButton that shows the settings
	 */
	static JButton 			Settings = new JButton("Settings");
	
	/**
	 * A JButton that shows the how to play 
	 */
	static JButton 			HowToPlay = new JButton("How to play");
	
	//ColorChanges
	/**
	 * Changes the color of the main deck to red
	 */
	static JButton 			Red = new JButton(MainGameLoop.ColorsBackup[0]);
	
	/**
	 * Changes the color of the main deck to blue
	 */
	static JButton 			Blue = new JButton(MainGameLoop.ColorsBackup[1]);
	
	/**
	 * Changes the color of the main deck to green
	 */
	static JButton 			Green = new JButton(MainGameLoop.ColorsBackup[2]);
	
	/**
	 * Changes the color of the main deck to yellow
	 */
	static JButton 			Yellow = new JButton(MainGameLoop.ColorsBackup[3]);
	//Player select
	
	/**
	 * Sets the amount of players to 1
	 */
	static JButton 			P1 = new JButton("1 Player");
	/**
	 * Sets the amount of players to 2
	 */
	static JButton 			P2 = new JButton("2 Players");
	/**
	 * Sets the amount of players to 3
	 */
	static JButton 			P3 = new JButton("3 Players");
	/**
	 * Sets the amount of players to 4
	 */
	static JButton 			P4 = new JButton("4 Players");
	
	
	//SFX
	/**
	 * The audio clip of the button click
	 */
	Clip 					clip;
	
	/**2
	 * the audio stream of the button click
	 */
	AudioInputStream 		AudioStream;
      
	
	/**
	 * Creates the frame
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 
		//sets the sfx 
		File file = new File("src/ButttonClick.wav");
		try 
		{
			AudioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(AudioStream);
		} 
		catch (UnsupportedAudioFileException e) 
		{
			e.printStackTrace();
		}
		catch ( LineUnavailableException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		

		//Sets the image 
		ImageIcon img = new ImageIcon("src/Uno.png");
		this.setIconImage(img.getImage());
		
		panel = new MyPannel(newColor, newText);
		windowSettup();
		this.setResizable(false);
		panel.setLayout(					  null);
		P1.addActionListener(                 this);
		P2.addActionListener(                 this);
		P3.addActionListener(                 this);
		P4.addActionListener(                 this);
		Play.addActionListener(			   	  this);
		Start.addActionListener(			  this);
		Settings.addActionListener(			  this);
		SkipTurn.addActionListener(			  this);
		HowToPlay.addActionListener(          this);
		FlipCurentHand.addActionListener(	  this);
		FlipCurentHandBack.addActionListener( this);
		
		
		SetupButton(Settings, 0, 480, 100, 20);
		SetupButton(HowToPlay, 100, 480, 100, 20);
		SetupButton(P1, 2,400);
		SetupButton(P2, 104,400);
		SetupButton(Start, 206, 400);
		SetupButton(P3, 308,400);
		SetupButton(P4, 410,400);
		P1.setVisible(true);
		P2.setVisible(true);
		P3.setVisible(true);
		P4.setVisible(true);
		this.setVisible(true);
		
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
		panel.remove(P1);
		panel.remove(P2);
		panel.remove(P3);
		panel.remove(P4);
		SetupButton(Settings, 0, 480, 100, 20);
		SetupButton(HowToPlay, 100, 480, 100, 20);
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
		SetupButton(Play,				90,400);
		SetupButton(FlipCurentHand,		290,400);	
		SetupButton(FlipCurentHandBack,	0,400);

		
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
	
	/**
	 * Sets up the window format
	 */
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
	 * @param position the position of the button
	 */
	public void SettupColorButtons(int position)
	{
		panel.setLayout(null);
		
		//Red
		Red.setBounds(0,position,100,60);
		panel.add(Red);
		Red.addActionListener(this);
		Red.setFocusPainted(false);
		Red.setBackground(Color.white);
		
		//Blue
		Blue.setBounds(90,position,100,60);
		panel.add(Blue);
		Blue.addActionListener(this);
		Blue.setFocusPainted(false);
		Blue.setBackground(Color.white);
		
		//Green
		Green.setBounds(190,position,100,60);
		panel.add(Green);
		Green.addActionListener(this);
		Green.setFocusPainted(false);
		Green.setBackground(Color.white);
		
		//Yellow
		Yellow.setBounds(290,position,100,60);
		panel.add(Yellow);
		Yellow.addActionListener(this);
		Yellow.setFocusPainted(false);
		Yellow.setBackground(Color.white);
		
		Red.setVisible(true);
		Blue.setVisible(true);
		Green.setVisible(true);
		Yellow.setVisible(true);
		this.setVisible(true);
	}
	
	
	/**
	 * Sets up the button 
	 * @param Button the button to setup
	 */
	public void SetupButton(JButton Button)
	{
		Button.setFocusPainted(false);
		Button.setBackground(Color.white);
		panel.setLayout(null);
		Button.setBounds(190,400,100,60);
		panel.add(Button);
		this.setVisible(true);
		panel.setComponentZOrder(Button, 0);
		Button.setVisible(true);
		panel.setVisible(true);
	}
	
	/**
	 * Sets up the button with x and y cordenants
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 */
	public void SetupButton(JButton Button, int x, int y)
	{	
		Button.setFocusPainted(false);
		Button.setBackground(Color.white);
		panel.setLayout(null);
		this.setVisible(true);
		Button.setBounds(x, y ,100,60);
		panel.add(Button);
		Button.addActionListener(this);
		Button.setFocusPainted(false);
		Button.setBackground(Color.white);
	}
	
	
	/**
	 * Sets up the button with x and y cordenants and with  a size
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 * @param sizeX the horizontal size of the button
	 * @param sizeY the vertical size of the button
	 */
	public void SetupButton(JButton Button, int x, int y, int sizeX, int sizeY)
	{	
		Button.setFocusPainted(false);
		Button.setBackground(Color.white);
		panel.setLayout(null);
		Button.setBounds(x, y, sizeX, sizeY);
		panel.add(Button);
		Button.setVisible(true);
		this.setVisible(true);
		panel.setComponentZOrder(Button, 0);
		Button.setVisible(true);
	}
	
	
	
	//Actions **********************************************************************************
	/**
	 * Is called the button is clicked
	 */
	public void actionPerformed(ActionEvent e)
	{
		PlayClick();
		if(e.getSource().equals(P1))
		{
			ChangePlayers("1");
			P1.setVisible(true);
			this.setVisible(true);
		}
		if(e.getSource().equals(P2))
		{
			ChangePlayers("2");
			P2.setVisible(true);
			this.setVisible(true);
		}
		if(e.getSource().equals(P3))
		{
			ChangePlayers("3");
			P3.setVisible(true);
			this.setVisible(true);
		}
		if(e.getSource().equals(P4))
		{
			ChangePlayers("4");
			P4.setVisible(true);
			this.setVisible(true);
		}
				
				
				
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
				MainGameLoop.initGame();
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
			if(e.getSource().equals(Settings))
			{
				ShowSettings();
			}
		}
		else
		{
			if(e.getSource().equals(Red))
			{
				MainGameLoop.CurentColor = MainGameLoop.ColorsBackup[0];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Blue))
			{
				MainGameLoop.CurentColor = MainGameLoop.ColorsBackup[1];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Green))
			{
				MainGameLoop.CurentColor = MainGameLoop.ColorsBackup[2];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Yellow))
			{
				MainGameLoop.CurentColor = MainGameLoop.ColorsBackup[3];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}	
		}
		
		if(e.getSource().equals(HowToPlay))
		{
			ShowHowToPlay();
		}
		

	}
	
	/**
	 * Shows the settings file
	 */
	public void ShowSettings()
	{
		if (Desktop.isDesktopSupported()) 
		{
			String FilePath = System.getProperty("user.home");
			FilePath = FilePath + "/Documents/Settings.txt";
		    try 
		    {
		    	System.out.println("Only four colors are used");
		    	System.out.println("Supported colors are: Red, Blue, Green, Yellow, Magenta, & Cyan");
				Desktop.getDesktop().edit(new File(FilePath));
			} 
		    catch (IOException e1) 
		    {
				e1.printStackTrace();
			}
		} 
		else 
		{
		   System.out.println("Error getting settings file");
		}
		this.setVisible(true);
		Settings.setVisible(true);
	}
	
	/**
	 * Shows the how to play  file
	 */
	public void ShowHowToPlay()
	{
		if (Desktop.isDesktopSupported()) 
		{
			String FilePath = System.getProperty("user.home");
			FilePath = FilePath + "/Documents/HTP.txt";
		    try 
		    {
				Desktop.getDesktop().edit(new File(FilePath));
			} 
		    catch (IOException e1) 
		    {
				e1.printStackTrace();
			}
		} 
		else 
		{
		   System.out.println("Error getting file");
		}
		this.setVisible(true);
		Settings.setVisible(true);
	}
	
	public void ChangePlayers(String input)
	{
		try 
		{
			String FilePath3 = System.getProperty("user.home");
			FilePath3 = FilePath3 + "/Documents/Players.txt";
			FileWriter myWriter3 = new FileWriter(FilePath3);
		    myWriter3.write(input);
		    myWriter3.close();
		}       
		catch (IOException e2) 
		{
		      System.out.println("An error occurred.");
		      e2.printStackTrace();
		}
	}
	
	/**
	 * Hides the buttons
	 */
	public void hideButtons()
	{
		SetupButton(Settings, -1111, 480, 100, 20);
		SetupButton(HowToPlay,-1111, 480, 100, 20);
		SetupButton(SkipTurn, -1111, 0);
		SetupButton(Play,-1111,400);
		SetupButton(FlipCurentHand,-1111,400);
		SetupButton(FlipCurentHandBack,-1111,400);
	}
	
	/**
	 * Plays the button click
	 */
	public void PlayClick()
	{
		clip.start();
		clip.setMicrosecondPosition(0);
	}
	
	
	public String toString()
	{
		String s = canPlay + "," + panel;
		
		return s;
	}
}
