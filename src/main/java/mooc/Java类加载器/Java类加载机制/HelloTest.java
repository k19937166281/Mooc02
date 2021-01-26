package mooc.Java类加载器.Java类加载机制;

public class HelloTest {
    public static void main(String[] args) {
        new Hello().say();
    }
}
//jVM是有序的根据需要来加载相应的类
//加上了VM参数   -verbose：class 之后，最易于理解的一部分打印
//[Opened C:\Program Files\Java\jdk1.8.0_221\jre\lib\rt.jar]
//[Loaded java.lang.Object from C:\Program Files\Java\jdk1.8.0_221\jre\lib\rt.jar]
//[Loaded java.lang.String from C:\Program Files\Java\jdk1.8.0_221\jre\lib\rt.jar]
//[Loaded mooc.Java类加载器.Java类加载机制.HelloTest from file:/E:/新季度/Project/Mooc02/target/classes/]
//[Loaded mooc.Java类加载器.Java类加载机制.Hello from file:/E:/新季度/Project/Mooc02/target/classes/]
//[Loaded java.lang.Shutdown$Lock from C:\Program Files\Java\jdk1.8.0_221\jre\lib\rt.jar]
