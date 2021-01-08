package mooc.代理.StaticProxy;

public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("subjectImpl");
    }
}
