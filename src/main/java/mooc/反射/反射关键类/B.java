package mooc.反射.反射关键类;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class B {

    public void f1(){
        System.out.println("B.f1....");
    }
public static void f11(){
        System.out.println("B.f1....");
    }

    private String f2(String s){
        System.out.println("B.f2....");
        return s;
    }



    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        B b = new B();

        Class bClass = b.getClass();

        //获取public 方法 包括父类和父接口
        Method[] methods = bClass.getMethods();
        for (Method method : methods) {
            if ("f11".equals(method.getName())||"f1".equals(method.getName())){
                method.invoke(b);
            }
        }
        Method[] declaredMethods = bClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            if ("f2".equals(declaredMethod.getName())){
                String a = (String)declaredMethod.invoke(b,"abc");
                System.out.println(a);
            }

        }
    }

}
