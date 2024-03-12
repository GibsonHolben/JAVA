import java.util.ArrayList;
import java.util.Objects;

public class Encryptor
{
    static String[] Letters = {"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    static int[] letterNumb = {1,    2,   3,    4,   5,  6,   7,   8,   9,   10,  11,  12,  13,  14,  15,  16,  17,  18,  19,  20,  21,  22,  23,  24,  25,  26};
    public static String encrypt(String toEnc)
    {
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

            for(int i = 0; i < Letters.length; i++)
            {

                if(charArray[j].equals(Letters[i]))
                {
                    if(upperIndex.get(j).equals(1))
                    {
                        finish.append(letterNumb[i]).append("*.");
                    }
                    else
                    {
                        finish.append(letterNumb[i]).append(".");
                    }
                }
            }
            if (charArray[j].equals(" "))
            {
                finish.append("_.");
            }
        }
        return finish.toString();
    }

    public static String decrypt(String toDec)
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
                toAp = Letters[Integer.parseInt(s) -1];
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
    static boolean isLowerCase(String str) {
        return str == str.toLowerCase() && str != str.toUpperCase();
    }
}
