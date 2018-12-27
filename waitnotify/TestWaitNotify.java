package main.thread.waitnotify;

/**
 * wait notify 测试
 * 说明 ： 该程序执行步骤仅仅是本人的理解，不一定保证十分正确。
 * @author fanwei
 *
 */
public class TestWaitNotify
{
    public static void main(String[] args)
    {
        //第一步：初始化线程1
        Thread thread1 = new ThreadA("t1");

        ThreadB threadB = new ThreadB("ThreadBBBBB", thread1);

        //第二步：主线程获取线程1的同步锁
        synchronized (thread1)
        {
            try
            {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                //第三步：主线程里面启动线程1，执行完start()方法之后线程1已经启动完成并且进入到了就绪队列，
                //      此时是与主线程并列的，但是执行到run方法的同步代码块的时候发现需要线程1的对象锁，
                //      此时因为主线程占用了线程1的对象锁，所以线程1的run方法是需要等待锁的释放然后再占用锁的，
                //      所以这里会继续往下执行，而线程1会synchronized (this)代码块处等待锁的释放。
                thread1.start();

                threadB.start();
                //错误提示 ： 这里threadB调用wait方法会报java.lang.IllegalMonitorStateException异常；
                //      因为wait方法只能是synchronized (obj)方法里面的obj对象才能调用，其他的对象没有这个权利。
                //threadB.wait();

                //第四步： 代号main4，另一个代号one4在ThreadA中（有两个线程同时执行，不分先后顺序）
                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                //第五步： 代号main，另一个代号one在ThreadA中（有两个线程同时执行，不分先后顺序）
                //      wait方法将会让main主线程释放线程1的锁，并且进入等待状态（阻塞）。释放完毕之后其他线程可以拥有。
                //注意：jdk的解释中，说wait()的作用是让“当前线程”等待，而“当前线程”是指正在cpu上运行的线程！
                thread1.wait();

                //第八步： main主线程已经被第七步中的notify方法唤醒并且获取到了线程1的对象锁。得以继续执行下去。
                System.out.println(Thread.currentThread().getName() + " continue");

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

class ThreadA extends Thread
{
    public ThreadA(String name)
    {
        super(name);
    }

    //第四步： 代号one4，另一个代号main4在Main主线程中（有两个线程同时执行，不分先后顺序）
    public void run()
    {
        //第五步： 代号one4，另一个代号main4在Main主线程中（有两个线程同时执行，不分先后顺序）
        //      当前方法在等待线程1的锁，所以会暂停在这里。
        synchronized (this)
        {
            try
            {
                //第六步： 此时main主线程释放线程1对象的锁，ThreadA线程1实例获取到了this，即将执行以下语句。
                System.out.println(Thread.currentThread().getName() + " call notify()");
                //第七步： 唤醒当前的wait线程
                //      ThreadA线程的实例线程1调用notify方法可以唤醒“当前对象（ThreadA线程的实例线程1）上的等待线程”，
                //      也就是唤醒“main主线程”，因为main主线程在等待ThreadA线程的实例线程1的同步锁获取。
                notify();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread
{
    private Thread threadA;

    public ThreadB(String name, Thread threadA)
    {
        super(name);
        this.threadA = threadA;
    }

    public void run()
    {
        synchronized (threadA)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " run method");
                System.out.println(Thread.currentThread().getName() + " call notify()");

                //这里直接notify会报错。必须加上threadA才行，直接notify默认应该是以ThreadB为对象进行唤醒，所以出错。
                threadA.notify();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
