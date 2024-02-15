import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * The settings menu of the game, used as an interface for the file Uno/Settings.ini
 * @author CTEHolbenG46
 * @version 1.2.5
 */

@SuppressWarnings("serial")
public class Settings extends JFrame
{
	/**
	 * The array that hold the indexes of the combo box
	 */
	String[] 				DeckSizeArray 		= new String[98];
	
	/**
	 * The input field for the amount of cards in the deck
	 * Default = a new JText
	 */
	JComboBox<String> 		DeckSizeCombo 		= new JComboBox<String>();
	
	/**
	 * Checks if it is the first time the button is clicked
	 * Default = false
	 */
	public static boolean 	doneOnce 			= false;
	
	/**
	 * The main panel of the game
	 */
	JPanel 					Panel 				= new JPanel();
	
	/**
	 * Resets the settings of the game
	 * Text = Reset Settings
	 */
	JButton 				Reset 				= new JButton("Reset Settings");
	
	/**
	 * Generates a log of the game
	 * Text = Print Log
	 */
	JButton 				GenerateLog 		= new JButton("Print Log");
	
	/**
	 * The button for the sfx
	 * Text = SFX/ON
	 */
	JButton 				SfxToggle 			= new JButton("SFX/ON");
	
	/**
	 * Sumbits the settings fro the wild card settings
	 * Text = Submit
	 */
	JButton 				SubmitWildCardSize 	= new JButton("Submit");
	
	/**
	 * Sumbits the settings for the wild card settings
	 * Text = Submit
	 */
	JButton 				SubmitDeckSize 		= new JButton("Submit");
	
	/**
	 * Sumbits the settings for the colors
	 * Text = Submit Colors
	 */
	JButton 				SubmitColors 		= new JButton("Submit Colors");
	
	/**
	 * The input field for the wild card draw
	 * Default = a new JText
	 */
	JComboBox<String> 		WildCardDrawCombo 	= new JComboBox<String>();
	
	
	
	//Dropdown menus
	/**
	 * The dropdown menu for color 1
	 * Array = ACCEPTEDCOLORS
	 */
	JComboBox<String> 		Color1Combo 		= new JComboBox<String>(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for color 2
	 * Array = ACCEPTEDCOLORS
	 */
	JComboBox<String> 		Color2Combo 		= new JComboBox<String>(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for color 3
	 * Array = ACCEPTEDCOLORS
	 */
	JComboBox<String> 		Color3Combo 		= new JComboBox<String>(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for color 4
	 * Array = ACCEPTEDCOLORS
	 */
	JComboBox<String> 		Color4Combo 		= new JComboBox<String>(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for the background color
	 * Array = ACCEPTEDCOLORS
	 */
	JComboBox<String> 		ColorBackground 	= new JComboBox<String>(ACCEPTEDCOLORS);
	
	/**
	 * The buttons that are used in the settings
	 */
	public JButton[] 		Buttons 			= {SfxToggle, 
												   Reset,
												   SubmitWildCardSize,
												   SubmitDeckSize,
												   SubmitColors,
												   GenerateLog};
	
	/**
	 * Mouse over events
	 */
	Hover 					Hover 				= new Hover(Buttons);
	
	
	//FINALS
	/**
	 * A list of all aceptable colors in the settings
	 */
	static final String[] 	ACCEPTEDCOLORS 		= {"Red",
												   "Blue", 
												   "Green", 
												   "Yellow", 
												   "Magenta", 
												   "Cyan", 
												   "Orange",
												   "Grey"};		
	
	/**
	 * Holds the 4 colors of the cards in the game
	 */
	public static String[]  ColorsBackup 		= new String[4];
	

	/**
	 * Creates a settings form and sets up all the buttons needed for the menu
	 */
	Settings()
	{
		this.requestFocus();
		
		//Setups the top bar
		SettupSettings();
		SettupLoops();
		SetComboBoxes();
		
		//Sets up the details
		WildCardDrawCombo.setBounds(new Rectangle(105, 40, 135, 20));
		DeckSizeCombo.setBounds(new Rectangle(245, 40, 135, 20));
		
		//The color drop down menus
		@SuppressWarnings("rawtypes")
		JComboBox[] Boxes = {Color1Combo, Color2Combo, Color3Combo, Color4Combo};
		for(int i = 0; i < Boxes.length; i++)
		{
			Panel.add(Setup.CreateLabel(i * 105, 90, 100, 20, "Colors"));
			Boxes[i].setBounds(i * 105, 110, 100, 20);
		}
		
		//Sets the item in the boxes
		WildCardDrawCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[1]) - 1);
		DeckSizeCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[2]) - 1);
		
		//Adds the components to the panel
		Panel.add(WildCardDrawCombo);
		Panel.add(DeckSizeCombo);
		Panel.add(Setup.CreateLabel(105, 20, 135, 20, "Wild card draw amount"));
		Panel.add(Setup.CreateLabel(245, 20, 135, 20, "Card amount"));
		Panel.add(Color1Combo);
		Panel.add(Color2Combo);
		Panel.add(Color3Combo);
		Panel.add(Color4Combo);
		
		Panel.add(Setup.CreateLabel(0, 130, 100, 20, "Background color"));
		ColorBackground.setBounds(0, 150, 100, 20);
		Panel.add(ColorBackground);
		//Sets up the buttons
		this.setLayout(null);
		Setup.Button(SfxToggle, 					0, 	 25,  100, 60,  	Panel);
		Setup.Button(Reset, 				0, 	 440, 150, 60, 		Panel);
		Setup.Button(SubmitWildCardSize, 	105, 65,  135, 20,  	Panel);
		Setup.Button(SubmitDeckSize, 		245, 65,  135, 20, 		Panel);
		Setup.Button(SubmitColors, 			350, 440, 150, 60, 		Panel);
		Setup.Button(GenerateLog, 			175, 440, 150, 60, 		Panel);
				
		//Sets teh background color
		Panel.setBackground(MyPannel.BackgroundColor());
		
		//Sets the form visible
		this.setVisible(true);

	
	}

	/**
	 * Turns off the sound effects in the game
	 */
	public void ChangeSfx()
	{
		System.out.println(MainGameLoop.Settings[3]);
		if(MainGameLoop.Settings[3].equals("true"))
		{
			MainGameLoop.Settings[3] = "false";
			SfxToggle.setText("SFX/OFF");
			System.out.println("Sfx are now off");
			MainGameLoop.Frame.MusicClip.close();
			MainGameLoop.Frame.MusicClip.stop();
			MainGameLoop.Frame.ButtonClip.close();
			MainGameLoop.Frame.ButtonClip.stop();
		}
		else if(MainGameLoop.Settings[3].equals("false"))
		{
			MainGameLoop.Settings[3] =  "true";
			SfxToggle.setText(			"SFX/ON");
			System.out.println(			"Sfx are now on");
			MainGameLoop.Frame.SetSfx();
		}
	}
	
	/**
	 * Sets up all the things that need loops
	 */
	public void SettupLoops()
	{
		//Adds the action listeners
        for (JButton button : Buttons) 
        {
            button.addActionListener(MainGameLoop.Frame.Handler);
            button.addMouseListener(Hover);
        }
				
		//Sets up the drop-down menu
		for(int i = 0; i < DeckSizeArray.length; i++)
		{
			DeckSizeArray[i] = Integer.toString(i);
		}
		
		//Dropdowns
		DeckSizeCombo = new JComboBox<String>(DeckSizeArray);
		String[] AllowedWildCardDraw = {"1","2","3","4","5","6","7","8","9"};
		WildCardDrawCombo = new JComboBox<String>(AllowedWildCardDraw);
				
		//Sets up the sfx 
		if(MainGameLoop.Settings[3].equals("true"))
		{
			SfxToggle.setText("SFX/ON");
			System.out.println("Sfx are now on");
		}
		else
		{
			SfxToggle.setText("SFX/OFF");
			System.out.println("Sfx are now off");
		}
	}
	
	
	/**
	 * Sets us the settings menu with all the needed things
	 */
	public void SettupSettings()
	{
		URL url = MyPannel.class.getResource(	"img/Uno.png");
		ImageIcon img = new ImageIcon(			url);
		this.setIconImage(						img.getImage());
		this.setTitle(							"Settings");
		this.setDefaultCloseOperation(			JFrame.DISPOSE_ON_CLOSE);
		Panel.setPreferredSize(					new Dimension(500, 500));
		Panel.setLayout(					  	null);
		this.add(								Panel);
		Panel.setVisible(						true);
		this.setLocationRelativeTo(				null);
		this.setAlwaysOnTop(					true);
		this.setName(							"Settings");
		this.pack();
	}
	
	/**
	 * Used to submit the settings and check if they are good
	 * @return true if the settigns are accepted, false if not
	 * @param Setting the setting that is to be submited
	 */
	public boolean SubmitSetting(String Setting)
	{
		if(Setting.equals("Wild"))
		{
			try
			{
				Integer.parseInt(WildCardDrawCombo.getSelectedItem().toString());
				if(Integer.parseInt(WildCardDrawCombo.getSelectedItem().toString()) > 9 ||
						Integer.parseInt(WildCardDrawCombo.getSelectedItem().toString()) < 1)
				{
					MainGameLoop.Settings[1] = "4";
					return false;
				}
				else
				{
					MainGameLoop.Settings[1] = WildCardDrawCombo.getSelectedItem().toString();
				}
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Please enter a number");
				WildCardDrawCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[1]) - 1);
				return false;
			}
		}
		else if(Setting.equals("Deck"))
		{
			try
			{
				Integer.parseInt(DeckSizeCombo.getSelectedItem().toString());
				
				if(Integer.parseInt(DeckSizeCombo.getSelectedItem().toString()) > 99 || 
						Integer.parseInt(DeckSizeCombo.getSelectedItem().toString()) < 4)
				{
					MainGameLoop.Settings[2] = "11";
					return false;
				}
				else
				{
					MainGameLoop.Settings[2] = DeckSizeCombo.getSelectedItem().toString();
				}
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Please enter a number");
				DeckSizeCombo.setSelectedIndex(Integer.parseInt(MainGameLoop.Settings[2]) - 1);
				return false;
			}
		}
		else
		{
			return(false);
		}
		
		
	}
	
	/**
	 * Saves the settings to a file
	 */
	public void SaveSettings()
	{
		String SettingsPath = FileManager.Home + 
									"/Settings" + 
									FileManager.FILEEXTENTION;
		
		String Settings = "";
		
		for(int i = 0; i < MainGameLoop.Settings.length; i++)
		{
			Settings = Settings + MainGameLoop.Settings[i] + "/";
		}
		
		try
	    {
	    	FileWriter SettingsWriter = new FileWriter(SettingsPath);
		    SettingsWriter.write(Settings);
		    SettingsWriter.close();
		    System.out.println("Successfully wrote to the file.");		     
	    }
	    catch (IOException e)
	    {
	    	System.out.println("An error occurred while saving the file");
		    e.printStackTrace();
	    }
	    catch (Exception e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}     
	}
	
	
	/**
	 * Sets up the combo boxes with the correct text
	 */
	public void SetComboBoxes()
	{
		@SuppressWarnings("rawtypes")
		JComboBox[] ComboBoxes = {Color1Combo, Color2Combo, Color3Combo, Color4Combo};
		
		for(int i = 0; i < ComboBoxes.length; i++)
		{
			for(int j = 0; j < ACCEPTEDCOLORS.length; j++)
			{
				if(ColorsBackup[i].equals(ACCEPTEDCOLORS[j]))
				{
					ComboBoxes[i].setSelectedIndex(j);
				}
			}
		}
		
		for(int i = 0; i < ACCEPTEDCOLORS.length; i++)
		{
			if(MainGameLoop.Settings[4].equals(ACCEPTEDCOLORS[i]))
			{
				ColorBackground.setSelectedIndex(i);
			}
		}
	}
}
