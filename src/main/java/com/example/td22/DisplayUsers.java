package com.example.td22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

@WebServlet("/display_user")
public class DisplayUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hashtable<String, User> users_table = (Hashtable<String, User>) getServletContext().getAttribute("usersTable");
        PrintWriter out = resp.getWriter();
        out.println(
                "<html>\n" + "<table><tr>" + "<th>First Name</th>" + "<th>Family Name</th>" + "<th>Email</th>" + "<th>Gender</th>" + "<th>Admin</th>" + "</tr><tr>"
        );
        for (User user : users_table.values()) {
            out.println(
                    "<td>"+ user.getFirstName() + "</td>" +
                    "<td>"+ user.getFamilyName() + "</td>" +
                    "<td>"+ user.getEmail() + "</td>" +
                    "<td>"+ user.getGender() + "</td>" +
                    "<td>"+ user.getAdmin() + "</td>"
//        "<td>${user.getFamilyName()}</td>" + "<td>${user.getEmail()}</td>" + "<td>${user.getGender()}</td>" + "<td>${user.getAdmin()}</td>"
            );
        }
        out.println("</tr></table></html>\n");
    }
}
