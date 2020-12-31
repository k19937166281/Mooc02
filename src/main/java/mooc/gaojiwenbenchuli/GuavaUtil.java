package mooc.gaojiwenbenchuli;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * ����Google Guava�����ַ�������
 * @author Tom
 *
 */
public class GuavaUtil {
	public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        System.out.println(list);

        //ֱ�ӳ�ʼ��List����
        List<Integer> integers = Lists.newArrayList(123, 456);
        System.out.println(integers);

        //����ַ��������Կ��ַ���
        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("123,321,,   abc");

        for (String s : split) {
            System.out.println(s);
        }

        //�շ�����
        String s1 = "CONSTANT_NAME";
        String s2 = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, s1);
        System.out.println(s2); //constantName;


        String a = "123,321,,   abc";
        String[] as = a.split(",");

        for(int i=0;i<as.length;i++)
        {
        	if(null == as[i] || as[i].length()<=0)
        	{
        		continue;
        	}
        	else
        	{
        		System.out.println(as[i].trim());
        	}
        }
    }
}
