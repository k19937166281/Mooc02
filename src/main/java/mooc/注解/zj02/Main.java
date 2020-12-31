package mooc.注解.zj02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        int passed = 0, failed = 0;
        String className = "mooc.注解.zj02.Foo";
        for (Method m : Class.forName(className).getMethods()) {
            //通过反射判断此方法是否带有注解
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    //格式化呀，针不戳
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}


