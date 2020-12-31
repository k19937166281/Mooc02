package mooc.gaojiwenbenchuli.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatcherDemo {

	private static final String REGEX = "\\bdog\\b";  //\b��ʾ�߽�
	private static final String INPUT = "dog dog dog doggie dogg";

	public static void main(String[] args) {
		//����ַ��������ж��ٸ�dog
		Pattern p = Pattern.compile(REGEX);

		Matcher m = p.matcher(INPUT);
		int count = 0;
		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m.start());
			System.out.println("end(): " + m.end());
		}
	}
}
