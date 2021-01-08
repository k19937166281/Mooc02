package mooc.代理.Proxy02_2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
* 代理类的调用处理器
* */
public class CookProxyHandler implements InvocationHandler {

    private Cook cook;

    public CookProxyHandler(Cook cook) {
        this.cook = cook;
    }
    //此函数在代理对象调用任何一个方法时都会被调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        //定义预处理的工作，当然你也可以根据method的不同进行不同的预处理工作
        System.out.println("------before-------");
        Object result = method.invoke(cook, args);
        System.out.println("------after-------");
        return result;
    }
}
