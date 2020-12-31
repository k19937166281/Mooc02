package mooc.duoxiancheng.dxc02;

public class Thread2 implements Runnable{

    @Override
    public void run()
	{
		System.out.println("hello");
	}

	public static void main(String[] a)
	{
	    new Thread(new Thread2()).start();
	}

}
