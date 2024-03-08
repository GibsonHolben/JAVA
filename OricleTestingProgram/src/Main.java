public class Main
{
    public static void main(String[] args)
    {

       StringBuilder sb = new StringBuilder();
       sb.append("hello");
       sb.append("world");
       print(sb);

        Runnable run = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Test");
            }
        };

        run.run();


    }
    interface Runnable
    {
        public void run();
    }

    public static void print(String text)
    {
        System.out.println(text);
    }

    public static void print(StringBuilder text)
    {
        System.out.println(text);
    }
}
