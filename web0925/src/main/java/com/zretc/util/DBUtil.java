package com.zretc.util;

import java.sql.*;

public class DBUtil {

    private static String url = "jdbc:mysql://localhost:3306/scott?useUnicode=true&characterEncoding=utf8&useSSL=false&nullCatalogMeansCurrent=true&serverTimezone=Asia/Shanghai";
    private static String username = "root";
    private static String password = "123456";


    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    //获取连接方法
    public static Connection getConn() {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //增删改方法
    public static int exUpdate(String sql, Object... object) {
        Connection conn = getConn();
        int n = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            //?的个数不确定
            if (object != null) {
                for (int i = 0; i < object.length; i++) {
                    pstmt.setObject(i + 1, object[i]);
                }
            }
            //执行sql,executeUpdate()
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n;
    }

    //查询方法
    public static ResultSet exQuery(String sql, Object... object) {
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            //?的个数不确定
            if (object != null) {
                for (int i = 0; i < object.length; i++) {
                    pstmt.setObject(i + 1, object[i]);
                }
            }
            //执行sql,executeQuery()
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //关闭资源
    public static void close() {
        try {
            if (rs!=null){
                rs.close();
            }
            if (pstmt!=null){
                pstmt.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
