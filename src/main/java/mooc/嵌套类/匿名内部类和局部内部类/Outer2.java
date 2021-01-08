package mooc.嵌套类.匿名内部类和局部内部类;

public class Outer2 {
    static String name = "abc";
    String name2 = "abc";


    public void f1(){
        String name = "efg";

        //局部内部类
        class Inner2111111 implements Runnable {
            final static int a = 1;
            //error
            // static int b = 1;
            String name= "ghi";
            public void f2(){
                System.out.println(name);
                // 普通 方法 对应 普通变量 对应 普通 调用方式
                System.out.println(Outer2.this.name2);
            }

            @Override
            public void run() {

            }
        }
        Inner2111111 inner2 = new Inner2111111();
        inner2.f2();
        System.out.println(inner2.getClass().getName());

    }

    public static void f2(){
        String name = "efg";

        //局部内部类
        class Inner2{
            //error
            // static int b = 1;
            //String name= "ghi";
            public void f2(){
                System.out.println(name);
                //  static 方法 对应 static变量 对应 static 调用方式
                System.out.println(Outer2.name);
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.f2();
        System.out.println(inner2.getClass().getName());

    }

    public static void main(String[] args) {

        Outer2 outer2 = new Outer2();
        outer2.f1();
        f2();

        //命名规则  外部类名+$+顺序号+内部类名
       /* ghi
                abc
        mooc.嵌套类.匿名内部类和局部内部类.Outer2$1Inner2111111
                efg
        abc
        mooc.嵌套类.匿名内部类和局部内部类.Outer2$1Inner2*/
    }
}
