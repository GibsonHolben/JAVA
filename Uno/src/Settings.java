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
	 * The button for the sfx
	 */
	JButton Sfx = new JButton("SFX/ON");
	
	/**
	 * Sumbits the settings
	 */
	JButton Submit = new JButton("Submit");
	
	/**
	 * The main panel of the game
	 */
	JPanel panel = new JPanel();
	
	/**
	 * The input field for the wild card draw
	 */
	JTextField text = new JTextField(16);
	
	Settings()
	{
		this.requestFocus();
		
		//Setups the top bar
		SettupSettings();
		
		Sfx.addActionListener(this);
		Submit.addActionListener(this);
		
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
		
		text.setBorder(new LineBorder(Color.black, 2));
		text.setBounds(new Rectangle(105, 40, 135, 20));
		
		panel.add(CreateLabel(105, 20, 135, 20, "Wild card draw amount"));
		text.setText("Enter a number 1-9");
		panel.add(text);
		SetupButton(Sfx, 0,0, Color.black);
		SetupButton(Submit, 245, 0, Color.black);
		this.setVisible(true);

	
	}
	
	/**
	 * Creates a JLabel at specified cordenates with a specified size and a specified text
	 * @param x the x cords of the label
	 * @param y the y cords of the label
	 * @param w the width of the label
	 * @param h the height of the label
	 * @param text the text of the label
	 * @return a new JLabel of the label
	 */
	public JLabel CreateLabel(int x, int y, int w, int h, String text)
	{
		JLabel jb = new JLabel(text);
		jb.setBounds(new Rectangle(x, y, w, h));
		
		return jb;
	}
	/**
	 * Runs when a buttons is clicked
	 * @param e Gets which button was pressed
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(Sfx))
		{
			ChangeSfx();
		}
		
		if(e.getSource().equals(Submit))
		{
			try
			{
				Integer.parseInt(text.getText());
				
				if(Integer.parseInt(text.getText()) > 9 || Integer.parseInt(text.getText()) < 1)
				{
					JOptionPane.showMessageDialog(this, "Invalid number (1-9)");
				}
				else
				{
					MainGameLoop.Settings[1] = text.getText();
					JOptionPane.showMessageDialog(this, "Number accepted, Please restart the game for changed to take effect");
				}
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(this, "Please enter a number (1-9)");
				text.setText("");
			}
			
				
			
		
		}
		
		SaveSettings();
	}

	
	/**
	 * Sets us the settings menu 
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
	 * Sets the font on a jbutton
	 * @param Jb the button that the font is changed on
	 * @param fontsize the new size of the font
	 */
	public void resetFonts(JButton Jb, int fontsize)
	{
		Jb.setFont(new Font("URW Grotesk", Font.BOLD, fontsize));
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
	
		this.setLayout(					null);
		panel.add(						Button);
		panel.setComponentZOrder(		Button, 0);
		panel.setVisible(				true);
		this.setVisible(true);
	}
}
