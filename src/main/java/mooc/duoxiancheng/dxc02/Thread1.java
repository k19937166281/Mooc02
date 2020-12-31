package mooc.duoxiancheng.dxc02;

public class Thread1 extends Thread{
	@Override
    public void run()
	{
		System.out.println("hello");
	}
	public static void main(String[] a)
	{
		new Thread1().start();
	}
}
