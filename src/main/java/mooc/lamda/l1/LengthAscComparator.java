package mooc.lamda.l1;

import java.util.Comparator;

public class LengthAscComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int len1 = (o1==null?0:o1.length());
        int len2 = (o2==null?0:o2.length());

        return len1-len2;//==0  <的话 返回 负值   >的话 返回 正值     -n 0 n  是正序   从小到大    反之是倒序
        //return (-1)*（len1-len2）;//==0  <的话 返回 负值   >的话 返回 正值  这样就会是倒序排列了
    }
}
