package mooc.语法糖.enumtype;

public class FruitTest {
	public static void main(String[] args) {
	    //枚举的 属性 调用方式
		Fruit a1 = Fruit.APPLE;
		System.out.println("Price is " + a1.getPrice());
	}
}

enum Fruit
{
	APPLE(10), ORANGE(8);
	private int price;
    //枚举的构造  只能够 不写（此时默认为  degfault）或者 写 private
	Fruit(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
}

