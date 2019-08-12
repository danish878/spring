package com.danish.spring.mvc.hibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String username = "nativeuser";
        String password = "PmDbS@787";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            out.println("<br>Connection successful");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
