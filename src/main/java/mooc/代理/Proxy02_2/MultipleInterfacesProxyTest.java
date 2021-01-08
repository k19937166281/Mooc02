package mooc.代理.Proxy02_2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class MultipleInterfacesProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        CookImpl cook = new CookImpl();
        ClassLoader classLoader = MultipleInterfacesProxyTest.class.getClassLoader();

        CookProxyHandler cookProxyHandler = new CookProxyHandler(cook);

        //生成代理类型
        Class<?> proxyClass = Proxy.getProxyClass(classLoader, new Class<?>[]{Cook.class, Driver.class});

        //生成代理对象
        Object proxy = proxyClass.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{cookProxyHandler});

        System.out.println(Proxy.isProxyClass(proxyClass));
        Proxy p = (Proxy)proxy;
        System.out.println(p.get);
    }
}
