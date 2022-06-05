package com.xkk.utils;

import java.sql.*;

public class DataBaseConnection {
    private Connection conn = null;

    public DataBaseConnection() {
        try {
            String DBDRIVER = "com.mysql.cj.jdbc.Driver";
            Class.forName(DBDRIVER);
            String DBURL = "jdbc:mysql://localhost:3306/web_review?useSSL=false&serverTimezone=UTC";
            String DBUSER = "root";
            String DBPASSWORD = "107107";
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        System.out.println(this.conn);
        return this.conn;
    }

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}