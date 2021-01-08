package mooc.stream.s6;

import java.util.stream.IntStream;

public class ParallelStream {

	public static void main(String[] args) {

		IntStream s1 = IntStream.range(1,10000000);
		long evenNum = s1.parallel().filter(n->n%2==0).count();
		System.out.println(evenNum);

	}

}
