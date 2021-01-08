package mooc.多线程.dxc03;

public class ThreadDemo2
{
	public static void main(String args[]) throws Exception
	{
		TestThread2 t = new TestThread2();
		t.start();
		Thread.sleep(2000);
		t.flag = false;
		System.out.println("main thread is exiting");
	}
}

class TestThread2 extends Thread
{
    //使用普通变量时   在main线程改变了flag后 子线程始终访问的是自己的工作缓存flag的值
	boolean flag = true;
	//用volatile 修饰的变量可以及时在各线程中通知
	//volatile boolean flag = true;
	@Override
    public void run()
	{
		int i=0;
		while(flag)
		{
			i++;
		}
		System.out.println("test thread3 is exiting");
	}
}
