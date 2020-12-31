package shejimoshi.factoryPattern;

import java.util.concurrent.ThreadPoolExecutor;

//通过工厂来引用想要的特定实例    我觉得enum枚举天生应用了这种模式
//实际业务中如此简单的图形类，并没有创建工厂的必要
//让我有一个疑问  直接使用多态 也能实现这种效果
public class FactoryPatternDemo {
    public static void main(String[] args) {

        ShareFactory shareFactory = new ShareFactory();
        Shape shape = shareFactory.getShape("rectangle");
        shape.draw();
        Shape shape1 = shareFactory.getShape("square");
        shape1.draw();
        Shape shape2 = shareFactory.getShape("circle");
        shape2.draw();

        Shape shape3 = new Rectangle();

    }
}
