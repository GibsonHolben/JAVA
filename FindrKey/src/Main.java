import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    static int counter = 1;
    public static void main(String[] args)
    {
        try {
            File myObj = new File("C://Users//CTEHolbenG46//Documents//JavaOracle_1Z0-811-2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.startsWith("Answer: "))
                {
                    data = data.replace("Answer:", "");
                    System.out.println(counter + "." + data);
                    counter++;
                }



            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}