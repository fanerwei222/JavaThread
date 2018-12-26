package main.thread.synchronize;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞
 * @author fanwei
 *
 */
public class Demo1_1
{
    public static void main(String[] args)
    {
        Runnable demoOneRunnable = new DemoOneRunnable();

        Thread thread1 = new Thread(demoOneRunnable, "thread1");
        Thread thread2 = new Thread(demoOneRunnable, "thread2");

        thread1.start();
        thread2.start();
    }
}

class DemoOneRunnable implements Runnable
{

    @Override
    public void run()
    {
        synchronized (this)
        {
            try
            {
                for (int i = 0; i < 5; i++)
                {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
