import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Enter a string to encrypt");
        Scanner sc = new Scanner(System.in);
        String toEnc = sc.nextLine();
        String enced = Encryptor.encrypt(toEnc);
        System.out.println(enced);

        System.out.println("Enter a string to decrypt");
        String deced = Encryptor.decrypt(sc.nextLine());
        System.out.println(deced);


    }
}