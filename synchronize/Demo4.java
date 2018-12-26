package main.thread.synchronize;

/**
 * “synchronized方法”是用synchronized修饰方法，
 * 而 “synchronized代码块”则是用synchronized修饰代码块
 * synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率
 * @author fanwei
 *
 */
public class Demo4
{
    public static void main(String[] args)
    {
        Demo4 demo = new Demo4();
        long start, diff;
        // 获取当前时间(millis)
        start = System.currentTimeMillis();
        demo.synMethod();
        // 获取“时间差值”
        diff = System.currentTimeMillis() - start;
        System.out.println("synMethod() : " + diff);

        // 获取当前时间(millis)
        start = System.currentTimeMillis();
        demo.synBlock();
        // 获取“时间差值”
        diff = System.currentTimeMillis() - start;
        System.out.println("synBlock() : " + diff);
    }

    /**
     * 同步方法
     */
    public synchronized void synMethod()
    {
        for (int i = 0; i < 1000000; i++)
        {
            ;
        }
    }

    /**
     * 同步代码块
     */
    public void synBlock()
    {
        synchronized (this)
        {
            for (int i = 0; i < 1000000; i++)
            {
                ;
            }
        }
    }
}
