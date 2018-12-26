package main.thread.synchronize;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞
 * @author fanwei
 *
 */
public class Demo1_2
{
    public static void main(String[] args)
    {
        Thread thread1 = new DemoTwoThread("thread1");
        Thread thread2 = new DemoTwoThread("thread2*********");

        thread1.start();
        thread2.start();
    }
}

class DemoTwoThread extends Thread
{

    public DemoTwoThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        synchronized (this)
        {
            try
            {
                for (int i = 0; i < 500; i++)
                {
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
