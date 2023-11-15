import java.util.Timer;
import java.util.TimerTask;

public class TimerTest 
{
	public static Timer t;

	public static void main(String[] args)
	{
		TimerTest.startPollingTimer();
	}
	
	public synchronized static void startPollingTimer() 
	{
        if (t == null) 
        {
            TimerTask task = new TimerTask() 
            {
                @Override
                public void run() 
                {
                  System.out.println("Gibson");
                }
            };

            t = new Timer();
            t.scheduleAtFixedRate(task, 0, 1000);
        }
    }
	
}
