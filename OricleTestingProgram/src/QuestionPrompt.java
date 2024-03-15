import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionPrompt
{

        static ArrayList<String> questions = new ArrayList<>();
        static JFrame frame = new JFrame();
        static listener listr = new listener();

        static boolean donext = false;

        static boolean doPrint = false;

        static JButton button = new JButton("next");
        public static void main(String[] args)
        {
            JLabel label = new JLabel("Hello, JFrame!");
            frame.getContentPane().add(label);

            button.setBounds(1800, 900, 100, 100);
            button.addActionListener(listr);
            frame.getContentPane().add(button);
            frame.setLayout(new FlowLayout());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);


            try (Scanner scanner = new Scanner(new File("C:/Users/CTEHolbenG46/Documents/Test.txt")))
            {
                while (scanner.hasNextLine()) {

                    String line = scanner.nextLine();
                    System.out.println("do print: " + doPrint);
                    if (line.contains("Question")) {
                        doPrint = true;
                        if(doPrint)
                            if(!line.isEmpty())
                                label.setText("<html>" + label.getText() + "<br>" + line + "<html>");
                    } else if (line.contains("Answer")) {
                        donext = false;
                        if(doPrint)
                            if(!line.isEmpty())
                                label.setText("<html>" + label.getText() + "<br>" + line + "<html>");

                        while(!donext)
                        {
                            //System.out.println("Waiting");
                        }
                        System.out.println("cont");
                        questions.add(label.getText());
                        label.setText("");
                    } else {
                        if(doPrint)
                        {
                            if(!line.isEmpty())
                                label.setText("<html>" + label.getText() + "<br>" + line + "<html>");
                        }

                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    class listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            if(actionEvent.getSource().equals( QuestionPrompt .button))
            {
                QuestionPrompt .donext = true;
                QuestionPrompt .doPrint = false;
                try
                {
                    System.out.println( QuestionPrompt .questions.get(0).toString());

                }
                catch(Exception e )
                {

                }
            }

        }
    }






