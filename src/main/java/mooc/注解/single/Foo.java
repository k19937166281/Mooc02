package mooc.注解.single;

import mooc.注解.zj01.SingleValue;

public class Foo {

    @SingleTest(1)
    public static void m1(int a){
        if (a<0){
            throw new RuntimeException("m1 ex");
        }
        System.out.println("m111111");
    }

    @SingleTest(value = -1)
    public static void m2(int a){
        if (a<0){
            throw new RuntimeException("m2 ex");
        }
    }


    public static void m3(int a){

    }



}
