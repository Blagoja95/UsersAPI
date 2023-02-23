package com.example.usersapi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccess {
    private final String CONNECTIONURL = "jdbc:mysql://localhost:3306/restapidemo",
            USERNAME = "root",
            PASSWORD = "";

    public List<String> getAllUsers() {

        List<String> users = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                users.add(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
            }

            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println('E');

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public String getUser(String name) {
        String NOUSERFOUND = "No users found";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users where fname='" + name + "';");

            if (resultSet != null)
                return resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4);
            else
                return NOUSERFOUND;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return NOUSERFOUND;
    }
}
