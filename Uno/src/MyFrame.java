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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.URL;

/**
 * Used for the high level graphics such as the Buttons and holding all the 
 * button actions
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
	static JButton 			Red = new JButton(Card.ColorsBackup[0]);
	
	/**
	 * Changes the color of the main deck to blue
	 */
	static JButton 			Blue = new JButton(Card.ColorsBackup[1]);
	
	/**
	 * Changes the color of the main deck to green
	 */
	static JButton 			Green = new JButton(Card.ColorsBackup[2]);
	
	/**
	 * Changes the color of the main deck to yellow
	 */
	static JButton 			Yellow = new JButton(Card.ColorsBackup[3]);
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
	public Clip 					clipButton;
	
	/**2
	 * the audio stream of the button click
	 */
	public AudioInputStream 		AudioStreamButton;
	
	/**
	 * The audio clip of the music
	 */
	public Clip 					clipMusic;
	
	/**
	 * the audio stream of the music
	 */
	public AudioInputStream 		AudioStreamMusic;	
      
	
	/**
	 * Creates the frame and gets the buttons setup
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 
		//Key listener
		this.requestFocus();
		
		System.out.println(MainGameLoop.Settings[3]);
		SetSfx();
		
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
		Setup.Button(Settings, 	0, 480, 100, 20, panel);
		Setup.Button(HowToPlay, 	100, 480, 100, 20, panel);
		Setup.Button(P1, 		2,400, panel);
		Setup.Button(P2, 		104,400, panel);
		Setup.Button(Start,		206,400, panel);
		Setup.Button(P3, 		308,400, panel);
		Setup.Button(P4, 		410,400, panel);
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
		
		
		this.requestFocus();
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
		Setup.Button(Settings, 			0, 480, 100, 20, panel);
		Setup.Button(HowToPlay, 			104, 480, 100, 20, panel);
		Setup.Button(SkipTurn, 			104, 400, panel);
		Setup.Button(Play,				395, 300, 100, 200, panel);
		Setup.Button(FlipCurentHand,		294,400, panel);
		Setup.Button(FlipCurentHandBack,	0,400, panel);
		
		Play.setOpaque(false);
		Play.setContentAreaFilled(false);
		Play.setBorderPainted(false);
		resetFonts(Play, 10);
		this.setVisible(true);
	}
	
	/**
	 * Loops the background music
	 */
	public void LoopMusic()
	{
		
		if(MainGameLoop.Settings[3].equals("true"))
		{
			clipMusic.loop(Clip.LOOP_CONTINUOUSLY);
			clipMusic.start();
		}
	}
	
	
	/**
	 * Redraws the JFrame 
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void resetPlayerhand(Color newColor, String newText)
	{
		this.requestFocus();
		windowSettup();
		panel.repaint();
		panel.PlayerDeckColor = newColor;
		panel.PlayerDeckText = newText;
		panel.setLayout(null);
		panel.remove(Start);
		Setup.Button(Play,				395, 300, 100, 200, panel);
		Setup.Button(FlipCurentHandBack,	0,400, panel);
		Setup.Button(SkipTurn, 			104, 400, panel);
		Setup.Button(FlipCurentHand, 	208,400, panel);


		
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
	 * Sets up the player selector colors on startup based on what 
	 * was saved from last use
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
	
	/**
	 * Sets up the music
	 */
	public void SetSfx()
	{
		//setups the sfx 
		File file = new File("src/ButttonClick.wav");
		File file2 = new File("src/Bkg.wav");
		try 
		{
			AudioStreamButton = AudioSystem.getAudioInputStream(file);
			clipButton = AudioSystem.getClip();
			clipButton.open(AudioStreamButton);
			
			AudioStreamMusic = AudioSystem.getAudioInputStream(file2);
			clipMusic = AudioSystem.getClip();
			clipMusic.open(AudioStreamMusic);
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
		
		LoopMusic();
	}
	
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
			ColorB[i].setBounds(				(i * 100) +  (i * 4),
												position, 100, 60);
			panel.add(					ColorB[i]);
			ColorB[i].addActionListener(		this);
			ColorB[i].setFocusPainted(		false);
			ColorB[i].setBackground(			Color.white);
			ColorB[i].setBorder(				new LineBorder(Color.black, 2));
			Setup.Fonts(ColorB[i], 15);
		}
	}
	
	
	//Actions *******************************************
	
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
			FileManager.ChangePlayers("1");
			P1.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P1);
		}
		if(e.getSource().equals(P2))
		{
			FileManager.ChangePlayers("2");
			P2.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P2);
		}
		if(e.getSource().equals(P3))
		{
			FileManager.ChangePlayers("3");
			P3.setVisible(true);
			this.setVisible(true);
			ResetPlayerButtons(P3);
		}
		if(e.getSource().equals(P4))
		{
			FileManager.ChangePlayers("4");
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
				Setup.initGame();
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
				MainGameLoop.CurentColor = Card.ColorsBackup[0];
				canPlay = true;
				System.out.println(MainGameLoop.CurentColor);
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Blue))
			{
				MainGameLoop.CurentColor = Card.ColorsBackup[1];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Green))
			{
				MainGameLoop.CurentColor = Card.ColorsBackup[2];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}
			
			if(e.getSource().equals(Yellow))
			{
				MainGameLoop.CurentColor = Card.
						ColorsBackup[3];
				canPlay = true;
				MainGameLoop.NextPlayer();
				SettupColorButtons(-1000);
			}	
		}
		
		//Help buttons
		if(e.getSource().equals(HowToPlay))
		{
			FileManager.ShowHowToPlay();
		}
		if(e.getSource().equals(Settings))
		{
			//FileManager.ShowSettings();
			Settings s = new Settings();
		}
		

	}
	
	
	
	/**
	 * Hides the buttons on game end
	 */
	public void hideButtons()
	{
		Setup.Button(Settings, -1111, 480, 100, 20, panel);
		Setup.Button(HowToPlay,-1111, 480, 100, 20, panel);
		Setup.Button(SkipTurn, -1111, 0, panel);
		Setup.Button(Play, -1111, 400, panel);
		Setup.Button(FlipCurentHand,-1111,400, panel);
		Setup.Button(FlipCurentHandBack, -1111,400, panel);
	}
	
	/**
	 * Plays the button click
	 */
	public void PlayClick()
	{
		if(clipButton != null)
		{
			clipButton.start();
			clipButton.setMicrosecondPosition(0);
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
