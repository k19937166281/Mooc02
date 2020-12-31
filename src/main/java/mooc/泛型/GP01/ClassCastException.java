package mooc.泛型.GP01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ClassCastException {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(123);
        list.add("fasf");
        list.add(123);
        //编译时没错误
        //ClassCastException extends RuntimeException
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        for (Object o : list) {
            //System.out.println((String)o);
        }
        //那么就必须加以限制，限定一种类型     存储和使用：不需要转型，没有转型错误

        //  右侧可以自动推导出对应的  广泛类型   犯不着在同一句代码中  写下两次  广泛类型   拒绝冗余
        ArrayList<Integer> list2 = new ArrayList();
        list2.add(123);


        ArrayList<String> list3 = new ArrayList();
        list3.add("123");
        list3.add("234");

        //  todo:  拆箱操作
        list2.get(0);
        //查询元素在集合中的下标的   有就返回对应下标     没有就返回   -1
        int i = Collections.binarySearch(list3, "123");
        int i1 = Collections.binarySearch(list3, "234");
        int i2 = Collections.binarySearch(list2, 1);

        System.out.println(i);
        System.out.println(i1);


        System.out.println(i2);
        //迭代器  支持  泛型
        Iterator<Object> iterator = list.iterator();

    }
}
