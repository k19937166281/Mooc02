package mooc.代理.StaticProxy;

public class SubjectProxyTest {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        SubjectProxy subjectProxy = new SubjectProxy(subject);
        subjectProxy.request();
    }
}
