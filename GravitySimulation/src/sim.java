import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class sim
{
	static ArrayList<JLabel> Labels = new ArrayList<JLabel>();
	
	   public static void main(String[] args)
	    {
	        // Create a new JFrame
	        JFrame frame = new JFrame("My First JFrame");
	 
	        // Create a label
	        Icon simIco = new ImageIcon(sim.class.getResource("img/Square.png")); 
	        JLabel sim = new JLabel(simIco);
	        Labels.add(sim);
	        
	        Icon floorIco = new ImageIcon(sim.class.getResource("img/Floor.png")); 
	        JLabel floor = new JLabel(floorIco);
	        
	        Labels.add(floor);
	        
	        frame.add(floor);
	        frame.add(sim);
	        
	        
	 
	        frame.setSize(500,
	                      500); // Set the size of the frame
	 
	        frame.setDefaultCloseOperation(
	            JFrame.EXIT_ON_CLOSE);
	 
	        frame.setVisible(true);
	        
	        while(true)
	        {
	        	floor.setBounds(500, 800, 1000, 50);
	        	if(sim.getY() != floor.getY())
	        		sim.setBounds(sim.getX(), sim.getY() + 10, sim.getWidth(), sim.getHeight());
	        	frame.repaint();
	        	try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
	    }
}
