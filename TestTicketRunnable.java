package main.thread;

/**
 * 线程卖票Runnable形式
 * @author fanwei
 *
 */
public class TestTicketRunnable
{
    public static void main(String[] args)
    {
        TicketRunnable ticketRunnable = new TicketRunnable();

        Thread thread1 = new Thread(ticketRunnable);
        Thread thread2 = new Thread(ticketRunnable);
        Thread thread3 = new Thread(ticketRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketRunnable implements Runnable
{
    private int ticket = 10;

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            if (this.ticket > 0)
            {
                System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }

}
