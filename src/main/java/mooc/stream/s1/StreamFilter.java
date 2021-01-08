package mooc.stream.s1;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
    public static void main(String[] args) {
        //老式写法
        String[] strs=new String[]{"12345","asdfg","qwerty","!@!#!$","zxcvbn"};
        byte count = 0;
        for (String str : strs) {
            if (str.length()>5){
                count++;
            }
        }
        System.out.println(count);
        //把数组转化为 List
        List<String> strList = Arrays.asList(strs);
        //然后一句话取得数量    filter 内部通过lamda进行了 类型推导
        long listCount=strList.stream().filter(p->p.length()>5).count();
        System.out.println(listCount);
        //如果集合长度很长  可以使用  并行流parallelStream
        long pCount=strList.parallelStream().filter(p->p.length()>5).count();
        System.out.println(pCount);

    }


}
