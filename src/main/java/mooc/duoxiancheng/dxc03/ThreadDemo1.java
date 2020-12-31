package mooc.duoxiancheng.dxc03;

public class ThreadDemo1
{
	public static void main(String [] args) {
        System.out.println(Thread.currentThread().getName());//main

        TestThread1 t = new TestThread1();
        new Thread(t).start();
        System.out.println(1);
        new Thread(t).start();
        System.out.println(2);
        new Thread(t).start();
        System.out.println(3);
        new Thread(t).start();

//        TestThread1 t2=new TestThread1();
//        new Thread(t2).start();
    }
}
class TestThread1 implements Runnable
{
    //打印了 138次    普通变量在多个  实现了runable的类的实例对象之间  互通，
    // 看上去了实现了变量共享的效果
    // 写法上  是执行了 四次 new Thread(t).start();
    // 操作的对象始终是  t  对象，
    // 不过实现了  多线程 的效果，多个线程处理同一个任务

	private int tickets=100;
	@Override
    public void run()
	{
		while(true)
		{
			if(tickets>0)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tickets--;
				//Thread.currentThread().getName() JVM 会给线程一个默认名称
				System.out.println(Thread.currentThread().getName() +" is selling ticket " + tickets);
			}
			else
			{
				break;
			}

		}
	}
}
