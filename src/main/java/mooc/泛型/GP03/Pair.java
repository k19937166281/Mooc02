package mooc.泛型.GP03;

import java.util.ArrayList;
import java.util.List;

public class Pair<T> {

    private T first;
    private T second;

    public Pair()
    {
        first = null;
        second = null;
    }

    public Pair(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }


    public static void main(String[] args) {
        Pair<Apple> applePair = new Pair<>(new Apple(3),new Apple(4));

        Pair<? extends Fruit> fruits = applePair;

        Fruit first = fruits.getFirst();
        System.out.println(first.getClass().getName());


        //下限界定符号： Pair<? super S>   Pair能接收的类型参数   是 S 的自身或者是  S的父类 父接口

        Pair<? super Apple>  lowerBound =  new Pair<Fruit>();
        lowerBound.setFirst(new Apple(5));//Apple到超类的转型
        //lowerBound.setSecond(new Object());//无法转型为 Apple的超类型
    }

    //上限界定符    T 和 T 子类
    public void upperLimit(Pair<? extends T> pair){
        Pair<Apple> applePair = new Pair<>(new Apple(2),new Apple(3));
        Pair<?> fruitPair = applePair;




    }

    //下限界定符   T 和 T超类
    public void lowerBound(Pair<? super T> pair){

    }

}
