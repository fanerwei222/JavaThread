package main.thread.lock;

/**
 * (01) x.isSyncA()与x.isSyncB()  不能被同时访问。
 * 因为isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！
 * @author fanwei
 *
 */
public class LockTest1
{
    Something x = new Something();

    // 比较(01) x.isSyncA()与x.isSyncB() 
    //这里isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁
    //所以不能被同时访问
    private void test1()
    {
        // 新建t11, t11会调用 x.isSyncA()
        Thread t11 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                x.isSyncA();
            }
        }, "t11");

        // 新建t12, t12会调用 x.isSyncB()
        Thread t12 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                x.isSyncB();
            }
        }, "t12");

        t11.start(); // 启动t11
        t12.start(); // 启动t12

    }

    public static void main(String[] args)
    {
        LockTest1 demo = new LockTest1();
        demo.test1();
    }
}
