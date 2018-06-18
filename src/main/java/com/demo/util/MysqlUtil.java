package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Mysql管理工具
 */
public class MysqlUtil {

    private static final String userName = "root";
    private static final String passWord = "";
    private static final String driverclass = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/imooc_project?useUnicode=true&characterEncoding=utf8&useSSL=false";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverclass);
            connection = DriverManager.getConnection(URL,userName,passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("连接："+getConnection());
    }

}
