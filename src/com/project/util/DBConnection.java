package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("DRIVER LOADED");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/complaint_db",
                "complaint_user",
                "com@123"   // 🔴 put YOUR password
            );

            System.out.println("DB CONNECTED");

        } catch (Exception e) {
            System.out.println("DB ERROR:");
            e.printStackTrace();
        }

        return con;
    }
}