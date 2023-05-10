import java.text.SimpleDateFormat;
import java.util.Date;

class LogSync implements Runnable
{
    private static volatile int counter = 0;
    private final String threadName;
    private final int interval;

    public LogSync(String threadName, int interval)
    {
        this.threadName = threadName;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (counter < 240)
        {
            try
            {
                Thread.sleep(interval);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (threadName.equals("Thread 1"))
            {
                counter++;
            }

            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
            String formattedDate = dateFormat.format(currentDate);
            String logString = threadName + ": " + formattedDate + ", Counter: " + counter + "\n";

            Logger.writeToFile(logString);
        }
    }

}