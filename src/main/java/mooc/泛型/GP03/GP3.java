package mooc.泛型.GP03;

import javafx.util.Pair;

import java.io.File;
import java.io.Serializable;
//多参数 使用   ， 分割
public class GP3<T extends File &Cloneable,U extends Serializable> {

    //限定了传入的  类型 必须是继承了 Comparable这个比较器的 类
    public static <T extends Comparable & Serializable> T getMin(T... a){
        if (a==null || a.length == 0){
            return null;
        }
        T min = a[0];

        for (int i = 0; i <a.length ; i++) {
            if (min.compareTo(a[i])>0){
                min = a[i];
            }
        }

        return min;
    }




    public static void main(String[] args) {

        Pair<Integer, Integer> fileFilePair = new Pair<>(1, 2);

        //Integer extends Number implements Comparable<Integer>
        Integer min = GP3.getMin(1, 2, 3);

        System.out.println(min);
    }


}
