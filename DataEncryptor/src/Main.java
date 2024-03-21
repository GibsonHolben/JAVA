import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String enced = "";

        System.out.println("Please enter a encryption/decryption key (Remember the numbers)");
        String Seed = sc.nextLine();
        if(Seed.isEmpty() || Seed.equals(" ")){Seed = "0";}

        Encryptor Encryptor = new Encryptor(Integer.parseInt(Seed));

        System.out.println("encrypt or decrypt? (enc/dec)");

        sc = new Scanner(System.in);
        switch (sc.nextLine())
        {
            case "enc":
                System.out.println("Enter a string to encrypt");
                String toEnc = sc.nextLine();
                enced = Encryptor.encrypt(toEnc);
                System.out.println(enced);
                break;
            case "dec":
                System.out.println("Enter a string to decrypt");
                String deced = Encryptor.decrypt(sc.nextLine());
                System.out.println(deced);
                break;
            case "dump":
                for(int i : Encryptor.letterNumb)
                {
                    System.out.println(i + "," + Encryptor.Letters.get(i-1));
                }

        }

    }
}


