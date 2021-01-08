package mooc.多线程.dxc01;

public class ThreadDemo1
{
    //main方法是一个主体进程    在进程之中又加入了一个 线程   模拟多线程
	public static void main(String args[]) throws Exception
	{
		new TestThread1().start();
		while(true)
		{
			System.out.println("main thread is running");
			Thread.sleep(1000);
		}
	}
}

class TestThread1 extends Thread
{
	@Override
    public void run()
	{
		while(true)
		{
			System.out.println(" TestThread1 is running");
			try {
				Thread.sleep(1000); //1000����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
