package main.thread.lock;

/**
 * 方法类
 * @author fanwei
 *
 */
public class Something
{
    /**
     * 对象锁
     */
    public synchronized void isSyncA()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : isSyncA");
            }
        } catch (InterruptedException ie)
        {
        }
    }

    /**
     * 对象锁
     */
    public synchronized void isSyncB()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : isSyncB");
            }
        } catch (InterruptedException ie)
        {
        }
    }

    /**
     * 全局锁
     */
    public static synchronized void cSyncA()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : cSyncA");
            }
        } catch (InterruptedException ie)
        {
        }
    }

    /**
     * 全局锁
     */
    public static synchronized void cSyncB()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " : cSyncB");
            }
        } catch (InterruptedException ie)
        {
        }
    }
}
