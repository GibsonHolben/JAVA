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
import java.io.*;
import java.net.URL;

/**
 * Used for the high level graphics such as the Buttons and holding all the 
 * button actions
 * @author CTEHolbenG46
 * @version 13.3.6
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame
{
	/**
	 * Can the user play
	 * default = true
	 */
	boolean 				canPlay = true;
	
	/**
	 * A JButton that calls flipTheCurentDeck
	 * Text = Flip >
	 */
	public static JButton 	FlipCurentHand = new JButton("Flip >");
	/**
	 * A JButton that calls flipTheCurentDeck backwards
	 * Text = < Flip
	 */
	public static JButton 	FlipCurentHandBack = new JButton("< Flip");
	
	/**
	 * A JButton that shows the how to play 
	 * Text = How To Play
	 */
	static JButton 			HowToPlay = new JButton("How to play");
	
	/**
	 * The main panel
	 */
	MyPannel 				panel;
	
	/**
	 * A JButton that calls play on the current player
	 */
	public static JButton 	Play = new JButton();
	
	/**
	 * A JButton that skips the active players turn
	 * Text = Skip
	 */
	public static JButton 	SkipTurn = new JButton("Skip");
	
	/**
	 * A JButton that calls start
	 * Text = Start
	 */
	static JButton 			Start = new JButton("Start");

	/**
	 * A JButton that shows the settings
	 * Text = Settings
	 */
	static JButton 			SettingsButton = new JButton("Settings");

	/**
	 * A JButton that resets the game
	 * Text = Play Again?
	 */
	static JButton 			Reset = new JButton("Play Again?");

	/**
	 * A JButton that closes the game
	 * Text = X
	 */
	static JButton 			Close = new JButton("X");

	//ColorChanges
	/**
	 * Changes the color of the main deck to red
	 * Text = Settings.ColorsBackup[0])
	 */
	static JButton 			Red = new JButton(Settings.ColorsBackup[0]);
	
	/**
	 * Changes the color of the main deck to blue
	 * Text = Settings.ColorsBackup[1])
	 */
	static JButton 			Blue = new JButton(Settings.ColorsBackup[1]);
	
	/**
	 * Changes the color of the main deck to green
	 * Text = Settings.ColorsBackup[2])
	 */
	static JButton 			Green = new JButton(Settings.ColorsBackup[2]);
	
	/**
	 * Changes the color of the main deck to yellow
	 * Text = Settings.ColorsBackup[3])
	 */
	static JButton 			Yellow = new JButton(Settings.ColorsBackup[3]);
	
	
	//Player select
	/**
	 * Sets the amount of players to 2
	 * Text = 2 Player
	 */
	static JButton 			P2 = new JButton("2 Players");
	
	/**
	 * Sets the amount of players to 3
	 * Text = 3 Player
	 */
	static JButton 			P3 = new JButton("3 Players");
	
	/**
	 * Sets the amount of players to 4
	 * Text = 4 Player
	 */
	static JButton 			P4 = new JButton("4 Players");
	
	//The array of buttons
	static JButton[] Buttons = {P2, 
								P3, 
								P4, 
								Play,
								Start, 
								Reset, 
								SettingsButton, 
								SkipTurn, 
								HowToPlay, 
								FlipCurentHand,
								FlipCurentHandBack,
								Red, 
								Blue, 
								Green, 
								Yellow};
	//SFX
	/**2
	 * the audio stream of the button click
	 */
	public AudioInputStream AudioStreamButton;
	
	/**
	 * the audio stream of the music
	 */
	public AudioInputStream AudioStreamMusic;	
	
	/**
	 * The audio clip of the button click
	 */
	public Clip 			clipButton;
	
	/**
	 * The audio clip of the music
	 */
	public Clip 			clipMusic;
	
	/**
	 * An array of all the clips in the game
	 */
	Clip[] 			Clips = {clipButton, clipMusic};
	
	/**
	 * And array of the AudioStreams in the game
	 */
	AudioInputStream[] 		Audios = { AudioStreamButton, AudioStreamMusic};
	
	//Events
	/**
	 * Handers the button click events
	 */
	public EventHandler 	Handler = new EventHandler();
	
	/**
	 * Used to control the mouse over events
	 */
	Hover 					Hover = new Hover(Buttons);
	
	
	
	/**
	 * Creates the frame and gets the buttons setup
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 
		
		//Key listener
		this.requestFocus();
		
		//Settings SFX
		System.out.println(MainGameLoop.Settings[3]);
		SetSfx();
		
		//Setups the Famicon
		URL url = MyPannel.class.getResource("Uno.png");
		ImageIcon img = new ImageIcon(url);
		this.setIconImage(img.getImage());
		this.setTitle("UNO");
		
		//Sets up the panel
		panel = new MyPannel(newColor, newText);
		this.dispose();
		windowSettup();
		
		int width = this.getSize().width;
		int height = this.getSize().height;
		System.out.println(width + "," + height);
		
		//Setups the buttons
		Setup.Button(SettingsButton, 	10,   980, 200,  40, panel);
		Setup.Button(HowToPlay, 		1710, 980, 200,  40, panel);
		Setup.Button(P2, 				595,  900, 200, 120, panel);
		Setup.Button(Start,				800,  900, 200, 120, panel);
		Setup.Button(P3, 				1005, 900, 200, 120, panel);
		Setup.Button(P4, 				1210, 900, 200, 120, panel);
		Setup.Button(Close,   			width - 1870,   0,  50,  50, panel); //1870
		Close.repaint();
		
		for(int i = 0; i < Buttons.length - 4; i++) 
		{
			Buttons[i].addActionListener(Handler);
			Buttons[i].addMouseListener(Hover);
			Buttons[i].repaint();
			Buttons[i].setVisible(true);
		}
		Close.addActionListener(Handler);
		this.setVisible(true);
		setupPlayeBttonColors();
		

		
	}
	
	
	/**
	 * Hides the buttons on game end
	 */
	public void hideButtons()
	{
		Setup.Button(SettingsButton, 	 -1111, 480, 100, 20, panel);
		Setup.Button(HowToPlay,		 	 -1111, 480, 100, 20, panel);
		Setup.Button(SkipTurn, 		 	 -1111,   0, panel);
		Setup.Button(Play, 			 	 -1111, 400, panel);
		Setup.Button(FlipCurentHand, 	 -1111, 400, panel);
		Setup.Button(FlipCurentHandBack, -1111, 400, panel);
	}
	
	/**
	 * Loops the background music
	 */
	public void LoopMusic()
	{
		
		if(MainGameLoop.Settings[3].equals("true"))
		{
			try
			{
				clipMusic.loop(Clip.LOOP_CONTINUOUSLY);
				clipMusic.start();
			}
			catch(Exception e)
			{
				System.out.println("Could not loop music");
			}
			
		}
	}
	
	/**
	 * Plays the button click sound effect
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
	 * Redraws the JFrame (start of the game)
	 * @param newColor the new color of the card
	 * @param newText the new text on the card
	 */
	public void reset(Color newColor, String newText)
	{
		
		if(MainGameLoop.isRunning)
		{
			
			windowSettup();
			
			//Sets up the game visuals
			panel.repaint();
			panel.MainDeckColor = newColor;
			panel.MainDeckText = newText;
			panel.setLayout(null);
			
			//Removes the main menu buttons
			panel.remove(Start);
			panel.remove(P2);
			panel.remove(P3);
			panel.remove(P4);
			
			//Setup the buttons
			Setup.Button(HowToPlay, 			1710, 980, 200,  40, panel);
			Setup.Button(Play,					1500, 610, 200, 400, panel);
			Setup.Button(SettingsButton, 		10,   980, 200,  40, panel);
			Setup.Button(Close,   				0,    	0,  50,  50, panel);
			Setup.Button(FlipCurentHand,		294,  400, panel);
			Setup.Button(FlipCurentHandBack,	0, 	  400, panel);
			Setup.Button(SkipTurn, 				104,  400, panel);
			
			//Setup player buttons
			Play.setOpaque(false);
			Play.setContentAreaFilled(false);
			Play.setBorderPainted(false);
			resetFonts(Play, 10);
			this.setVisible(true);
		}

	}
	
	
	/**
	 * Sets the font on a JButton
	 * @param Jb the button that the font is changed on
	 * @param fontsize the new size of the font
	 */
	public void resetFonts(JButton Jb, int fontsize)
	{
		Jb.setFont(new Font("URW Grotesk", Font.BOLD, fontsize));
	}
	
	
	/**
	 * Redraws the JFrame for the players hand
	 * @param newColor the new color of the card
	 * @param newText the new text on the card
	 */
	public void resetPlayerhand(Color newColor, String newText)
	{
		if(MainGameLoop.gamestarted)
		{
			for(int i = 0; i < MainGameLoop.Players.size(); i++)
			{
				if(MainGameLoop.Players.get(i).MyDeck.Cards.size() < 1)
				{
					MainGameLoop.CurentWinPlayer = MainGameLoop.CurentPlayer;
					System.out.println(		 "Game over");
					System.out.println( 	 MainGameLoop.Players.get(i).Name + " Wins");
					MainGameLoop.isRunning = false;
					panel.repaint();
					this.hideButtons();
					Setup.Button(			Reset,850,900, 200, 120, panel);
					Reset.addActionListener(Handler);
					Reset.setVisible(		true);
					break;
				}
			}
		}

		if(MainGameLoop.isRunning)
		{
			this.requestFocus();
			windowSettup();
			panel.repaint();
			panel.PlayerDeckColor = newColor;
			panel.PlayerDeckText = newText;
			panel.setLayout(null);
			panel.remove(Start);
			Setup.Button(Play, 				 1500, 610, 200, 400, panel);
			Setup.Button(FlipCurentHandBack, 620,  900, 200, 120, panel);
			Setup.Button(SkipTurn, 			 830,  900, 200, 120, panel);
			Setup.Button(FlipCurentHand, 	 1040, 900, 200, 120, panel);

			JButton[] ButtonsToChange = {Play, 
										 SkipTurn, 
										 FlipCurentHand, 
										 FlipCurentHandBack};
			for(int i = 0; i < ButtonsToChange.length; i++)
			{
				ButtonsToChange[i].setFocusPainted(false);
				ButtonsToChange[i].setBackground(Color.white);
			}

			Play.setOpaque(			  false);
			Play.setBorderPainted(	  false);
			Play.setContentAreaFilled(false);
			
			
			this.setVisible(true);
		}

	}
	
	/**
	 * Resets the colors of the buttons
	 * @param Button the button that is held down
	 */
	public void ResetPlayerButtons(JButton Button)
	{
		P2.setBackground(	 Color.white);
		P3.setBackground(	 Color.white);
		P4.setBackground(	 Color.white);
		Button.setBackground(Color.lightGray);
	}
	
	//Settups *******************************
	/**
	 * Sets up the player selector colors on startup based on what 
	 * was saved from last use
	 */
	public void setupPlayeBttonColors()
	{
		switch(MainGameLoop.Players.size())
		{
			case 2: ResetPlayerButtons(P2);
				break;
			case 3: ResetPlayerButtons(P3);
				break;
			case 4: ResetPlayerButtons(P4);
				break;
			default: ResetPlayerButtons(P2);
				break;
		}
	}
	
	/**
	 * Sets up the music
	 */
	public void SetSfx()
	{
		//setups the sfx 
		File files[] = {new File("src/ButttonClick.wav"),
						new File("src/Bkg.wav")};
		try 
		{

			AudioStreamButton = AudioSystem.getAudioInputStream(files[0]);
			AudioStreamMusic = AudioSystem.getAudioInputStream(files[1]);
			Clips[0] = AudioSystem.getClip();
			Clips[0].open(AudioStreamButton);
			
			Clips[1] = AudioSystem.getClip();
			Clips[1].open(AudioStreamMusic);
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
	 * Sets up the wild card buttons
	 * @param position the position of the button
	 */
	public void SettupColorButtons(int position)
	{
		panel.repaint();
		JButton[] ColorB = {Red, Blue, Green, Yellow};
		for(int i = 0; i < ColorB.length; i++)
		{

			ColorB[i].setBounds(400 + (i * 200) +  10 + (i * 10),position, 200, 120);
			panel.add(							ColorB[i]);
			ColorB[i].addActionListener(		Handler);
			ColorB[i].setFocusPainted(			false);
			ColorB[i].setBackground(			Color.white);
			ColorB[i].setBorder(				new LineBorder(Color.black, 2));
			Setup.Fonts(ColorB[i], 				15);
		}
	}
	
	/**
	 * Sets up the window and general frame settings
	 */
	public void windowSettup()
	{
		this.requestFocus();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setName(				  "UNO");
		this.add(					  panel);
		this.setLocationRelativeTo(	  null);
		this.setAlwaysOnTop(		  true);
		this.setResizable(			  false);
		this.setUndecorated(		  true);
		this.setVisible(			  true);
		panel.setLayout(			  null);
		this.pack();
	}
	
}
