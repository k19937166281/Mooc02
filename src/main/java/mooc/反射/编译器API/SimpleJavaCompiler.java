package mooc.反射.编译器API;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class SimpleJavaCompiler {
    public static void main(String[] args) throws UnsupportedEncodingException {
        successCompile();
        failCompile();
    }

    private static void successCompile() {
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        //1.输入流 输入null 默认使用 system.in
        //2.输出流 输入null 默认使用 system.out
        //3.错流 输入null 默认使用 system.err
        //4.String... 多参数 需要编译的文件名
        //返回值 0表示成功  其他表示错误
        int run = systemJavaCompiler.run(null, null, null, "D:/temp/Hello.java");

        System.out.println(run);

    }

    private static void failCompile() throws UnsupportedEncodingException {
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        //1.输入流 输入null 默认使用 system.in
        //2.输出流 输入null 默认使用 system.out
        //3.错流 输入null 默认使用 system.err
        //4.String... 多参数 需要编译的文件名
        //返回值 0表示成功  其他表示错误
        int run = systemJavaCompiler.run(null, null, err, "D:/temp/Hello2.java");

        System.out.println(run);
        if (run!=0){
            String s = new String(err.toByteArray(), Charset.defaultCharset().toString());
            System.out.println(s);
        }

    }
}
