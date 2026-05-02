package com.project.servlet;

import com.project.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE email=? AND password=?");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession session = req.getSession();
                session.setAttribute("userId", rs.getInt("id"));

                System.out.println("LOGIN SUCCESS"); // 👈 DEBUG

                res.sendRedirect(req.getContextPath() + "/dashboard.jsp");

            } else {
                System.out.println("LOGIN FAILED"); // 👈 DEBUG
                res.sendRedirect(req.getContextPath() + "/login.html");
            }

        } catch (Exception e) {
            e.printStackTrace();

            res.getWriter().println("ERROR: " + e.getMessage()); // 👈 SHOW ERROR
        }
    }
}