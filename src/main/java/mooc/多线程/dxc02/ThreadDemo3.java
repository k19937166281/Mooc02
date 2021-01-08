package mooc.多线程.dxc02;

public class ThreadDemo3
{
	public static void main(String args[])
	{
		//new TestThread3().start();
		//Runnable没有start方法，需要通过 Thread包装一次才可以使用 start 方法
		TestThread3 tt= new TestThread3();
		Thread t= new Thread(tt);
		t.start();
		while(true)
		{
			System.out.println("main thread is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class TestThread3 implements Runnable //extends Thread
{

	@Override
    public void run()
	{
		while(true)
		{
			System.out.println(Thread.currentThread().getName() + " is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
