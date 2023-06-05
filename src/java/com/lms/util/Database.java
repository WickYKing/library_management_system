package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Connection conn;

   public static Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/librarymanagementsystem";
                String username = "lms";
                String password = "lms";

                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
