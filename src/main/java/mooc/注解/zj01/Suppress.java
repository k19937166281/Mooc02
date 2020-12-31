package mooc.注解.zj01;

import java.util.Date;

public class Suppress {
    //压制警告  作用域在此注解类中有详细介绍
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int a = 6;

        Date date = new Date();
        System.out.println(date.getDate());
    }
}
