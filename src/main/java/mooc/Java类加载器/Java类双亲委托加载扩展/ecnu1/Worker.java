package mooc.Java类加载器.Java类双亲委托加载扩展.ecnu1;

public class Worker {
	public void say()
	{
		System.out.println("I am loaded by AppClassLoader111111111111111111111111111111");
		ClassLoader c = Worker.class.getClassLoader();
		if(null != c)
		{
			System.out.println(c.getClass().getName());
		}
		else
		{
			System.out.println("Bootstrap Classloader");
		}
	}
}
