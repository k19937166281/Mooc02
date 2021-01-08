package mooc.反射.反射关键类;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class D extends A{
    private int num;

    private D() {
        super(1,"");
        this.num = 10;
    }

    private D(int num) {
        super(1,"");
        this.num = num;
    }

    public void printNum(){
        System.out.println(this.num);
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        D d = new D();
        Class dClass = d.getClass();
        //只能获取本类的public 构造
        Constructor[] constructors = dClass.getConstructors();
        System.out.println(constructors.length);
        //能够获取本类的所有构造
        Constructor[] declaredConstructors = dClass.getDeclaredConstructors();
        System.out.println(declaredConstructors.length);
        for (Constructor constructor : declaredConstructors) {
            constructor.setAccessible(true);
            if (constructor.getParameterCount()>0){
                D d1 = (D) constructor.newInstance(100);
                d1.printNum();
            }else {
                D d2 = (D) constructor.newInstance();
                d2.printNum();
            }
        }

    }
}
