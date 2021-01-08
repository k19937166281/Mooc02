package mooc.代理.Proxy02;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        //创建目标对象
        SubjectImpl subject = new SubjectImpl();
        //创建调用处理器对象     处理器自己创建需要实现java.lang.reflect.InvocationHandler
        FanxingProxyHandler proxyHandler = new FanxingProxyHandler(subject);
        //动态生成代理对象 这个是通过反射包下面的java.lang.reflect.Proxy类闯入  类加载器，类的接口，代理处理器（定义了对被代理类的前置后置处理方法）
        //现在我感觉动态代理，适用于一个类有好多方法都需要相对复杂点的通用前置后置操作时
        Subject proxyInstance = (Subject)Proxy.newProxyInstance(
                subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), proxyHandler);

        //好强
        proxyInstance.request();
        int i = proxyInstance.requestInt(2, 1);
        System.out.println(i);

        System.out.println(proxyInstance.getClass().getName());
    }
}
