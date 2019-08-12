package com.danish.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String username = "hbstudent";
        String password = "hbstudent";

        System.out.println("Connecting to database: " + jdbcUrl);

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Connection successful!!! Yayyy");


    }

}
