package mooc.多线程.dxc04.deadlock;

import java.util.concurrent.TimeUnit;
//死锁问题
//哲学家吃面条 五个人 五根筷子  每人同一时刻拿右手边筷子，再去拿左手边筷子
//才能吃的上面条，但是 N的左边是N-1 的右边 所以，任何一个哲学家需要的左手筷子对象都拿不到
//也就是进入了 死锁状态
//某一个线程需要用的对象被其他的线程占用着，那么这个线程就进入了死锁状态
//
public class ThreadDemo5
{
	public static Integer r1 = 1;
	public static Integer r2 = 2;
	public static void main(String args[]) throws InterruptedException
	{
		TestThread51 t1 = new TestThread51();
        TestThread52 t2 = new TestThread52();
		t1.start();
		t2.start();
	}
}

class TestThread51 extends Thread
{
	@Override
    public void run()
	{
	    //synchronized(ThreadDemo5.r2)  这样的调用顺序会造成死锁
		//正确的资源调用顺序  能够避免死锁
		synchronized(ThreadDemo5.r1)
		{
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//synchronized(ThreadDemo5.r1) 这样的调用顺序会造成死锁
            synchronized(ThreadDemo5.r2)
			{
				System.out.println("TestThread51 is running");
			}
		}
	}
}
class TestThread52 extends Thread
{
	@Override
    public void run()
	{
		//��Ҫr2,��Ҫr1
		synchronized(ThreadDemo5.r1)
		{
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(ThreadDemo5.r2)
			{
				System.out.println("TestThread52 is running");
			}
		}
	}
}
