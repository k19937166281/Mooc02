package mooc.Java类加载器.Java类双亲委托加载扩展.ecnu1;

public class WorkerTest {

	public static void main(String[] args) {
		new Worker().say();
        Class aClass = new Worker().getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader.getClass().getName());

        //-Xbootclasspath/a:E:/java/source/PMOOC11-02/bin
		//-Xbootclasspath/a:E:/新季度/Project/Mooc02/target/classes/mooc/Java类加载器/Java类双亲委托加载扩展/ecnu
	}
}
