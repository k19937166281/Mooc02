package mooc.代理.Proxy02;

public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("subjectImpl");
    }

    @Override
    public int requestInt(int a,int b) {
        return a-b;
    }
}
