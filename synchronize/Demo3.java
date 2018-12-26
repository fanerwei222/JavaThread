package main.thread.synchronize;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞
 * @author fanwei
 *
 */
public class Demo3
{
    /**
     * 主线程中新建了两个子线程t1和t2。t1和t2运行时都调用synchronized(this)，
     * 这个this是Count对象(count)，而t1和t2共用count。
     * 因此，在t1运行时，t2会被阻塞，等待t1运行释放“count对象的同步锁”，t2才能运行
     * @param args
     */
    public static void main(String[] args)
    {
        final CountTwo count = new CountTwo();

        //调用“count对象”的synMethod()方法
        Thread thread1 = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                count.synMethod();
            }
        }, "thread1");

        //调用“count对象”的twoSynMethod()方法
        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                count.twoSynMethod();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}

class CountTwo
{

    // 含有synchronized同步块的方法
    public void synMethod()
    {
        synchronized (this)
        {
            try
            {
                for (int i = 0; i < 5; i++)
                {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " 同步synMethod loop " + i);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    // 同步的方法
    public void twoSynMethod()
    {
        try
        {
            synchronized (this)
            {
                for (int i = 0; i < 5; i++)
                {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " two同步nonSynMethod loop " + i);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
