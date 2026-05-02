package com.project.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

import com.project.util.DBConnection;

public class ComplaintServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId"); // 🔥 important

        String category = req.getParameter("category");
        String description = req.getParameter("description");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO complaints(user_id, category, description) VALUES(?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setString(2, category);
            ps.setString(3, description);

            ps.executeUpdate();

            res.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}