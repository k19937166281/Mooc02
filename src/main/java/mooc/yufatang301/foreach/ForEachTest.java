package mooc.yufatang301.foreach;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ForEachTest {

	public static void main(String[] args) {
		arrayTraverse();
		collectionTraverse();
		elementDeleteOrReplace();
		forWardOrBackwardTraverse();
		traverseBothArray();
	}

	public static void arrayTraverse()
	{
		System.out.println("=========�����������==========");
		double[] nums = new double[5];
		for(int i=0;i<nums.length;i++)
		{
			nums[i] = Math.random();
		}
		for(double item : nums)
		{
			System.out.println(item);
		}
	}
	public static void collectionTraverse()
	{
		System.out.println("=========Collection��������==========");

		Set<String> hs = new HashSet<String>();
		hs.add("I");
		hs.add("Love");
		hs.add("Java");

		for(Iterator<String> i = hs.iterator(); i.hasNext(); )
		{
			System.out.println(i.next());
		}

		for(String i:hs)
		{
			System.out.println(i);
		}
	}

	public static void elementDeleteOrReplace()
	{
		System.out.println("=========ɾ�����滻Ԫ�ز���==========");

		Set<Person> ps = new HashSet<Person>();
		ps.add(new Person("Jerry", 20));
		ps.add(new Person("Mike", 21));
		ps.add(new Person("Tom", 22));

		for(Iterator<Person> i = ps.iterator(); i.hasNext(); )
		{
			Person p = i.next();
			System.out.println(p.getName() + "," + p.getAge());
			//i.remove();  //ɾ��Ԫ��
		}
		for(Person p:ps)
		{
			p.setAge(25);
			p=new Person("William", 30); //��û���޸�ԭʼ����
		}
		for(Person p:ps)
		{
			System.out.println(p.getName() + "," + p.getAge());
		}
	}

	public static void forWardOrBackwardTraverse()
	{
		System.out.println("=========�����������������==========");
		double[] nums = new double[5];
		for(int i=0;i<nums.length;i++)
		{
			nums[i] = Math.random();
		}

		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
		for(double item : nums)
		{
			System.out.println(item);
		}
		for(int i=nums.length-1;i>=0;i--)
		{
			System.out.println(nums[i]);
		}

		//for-each ֻ����ǰ��������֧��������
	}

	public static void traverseBothArray()
	{
		System.out.println("=========���������������==========");
		double[] nums1 = new double[5];
		double[] nums2 = new double[5];

		for(int i=0;i<nums1.length;i++)
		{
			nums1[i] = Math.random();
			nums2[i] = Math.random();
		}

		for(int i=0;i<nums1.length;i++)
		{
			System.out.println(nums1[i] + "," + nums2[i]);
		}

		//for-each ����ͬʱ������������
	}
}
