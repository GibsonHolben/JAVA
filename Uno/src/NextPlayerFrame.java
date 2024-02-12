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
    public JPanel panel = new JPanel();

    /**
     * Sets up the frame
     */
    NextPlayerFrame()
    {
        panel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        	
        //Setup the image icon
        URL url = MyPannel.class.getResource("img/Uno.png");
        ImageIcon img = new ImageIcon(url);
        this.setIconImage(img.getImage());
        
        this.setTitle("Click");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.setUndecorated(		  true);
        this.setLocationRelativeTo(	  null);
        this.setAlwaysOnTop(		  true);
        this.setResizable(            false);
        this.setName(				  "UNO");
        this.add(                     panel);
        panel.setLayout(              null);

        //Button setup
        Setup.Button
        (
        	Start, 
        	0, 
        	0, 
        	1900, 
        	1100, 
        	panel
        );	
        
        Start.setOpaque(              false);
        panel.setBackground(          Color.black);
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
        panel.add(Setup.CreateLabel(900, 700, 100, 100, "(Click to play)"));
        
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
