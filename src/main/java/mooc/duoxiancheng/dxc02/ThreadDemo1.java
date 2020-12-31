package mooc.duoxiancheng.dxc02;

public class ThreadDemo1
{
	public static void main(String args[]) throws Exception
	{
	    //对应的调整为  start 启动方式后，就是并行效果
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
