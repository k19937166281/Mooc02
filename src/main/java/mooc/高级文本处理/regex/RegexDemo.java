package mooc.高级文本处理.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDemo {

    private static String REGEX = "a*b"; //*��ʾ�޶�ǰ���a������0���߶����
    private static String INPUT = "aabfooaabfooabfoobcdd";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // get a matcher object
        StringBuffer sb = new StringBuffer();
        //ȫ���滻
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        //������β���ַ���������
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
