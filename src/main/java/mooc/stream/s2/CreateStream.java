package mooc.stream.s2;

import com.wgw.EverytimeuseApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //我平常用到的都是  对于 List的 流式操作   通常操作对象

        //Collection接口中定义了 stream<T> 方法   ，   return StreamSupport.stream(spliterator(), false);
        // 所以集合类都可调用 stream 方法  将集合 转换为  流
        Stream<String> stream1=new ArrayList<String>().stream();
        Stream<String> stream2=new HashSet<String>().stream();
        //Arrays 工具类 中也引入 stream 的调用方法
        //return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
        Stream<String> arrayStream= Arrays.stream("a,b,c,e,d".split(","),3,5);

        Set<String> sets = new HashSet<>();
        sets.stream();

        Map<String,String> maps = new HashMap<>();
        //Map 不行

        //通过 stream.of() 创建流
        Stream<Integer> c1=Stream.of(new Integer[5]);
        Stream<String> c2=Stream.of("a,b,c".split(","));
        Stream<String> c3=Stream.of("a","b","c");
        Stream.of(new HashSet<String>());
        //产生一个空流  泛型啥都行
        Stream<String> d1=Stream.empty();

        //接收一个lamda表达式     Supplier<T>
        //@FunctionalInterface
        //public interface Supplier<T> {
        Stream<String> e1=Stream.generate(()->"hello");
        //Math.random() 返回值  double
        Stream<Double> e2=Stream.generate(Math::random);

        //有三种基本类型流 IntStream LongStream  DoubleStream
        IntStream s2=IntStream.of(1,2,3,4,5);
        //转换为对象流
        Stream<Integer> s3=s2.boxed();
        //转换为 基本类型流   mapToInt(放入一个lamda)
        //@FunctionalInterface
        //public interface ToIntFunction<T> {
        IntStream s4=s3.mapToInt(Integer::intValue);

        //特殊流  并行流  会以并行化方式来操作，当前机器有多少个CPU，它就分成多少个线程来做（自动化的）  并行 串行  需另行了解
        //Collection.parallelStream() 将集合转换为并行流
        //Stream<T>.parallel() 将流转换为 并行流
        IntStream o1=IntStream.range(1,1000); //流里包含 1到999
        IntStream o2=IntStream.rangeClosed(1,1000); //流里包含 1到1000
        //普通流转换为 并行流
        IntStream o3=o1.parallel();

        Stream<String> p1=new ArrayList<String>().parallelStream();
        p1.isParallel();
        //需要保证传给并行流的操作不存在竞争

        //其他类/方法产生流  简洁方便快
        try {
            Stream<String> contents=Files.lines(Paths.get("C:/a.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<String> words= Pattern.compile(",").splitAsStream("1,2,3");


    }



}
