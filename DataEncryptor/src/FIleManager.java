import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.FileWriter;


public class FIleManager
{

    public static String ReadFile(String path)
    {
        StringBuilder line = new StringBuilder();
        try
        {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine())
            {
                line.append(scanner.nextLine() + "\n");
            }
            scanner.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return line.toString();
    }

    public static String ReadEncFile(String path)
    {
        StringBuilder line = new StringBuilder();
        try
        {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine())
            {
                String t = scanner.nextLine();
                line.append(t).append("\n");

            }
            scanner.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return line.toString();
    }


    public static void WriteFile(String path,String name, String contents)
    {
        File f = new File(path + name + ".txt");
        try
        {
            FileWriter writer = new FileWriter(f);
            writer.write(contents);
            writer.write(String.valueOf(2));
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

    }

}
