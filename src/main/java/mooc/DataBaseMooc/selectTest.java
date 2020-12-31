package mooc.DataBaseMooc;

import java.sql.*;

//过程步骤
//1.加载驱动
//2.建立连接
//3.通过连接创建一个执行者（statement）
//4.通过执行者执行查询executeQuery
//5.取值
//6.关闭连接
public class selectTest {
    public static void main(String[] args) {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("注册驱动成功！");
        } catch (ClassNotFoundException e) {
            System.out.println("注册驱动失败！");
            e.printStackTrace();
            return;
        }

       // String url = "jdbc:sqlserver://192.168.1.239:1433;DatabaseName=ArchivesManagement";
        //mysql或许需要通过url指定一些属性 useSSL=false&serverTimezone=GMT%2B8  根据错误提示来吧
        //使用5.1.38版本的驱动，但是装的mysql版本较高，无法建立连接（但是没有具体的错误提示）
        // 版本改为8.0.11 之后建立连接成功
        String url = "jdbc:mysql://localhost:3306/emp?useSSL=false&serverTimezone=GMT%2B8";
        Connection connection=null,root = null;
        //构建java和数据库之间的桥梁，URL，用户名，密码
        try {
            long l = System.currentTimeMillis();
            //建立连接
            connection = DriverManager.getConnection(url,"root","123456");
            //构建数据库执行者
            Statement statement = connection.createStatement();
            System.out.println("创建statement成功");
            //执行sql语句并返回结果到resultSet
            ResultSet resultSet = statement.executeQuery("select * from t_emp");



//            while (resultSet.next()){
//                //填写的columnIndex参数是从1开始的而非是0
//
//                System.out.println(resultSet.getDouble("salary"));
//                System.out.println(resultSet.getInt("age"));
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(5));
//                System.out.println(resultSet.getString("path"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println("---");
//            }
            System.out.println((System.currentTimeMillis()-l)/1000+"秒");
            root = DriverManager.getConnection(url, "root", "123456");
            Statement statement2 = root.createStatement();
            //statement可以复用     但是第二次执行语句时会把第一次执行得到的ResultSet 给 close掉
            ResultSet resultSet1 = statement2.executeQuery("select salary from t_emp");

            long l2 = System.currentTimeMillis();
            int i = 0;

            //resultSet的笛卡尔积操作    没有测试出来，不测了
            while (resultSet.next()){
                while (resultSet1.next()){
                    i++;
                    //循环次数等于  resultSet条数乘以resultSet条数
                    System.out.println(resultSet1.getDouble("salary"));
                }
            }
            System.out.println(i);
            System.out.println((System.currentTimeMillis()-l2)/1000+"秒");
            resultSet.close();
            resultSet1.close();
            statement.close();
            statement2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
                root.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
