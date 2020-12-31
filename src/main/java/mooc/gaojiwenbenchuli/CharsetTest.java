package mooc.gaojiwenbenchuli;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) {
		//Ĭ���ַ��� GBK
		Charset c = Charset.defaultCharset();
		System.out.println(c.name());

		//������е�֧���ַ���
		SortedMap<String, Charset> sm = Charset.availableCharsets();
        Set<String> keyset = sm.keySet();
        System.out.println("Java ֧�ֵ������ַ���");
        for (String s : keyset) {
            System.out.println(s);
        }
	}
}
