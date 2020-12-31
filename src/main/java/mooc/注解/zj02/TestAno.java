package mooc.注解.zj02;

@MultipleTest
public class TestAno {
    @SingleTest
    String a;
    @SingleTest(5)
    String b;


     @SingleTest(value=5)
    String c;

    @MultipleTest
    int d;

    @MultipleTest(a=1)
    int e;
    @MultipleTest(a=1,b=2)
    int v;
    @MultipleTest(b=2,a=1)
    int vdas;
    //这种不行
    //@MultipleTest(1,2)


}
