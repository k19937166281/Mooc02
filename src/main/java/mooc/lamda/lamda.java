package mooc.lamda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class lamda {
    private int id;

    public lamda() {

        this.id = 1;

    }

    public int getId() {
        System.out.println(id);
        return id;
    }

    public static void main(String[] args) {
        lamda l1 = new lamda();

        Runnable getId = l1::getId;

        getId.run();

        List<String> strs = new ArrayList<>();
        strs.add("aa");
        strs.add("bb");
//        @FunctionalInterface
//        public interface Consumer<T> {
//        Consumer<? super T> action
        //消费者  消化器
        strs.forEach(System.out::println);

        File file = new File("C:\\");
        //类型推导
        File[] files = file.listFiles((dir,name)->name.startsWith("a"));

        //R 一个  集合或者Map  多行数据结构
//        <R> R collect(Supplier<R> supplier,
//                BiConsumer<R, ? super T> accumulator,
//                BiConsumer<R, R> combiner);
        //多参数 ，
        strs.stream().collect(ArrayList::new,(strsList,str)->str.startsWith("a"),(sl1,sl2)->sl1.addAll(sl2));


    }
}
