import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Encryptor
{

    Encryptor(int Seed)
    {
        OffsetList(Seed);
    }
    static ArrayList<String> Letters = new ArrayList<String>();
    static ArrayList<Integer> letterNumb = new ArrayList<Integer>();

    static void load()
    {
        String[] s = {"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "?", "/", "(", ")", "@", "#", "$", "%", "^", "&", "*","-","_","+","=","|",",",".","<",">","`","~","\"","'","\\", "}", "{",""}; //Leave empty char

        for(int i = 1; i < s.length + 1; i++)
        {
            letterNumb.add(i);
        }


        Collections.addAll(Letters, s);

    }

    public void OffsetList(int seed)
    {
        load();
        Random random = new Random(seed);
        Collections.shuffle(letterNumb, random);
    }
    public String encrypt(String toEnc)
    {
        if(toEnc.endsWith(".2"))
        {
            toEnc = toEnc.substring(0, toEnc.length() - 2);
        }
        StringBuilder finish = new StringBuilder();
        String[] charArray = toEnc.split("");
        ArrayList<Integer> upperIndex = new ArrayList<>();
        for(String s : charArray)
        {
            upperIndex.add(0);
        }

        for(int i = 0; i < charArray.length; i++)
        {
            if(isLowerCase(charArray[i]))
            {
                charArray[i] = charArray[i].toUpperCase();
                upperIndex.set(i, 1);
            }
        }

        for(int j = 0; j < charArray.length; j++)
        {

            try
            {
                for(int i = 0; i < Letters.size(); i++)
                {

                    if(charArray[j].equals(Letters.get(i)))
                    {
                        if(upperIndex.get(j).equals(1))
                        {
                            finish.append(letterNumb.get(i)).append("*.");
                        }
                        else
                        {
                            finish.append(letterNumb.get(i)).append(".");
                        }
                    }
                }
                if (charArray[j].equals(" "))
                {
                    finish.append("_.");
                }
            }
            catch (Exception e)
            {
                System.err.println("Could not encrypt");
                e.printStackTrace();
            }

        }
        return finish.toString();




    }

    public String decrypt(String toDec, int offset)
    {
        String finish = "";
        String[] intArray = toDec.split("\\.");
        for(String s : intArray)
        {
            boolean doLower = false;
            boolean doSpace = false;
            String toAp = "";
            if(s.contains("*"))
            {
                doLower = true;
                s = s.replace("*", "");
            }
            else if(s.contains("_"))
            {
                doSpace = true;
                s = s.replace("_", "");
            }
            if(!doSpace)
            {
                for(int i = 0; i < letterNumb.size() - 1; i++)
                {
                    if(letterNumb.get(i) == Integer.parseInt(s))
                    {
                        toAp = Letters.get(i);
                    }
                }
            }
            if(doLower)
            {
                toAp = toAp.toLowerCase();
            }
            else if(doSpace)
            {
                toAp = " ";
            }
            finish += toAp;
        }
        return finish;
    }
    boolean isLowerCase(String str) {
        return str == str.toLowerCase() && str != str.toUpperCase();
    }
}
