package main.thread.synchronize;

/**
 * 同步线程测试
 * @author fanwei
 *
 */
public class MyThreadSyn implements Runnable
{

    @Override
    public void run()
    {
        synchronized (MyThreadSyn.class)
        {
            System.out.println("打印**-------" + this);
        }
    }

    public void print()
    {
        System.out.println("**********");
    }

}
