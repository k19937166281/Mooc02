package mooc.嵌套类.普通内部类和静态嵌套类.commoninner;

public class Outer3 {
	String name = "aaaaaa";
    //成员变量级别  可以继承 实现
	public class Bird extends Animal implements Flyable {
		public static final int a=3; //常量OK
		//public static int b = 4;   //error
		@Override
        public void fly() {
			System.out.println("I can fly " + name);
		}

		@Override
        public void eat() {
			System.out.println("I can fly");
		}
	}
	public Bird obj = new Bird();
	public void f1() {
		obj.fly();
		System.out.println(obj.getClass().getName());
		this.name = "bbbbbb";
		obj.fly();
	}

	public Bird getBird()
	{
		return this.obj;
	}
}
//这玩意不叫内部类
class pingjilei{

}
