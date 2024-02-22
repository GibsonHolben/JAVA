import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

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
	boolean canPlay = true;
	
	//JComponents*************************************
	/**
	 * A JButton that closes the game
	 * Text = X
	 */
	static JButton 			Close 				= new JButton("X");
	
	/**
	 * Holds the JButtons that are used to select the cards
	 */
	public JButton[] 		CardButtons 		= new JButton[10];
	
	/**
	 * A JButton that calls flipTheCurrentDeck
	 * Text = Flip
	 */
	public static JButton 	FlipCurentHand 		= new JButton("Flip >");
	/**
	 * A JButton that calls flipTheCurrentDeck backwards
	 * Text = Flip
	 */
	public static JButton 	FlipCurentHandBack 	= new JButton("< Flip");
	
	/**
	 * A JButton that shows the how to play 
	 * Text = How To Play
	 */
	static JButton 			HowToPlay 			= new JButton("How to play");
	
	/**
	 * The main panel
	 */
	MyPannel 				Panel;
	
	/**
	 * A JButton that calls play on the current player
	 */
	public static JButton 	Play 				= new JButton();
	
	/**
	 * A JButton that resets the game
	 * Text = Play Again?
	 */
	static JButton 			Reset 				= new JButton("Play Again?");
	
	/**
	 * A JButton that skips the active players turn
	 * Text = Skip
	 */
	public static JButton 	SkipTurn 			= new JButton("Skip");
	
	/**
	 * A JButton that calls start
	 * Text = Start
	 */
	static JButton 			Start 				= new JButton("Start");

	/**
	 * A JButton that shows the settings
	 * Text = Settings
	 */
	static JButton 			SettingsButton 		= new JButton("Settings");




	//ColorChanges
	/**
	 * Changes the color of the main deck to red
	 * Text = Settings.ColorsBackup[0]
	 */
	static JButton 			Red 				= new JButton(Settings.ColorsBackup[0]);
	
	/**
	 * Changes the color of the main deck to blue
	 * Text = Settings.ColorsBackup[1]
	 */
	static JButton 			Blue 				= new JButton(Settings.ColorsBackup[1]);
	
	/**
	 * Changes the color of the main deck to green
	 * Text = Settings.ColorsBackup[2]
	 */
	static JButton 			Green 				= new JButton(Settings.ColorsBackup[2]);
	
	/**
	 * Changes the color of the main deck to yellow
	 * Text = Settings.ColorsBackup[3]
	 */
	static JButton 			Yellow 				= new JButton(Settings.ColorsBackup[3]);
	
	
	//Player select
	/**
	 * Sets the amount of players to 2
	 * Text = 2 Player
	 */
	static JButton 			P2 					= new JButton("2 Players");
	
	/**
	 * Sets the amount of players to 3
	 * Text = 3 Player
	 */
	static JButton 			P3 					= new JButton("3 Players");
	
	/**
	 * Sets the amount of players to 4
	 * Text = 4 Player
	 */
	static JButton 			P4 					= new JButton("4 Players");
	
	/***
	 * The array of buttons
	 */
	static JButton[] 		Buttons 			= {P2, 
												   P3, 
												   P4, 
												   Play,
												   Start, 
												   SettingsButton, 
												   SkipTurn, 
												   HowToPlay, 	
												   FlipCurentHand, 
												   FlipCurentHandBack, 
												   Red, Blue, Green, Yellow};
								
	//SFX*************************************
	/**2
	 * the audio stream of the button click
	 */
	public AudioInputStream ButtonStream;
	
	/**
	 * the audio stream of the music
	 */
	public AudioInputStream MusicStream;	
	
	/**
	 * The audio clip of the button click
	 */
	public Clip 			ButtonClip;
	
	/**
	 * The audio clip of the music
	 */
	public Clip 			MusicClip;
	
	//Events*************************************
	/**
	 * Handles the button click events
	 */
	public EventHandler 	Handler 			= new EventHandler();
	
	/**
	 * Used to get mouse over funtions
	 */
	Hover 					Hover 				= new Hover(Buttons);
	
	
	
	
	/**
	 * Creates the frame and gets the buttons setup
	 * @param newColor	the color of the main deck
	 * @param newText	the number of the main deck
	 */
	MyFrame(Color newColor, String newText)
	{ 		
		//Set up the sfx
		System.out.println(MainGameLoop.Settings[3]);
		SetSfx();
		
		//Setups the top bar
		URL url = MyPannel.class.getResource("img/Uno.png");
		ImageIcon img = new ImageIcon(url);
		this.setIconImage(img.getImage());
		this.setTitle("UNO");

		//Sets up the panel
		Panel = new MyPannel(newColor, newText);
		this.dispose();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(				  true);
		WindowSettup();
		
		//Setups the buttons
		Setup.Button(SettingsButton, 	10,   980, 200,  40, Panel);
		Setup.Button(HowToPlay, 		1710, 980, 200,  40, Panel);
		Setup.Button(P2, 				595,  900, 200, 120, Panel);
		Setup.Button(Start,				800,  900, 200, 120, Panel);
		Setup.Button(P3, 				1005, 900, 200, 120, Panel);
		Setup.Button(P4, 				1210 ,900, 200, 120, Panel);
		Setup.Button(Close,   			1870,   0,  50,  50, Panel);
		
		try
		{
			for(int i = 0; i < Buttons.length - 4; i++) 
			{
				Buttons[i].removeActionListener(Handler);
				Buttons[i].removeMouseListener(Hover);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//Add the needed listeners
		for(int i = 0; i < Buttons.length - 4; i++) 
		{
			Buttons[i].addActionListener(Handler);
			Buttons[i].addMouseListener(Hover);
		}
		Close.addActionListener(Handler);
		
		//Repaints the player select buttons
		P2.repaint();
		P3.repaint();
		P4.repaint();
		Start.repaint();
		P2.setVisible(true);
		P3.setVisible(true);
		P4.setVisible(true);
		SetupPlayeBttonColors();
		
		//Sets the frame visible
		this.setVisible(true);
	}
	
	/**
	 * Creates the buttons in the players hand and sets them invisable
	 */
	public void CreateCardButtons()
	{
		for(int i = 1; i < 10; i++)
		{
			if(i > 5)
			{
				CardButtons[i] = new JButton();
				Setup.Button(CardButtons[i], i * 100, 295 + 320, 90, 280, Panel);	
			}
			else
			{
				CardButtons[i] = new JButton();
				CardButtons[i].setOpaque(false);
				Setup.Button(CardButtons[i], i * 100, 295 + 320, 90, 400, Panel);
				
			}
			CardButtons[i].setOpaque(false);
			CardButtons[i].setContentAreaFilled(false);
			CardButtons[i].setBorderPainted(false);
			CardButtons[i].addActionListener(Handler);	
		}	
	}
	
	/**
	 * Hides the buttons on game end
	 */
	public void HideButtons()
	{
        for (JButton button : Buttons)
        {
            Setup.Button(button, -1000, -1000, 0, 0, Panel);
        }
	}
	
	/**
	 * Makes the background music loop
	 */
	public void LoopMusic()
	{
		if(MainGameLoop.Settings[3].equals("true"))
		{
			MusicClip.loop(Clip.LOOP_CONTINUOUSLY);
			MusicClip.start();
		}
	}
	
	
	/**
	 * Plays a button click Sound effect
	 */
	public void PlayClick()
	{
		if(ButtonClip != null)
		{
			ButtonClip.start();
			ButtonClip.setMicrosecondPosition(0);
		}

	}
	
	
	/**
	 * Redraws the JFrame (start of the game)
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void Reset(Color newColor, String newText)
	{
		CreateCardButtons();
		if(MainGameLoop.isRunning)
		{
			this.requestFocus();
			WindowSettup();
			Panel.repaint();
			Panel.MainDeckColor = newColor;
			Panel.MainDeckText = newText;
			Panel.setLayout(null);
			Panel.remove(Start);
			Panel.remove(P2);
			Panel.remove(P3);
			Panel.remove(P4);
			Setup.Button(SettingsButton, 		10, 1020, 200, 40, Panel);
			Setup.Button(HowToPlay, 			1710, 1020, 200, 40, Panel);
			Setup.Button(SkipTurn, 				104, 400, 200, 40, Panel);
			Setup.Button(Play,					1500, 610, 200, 400, Panel);
			Setup.Button(FlipCurentHand,		294,400, 200, 40, Panel);
			Setup.Button(FlipCurentHandBack,	0,400, 200, 40, Panel);
			Setup.Button(Close,   				1870, 0, 50, 50, Panel);

			Play.setOpaque(false);
			Play.setContentAreaFilled(false);
			Play.setBorderPainted(false);
			
			
			ResetFonts(Play, 10);
			this.setVisible(true);
		}

	}
	
	
	/**
	 * Sets the font on a jbutton
	 * @param Jb the button that the font is changed on
	 * @param fontsize the new size of the font
	 */
	public void ResetFonts(JButton Jb, int fontsize)
	{
		Jb.setFont(new Font("URW Grotesk", Font.BOLD, fontsize));
	}
	
	
	/**
	 * Redraws the JFrame for the players hand and runs a check to see if the game should end
	 * @param newColor the new color of tha card
	 * @param newText the new text on the card
	 */
	public void ResetPlayerhand(Color newColor, String newText)
	{
		if(MainGameLoop.isGameStarted)
		{
			for(int i = 0; i < MainGameLoop.Players.size(); i++)
			{
				if(MainGameLoop.Players.get(i).MyDeck.Cards.isEmpty())
				{
					MainGameLoop.CurentWinPlayer = MainGameLoop.CurentPlayer;
					System.out.println("Game over");
					System.out.println(MainGameLoop.Players.get(i).Name + " Wins");
					MainGameLoop.isRunning = false;
					Panel.repaint();
					this.HideButtons();
					Setup.Button(Reset,850,900, 200, 120, Panel);
					Reset.addActionListener(Handler);
					Reset.setVisible(		true);
					break;
				}
			}
		}

		if(MainGameLoop.isRunning)
		{
			this.requestFocus();
			WindowSettup();
			Panel.repaint();
			Panel.PlayerDeckColor = newColor;
			Panel.PlayerDeckText = newText;
			Panel.setLayout(null);
			Panel.remove(Start);
			Setup.Button(Play, 600 + 900, 610, 200, 400, Panel);
			Setup.Button(FlipCurentHandBack, 620, 900, 200, 120, Panel);
			Setup.Button(SkipTurn, 830, 900, 200, 120, Panel);
			Setup.Button(FlipCurentHand, 1040, 900, 200, 120, Panel);


            for (JButton button : Buttons) {
                button.setFocusPainted(false);
                button.setBackground(Color.white);
            }

			Play.setOpaque(false);
			Play.setContentAreaFilled(false);
			Play.setBorderPainted(false);
			Play.setForeground(Color.white);
			this.setVisible(true);
		}

	}
	
	/**
	 * Resets the colors of the buttons
	 * @param Button the button that is held down
	 */
	public void ResetPlayerButtons(JButton Button)
	{
		P2.setBackground(Color.white);
		P3.setBackground(Color.white);
		P4.setBackground(Color.white);
		Button.setBackground(Color.lightGray);
	}
	
	//Settups *******************************
	/**
	 * Sets up the player selector colors on startup based on what 
	 * was saved from last use
	 */
	public void SetupPlayeBttonColors()
	{
		try
		{
			File PlayerObj = new File( FileManager.Home+ "/Players" + FileManager.FILEEXTENTION);
			Scanner PlayerReader;
			PlayerReader = new Scanner(PlayerObj);
			String PlayerInput = PlayerReader.nextLine();
			PlayerReader.close();

			switch((Integer.parseInt(PlayerInput)))
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
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(this,
							"Could not get settings file... Refactoring...");
			Setup.FixColors();
		}
	}
	
	/**
	 * Sets up the music
	 */
	public void SetSfx()
	{
		//setups the sfx 
		File ButtonClickFile = new File("src/sfx/ButttonClick.wav");
		File BKGMusicFile = new File("src/sfx/Bkg.wav");
		try 
		{
			ButtonStream = AudioSystem.getAudioInputStream(ButtonClickFile);
			ButtonClip = AudioSystem.getClip();
			ButtonClip.open(ButtonStream);
			
			MusicStream = AudioSystem.getAudioInputStream(BKGMusicFile);
			MusicClip = AudioSystem.getClip();
			MusicClip.open(MusicStream);
		} 
		catch (UnsupportedAudioFileException | LineUnavailableException | IOException e)
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
		Panel.repaint();
		JButton[] ColorB = {Red, Blue, Green, Yellow};
		for(int i = 0; i < ColorB.length; i++)
		{

			ColorB[i].setBounds(400 + (i * 200) +  10 + (i * 10),position, 200, 120);
			Panel.add(							ColorB[i]);
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
	public void WindowSettup()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(					  Panel);
		this.setLocationRelativeTo(	  null);
		this.setAlwaysOnTop(		  true);
		this.setName(				  "UNO");
		this.setResizable(			  false);
		this.setVisible(			  true);
		Panel.setLayout(			  null);
		this.pack();
	}
	
}
