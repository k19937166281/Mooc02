package mooc.多线程.dxc03;

public class ThreadDemo0
{
	public static void main(String [] args)
	{
        System.out.println(Thread.currentThread().getName());
        Object o = new Object();
        o.notify();
        new TestThread0().start();
		new TestThread0().start();
		new TestThread0().start();
		new TestThread0().start();
	}
}
class TestThread0 extends Thread
{
    //使用普通变量  打印了  400次，多个实例对象之间不相通
	private int tickets=100;
    // 使用static变量  实现了变量共享 执行了打印 103次
	//private static int tickets=100;
	@Override
    public void run()
	{
		while(true)
		{
			if(tickets>0)
			{
				System.out.println(Thread.currentThread().getName() +
				" is selling ticket " + tickets);
				tickets = tickets - 1;
			}
			else
			{
				break;
			}
		}
	}
}
