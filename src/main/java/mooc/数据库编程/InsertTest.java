package mooc.数据库编程;

import java.sql.*;

public class InsertTest {
    static String url = "jdbc:mysql://localhost:3306/emp?useSSL=false&serverTimezone=GMT%2B8";
    public static void main(String[] args) {
        //contactInsertBook();
        //unsafeConcatInsertBook();
        //safeInsertBook();
        batchInsertBook();
    }

    //拼接 对比 占位符 麻烦了许多
    private static void contactInsertBook() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url,"root","123456");
            Statement statement = connection.createStatement();
            String name = "EFFECTIVE JAVA";
            double salary = 20.5;
            String sql = "insert into t_emp(name,salary) values('"+name+"',"+salary+")";
            statement.executeUpdate(sql);
            statement.close();

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

    //不安全拼接 sql注入攻击
    private static void unsafeConcatInsertBook() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        //    MySQL连接数据库时，添加语句：“allowMultiQueries=true”的作用：
        //    1.可以在sql语句后携带分号，实现多语句执行。
        //    2.可以执行批处理，同时发出多个SQL语句。
        String url = "jdbc:mysql://localhost:3306/emp?allowMultiQueries=true&serverTimezone=GMT%2B8";
        try{
            connection = DriverManager.getConnection(url,"root","123456");
            Statement statement = connection.createStatement();
            //very bad
            String name = "EFFECTIVE JAVA',50);delete from t_emp;insert into t_emp(name,salary) values('faked book";
            double salary = 20.5;
            String sql = "insert into t_emp(name,salary) values('"+name+"',"+salary+")";
            statement.executeUpdate(sql);
            statement.close();

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

    private static void safeInsertBook() {

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
            String sql = "insert into t_emp(name,salary) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String name1 =  "EFFECTIVE JAVA',50);delete from t_emp;";
            //一长串会因为字符串过长导致  com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column 'name' at row 1
            String name =  "EFFECTIVE JAVA',50);delete from t_emp;insert into t_emp(name,salary) values('faked book";
            preparedStatement.setString(1,name1);
            preparedStatement.setDouble(2,20);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            preparedStatement.close();
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


    //PreparedStatement  预编译 速度快 支持批量处理  能够放置sql注入攻击    牛批
    private static void batchInsertBook() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
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
            String sql = "insert into t_emp(name,salary) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1,"zhangsan");
                preparedStatement.setDouble(2,20);
                preparedStatement.addBatch();
            }
            int[] i = preparedStatement.executeBatch();
            for (int i1 = 0; i1 < i.length; i1++) {
                System.out.println(i[i1]);
            }

            preparedStatement.close();
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
