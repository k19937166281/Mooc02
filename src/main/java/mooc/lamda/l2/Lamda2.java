package mooc.lamda.l2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class Lamda2 {   //函数式接口 讲解
    public static void main(String[] args) {

        String[] plants = new String[]{"p1","p2-","p3--","p4---","p5-","p6","p7","p8"};
        //public static <T> void sort(T[] a, Comparator<? super T> c)
        Arrays.sort(plants,(s1, s2)->(-1)*(s1.length()-s2.length()));

        //Arrays.sort 接受的两个参数  一是  一个数组，二是一个Comparator对象  ，那么由此得出 (s1, s2)->(-1)*(s1.length()-s2.length())  可以替代一个Comparator对象
        //那么：
        Comparator<String> com = (s1, s2) -> (-1) * (s1.length() - s2.length());//用这一小段代码，引入局部变量，惊了，它可以替代N多个对象，此处使用 Comparator对象
        Arrays.sort(plants,com);
        //成立

        //那么探究本质  ，它其实是一种   嵌套类的实现  ,此处必须实现这个  接口的   方法  ，而  lamda表达式（匿名函数）自动成为接口方法的实现
        //  接口是  有名字没有实现，，  lamda是 有实现，没有名字   ，匹配并且填充      自动填充  实现接口的抽象方法
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return (-1) * (s1.length() - s2.length());
            }
        };
        //此时  引入   java的函数式接口的定义
        //首先它是一个接口，然后它内部只能有一个 未实现的  抽象方法  除此之外  可以  有   default  static  private  的带有方法体的  方法    这些是  java8乃至java9推出的新东西
        //由于只有一个未实现的方法，所以 lamda可以自动填上这个未实现的方法

        //采用lamda表达式，可以自动创建一个 （伪）嵌套类的对象，没有实际的嵌套类（会生成带有$符号的文件） class文件产生，比真正的嵌套类，轻量，方便，好用
        //Comparator 中其实呢，是两个方法  但是一个 是  equals   ，在进行 实现 Comparator时，会自动  继承Object，继承了Object的equals实现

        //自定义函数式接口 并进行试验
        String[] plants2 = new String[]{"p","p-","p3--","p4---","p5-","p6","p7","p8"};

        StringChecker checker = (s)->s.length()%2==0;

        for (String s : plants2) {
            System.out.println(checker.test(s));
        }

        // 函数式接口带来方便，同时也有隐含的弊端，如果大量重复性的函数式接口，会使源码膨胀，过多的class文件被编译出来，
        //此时，jdk提供了一个可以重复使用的函数式接口  涵盖大部分常用功能，可以重复使用  位于  java。util function 包

        //Predicate<T> 谓词函数       T  boolean 接受一个参数，返回一个布尔值
        //Consumer<T>  消费者   T  void  接收一个参数 ，无返回
        //Function<T,R>        T  R  接收一个参数，返回一个值
        //Supplier<T>数据提供者   None  T   数据工厂
        Predicate<String> predicate = (s)->s.length()%2==0;  //boolean test(T t);

        Consumer<String> printer = s-> System.out.println("pp"+s);//void accept(T t);  Stream.map()
        for (String s : plants2) {
            printer.accept(s);
        }
        System.out.println("11111111111111111111111");
        Supplier<String> stringSupplier = ()->plants[(int)floor(random()*8)]; // T get();   Stream.collect()
        for (int i = 0; i < 6 ; i++) {
            System.out.println(stringSupplier.get());
        }
        System.out.println("11111111111111111111111");

        String[] plants3 = new String[]{"p","p-","p3--","p4---","p5-","p6","p7","p8"};
        Function<String,String> upper = s->{return s.toUpperCase();};
        for (String s : plants3) {
            System.out.println(upper.apply(s));
        }
    }

}
