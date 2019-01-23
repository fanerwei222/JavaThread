package main.thread.synchronize;

/**
 * 同步锁 class 测试
 * @author fanwei
 *
 */
public class SynClass
{
    public static void main(String[] args)
    {
        MyThreadSyn run1 = new MyThreadSyn();
        MyThreadSyn run2 = new MyThreadSyn();

        Thread syn1 = new Thread(run1);
        Thread syn2 = new Thread(run2);

        syn1.start();
        syn2.start();
        run2.print();

    }
}
