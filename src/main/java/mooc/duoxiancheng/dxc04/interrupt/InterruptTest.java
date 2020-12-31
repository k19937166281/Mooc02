package mooc.duoxiancheng.dxc04.interrupt;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		TestThread1 t1 = new TestThread1();
		TestThread2 t2 = new TestThread2();

		t1.start();
		t2.start();

		// 当前线程停两秒钟之后再去干预  t1 t2
		Thread.sleep(2000);
        //由其他线程控制线程的终止，可能会 出现 抛出异常，资源占用无法释放 等问题
		t1.interrupt();//调用 中断线程方法
		t2.flag = false;//操作  volatile 变量
		System.out.println("main thread is exiting");
	}

}

class TestThread1 extends Thread {
	@Override
    public void run() {
		// 判断标志，当本线程被别人interrupt后，JVM会把本线程设置interrupted 标记
        //由其他线程控制线程的终止，可能会 出现 抛出异常，资源占用 等问题
		while (!interrupted()) {
			System.out.println("test thread1 is running");
			try {
			    //睡的时候被中断了，就会触发  InterruptedException
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("test thread1 is exiting");
	}
}

class TestThread2 extends Thread {
	public volatile boolean flag = true;
	@Override
    public void run() {
        // 定期监控共享变量 由自己来控制 线程的终止
		while (flag) {
			System.out.println("test thread2 is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("test thread2 is exiting");
	}
}
