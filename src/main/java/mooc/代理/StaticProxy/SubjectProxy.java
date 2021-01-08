package mooc.代理.StaticProxy;
//这种方式属于静态代理
//重写方法包装实际对象即可，简单易懂

//相应的弊端也是因为重写方法，如果方法数量很多的话就比较麻烦
public class SubjectProxy implements Subject {

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        //前置操作   可以进行操作校验，不去触碰真正做处理的对象
        System.out.println("pre");
        subject.request();
        System.out.println("post");
    }
}
