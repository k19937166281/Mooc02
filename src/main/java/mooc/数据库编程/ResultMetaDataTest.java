package mooc.数据库编程;

import java.sql.*;

public class ResultMetaDataTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        //    MySQL连接数据库时，添加语句：“allowMultiQueries=true”的作用：
        //    1.可以在sql语句后携带分号，实现多语句执行。
        //    2.可以执行批处理，同时发出多个SQL语句。
        try{
            String url = "jdbc:mysql://localhost:3306/emp?allowMultiQueries=true&serverTimezone=GMT%2B8";
            connection = DriverManager.getConnection(url,"root","123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from t_emp");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            //从1开始
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(metaData.getColumnClassName(i));//java 类名
                System.out.println(metaData.getColumnName(i));//列名
                System.out.println(metaData.getColumnTypeName(i));//数据库类型名称
                System.out.println(metaData.getColumnType(i));//SQL类型
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
