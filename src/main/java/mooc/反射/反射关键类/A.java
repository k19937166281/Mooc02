package mooc.反射.反射关键类;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class A
{
    public int age;
    private String name;

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        A obj = new A(20, "tom");
        Class<? extends A> aClass = obj.getClass();
        //获取本类及父类所有的public字段
        Field[] fields = aClass.getFields();
        System.out.println(fields[0].getName() + ":" + fields[0].get(obj));
        //获取本类所有声明的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //把字段对象设置为可访问的  对应 public  这不会改变类本身对这个字段设置的访问等级，在new时原本是private的，依然还是private的
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(obj));
        }


    }
}
