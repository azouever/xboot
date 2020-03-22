package com.process.xboot.sql;

import org.junit.Test;

import java.sql.*;

public class SqlTest {


    @Test
    public void sqlConnectTest() throws SQLException, ClassNotFoundException {

        String URL = "jdbc:mysql://127.0.0.1:3306/leaf?useUnicode=true&characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        //String sql = "select * from leaf.leaf_bill where id = ?";
        //PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //preparedStatement.setLong(1, 1L);
        Statement preparedStatement = conn.createStatement();
        ResultSet rs =  preparedStatement.executeQuery("select * from leaf.leaf_bill where id ="+1);
        //4.处理数据库的返回结果(使用ResultSet类)zz
        while (rs.next()) {
            System.out.println(rs.getString("bill_no") + " "
                    + rs.getString("amount"));
        }
        //关闭资源
        rs.close();
        preparedStatement.close();
        conn.close();
    }


}
