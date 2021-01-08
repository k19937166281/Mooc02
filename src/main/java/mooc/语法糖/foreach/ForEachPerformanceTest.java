
package mooc.语法糖.foreach;
import java.util.HashSet;
import java.util.Iterator;

public class ForEachPerformanceTest {

	public static void main(String[] args) {
		int n = 100000;
		arrayTest(n);
		System.out.println("=====================");
		collectionTest(n);
	}

	public static void arrayTest(int n)
	{
		System.out.println("数组10万Double元素时间对比");
		double result = 0;
		double[] nums = new double[n];
		long startTime = 0;
		long endTime = 0;

		for(int i=0;i<nums.length;i++)
		{
			nums[i] = Math.random();
		}

		//����for����
		startTime = System.nanoTime();
		for(int i=0;i<nums.length;i++)
		{
			result += nums[i];
		}
		endTime = System.nanoTime();
		System.out.println("for      " + (endTime - startTime));

		//����for-each����
		result = 0;
		startTime = System.nanoTime();
		for(double item : nums)
		{
			result += item;
		}
		endTime = System.nanoTime();
		System.out.println("for-each " + (endTime - startTime));
	}

	public static void collectionTest(int n)
	{
		System.out.println("set集合10万Double元素时间对比");
		double result = 0;
		HashSet<Double> nums = new HashSet<Double>();
		long startTime = 0;
		long endTime = 0;

		for(int i=0;i<n;i++)
		{
			nums.add(Math.random());
		}

		//����for����
		startTime = System.nanoTime();
		for(Iterator<Double> i = nums.iterator(); i.hasNext(); )
		{
			result += i.next();
		}
		endTime = System.nanoTime();
		System.out.println("for      " + (endTime - startTime));

		//����for-each����
		result = 0;
		startTime = System.nanoTime();
		for(double item : nums)
		{
			result += item;
		}
		endTime = System.nanoTime();
		System.out.println("for-each " + (endTime - startTime));
	}

}
