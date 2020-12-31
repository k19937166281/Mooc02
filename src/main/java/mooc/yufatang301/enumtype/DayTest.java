package mooc.yufatang301.enumtype;

public class DayTest {

	public static void main(String[] args) {

		Day d1 = Day.MONDAY;
		//另一种调用方式
		Day d2 = Enum.valueOf(Day.class, "MONDAY");
		System.out.println(d1 == d2);    //true

		Day d3 = Enum.valueOf(Day.class, "TUESDAY");
		//比较二者的 下标  大小
		System.out.println(d1.compareTo(d3)); //MONDAY<TUESDAY

		//�������е�ö��ֵ
		for(Day item : Day.values())
		{
			System.out.println(item.toString() + "," + item.ordinal());
		}
	}
}

enum Day
{
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
