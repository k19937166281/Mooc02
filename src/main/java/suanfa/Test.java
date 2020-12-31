package suanfa;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args) {
        Pattern p = Pattern.compile("c*a*b");
        Matcher matcher = p.matcher("aab");
        System.out.println(matcher.matches());
    }
}
