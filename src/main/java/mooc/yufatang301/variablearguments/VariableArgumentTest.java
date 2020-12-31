package mooc.yufatang301.variablearguments;

import mooc.yufatang301.asdf111sadf;

public class VariableArgumentTest implements asdf111sadf {

	public static void main(String[] args) {
		print();//print(String... args) {
		print("aaa");//print(String s)
		print("aaa", "bbb");//print(String... args) {
		print("aaa", "bbb", "ccc");
        long a = 111_111_111;
        System.out.println(a);
        System.out.println("---------------------------------------------");
       VariableArgumentTest variableArgumentTest = new VariableArgumentTest();


        variableArgumentTest.def();
        variableArgumentTest.nobody();
	}

	public static void print(String... args) {

        System.out.println(args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    //固定参数方法的优先级 比 可变参数方法的优先级更高
	public static void print(String s)
	{
	    System.out.println("I am another method");
	}

    @Override
    public void def() {
        int i = super.hashCode();
    }

    @Override
    public void nobody() {
super.hashCode();
    }

    //一个方法只能有一个不定项参数
//	public static void print(String... args, int... irgs)
//	{ }

	//调用语句，同时与两个带可变参数的方法匹配，则报错，，，因为可变参数的填写方式 导致 开发工具和程序难以识别 所填写的实参和形参的关联关系
//	public static void print(String s1, String... args)
//	{
//
//	}


}
