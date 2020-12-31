package mooc.duoxiancheng.dxc02;

public class ThreadDemo0
{
	public static void main(String args[]) throws Exception
	{
	    //直接使用  run方法 执行出来的效果是   串行效果   只会一直在  run方法中 进行循环打印，而不会执行 main方法中的循环
        //建议使用   start（）方法 ，这个方法会自动调用  run 方法，并且执行效果是  并行的
		new TestThread0().run();
		while(true)
		{
			System.out.println("main thread is running");
			Thread.sleep(10);
		}
	}
}
 class TestThread0 extends Thread
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
