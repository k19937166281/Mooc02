package mooc.yufatang301.enumtype;


import java.util.HashMap;

public class SizeTest {

	public static void main(String[] args) {
        //  Enum 不能new    枚举里面的对象都是一个定义好的实例，取用即可
		Size s1 = Size.SMALL;
		Size s2 = Size.SMALL;
		Size s3 = Size.MEDIUM;

		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //false
	}
}

//枚举默认继承
enum Size {
	SMALL,MEDIUM,LARGE,EXTRA_LARGE;
}

