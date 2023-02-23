package com.example.usersapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/")
public class handleReq extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqUrl = req.getRequestURI();

        resp.getWriter().println("HELLO1111");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String connectionURL = "jdbc:mysql://localhost:3306/restapidemo",
                    username = "root",
                    pasword = "";

            Connection connection = DriverManager.getConnection(connectionURL, username, pasword);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
            }

            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println('E');

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}