package mooc.DataBaseMooc;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DruidFactory1 {
    private static DruidDataSource druidDataSource = null;

    public static void init() throws SQLException {
        druidDataSource = new DruidDataSource();
        System.out.println(druidDataSource.getClass().getName());
        //基础连接属性
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/emp?useSSL=false&allowMultiQueries=true&serverTimezone=GMT%2B8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        //
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(10);
        //启用监控统计功能
        druidDataSource.setFilters("stat");

    }
    public static Connection getConnection() throws Exception{
        if (null==druidDataSource){
            init();
        }
        return druidDataSource.getConnection();
    }
}
