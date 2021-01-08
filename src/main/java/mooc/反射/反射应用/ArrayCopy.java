package mooc.反射.反射应用;

import java.lang.reflect.Array;

public class ArrayCopy {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        a = (int[])goodCopy(a,10);
        for (int i : a) {
            System.out.println(i);
        }
    }
    //java核心技术 卷1的一个例子
    public static Object goodCopy(Object oldArray,int newLength){
        //返回的是 Array类型
        Class aClass = oldArray.getClass();
        //获取数组中的单个元素类型
        Class componentType = aClass.getComponentType();

        //旧数组长度
        int oldLength1 = Array.getLength(oldArray);

        //新数组
        Object newArray = Array.newInstance(componentType, newLength);

        //拷贝旧数据
        System.arraycopy(oldArray,0,newArray,0,oldLength1);
        return newArray;
    }
}
