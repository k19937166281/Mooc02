package mooc.嵌套类.匿名内部类和局部内部类;

public class Outer1 {

    private String name = "abc";


    public void f1(){
        String name = "def";

        //匿名内部类会被编译成一个class文件的 命名规则是 $+代码中的顺序号
        //mooc.嵌套类.匿名内部类和局部内部类.Outer1$1
        Runnable runnable = new Runnable() {
            //匿名内部类不能定义静态变量，除非是常量
            public static final int c = 1;
            //public static int b = 1;
            String name = "ghi";
            @Override
            public void run() {
                //变量
                final int a = 5;
                int b = 5;
                //匿名内部类会自动屏蔽 外部方法的临时变量
                //会屏蔽外部类的成员变量
                System.out.println("hello"+name);

                Outer1 outer1 = new Outer1();
                System.out.println("hello"+outer1.name);
            }
            //不支持 static方法  静态方法不能再匿名内部类定义   会提示  make ”f2“ not static
//            public static void f2(){
//
//            }

        };

        new Thread(runnable).start();

        System.out.println(runnable.getClass().getName());

        //mooc.嵌套类.匿名内部类和局部内部类.Outer1$2
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello" + Outer1.this.name);
            }
        };

        new Thread(runnable1).start();
        System.out.println(runnable1.getClass().getName());

    }


    public static void main(String[] args) {
        new Outer1().f1();

//        执行结果
//        mooc.嵌套类.匿名内部类和局部内部类.Outer1$1
//        helloghi
//        helloabc
//        mooc.嵌套类.匿名内部类和局部内部类.Outer1$2
//        helloabc

    }

}
