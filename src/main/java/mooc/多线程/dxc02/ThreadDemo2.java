package mooc.多线程.dxc02;

public class ThreadDemo2
{
	public static void main(String args[]) throws InterruptedException
	{
		new TestThread2().start();
//		while(true)
//		{
//			System.out.println("main thread is running");
//			Thread.sleep(1000);
//		}
	}
}
 class TestThread2 extends Thread
{
	@Override
    public void run()
	{
		while(true)
		{
			System.out.println("TestThread2" + " is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
