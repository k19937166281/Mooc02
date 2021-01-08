package mooc.stream.s3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConvert {
    public static void main(String[] args) {



        List<Student> stus=new ArrayList<>();
        Student student1 = new Student("张三", 3);
        Student student2 = new Student("李四", 2);
        Student student3 = new Student("王五", 1);
        Student student4 = new Student("张三", 3);
        stus.add(student1);
        stus.add(student2);
        stus.add(student3);
        stus.add(student4);
        //Stream的许多返回值还是 Stream  调用方法就会转换 Stream  这就是  流的转换
        Stream<Student> students=stus.stream();
        Stream<Student> studentStream = students.filter(student -> student.getAge() > 1);
        Stream<String> stringStream = studentStream.map(student -> student.getName());

        //下面是详细点的


        //排序

        String[] strs = new String[]{"1a23121312","b23","c455","a66666"};
        //按照字符串长度排序
        Stream<String> strs1 = Stream.of(strs).sorted(Comparator.comparing(String::length));
        strs1.forEach(System.out::println);
        System.out.println("---------------------");
        //对自定义类进行排序，调用对象的 compareTo方法
        //当然需要实现  Comparable 接口  否则会  出现 类型转换异常 java.lang.ClassCastException: Student cannot be cast to java.lang.Comparable
        //我定义了排序规则为年龄大小
        stus.stream().sorted().forEach(student -> System.out.println(student.toString()));
        System.out.println("---------------------");
        //在sorted中调用了一个倒叙排序
        stus.stream().sorted(Comparator.reverseOrder()).forEach(student -> System.out.println(student.toString()));
        System.out.println("---------------------");
        //转化  Stream.map（里面放一个lamda表达式，它会自动进行类型推导，依据的是 Stream的泛型，得出此处的类对象是属于哪一个类的）
        //此处使用  map方法  转化出来一个  Stream<String>  然后使用 collect（）方法把它装入到list里面
        List<String> collect = stus.stream().map(student -> student.getName()).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
        System.out.println("---------------------");
        //拆开写
        //转化  这里用了一个  getName（） 这玩意儿是个方法  所以  map  里面可以填写方法
        Stream<String> stringStream12 = stus.stream().map(student -> student.getName());
        //装入  就是把流转换为一个 List  我平常前后台交互  用List比较多
        List<String> collect1 = stringStream12.collect(Collectors.toList());
        //for一下，这里  进行了一次  参数推导，自动的
        //  格式 是   对象名：：方法名  这个System类里面有个static对象属性  定义为  out  它内部的方法有个 println（String str）
        //  然后collect1的泛型是 String 的  就可以这样用
        collect1.forEach(System.out::println);
        System.out.println("---------------------");
        // 再拿Student的list举例,也能用，因为  println有许多重载方法  println（Object obj）
        stus.forEach(System.out::println);
        //也可以这样玩
        stus.forEach(student -> student.getName());

        System.out.println("---------------------");

        //过滤  接收一个lamda表达式 （lamda，自己去看嘿嘿）   去除重复，只留下不重复的元素
        //filter可以使用多次
        Stream<Integer> s1 = Stream.of(1,2,3,4,5);
        Stream<Integer> s2 = s1.filter(i->i>2);
        s2.forEach(System.out::println);
        System.out.println("---------------------");
        //去重 distinct()
        //这个是简单对象的去重
        Stream<Integer> s3 = Stream.of(1,1,2,3,2,3,4,5);
        Stream<Integer> s4 = s3.distinct();
        s4.forEach(System.out::println);
        System.out.println("---------------------");

        //，那么复杂的对象如何去重呢？先调用hashcode  再调用equals   HashSet也是如此
        stus.stream().distinct().forEach(System.out::println);
        System.out.println("---------------------");

        //截取  截取一个   那么这个流的长度是 1
        System.out.println(stus.stream().limit(1).count());


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> limit = integerStream.limit(3);
        //limit.forEach(System.out::println);
        System.out.println("---------------------");
        // 跳过
        Stream<Integer> integerStream2= Stream.of(1, 2, 3, 4, 5, 6, 8,9,1,2,8);
        //这货或跳过前  8  个   填写负数会出错    超过总长会  全部越过
        Stream<Integer> skip = integerStream2.skip(8);
        //skip.forEach(System.out::println);
        System.out.println("---------------------");
        // 链接  不能调用  已经关闭的流   如果skip变量 和  limit变量 没有被打印，它俩就还活着
        //也就是说  一个流 只能被使用  一次
        //java.lang.IllegalStateException: stream has already been operated upon or closed
        //Stream<Integer> concat = Stream.concat(integerStream, integerStream2);
        //System.out.println(concat.count());
        Stream<Integer> concat = Stream.concat(limit, skip);
        System.out.println(concat.count());
        System.out.println("---------------------");


        //其他  peek  作用类似于调试
        Stream<String> String3= Stream.of("saf", "sdfas");
        List<String> collect2 = String3.peek(System.out::println).map(s -> s+"safsadfsdafsaf").collect(Collectors.toList());
        collect2.forEach(System.out::println);

        System.out.println("---------------------");
        stus.stream().map(s->s.getAge()).filter(i->i>2).collect(Collectors.toList()).forEach(System.out::println);
    }
}
