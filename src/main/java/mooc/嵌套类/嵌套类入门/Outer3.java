package mooc.嵌套类.嵌套类入门;

public class Outer3 {
    String name;
    //局部内部类
    public void f1(){
        //这是一个类的定义，但是它是放在一个方法上的
        //局部内部类，它是放在某一个方法里面的，或者是某一个局部的代码块 例如 if for
        class Inner3{
            String name;
        }
        Inner3 inner3 = new Inner3();
        inner3.name = "";

        if (true){
            class a{

            }
            {;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}
                System.out.println();
            }
        }
    }

    class a{

    }

}
