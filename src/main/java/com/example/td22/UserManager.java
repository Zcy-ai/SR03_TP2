package com.example.td22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Hashtable;
//import java.time.LocalDate;
@WebServlet("/insertion")
public class UserManager extends HttpServlet {
    private static Hashtable<String, User> usersTable= new Hashtable<String, User>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("User first name");
        String family_name = req.getParameter("User family name");
        String email = req.getParameter("User email");
        String password = req.getParameter("User password");
        String gender = req.getParameter("gender");
        String admin = req.getParameter("Admin");
        if (admin == null) {
            admin = "User";
        }
        User user = new User(first_name, family_name, email, password, gender, admin);
        usersTable.put(first_name + " " + family_name, user);
        getServletContext().setAttribute("usersTable", usersTable);
        HttpSession session = req.getSession();
        session.setAttribute("login", email);
        session.setAttribute("admin", admin);
//        // update cookie
//        LocalDate currentDate = LocalDate.now();
//        Cookie cookie = new Cookie("lastVisit", currentDate.toString());
//        cookie.setMaxAge(30 * 24 * 60 * 60); // durée de vie de 30 jours
//        resp.addCookie(cookie);

        if (admin.equals("Admin")) {
            resp.sendRedirect("AdminLogin.jsp");
        } else {
            resp.sendRedirect("success.jsp");
        }
    }

}
