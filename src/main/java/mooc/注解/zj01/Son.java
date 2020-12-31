package mooc.注解.zj01;

public class Son extends Father{
    @Override
    public void f1() {
        super.f1();
    }
    //会检测一下父类是否存在这个方法
    //@Override
    public void f2() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        new Son().f2();

    }
}
