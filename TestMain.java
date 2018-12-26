package main.thread;

/**
 * 线程测试类
 * @author fanwei
 * Thread 和 Runnable 的相同点：都是“多线程的实现方式”。
 * Thread 和 Runnable 的不同点：
 * Thread 是类，而Runnable是接口；Thread本身是实现了Runnable接口的类。我们知道“一个类只能有一个父类，但是却能实现多个接口”，因此Runnable具有更好的扩展性。
 * 此外，Runnable还可以用于“资源的共享”。即，多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。
 * 通常，建议通过“Runnable”实现多线程！
 */
public class TestMain
{

}

/**
 * start() : 它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
 * run()   : run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！
 * 
 */
