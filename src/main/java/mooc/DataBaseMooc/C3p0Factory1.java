package mooc.DataBaseMooc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class C3p0Factory1 {
    private static ComboPooledDataSource dataSource ;

    public static void init() throws Exception {
        dataSource = new ComboPooledDataSource();
        //基础连接属性
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/emp?useSSL=false&allowMultiQueries=true&serverTimezone=GMT%2B8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //
        dataSource.setMinPoolSize(5);
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxPoolSize(20);
    }

    public static Connection getConnection() throws Exception {
        if (null == dataSource ){
            init();
        }
        return  dataSource.getConnection();
    }


}
