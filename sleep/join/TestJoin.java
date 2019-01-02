package main.thread.join;

/**
 * join
 * 让“主线程”等待“子线程”结束之后才能继续运行
 * A先运行，A中运行B，执行B.join()方法后，需要等B执行完A才能继续执行。
 * @author fanwei
 *
 */
public class TestJoin
{
    public static void main(String[] args) throws InterruptedException
    {
        ThreadSleep threadSleep = new ThreadSleep("t1");
        threadSleep.start();
        //没有执行join方法的话，"now is thread main!"可能会比run方法先运行。
        threadSleep.join();
        System.out.println("now is thread main!");
    }
}

class ThreadSleep extends Thread
{
    public ThreadSleep(String name)
    {
        super(name);
    }

    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("now is " + i + "*****" + this.getName());
        }
    }
}
