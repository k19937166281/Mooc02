package mooc.数据库编程;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

public class DruidFactory2 {
    private static DruidDataSource druidDataSource = null;

    public static void init() throws Exception {
        Properties properties = new Properties();

        URL resource = DruidFactory2.class.getClassLoader().getResource("druid.properties");
        InputStream resourceAsStream = DruidFactory2.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        druidDataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        resourceAsStream.close();
    }
    public static Connection getConnection() throws Exception{
        if (null==druidDataSource){
            init();
        }
        return druidDataSource.getConnection();
    }
}
