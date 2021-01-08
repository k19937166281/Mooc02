package mooc.嵌套类.嵌套类对比.third;

import mooc.嵌套类.嵌套类对比.comparison.Outer3;

public class Outer3Test extends Outer3 {

	public static void main(String[] args) {
		Outer3 foo = new Outer3();
		Inner3 foo2 = foo.new Inner3();

	}

}
