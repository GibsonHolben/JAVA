import javax.swing.JFrame;
import java.awt.*;
/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MyFrame extends JFrame
{
	MyPannel panel;
	
	MyFrame(Color c, String s)
	{ 
		panel = new MyPannel(c, s);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void reset(Color c, String s)
	{
		panel = new MyPannel(c, s);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}
