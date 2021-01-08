package mooc.数据库编程;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionPoolSelectTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            //从c3p0获取
            //connection = C3p0Factory1.getConnection(); //可以
            //connection = C3p0Factory2.getConnection();
            //connection = DruidFactory1.getConnection();
            connection = DruidFactory2.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from t_emp");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != connection){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }


}
