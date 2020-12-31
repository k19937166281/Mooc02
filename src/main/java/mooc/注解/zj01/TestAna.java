package mooc.注解.zj01;

public class TestAna {
    @SingleValue(value = "a")
    String a;


    public static void main(String[] args) {
        System.out.println(new TestAna().a);
    }
}
