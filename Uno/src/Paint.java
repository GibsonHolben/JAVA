import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * COntains several functions that are used by MyPanel to render a card
 * @author CTEHolbenG46
 * @version 0.0.7
 */
public class Paint
{

    /**
     * Dynamically updates the wild card decals with the current four colors
     * @param x The X cordenants of the card
     * @param y The Y cordenants of the card
     * @param plusFour Is the card a +4 card
     * @param G2D The graphics componenet 
     */
    public static void CardWildDecals(int x, int y, boolean plusFour, Graphics2D G2D)
    {
        //Big circle
        int x2 = x + 10;
        int y2 = y + 100;
        G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[0]));
        G2D.fillRect(x2 + 105, y2 - 20, 80, 120);

        G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[1]));
        G2D.fillRect(x2 + 5, y2 - 10, 100, 160);

        G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[2]));
        G2D.fillRect(x2 + 5, y2 + 100, 100, 150);

        G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[3]));
        G2D.fillRect(x2 + 105, y2 + 100, 80, 120);

        if(!plusFour)
        {
            //Small circles
            for(int i = 0; i < 2; i++)
            {
                G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[0]));
                G2D.fillRect(x + 5 + (i * 115), y  + 20 + (i * 260), 40, 40);

                G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[1]));
                G2D.fillRect(x + 45 + (i * 115), y + 20 + (i * 260), 40, 40);

                G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[2]));
                G2D.fillRect(x + 5 + (i * 115), y + 60+ (i * 260), 40, 40);

                G2D.setPaint(Setup.GetColor(Settings.ColorsBackup[3]));
                G2D.fillRect(x + 45 + (i * 115), y + 60+ (i * 260), 40, 40);
            }
        }
    }

    /**
     * Paints a card at the specified position with the specified details
     * @param x the x position
     * @param y the y position
     * @param w the width
     * @param h the height
     * @param Color the color of the card
     * @param Card the card to draw
     * @param G2D the graphics component 
     */
    @SuppressWarnings("static-access")
    public static void Card(int x, int y, int w, int h, Color Color, Card Card, Graphics2D G2D)
    {
        MainGameLoop.Frame.Panel.setBackground(  MainGameLoop.Frame.Panel.BackgroundColor());
        G2D.setStroke(new BasicStroke(10));
        G2D.setPaint(Color.black);
        G2D.drawRoundRect(x- 2, y + 2, w, h, 20, 20);
        G2D.setPaint(Color.white);
        G2D.drawRoundRect(x, y, w, h, 20, 20);
        G2D.setStroke(new BasicStroke(1));
        G2D.setPaint(Color);
        G2D.fillRoundRect(x, y, w, h, 20, 20);

        MiddleNumber(x, y, Card, G2D);

        if(Card.SpecialEffect.contains("W+"))
        {
            G2D.setPaint(Color.white);
            CardWildDecals(x,y, true, G2D);
            URL Url = MyPannel.class.getResource("img/Uno4.png");
            Image img = new ImageIcon(Url).getImage();
            G2D.drawImage(img, x + -2, y + 20, null);
            G2D.setPaint(Color.black);
            G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    100));
            G2D.drawString("+" + MainGameLoop.Settings[1],
                    x + 5, y + 37 + 50);
            G2D.setPaint(Color.white);
            G2D.drawString("+" + MainGameLoop.Settings[1],
                    x + 7, y + 35+ 50);

            G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    -100));
            G2D.setPaint(Color.black);
            G2D.drawString("+" + MainGameLoop.Settings[1],
                    x + 200, y + 150+ 170);
            G2D.setPaint(Color.white);
            G2D.drawString("+" + MainGameLoop.Settings[1],
                    x + 198, y + 148+ 170);
        }
        else
        {
            switch(Card.SpecialEffect)
            {
                case "S":
                    URL Url = MyPannel.class.getResource("img/Uno5.png");
                    Image Uno1 = new ImageIcon(Url).getImage();
                    G2D.drawImage(Uno1, x + -2, y + 20, null);
                    G2D.setPaint(Color.white);
                    break;
                case "+2":
                    G2D.setPaint(Color.white);
                    Url = MyPannel.class.getResource("img/Uno2.png");
                    Image Uno2 = new ImageIcon(Url ).getImage();
                   
                    G2D.drawImage(Uno2, x + -2, y + 20, null);

                    G2D.setPaint(Color.black);
                    G2D.setFont(new Font(null, Font.BOLD,80));
                    G2D.drawString(Card.SpecialEffect, x - 1 + 5, y + 27+ 50);
                    G2D.setPaint(Color.white);
                    G2D.drawString(Card.SpecialEffect, x - 1 + 7, y + 25+ 50);

                    G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    										-80));

                    G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    										-100));
                    G2D.setPaint(Color.black);
                    G2D.drawString(Card.SpecialEffect, x + 200, y + 160+ 155);
                    G2D.setPaint(Color.white);
                    G2D.drawString(Card.SpecialEffect, x + 198, y + 158+ 155);
                    break;
                case "W":
                    CardWildDecals(x,y, false, G2D);
                    G2D.setPaint(Color.white);
                    Url = MyPannel.class.getResource("img/Uno3.png");
                    Image img = new ImageIcon(Url  ).getImage();
                  
                    G2D.drawImage(img, x + -2, y + 10, null);
                    break;
                default:
                    G2D.setPaint(Color.white);
                    Url = MyPannel.class.getResource("img/Uno2.png");
                    Image Uno3 = new ImageIcon(Url).getImage();
                 
                    G2D.drawImage(Uno3, x + -2, y + 20, null);

                    G2D.setPaint(Color.black);

                    G2D.setFont(new Font(null, Font.BOLD,100));
                    G2D.drawString(Integer.toString(Card.numberValue), x + 5, y + 37+ 50);
                    G2D.setPaint(Color.white);
                    G2D.drawString(Integer.toString(Card.numberValue), x + 7, y + 35+ 50);

                    G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                            -100));
                    G2D.setPaint(Color.black);
                    G2D.drawString(Integer.toString(Card.numberValue), x + 200, y + 160+ 155);
                    G2D.setPaint(Color.white);
                    G2D.drawString(Integer.toString(Card.numberValue), x + 198, y + 158+ 155);
                    break;

            }
        }
    }


    public static void MiddleNumber(int x, int y, Card Card, Graphics2D G2D)
    {
        G2D.setPaint(Color.black);
        if(Integer.toString(Card.numberValue).length() == 2)
        {
            G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    100));
            G2D.drawString(Integer.toString(Card.numberValue), x + 50 - 2, y + 230 + 2);
            G2D.setPaint(Color.white);
            G2D.drawString(Integer.toString(Card.numberValue), x + 50 , y + 230);
        }
        else if(Card.SpecialEffect.equals("+2"))
        {
            G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    100));
            G2D.drawString(Card.SpecialEffect, x + 40 - 2, y + 230 + 2);
            G2D.setPaint(Color.white);
            G2D.drawString(Card.SpecialEffect, x + 40 , y + 230);
        }
        else if (!Card.SpecialEffect.equals("W")&&
                !Card.SpecialEffect.contains("W+")&&
                !Card.SpecialEffect.equals("S"))
        {
            G2D.setFont(new Font("URW Grotesk", Font.BOLD,
                    150));
            G2D.drawString(Integer.toString(Card.numberValue), x + 60 - 2, y + 250 + 2);
            G2D.setPaint(Color.white);
            G2D.drawString(Integer.toString(Card.numberValue), x + 60, y + 250);
        }
    }


}
