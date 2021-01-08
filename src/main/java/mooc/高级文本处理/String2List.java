package mooc.高级文本处理;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * ����Apache Commons Lang ������ַ����ͼ���ת��
 * @author Tom
 *
 */

public class String2List {

	public static void main(String[] args) {
		List<String> names = new LinkedList<String>();
        names.add("Xiaohong");
        names.add("Xiaoming");
        names.add("Daming");
        names.add("Xiaohei");

        //��ArrayList�䵽�ַ���
        String str1 = String.join(",", names);  //String.join�� JDK 8 ����
        System.out.println(str1);

        String str2 = StringUtils.join(names, ",");  //Apache Commons Lang
        System.out.println(str2);

        //���ַ������ArrayList
        List<String> names2 = Arrays.asList(str2.split(","));
        for(String name:names2)
        {
        	System.out.println(name);
        }

        //StringUtils ����֧�ָ�����������
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        String str3 = StringUtils.join(ids, ",");
        System.out.println(str3);
	}

}
