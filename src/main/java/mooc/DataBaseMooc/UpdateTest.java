package mooc.DataBaseMooc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
    public static void main(String[] args) {
        executeUpdate("delete from t_emp where id =3");
        executeUpdate("update t_emp set name = 'zhangsan' where id=2");
        executeUpdate("insert into t_emp(name,path) values('safasdf','sfasfasdfdas')");
    }

    public static void executeUpdate(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/emp?useSSL=false&serverTimezone=GMT%2B8";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,"root","123456");
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println("影响的行数"+i);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
