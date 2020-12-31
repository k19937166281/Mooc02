package mooc.泛型.GP02;

public class Interval<T> {

    private T lower;   //修饰成员变量  //Integer lower不使用泛型   等价于      Interval2<Integer>
    private T upper;                 //Integer upper不使用泛型
 //修饰  函数形参
    public Interval(T lower, T upper) {    //   (Integer lower, Integer upper) {    不使用泛型
        this.lower = lower;
        this.upper = upper;
    }
    public Interval() {    //   (Integer lower, Integer upper) {    不使用泛型

    }
//  修饰   返回值
    public T getUpper() {
        return upper;
    }
//  修饰   返回值
    public T getLower() {
        return lower;
    }

    public T main() {
        T a = (T) new Interval<Integer>(1,1).getUpper();
        System.out.println(a.getClass());
        return a;
    }
//第一个T ：指泛型方法得引入类型，第二个值：返回值对应类型
    public static <T> Interval<T> getReverse(Interval<T> intervalGP2){
        return new Interval<T>(intervalGP2.getUpper(), intervalGP2.getLower());
    }


    public static void main(String[] args) {
        Interval<String> stringInterval2 = new Interval<>("1", "2");
        String main = stringInterval2.getLower();
        System.out.println(main);

        Interval<String> reverse = Interval.<String>getReverse(stringInterval2);

            //todo : 前缀的T  指定引入类型       可以省略这种前缀
        Interval<String> reverse3 = Interval.<String>getReverse(stringInterval2);


        String main1 = reverse.getLower();
        System.out.println(main1);
    }




}
