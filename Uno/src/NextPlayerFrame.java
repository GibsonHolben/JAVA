import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

@SuppressWarnings("serial")
public class NextPlayerFrame extends JFrame implements ActionListener
{
    /**
     * JButton that is used to start a players turn
     */
    JButton Start = new JButton(MainGameLoop.CurentPlayer.Name + "'s Turn");

    /**
     * The JPanel used to hold the buttons
     */
    JPanel  Panel = new JPanel();

    /**
     * Sets up the frame
     */
    NextPlayerFrame()
    {
        Panel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        	
        //Setup the image icon
        URL Url = MyPannel.class.getResource("img/Uno.png");
        ImageIcon Img = new ImageIcon(Url);
        this.setIconImage(Img.getImage());
        
        this.setTitle("NextPlayerIntermisonScreen");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.setUndecorated(		  true);
        this.setLocationRelativeTo(	  null);
        this.setAlwaysOnTop(		  true);
        this.setResizable(            false);
        this.setName(				  "UNO");
        this.add(                     Panel);
        Panel.setLayout(              null);

        //Button setup
        Setup.Button
        (
        	Start, 
        	0, 
        	0, 
        	1900, 
        	1100, 
        	Panel
        );	
        
        Start.setOpaque(              false);
        Panel.setBackground(          Color.black);
        Start.setForeground(          Color.white);
        Start.setFont
        (
	        new Font
	        (
	        	"URW Grotesk", Font.BOLD, 150
	        )
      	);    	
        Start.addActionListener(      this);
        Start.setContentAreaFilled(   false);
        Start.setBorderPainted(       false);
        
        //Creates a label to know how to start next round
        Panel.add(Setup.CreateLabel(900, 
					        		700, 
					        		100, 
					        		100, 
					        		"(Click to play)"));
        
        //Packing the frame
        this.requestFocus();
        this.setVisible(              true);
        this.pack();
        this.setVisible(              true);
    }

    /**
     * Used to get when the menu is closed
     * @param e the event that triggered the function
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(Start))
        {
            this.dispose();
        }
    }
}
