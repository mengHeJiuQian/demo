package db.sqlserver.connection;

import java.sql.*;

/**
 * 创建人：yang.liu
 * 创建时间：2020/6/27 10:53
 * 版本：1.0
 * 内容描述：连接本地的sqlserver2012
 */
public class ConnectionLocalSqlServer2012 {

    public static void main(String[] args) {
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String URL = "jdbc:sqlserver://localhost:12615;databasename=";
        String DATABASE_NAME = "AdventureWorksDW2012";
        String USER_NAME = "sa";
        String PASSWORD = "qweQWE123!";


        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL + DATABASE_NAME, USER_NAME, PASSWORD);
            //新建一个查询
            Statement stmt = conn.createStatement();
            //执行查询-->>返回一个结果集
            ResultSet rs = stmt.executeQuery("select * from tt1");    //括号里可以写相关的SQL语句，并把查询到的所有，放到一个rs集合里

            while (rs.next()) {//rs.next()返回的是一个boolean值，这是一个指针，表示查询表头部的的下一条数据，加载第二次就是头部的下一条的下一条，以此类推
                //如果所需要查询的那一条有数据，就会返回true,没有就返回false
                int k = rs.getInt("id");//这是查找数据库的id号
                String v = rs.getString("trade_name");//这是查找数据库的trade_name列有什么值
                System.out.println("结果是:ID" + k + "　　trade_name  :" + v);
            }
            /*if (sum == 0) {
                System.out.println("查找正常，没有记录");
            }*///这这是一个逻辑需求，如果数据库没有需要查找的内容，那么这句话怎么说都比白屏好看
            rs.close();
            stmt.close();//这三行是关闭连接的意思，这非常重要，如果没写关闭连接
            conn.close();//程序多人打开或多人访问，就会出现卡顿，重启或奔溃
        } catch (ClassNotFoundException e) {
            System.out.println("驱动问题" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("发生异常:" + e.getMessage());
        }
    }
}
