package mooc.duoxiancheng.dxc02;

import java.io.FileFilter;
import java.io.FilenameFilter;

public class ThreadDemo4
{
    //start 方法只能执行一次
	public static void main(String [] args)
	{
		TestThread4 t=new TestThread4();
		t.start();
		//t.start(); e.prestackrce
		//t.start();
		//t.start();
		TestThread4 t1=new TestThread4();
		t1.start();


		Runnable runnable = ()->{
            System.out.println("");
        };
		runnable.run();

        FileFilter fileFilter =(name)->{
            return name.getName().equals("");
        };


	}
}

class TestThread4 extends Thread
{
	@Override
    public void run()
	{
		while(true)
		{
			System.out.println(Thread.currentThread().getName() +
			" is running");
			try {
				Thread.sleep(1000); //1000����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
