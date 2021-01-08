package mooc.多线程.dxc03;

public class ThreadDemo3 {
	public static void main(String[] args) {
		TestThread3 t = new TestThread3();
		new Thread(t, "Thread-0").start();
		new Thread(t, "Thread-1").start();
		new Thread(t, "Thread-2").start();
		new Thread(t, "Thread-3").start();
	}
}

class TestThread3 implements Runnable {
	private volatile int tickets = 100;
	String str = new String("");

	@Override
    public void run() {
	    //通过 synchronized 保证了同一时刻只有一个线程能够访问变量

		while (true) {
			sale();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (tickets <= 0) {
				break;
			}
		}

		while (true) {
		    //老师的意思好像是说   随便锁个啥都行
            //{ synchronized (this){synchronized (this)
		    synchronized (str.getClass()){
                sale2();
            }
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (tickets <= 0) {
				break;
			}
		}

	}

	public synchronized void sale() {
		if (tickets > 0) {
			System.out.println(Thread.currentThread().getName() + " is saling ticket " + tickets--);
		}
	}

	public void sale2() {
		if (tickets > 0) {
			System.out.println(Thread.currentThread().getName() + " is saling ticket " + tickets--);
		}
	}

}
