package main.thread.synchronize;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程仍然可以访问“该对象”的非同步代码块
 * @author fanwei
 *
 */
public class Demo2
{
    public static void main(String[] args)
    {
        final Count count = new Count();

        //调用“count对象”的synMethod()方法
        Thread thread1 = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                count.synMethod();
            }
        }, "thread1");

        //调用“count对象”的nonSynMethod()方法
        Thread thread2 = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                count.nonSynMethod();
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}

class Count
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

    // 非同步的方法
    public void nonSynMethod()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " 非同步nonSynMethod loop " + i);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
