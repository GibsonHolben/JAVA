import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws StringNotEncryptableException {
        Scanner sc = new Scanner(System.in);
        String enced = "";

        System.out.println("Please enter a encryption key (Remember the numbers)");
        String Seed = sc.nextLine();
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
                String deced = Encryptor.decrypt(sc.nextLine(), 0);
                System.out.println(deced);
                break;

        }

    }
}


