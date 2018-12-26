package main.thread;

/**
 * 线程卖票Thread形式
 * @author fanwei
 *
 */
public class TestTicketThread
{
    public static void main(String[] args)
    {
        TicketThread ttrThread1 = new TicketThread();
        ttrThread1.start();
        TicketThread ttrThread2 = new TicketThread();
        ttrThread2.start();
        TicketThread ttrThread3 = new TicketThread();
        ttrThread3.start();
    }

}

class TicketThread extends Thread
{
    private int ticket = 10;
    Object object;

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            if (this.ticket > 0)
            {
                System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }

}
