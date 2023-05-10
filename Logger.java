import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger
{
    private static final Lock mutex = new ReentrantLock();

    public static void writeToFile(String logString)
    {
            mutex.lock();
            try
            {
                FileWriter writer = new FileWriter("results.txt", true);
                writer.write(logString);
                writer.close();
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }

            finally
            {
                mutex.unlock();
            }
    }

}
