
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Hover extends MouseAdapter
{
	/**
	 * The buttons needed
	 */
	JButton[] Buttons;
	
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
		for(int i = 0; i < Buttons.length; i++)
		{
			if(e.getSource().equals(Buttons[i]))
			{
				Buttons[i].setBackground(new Color(200, 200, 200));
			}
		}
	}

	/**
	 * Runs on mouse off button
	 */
	public void mouseExited(MouseEvent e) 
	{
		for(int i = 0; i < Buttons.length; i++)
		{
			if(e.getSource().equals(Buttons[i]))
			{
				Buttons[i].setBackground(new Color(255, 255, 255));
				MainGameLoop.Frame.setupPlayeBttonColors();
			}
		}
	}
}