package mooc.数据库编程;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;


public class C3p0Factory2 {
    private static ComboPooledDataSource dataSource;

    public static void init() throws Exception {
        dataSource = new ComboPooledDataSource("c3p0-config.xml");

    }

    public static Connection getConnection() throws Exception {
        if (null == dataSource ){
            init();
        }
        return  dataSource.getConnection();
    }
}
