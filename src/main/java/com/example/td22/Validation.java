package com.example.td22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashSet;
import java.util.Hashtable;

@WebServlet("/validation")
public class Validation extends HttpServlet {
    HashSet<String> usersTable = new HashSet<String>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("User first name");
        String family_name = req.getParameter("User family name");
        String email = req.getParameter("User email");
        String password = req.getParameter("User password");
        String gender = req.getParameter("gender");
        String admin = req.getParameter("Admin");
        if (first_name.isEmpty() || family_name.isEmpty() || email.isEmpty() || password.isEmpty() || gender.isEmpty()) {
            resp.sendRedirect("/td22_war_exploded");
            return;
        }
       // vérifier si l'utilisateur existe déjà
        Hashtable<String, User> users_table = (Hashtable<String, User>) getServletContext().getAttribute("usersTable");
        if (users_table != null) {
            for (User user : users_table.values()) {
                if (
                        user.getFirstName().equals(first_name) && user.getFamilyName().equals(family_name) && user.getEmail().equals(email) && user.getPassword().equals(password) && user.getGender().equals(gender) && user.getAdmin().equals(admin)
                ) {
                    // Si l'utilisateur existe déjà, afficher un récapitulatif et demander s'il faut l'ajouter quand même
                    req.setAttribute("FirstName", first_name);
                    req.setAttribute("FamilyName", family_name);
                    req.setAttribute("Email", email);
                    req.setAttribute("Password", password);
                    req.setAttribute("Gender", gender);
                    req.getRequestDispatcher("recap.jsp").forward(req, resp);
                    return;
                }
            }
        }
        // Si l'utilisateur n'existe pas, rediriger vers la servlet UserInsertion pour l'ajouter à la liste des utilisateurs
        req.getRequestDispatcher("/insertion").forward(req, resp);
    }
}
