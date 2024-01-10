import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class MyPannel extends JPanel
{
	public Color MyColor;
	String text;
	
	Graphics2D g2D;
	MyPannel(Color c, String s)
	{
		MyColor = c;
		text = s;
		this.setPreferredSize(new Dimension(500, 500));
	}
	

	public void paint(Graphics g)
	{
		g2D = (Graphics2D) g;
		g2D.setPaint(MyColor);
		g2D.fillRect(0, 0, 100, 200);
		g2D.setPaint(Color.black);
		g2D.setFont(new Font(null, Font.BOLD,50));
		g2D.drawString(text, 0, 50);
		
		
		
		
		
		
		//g2D.setPaint(Color.blue);
		//g2D.setStroke(new BasicStroke(5));
		//g2D.drawLine(0, 0, 500, 500);
		
		//g2D.setPaint(Color.blue);
		//g2D.drawRect(0, 0, 100, 200);
		//g2D.setPaint(Color.pink);
		//g2D.fillRect(0, 0, 100, 200);
		
		//g2D.setPaint(Color.orange);
		//g2D.drawOval(0, 0, 100, 100);
		//g2D.fillOval(0, 0, 100, 100);
		
		//g2D.setPaint(Color.red);
		//g2D.fillArc(0, 0, 100, 100, 0, 180);
		//g2D.setPaint(Color.white);
		//g2D.fillArc(0, 0, 100, 100, 180, 180);
		
		
		//int[] xPoints = {150,250,350};
		//int[] yPoints = {300,150,300};
		//g2D.setPaint(Color.yellow);
		//g2D.drawPolygon(xPoints, yPoints, 3);
		//g2D.fillPolygon(xPoints, yPoints, 3);
		
		
		//g2D.setPaint(Color.magenta);
		//g2D.setFont(new Font("Ink Free", Font.BOLD,50));
		//g2D.drawString("U are a winner", 50, 50);
		
		
	}
	
}
