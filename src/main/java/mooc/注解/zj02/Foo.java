package mooc.注解.zj02;

public class Foo {

    @Test
    public static void m1(){
        throw new RuntimeException("m1 Exception");
    }

    public static void m2(){

    }

    @Test
    public static void m3(){
        throw new RuntimeException("m3 Exception");
    }

    public static void m4(){

    }

    @Test
    public static void m5(){
        System.out.println("m5");
    }

    public static void m6(){

    }

}
