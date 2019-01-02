package main.thread.sleep;

/**
 * 带有同步方法的休眠测试
 * 
 * 注意，若我们注释掉synchronized (obj)后再次执行该程序，t1和t2是可以相互切换的
 * @author fanwei
 *
 */
public class TestSleepSyn
{
    private static Object obj = new Object();

    public static void main(String[] args)
    {
        ThreadSleep t1 = new ThreadSleep("t1");
        ThreadSleep t2 = new ThreadSleep("t2");
        t1.start();
        t2.start();
    }

    static class ThreadSleep extends Thread
    {
        public ThreadSleep(String name)
        {
            super(name);
        }

        public void run()
        {
            synchronized (obj)
            {
                try
                {
                    for (int i = 0; i < 10; i++)
                    {
                        System.out.printf("%s: %d\n", this.getName(), i);
                        // i能被4整除时，休眠100毫秒
                        if (i % 4 == 0)
                        {
                            Thread.sleep(3000);
                        }
                    }
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
