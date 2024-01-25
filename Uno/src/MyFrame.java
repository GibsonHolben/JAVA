import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

/**
 * Used for the high level graphics such as the Buttons and holding all the button actions
 * @author CTEHolbenG46
 * @version 13.3.7
 */
@SuppressWarnings("serial")
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
	static JButton 			FlipCurentHandBack = new JButton("< Flip");
	
	/**
	 * A JButton that skips the active players turn
	 */
	static JButton 			SkipTurn = new JButton("Skip");
	
	/**
	 * The main panel
	 */
	MyPannel 				panel;
	
	/**
	 * A JButton that calls play on the curent player
	 */
	static JButton 			Play = new JButton();
	
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
	 * Creates the frame and gets the buttons setup
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 
		//setups the sfx 

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
		
	

		//Setups the top bar
		URL url = MyPannel.class.getResource("Uno.png");
		ImageIcon img = new ImageIcon(url);
		this.setIconImage(img.getImage());
		this.setTitle("UNO");
		
		//Sets up the panel
		panel = new MyPannel(newColor, newText);
		windowSettup();
		this.setResizable(false);
		panel.setLayout(					  null);
		
		//Setups the buttons
		SetupButton(Settings, 	0, 480, 100, 20);
		SetupButton(HowToPlay, 	100, 480, 100, 20);
		SetupButton(P1, 		2,400, Color.black);
		SetupButton(P2, 		104,400, Color.black);
		SetupButton(Start,		206,400, Color.black);
		SetupButton(P3, 		308,400, Color.black);
		SetupButton(P4, 		410,400, Color.black);
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
		P1.repaint();
		P2.repaint();
		P3.repaint();
		P4.repaint();
		Start.repaint();
		P1.setVisible(true);
		P2.setVisible(true);
		P3.setVisible(true);
		P4.setVisible(true);
		this.setVisible(true);
		setupPlayeBttonColors();
	}
	
	//Resets ************************************************************
	
	/**
	 * Resets the colors of the buttons
	 * @param Button the button that is held down
	 */
	public void ResetPlayerButtons(JButton Button)
	{
		P1.setBackground(Color.white);
		P2.setBackground(Color.white);
		P3.setBackground(Color.white);
		P4.setBackground(Color.white);
		
		Button.setBackground(Color.lightGray);
	}
	
	/**
	 * Sets the font on a jbutton
	 * @param Jb the button that the font is changed on
	 * @param fontsize the new size of the font
	 */
	public void resetFonts(JButton Jb, int fontsize)
	{
		Jb.setFont(new Font("URW Grotesk", Font.BOLD, fontsize));
	}
	
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
		SetupButton(Settings, 			0, 480, 100, 20);
		SetupButton(HowToPlay, 			104, 480, 100, 20);
		SetupButton(SkipTurn, 			104, 400, Color.black);
		SetupButton(Play,				395, 300, 100, 200);
		SetupButton(FlipCurentHand,		294,400, Color.black);
		SetupButton(FlipCurentHandBack,	0,400, Color.black);
		
		Play.setOpaque(false);
		Play.setContentAreaFilled(false);
		Play.setBorderPainted(false);
		resetFonts(Play, 10);
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
		SetupButton(Play,				395, 300, 100, 200);
		SetupButton(FlipCurentHandBack,	0,400, Color.black);
		SetupButton(SkipTurn, 			104, 400, Color.black);
		SetupButton(FlipCurentHand, 	208,400, Color.black);


		
		Play.setFocusPainted(				false);
		SkipTurn.setFocusPainted(			false);
		FlipCurentHand.setFocusPainted(		false);
		FlipCurentHandBack.setFocusPainted(	false);
		Play.setBackground(					Color.white);
		SkipTurn.setBackground(				Color.white);
		FlipCurentHand.setBackground(		Color.white);
		FlipCurentHandBack.setBackground(	Color.white);
		
		Play.setOpaque(false);
		Play.setContentAreaFilled(false);
		Play.setBorderPainted(false);
		Play.setForeground(Color.white);
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
		
		JButton[] ColorB = {Red, Blue, Green, Yellow};
		for(int i = 0; i < ColorB.length; i++)
		{
			ColorB[i].setBounds(				(i * 100) +  (i * 4), position, 100, 60);
			panel.add(					ColorB[i]);
			ColorB[i].addActionListener(		this);
			ColorB[i].setFocusPainted(		false);
			ColorB[i].setBackground(			Color.white);
			ColorB[i].setBorder(				new LineBorder(Color.black, 2));
			resetFonts(ColorB[i], 15);
		}
	}
	
	
	/**
	 * Sets up the button 
	 * @param Button the button to setup
	 */
	public void SetupButton(JButton Button)
	{
		resetFonts(						Button, 15);
		Button.setBounds(				190, 400, 100, 60);
		Button.setBorder(				new LineBorder(Color.BLACK, 2));
		Button.setBackground(			Color.white);
		Button.setFocusPainted(			false);
		Button.setVisible(				true);
		panel.setLayout(				null);
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
		this.setVisible(				true);
	}
	
	/**
	 * Sets up the button with x and y cordenants
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 */
	public void SetupButton(JButton Button, int x, int y, Color BorderColor)
	{	
		resetFonts(						Button, 15);
		Button.setBorder(				new LineBorder(BorderColor, 2));
		Button.setFocusPainted(			false);
		Button.setBackground(			Color.white);
		Button.setBounds(				x, y, 100,60);
		Button.setVisible(				true);
		panel.setLayout(				null);
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
		this.setVisible(				true);
	}
	
	
	/**
	 * Sets up the button with x and y cordenants and with a size
	 * @param Button the button to setup
	 * @param x the x cor of the button
	 * @param y the y cor of the button
	 * @param sizeX the horizontal size of the button
	 * @param sizeY the vertical size of the button
	 */
	public void SetupButton(JButton Button, int x, int y, int sizeX, int sizeY)
	{	
		resetFonts(						Button, 15);
		Button.setBorder(				new LineBorder(Color.BLACK, 2));
		Button.setFocusPainted(			false);
		Button.setBackground(			Color.white);
		Button.setBounds(				x, y, sizeX, sizeY);
		Button.setVisible(				true);
		panel.setLayout(				null);
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
		this.setVisible(				true);
	
	}
	
	/**
	 * Sets up the player selector colors on startup based on what was saved from last use
	 */
	public void setupPlayeBttonColors()
	{
		System.out.println(MainGameLoop.Players.size());
		switch(MainGameLoop.Players.size())
		{
			case 1: ResetPlayerButtons(P1);
			break;
			case 2: ResetPlayerButtons(P2);
			break;
			case 3: ResetPlayerButtons(P3);
			break;
			case 4: ResetPlayerButtons(P4);
			break;
			default: ResetPlayerButtons(P1);
			break;
		}
	}
	
	
	//Actions **********************************************************************************
	
	/**
	 * Called when any button is clicked
	 * @param e used to find the source of the call
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(MainGameLoop.Settings[3].equals("true"))
		{
			PlayClick();
		}
		
		
		//Player select buttons
		if(e.getSource().equals(P1))
		{
			ChangePlayers("1");
			P1.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P1);
		}
		if(e.getSource().equals(P2))
		{
			ChangePlayers("2");
			P2.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P2);
		}
		if(e.getSource().equals(P3))
		{
			ChangePlayers("3");
			P3.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P3);
		}
		if(e.getSource().equals(P4))
		{
			ChangePlayers("4");
			P4.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P4);
		}
				
				
		//Flip through hand buttons
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
			//Action buttons
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
			
		}
		else
		{
			//Wild card buttons
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
		
		//Help buttons
		if(e.getSource().equals(HowToPlay))
		{
			ShowHowToPlay();
		}
		if(e.getSource().equals(Settings))
		{
			ShowSettings();
		}
		

	}
	
	/**
	 * Shows the settings file
	 */
	public void ShowSettings()
	{
		if (Desktop.isDesktopSupported()) 
		{
		
			String FilePath = FileManager.Home + "/Settings.json";
		    try 
		    {
		    	System.out.println("Settings are deliminated as follows");
		    	System.out.println("Colors/Wild Draw Amount/Amount of each color card/Play Sound Effect");
		    	System.out.println("Only four colors are used");
		    	System.out.println("Supported colors are: Red, Blue, Green, Yellow, Orange, Magenta, & Cyan");
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
			
			String FilePath  = FileManager.Home + "/HTP.json";
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
	
	/**
	 * Changes the amount of players
	 * @param input the new amount of players
	 */
	public void ChangePlayers(String input)
	{
		try 
		{
		
			String FilePath3  = FileManager.Home + "/Players.json";
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
	 * Hides the buttons on game end
	 */
	public void hideButtons()
	{
		SetupButton(Settings, -1111, 480, 100, 20);
		SetupButton(HowToPlay,-1111, 480, 100, 20);
		SetupButton(SkipTurn, -1111, 0, Color.black);
		SetupButton(Play, -1111, 400, Color.black);
		SetupButton(FlipCurentHand,-1111,400, Color.black);
		SetupButton(FlipCurentHandBack, -1111,400, Color.black);
	}
	
	/**
	 * Plays the button click
	 */
	public void PlayClick()
	{
		if(clip != null)
		{
			clip.start();
			clip.setMicrosecondPosition(0);
		}

	}
	
	/**
	 * Returns the object as a string
	 */
	public String toString()
	{
		String s = canPlay + "," + panel;
		
		return s;
	}
}
