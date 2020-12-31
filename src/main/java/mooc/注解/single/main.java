package mooc.注解.single;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main {
    public static void main(String[] args) throws ClassNotFoundException {
        int passed=0,failed=0;
        String className = "mooc.注解.single.Foo";

        Class<Foo> aClass = (Class<Foo>) Class.forName(className);
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            //判断此方法是否带有注解
            if (m.isAnnotationPresent(SingleTest.class)){
                //获取方法上的注解
                SingleTest annotation = m.getAnnotation(SingleTest.class);
                try {
                    passed++;
                    //注解类型
                    System.out.println(annotation.annotationType());
                    //通过反射的方法传入注解的变量值 执行方法
                    //变量定义 int value() default 0;  调用的时候
                    m.invoke(aClass,annotation.value());
                } catch (Exception e) {
                    System.out.printf("Test %s failed: %s %n", m, e.getCause());
                    failed++;
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("faild:%d;passed:%d %n",failed,passed);
    }
}
