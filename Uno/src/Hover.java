import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Used to change the color of the buttons on hover
 * @author CTEHolbenG46
 * @version 0.0.9
 */
public class Hover extends MouseAdapter
{
	/**
	 * The buttons that the listener is using 
	 */
	JButton[] Buttons;
	
	/**
	 * Creates a hover with an array of buttons
	 * @param Buttons the buttons that the listener covers
	 */
	Hover(JButton[] Buttons)
	{
		this.Buttons = Buttons;
	}
	
	@Override
	/**
	 * Runs on mouse over button
	 */
	public void mouseEntered(MouseEvent e)
	{
        for (JButton button : Buttons) 
        {
            if (e.getSource().equals(button))
            {
                button.setBackground(new Color(200, 200, 200));
            }
        }
		
	}

	/**
	 * Runs on mouse off button
	 */
	public void mouseExited(MouseEvent e) 
	{
        for (JButton button : Buttons) 
        {
            if (e.getSource().equals(button))
            {
                button.setBackground(new Color(255, 255, 255));
                MainGameLoop.Frame.setupPlayeBttonColors();
            }
        }
	}
}