package mooc.嵌套类.普通内部类和静态嵌套类.staticnested;


public class Outer4Test {

	public static void main(String[] args) {
		//第三方类访问静态嵌套类
		Outer4.Inner4  obj1 = new Outer4.Inner4();
        System.out.println(obj1.getInnField1());
        System.out.println(
                obj1.getClass().getName()
        );
        System.out.println(Outer4.Inner4.innStaticField2);
        Outer4.Inner4  obj2 = new Outer4.Inner4();
		System.out.println(obj1 == obj2);

		System.out.println("================");
        Outer4 obj3 = new Outer4();

		obj3.outFun2();
		//或者这样访问
        //Outer4.outFun2();
	}

}
