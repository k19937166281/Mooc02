package mooc.gaojiwenbenchuli;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 依赖于 Apache Commons IO ����ַ���ת���ַ���
 * @author Tom
 *
 */

public class String2InputStream {

    public static void main(String[] args) {
    	//�����ַ����б�
    	List<String> names = new LinkedList<String>();
        names.add("Xiaohong");
        names.add("Xiaoming");
        names.add("Daming");
        names.add("Xiaohei");

        //�ϲ�Ϊһ���ַ������Զ�������
        String nameStr = String.join(",",names);

        //���ַ�����ΪĬ�ϵ�������
        InputStream in = IOUtils.toInputStream(nameStr, Charsets.toCharset("UTF-8"));
        //����ϵͳ��������
        System.setIn(in);

        //ģ���������  ��Ҳ��OJƽ̨�������������ԭ��
        //�˴�Ҳ���Ի���һ���ļ�������
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter(",");
        while(sc.hasNext())
        {
            System.out.println(sc.next());
        }

    }
}
