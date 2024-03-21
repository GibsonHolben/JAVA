import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class Encryptor
{

    /**Creates an Encryptor with a seed that is used for encryption/decryption
     * @param Seed The seed that is used for randomization in the encryption*/
    Encryptor(int Seed)
    {
        OffsetList(Seed);
    }

    /**An Arraylist that holds all the characters that are supported in the Encryptor*/
    static ArrayList<String> Letters = new ArrayList<>();
    /**An Arraylist that holds the indexes of the characters*/
    static ArrayList<Integer> letterNumb = new ArrayList<>();

    static void load()
    {
        String[] s = {"A","B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "?", "/", "(", ")", "@", "#", "$", "%", "^", "&", "*","-","_","+","=","|",",",".","<",">","`","~","\"","'","\\", "}", "{",""}; //Leave empty char
        for(int i = 1; i < s.length + 1; i++) {
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
            toEnc = toEnc.substring(0, toEnc.length() - 2);
        StringBuilder finish = new StringBuilder();
        String[] charArray = toEnc.split("");
        ArrayList<Integer> upperIndex = new ArrayList<>();
        for(String ignored : charArray) {
            upperIndex.add(0);
        }
        for(int i = 0; i < charArray.length; i++) {
            if(isLowerCase(charArray[i])) {
                charArray[i] = charArray[i].toUpperCase();
                upperIndex.set(i, 1);
            }
        }

        for(int j = 0; j < charArray.length; j++) {
            try {
                for(int i = 0; i < Letters.size(); i++) {
                    if(charArray[j].equals(Letters.get(i))) {
                        if(upperIndex.get(j).equals(1)) {
                            finish.append(letterNumb.get(i)).append("*.");
                        }
                        else {
                            finish.append(letterNumb.get(i)).append(".");
                        }
                    }
                }
                if (charArray[j].equals(" ")) {
                    finish.append("_.");
                }
            }
            catch (Exception e) {
                System.err.println("Could not encrypt. Error: " + e.getMessage());
            }
        }
        return finish.toString();
    }
    public String decrypt(String toDec)
    {
        StringBuilder finish = new StringBuilder();
        String[] intArray = toDec.split("\\.");
        for(String s : intArray) {
            boolean doLower = false;
            boolean doSpace = false;
            String toAp = "";
            if(s.contains("*")) {
                doLower = true;
                s = s.replace("*", "");
            }
            else if(s.contains("_")) {
                doSpace = true;
                s = s.replace("_", "");
            }
            if(!doSpace) {
                for(int i = 0; i < letterNumb.size() - 1; i++) {
                    if(letterNumb.get(i) == Integer.parseInt(s)) {
                        toAp = Letters.get(i);
                    }
                }
            }
            if(doLower)
                toAp = toAp.toLowerCase();

            else if(doSpace)
                toAp = " ";
            finish.append(toAp);
        }
        return finish.toString();
    }
    boolean isLowerCase(String str) {
        return Objects.equals(str, str.toLowerCase()) && !str.equals(str.toUpperCase());
    }
}
