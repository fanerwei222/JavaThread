package main.thread.yield;

/**
 * (01) wait()是让线程由“运行状态”进入到“等待(阻塞)状态”，而yield()是让线程由“运行状态”进入到“就绪状态”。
 * (02) wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。
 * @author fanwei
 *
 */
public class TestYieldLock
{
    private static Object obj = new Object();

    public static void main(String[] args)
    {
        ThreadLockYield thread1 = new ThreadLockYield("t1");
        ThreadLockYield thread2 = new ThreadLockYield("t2");

        System.out.println(thread1 == thread2);
        thread1.start();
        thread2.start();
    }

    static class ThreadLockYield extends Thread
    {
        public ThreadLockYield(String name)
        {
            super(name);
        }

        public void run()
        {
            // 获取obj对象的同步锁
            synchronized (obj)
            {
                for (int i = 0; i < 10; i++)
                {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    // i整除4时，调用yield
                    if (i % 4 == 0)
                    {
                        Thread.yield();
                    }
                }
            }
        }
    }
}
