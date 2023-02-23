package com.example.usersapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/users")
public class handleReq extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqUrl = req.getRequestURI();

        MySqlAccess dbAccess = new MySqlAccess();

        String reqName = req.getParameter("name");

        if(reqName == null){
            for(String user : dbAccess.getAllUsers())
                resp.getWriter().println(user);
        }
        if (reqName != null && reqName.length() > 0){
            resp.getWriter().println(dbAccess.getUser(reqName));
        }

    }
}