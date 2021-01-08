package mooc.多线程.dxc01;

public class ProcessDemo1 {
    //启动两次这个项目  模拟多进程   多进程  就是 串行执行
	public static void main(String[] args) {
		while(true)
		{
			int a = (int) (Math.random() * 100);
			System.out.println(" main thread is running " + a);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
