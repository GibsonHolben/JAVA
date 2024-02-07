import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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

        URL url = MyPannel.class.getResource("Uno.png");
        ImageIcon img = new ImageIcon(url);
        this.setIconImage(img.getImage());
        this.setTitle("Click");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(		  true);
        this.requestFocus();
        this.setLocationRelativeTo(	  null);
        this.setAlwaysOnTop(		  true);
        this.setName(				  "UNO");
        this.setResizable(            false);
        this.add(                     panel);
        panel.setLayout(              null);
        panel.setBackground(          Color.black);
        Setup.Button(Start, 0, 0, 1900, 1100, panel);
        Start.setOpaque(              false);
        Start.setForeground(          Color.white);
        Start.setFont(new Font("URW Grotesk", Font.BOLD, 150));
        Start.addActionListener(    this);
        Start.setContentAreaFilled(   false);
        Start.setBorderPainted(       false);
        panel.add(Setup.CreateLabel(900, 700, 100, 100, "(Click to play)"));
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
            System.out.println("Closing");
            this.dispose();
        }
    }
}
