package mooc.注解.zj06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

@Fruit(name="apple")
public class Main {
    public static void main(String[] args) {
        //代理类导出设置    加上setProperty之后在项目里生成了两个class文件
        //E:\新季度\Project\Mooc02\com\sun\proxy\$Proxy0.class
        //E:\新季度\Project\Mooc02\com\sun\proxy\$Proxy1.class
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Fruit annotation = Main.class.getAnnotation(Fruit.class);

        System.out.println(annotation.name());
        //com.sun.proxy.$Proxy1  注解类被实现成了代理类的模式
        System.out.println(annotation.getClass().getName());


        Type[] genericInterfaces = annotation.getClass().getGenericInterfaces();
        System.out.println("--------");
        for (Type genericInterface : genericInterfaces) {
            //一个继承了 Fruit类 的代理类  能够实现前置后置操作了
            System.out.println(genericInterface.getTypeName());
        }
        //因为注解类被解析成了一个 接口 ，以上代码就像是  一个接口 和 一个实现类 的 感觉

        //Fruit annotation 在它被解析成一个代理类的时候就已经有了InvocationHandler对象
        //通过 $Proxy1  老师说要探索 InvocationHandler 这个类
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
        System.out.println(invocationHandler.getClass().getName());
        //sun.reflect.annotation.AnnotationInvocationHandler

    }
}
