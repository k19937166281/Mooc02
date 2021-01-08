package mooc.lamda.l1;

import java.util.Arrays;

public class Lamda1 {
    public static void main(String[] args) {

        String[] plants = new String[]{"p1","p2-","p3--","p4---","p5-","p6","p7","p8"};

        System.out.println("从小到大");

        Arrays.sort(plants,new LengthAscComparator());//我们这样写，重量且浪费，如果使用  lamda表达式的方法，会简便许多

        System.out.println(Arrays.toString(plants));

        //lamda式的写法   简便  轻量
        Arrays.sort(plants,(s1,s2)->s1.length()-s2.length());//
        System.out.println(Arrays.toString(plants));//lamda式的写法
        Arrays.sort(plants,(s1,s2)->(-1)*(s1.length()-s2.length()));//参数二实现了  函数式接口 Comparator<? super T> c，实现了他的 compare方法，制定了此处的排序规则
        System.out.println(Arrays.toString(plants));

        //面向对象语言   传递基本类型的变量 以及  对象变量
        //  刚开始，为了 保持java的简单性，一致性，拒绝此功能，，java8 开始，，可以传递  方法和代码块，这就是  java的lamda表达式实现


        //lamda表达式的发明人  数学家/逻辑学家  Alonzo Church   他是计算机发明者 图灵的老师，牛逼

        //语法格式
        //单语句
        //  -参数，箭头，一条语句
        //多语句
        //  -参数，箭头，{多个语句}
//        （first，second）->{    lamda的形式参数  可以不写参数类型，java会进行自动推导
//            return xxx；
//        }
        //概念：    类似于匿名方法，一个没有名字的方法    参数，箭头，表达式语句   可以忽略写 参数类型   坚决不声明返回值类型
        //没有  public protected private static final 等修饰符
        //单句表达式，将直接返回值，不用大括号
        //lamda的表达式逻辑代码部分 如果写了return ，就算多句的语法格式，必须带有   大括号

        //无参数  ，仅仅保留  括号，箭头，表达式    （）->逻辑代码  如（）->xxx>0
        new Thread(()->{
            int sum = 0;
            for (int i = 0; i <11 ; i++) {
                sum = sum+i;
            }
            System.out.println(sum);
        }).start();
        //一个参数，可以省略 括号，箭头，表达式
        Adder adder = x -> x+1;
        System.out.println(adder.selfAdd(1));

        //如果有返回值  例如 下面内部接口的  selfAdd 方法     返回值类型会在上下文推断出来，无需声明
        //比如一段代码有两种  结果   只在其中一种觉结果后面带上返回值，是不合法的,无需运行，编译器直接不支持
//        Adder adder2 = x -> {
//            if (x > 0)
//                return x+1;
////            else
////                return x;
//        };


    }

    interface Adder{
        int selfAdd(int x);
    }
}
