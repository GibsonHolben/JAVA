import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author CTEHolbenG46
 * @version 0.0.1
 */
public class Main
{
	static JFrame Frame = new JFrame();
	
	static JPanel Panel = new JPanel();
	
	static String[] Options = {"Option1", "Option2", "Option3"};
//	static JComboBox ComboBox = new JComboBox(Options);
//	
//	static JButton Button = new JButton("");
//	
//	static JTextField Input = new JTextField();
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 Panel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		 Panel.setBackground(Color.black);
		 Frame.setTitle("Click");
	     Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	     Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     Frame.setUndecorated(true);
	     Frame.setLocationRelativeTo(null);
	     Frame.setAlwaysOnTop(true);
	     Frame.setResizable(false);
	     Frame.setName("UNO");
	     Frame.add(Panel);
	     Panel.setLayout(null);

	     
	     
	     String[] Options = {"Option1", "Option2", "Option3"};
	     int x = 100;
	     int y = 100;
	     int width = 200;
	     int height = 100;
	     
	     JComboBox ComboBox = new JComboBox(Options);
	     ComboBox.setBounds(x, y, width, height);
	     
	 	 JButton Button = new JButton("Click me");
	 	 Button.setBounds(x + 300, y, width, height);
	 	 
	 	 JTextField Input = new JTextField();
	     Input.setBounds(x + 600, y, width, height);
	     
	     ComboBox.show();
	     Button.show();
	     Input.show();
	     
	     
	     ComboBox.setBackground(Color.gray);
	     Button.setBackground(Color.gray);
	     Input.setBackground(Color.gray);
	     
	     ComboBox.setForeground(Color.red);
	     Button.setForeground(Color.cyan);
	     Input.setForeground(Color.pink);

	     
	     
	    // JTextField InputField = new JTextField(16);
//	     String Input = InputField.getText();
//	     System.out.println(Input);
	     
	     
	     Panel.add(Button);
	     Panel.add(ComboBox);
	     Panel.add(Input);
	     Panel.repaint();
	        
	     //Packing the frame
	     Frame.requestFocus();
	     Frame.setVisible(true);
	     Frame.pack();
	     Frame.setVisible(true);  
	}

}
