package mooc.嵌套类.嵌套类入门;

public class Outer4 {
    String name;

    //匿名内部类   使用场景 只用一次的类，没必要再给它定义名字
    public void f1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();
    }

}
