public class ThreadSync
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread1 = new Thread(new LogSync("Thread 1", 250));
        Thread thread2 = new Thread(new LogSync("Thread 2", 500));
        Thread thread3 = new Thread(new LogSync("Thread 3", 1000));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

}