package mooc.反射.反射应用;

import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) throws Exception{
        //构建java和数据库之间的桥梁介质
        Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.jdbc.Driver",true,ClassLoader.getSystemClassLoader());
        //通知类加载器加载此类的class文件
        System.out.println("注册驱动成功！");
        //构建java和数据库之间的桥梁：URL 用户名 密码
        DriverManager.getConnection("url","root","123456");
        //DriverManager将会挑选加载合适的驱动类，并采用 getConnection方法连接
    }
}
