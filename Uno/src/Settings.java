import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */

@SuppressWarnings("serial")
public class Settings extends JFrame implements ActionListener
{
	/**
	 * The input field for the amount of cards in the deck
	 */
	JTextField DeckSizeText = new JTextField(16);
	
	/**
	 * Checks if it is the first time the button is clicked
	 * Default = false
	 */
	public boolean doneOnce = false;
	
	/**
	 * The main panel of the game
	 */
	JPanel panel = new JPanel();
	
	/**
	 * The button for the sfx
	 */
	JButton Sfx = new JButton("SFX/ON");
	
	/**
	 * Sumbits the settings fro the wild card settings
	 */
	JButton SubmitWildCardSize = new JButton("Submit");
	
	/**
	 * Sumbits the settings for the wild card settings
	 */
	JButton SubmitDeckSize = new JButton("Submit");
	
	/**
	 * Sumbits the settings for the colors
	 */
	JButton SubmitColors = new JButton("Submit Colors");
	
	/**
	 * The input field for the wild card draw
	 */
	JTextField WildCardDrawText = new JTextField(16);
	
	
	
	//Dropdown menus
	/**
	 * The dropdown menu for color 1
	 */
	JComboBox Color1Combo = new JComboBox(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for color 2
	 */
	JComboBox Color2Combo = new JComboBox(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for color 3
	 */
	JComboBox Color3Combo = new JComboBox(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for color 4
	 */
	JComboBox Color4Combo = new JComboBox(ACCEPTEDCOLORS);
	
	/**
	 * The dropdown menu for the background color
	 */
	public JComboBox ColorBackground = new JComboBox(ACCEPTEDCOLORS);
	
	/**
	 * A list of all aceptable colors in the settings
	 */
	public static final String[] ACCEPTEDCOLORS = {"Red", "Blue", "Green", "Yellow", "Magenta", "Cyan", "Orange"};
	
	/**
	 * Holds the 4 colors of the cards in the game
	 */
	public static String[] ColorsBackup = new String[4];
	
	
	
	
	/**
	 * Creates a settings form and sets up all the buttons needed for the menu
	 */
	Settings()
	{
		this.requestFocus();
		
		//Setups the top bar
		SettupSettings();
		
		//Adds the action listeners
		Sfx.addActionListener(this);
		SubmitWildCardSize.addActionListener(this);
		SubmitDeckSize.addActionListener(this);
		SubmitColors.addActionListener(this);
		Color1Combo.addActionListener(this);
		
		if(MainGameLoop.Settings[3].equals("true"))
		{
			Sfx.setText("SFX/ON");
			System.out.println("Sfx are now on");
		}
		else
		{
			Sfx.setText("SFX/OFF");
			System.out.println("Sfx are now off");
		}
		
		SetComboBoxes();
		
		//Sets up the details
		WildCardDrawText.setBorder(new LineBorder(Color.black, 2));
		WildCardDrawText.setBounds(new Rectangle(105, 40, 135, 20));
		DeckSizeText.setBorder(new LineBorder(Color.black, 2));
		DeckSizeText.setBounds(new Rectangle(245, 40, 135, 20));
		
		//The color drop down mnus
		panel.add(Setup.CreateLabel(0, 90, 100, 20, "Color One"));
		Color1Combo.setBounds(0, 110, 100, 20);
		
		
		panel.add(Setup.CreateLabel(105, 90, 100, 20, "Color Two"));
		Color2Combo.setBounds(105, 110, 100, 20);
		
		panel.add(Setup.CreateLabel(210, 90, 100, 20, "Color Three"));
		Color3Combo.setBounds(210, 110, 100, 20);
		
		panel.add(Setup.CreateLabel(315, 90, 100, 20, "Color Four"));
		Color4Combo.setBounds(315, 110, 100, 20);
		
		panel.add(Setup.CreateLabel(0, 130, 100, 20, "Background"));
		ColorBackground.setBounds(0, 150, 100, 20);
		
		
		
		//Sets the text in the boxes
		WildCardDrawText.setText("Enter a number 1-9 (" 
				+ MainGameLoop.Settings[1] + ")");
		DeckSizeText.setText("Enter a number 1-99 (" 
				+ MainGameLoop.Settings[2] + ")");
		
		//Adds the components to the panel
		panel.add(WildCardDrawText);
		panel.add(DeckSizeText);
		panel.add(Setup.CreateLabel(105, 20, 135, 20, "Wild card draw amount"));
		panel.add(Setup.CreateLabel(245, 20, 135, 20, "Card amount"));
		panel.add(Color1Combo);
		panel.add(Color2Combo);
		panel.add(Color3Combo);
		panel.add(Color4Combo);
		panel.add(ColorBackground);
		//Sets up the buttons
		this.setLayout(null);
		Setup.Button(Sfx, 					0, 	 25,  100, 60,  	panel);
		Setup.Button(SubmitWildCardSize, 	105, 65,  135, 20,  	panel);
		Setup.Button(SubmitDeckSize, 		245, 65,  135, 20, 		panel);
		Setup.Button(SubmitColors, 		350, 440, 150, 60, 		panel);
		this.setVisible(true);
		
		//Sets the form visible
		this.setVisible(true);

	
	}
	
	/**
	 * Runs when a buttons is clicked
	 * @param e Gets which button was pressed
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if(doneOnce)
		{
			if(e.getSource().equals(Sfx))
			{
				ChangeSfx();
			}
			
			if(e.getSource().equals(SubmitWildCardSize))
			{
				if(SubmitSetting("Wild"))
				{
					JOptionPane.showMessageDialog(this, 
							"Wild card Settings accepted, "
							+ "Please restart the game for changed to take effect");
					WildCardDrawText.setText( MainGameLoop.Settings[1] );
				}
				else
				{
					JOptionPane.showMessageDialog(this,
							"Invalid number for wild card draw (1-9) "
							+ "is accepted... Refactoring to default...");
					WildCardDrawText.setText( MainGameLoop.Settings[1] );
				}
			
			}
			
			if(e.getSource().equals(SubmitDeckSize))
			{
				if(SubmitSetting("Deck"))
				{
					JOptionPane.showMessageDialog(this, 
							"Settings accepted, Please restart the "
							+ "game for changed to take effect");
					DeckSizeText.setText( MainGameLoop.Settings[2] );
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, 
							"Invalid number for deck size (4-99) is"
							+ " accepted... Refactoring to default...");
					DeckSizeText.setText( MainGameLoop.Settings[2] );
				}
			
			}
			
			if(e.getSource().equals(SubmitColors))
			{
				
				System.out.println("Saved colors " + MainGameLoop.Settings[0]);
				MainGameLoop.Settings[0] = Color1Combo.getSelectedItem() + "," + 
											Color2Combo.getSelectedItem() + "," +
											Color3Combo.getSelectedItem() + "," +
											Color4Combo.getSelectedItem() + ",";
				JOptionPane.showMessageDialog(this, 
						"Color Settings accepted, Please restart "
						+ "the game for changed to take effect");
			}
			
			
			SaveSettings();
		}
		else
		{
			doneOnce = true;
		}
		
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
			Sfx.setText("SFX/OFF");
			System.out.println("Sfx are now off");
			MainGameLoop.Frame.clipMusic.close();
			MainGameLoop.Frame.clipMusic.stop();
			MainGameLoop.Frame.clipButton.close();
			MainGameLoop.Frame.clipButton.stop();
		}
		else if(MainGameLoop.Settings[3].equals("false"))
		{
			MainGameLoop.Settings[3] = "true";
			Sfx.setText("SFX/ON");
			System.out.println("Sfx are now on");
			MainGameLoop.Frame.SetSfx();
		}
	}
	
	
	/**
	 * Sets us the settings menu with all the needed things
	 */
	public void SettupSettings()
	{
		URL url = MyPannel.class.getResource(	"Uno.png");
		ImageIcon img = new ImageIcon(			url);
		this.setIconImage(						img.getImage());
		this.setTitle(							"Settings");
		this.setDefaultCloseOperation(			JFrame.DISPOSE_ON_CLOSE);
		
		
		panel.setPreferredSize(					new Dimension(500, 500));
		panel.setLayout(					  	null);
		this.add(								panel);
		panel.setVisible(						true);
		
		this.pack();
		this.setLocationRelativeTo(				null);
		this.setAlwaysOnTop(					true);
		this.setName(							"Settings");
	}
	
	/**
	 * Used to submit the settings and check if they are good
	 * @return true if the settigns are accepted, false if not
	 * @param Seting the setting that is to be submited
	 */
	public boolean SubmitSetting(String Setting)
	{
		if(Setting.equals("Wild"))
		{
			try
			{
				Integer.parseInt(WildCardDrawText.getText());
				
				
				if(Integer.parseInt(WildCardDrawText.getText()) > 9 ||
						Integer.parseInt(WildCardDrawText.getText()) < 1)
				{
					MainGameLoop.Settings[1] = "4";
					return false;
				}
				else
				{
					MainGameLoop.Settings[1] = WildCardDrawText.getText();
				
					
				}
				return true;
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this, "Please enter a number");
				WildCardDrawText.setText( MainGameLoop.Settings[1] );
				return false;
			}
		}
		else if(Setting.equals("Deck"))
		{
			try
			{
				Integer.parseInt(DeckSizeText.getText());
				
				if(Integer.parseInt(DeckSizeText.getText()) > 99 || 
						Integer.parseInt(DeckSizeText.getText()) < 4)
				{
					MainGameLoop.Settings[2] = "11";
					return false;
				}
				else
				{
					MainGameLoop.Settings[2] = DeckSizeText.getText();
				}
				return true;
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this, "Please enter a number");
				DeckSizeText.setText( MainGameLoop.Settings[2] );
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
		String FilePath = FileManager.Home + "/Settings.json";
		
		String Settings = "";
		
		for(int i = 0; i < MainGameLoop.Settings.length; i++)
		{
			Settings = Settings + MainGameLoop.Settings[i] + "/";
		}
		
		try
	    {
	    	FileWriter myWriter = new FileWriter(FilePath);
		    myWriter.write(Settings);
		    myWriter.close();
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
	 * Sets up the combo boxes with the corect text
	 */
	public void SetComboBoxes()
	{
		JComboBox[] boxes = {Color1Combo, Color2Combo, Color3Combo, Color4Combo};
		
		for(int i = 0; i < boxes.length; i++)
		{
			if(ColorsBackup[i].equals("Red"))
			{
				boxes[i].setSelectedIndex(0);
			}
			else if(ColorsBackup[i].equals("Blue"))
			{
				boxes[i].setSelectedIndex(1);
			}
			else if(ColorsBackup[i].equals("Green"))
			{
				boxes[i].setSelectedIndex(2);
			}
			else if(ColorsBackup[i].equals("Yellow"))
			{
				boxes[i].setSelectedIndex(3);
			}
			else if(ColorsBackup[i].equals("Magenta"))
			{
				boxes[i].setSelectedIndex(4);
			}
			else if(ColorsBackup[i].equals("Cyan"))
			{
				boxes[i].setSelectedIndex(5);
			}
			else if(ColorsBackup[i].equals("Orange"))
			{
				boxes[i].setSelectedIndex(6);
			}
		}
	}
}
