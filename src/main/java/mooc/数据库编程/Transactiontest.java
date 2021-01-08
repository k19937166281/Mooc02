package mooc.数据库编程;

import java.sql.*;

public class Transactiontest {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url ="jdbc:mysql://localhost:3306/emp?userSSL=false&serverTimezone=GMT%2B8";
        Connection root = null;

        root = DriverManager.getConnection(url, "root", "123456");
        //设置自动提交为 false
        root.setAutoCommit(false);
        Statement statement = root.createStatement();

        statement.executeUpdate("insert into t_emp(name,path) values ('aaaaaa','bbbbbbb')");
        statement.executeUpdate("insert into t_emp(name,path) values ('aaaaaa','bbbbbbb')");
        statement.executeUpdate("insert into t_emp(name,path) values ('aaaaaa','bbbbbbb')");
        Savepoint savepoint = root.setSavepoint();
        statement.executeUpdate("insert into t_emp(name,path) values ('aaaaaa','bbbbbbb')");
        statement.executeUpdate("insert into t_emp(name,path) values ('aaaaaa','bbbbbbb')");
        root.rollback(savepoint);
        root.commit();

        statement.close();
        root.close();
    }
}
