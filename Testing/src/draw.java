import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;
import java.util.Timer;

public class draw
{

	 public static void main(String[] args)
	 {
	        JFrame frame = new JFrame("My first JFrame");
	        frame.setSize(1200, 1200);  
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        frame.getContentPane().add(new ShapeDrawing ());
	        frame.setVisible(true);   	        
	 } 
}

class ShapeDrawing extends JComponent 
{
	  
	 public void paint(Graphics g)
	 { 	 
		 for(int i = 0; i< 110; i++)
	     {
			 Graphics2D g2 = (Graphics2D) g;
	         try 
	         {
		         g2.setColor(Color.black);
	        	 Point p = MouseInfo.getPointerInfo().getLocation();
		         int x = p.x;
		         int y = p.y;
		         
	             Thread.sleep(100);
	          
		         g2.drawLine(x, y, 0, 0);
	         }
	         catch  (InterruptedException ie)
	         {
	        	 println("Could not draw");
	         }        
	         
	         
	         Point p = MouseInfo.getPointerInfo().getLocation();
	         int x = p.x;
	         int y = p.y;
	         
	         g2.setColor(Color.blue);
	         
	         g2.drawLine(x, y, 600, 600);
	           
	         x = p.x;
	         y = p.y;
	         
	         g2.setColor(Color.green);
	         g2.drawLine(x, y, -600, -600);

	     }
	 }   
	 
	public void println(String print) 
	{
		   System.out.println(print);	
	}
	public void println(int print) 
	{
		   System.out.println(print);	
	}
	public void print(String print) 
	{
		   System.out.print(print);	
	}
	 
}	

