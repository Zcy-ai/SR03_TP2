package com.example.td22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.util.Hashtable;
import java.time.LocalDateTime;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres de la requête
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        // Récupération du cookie, s'il contient l'info lastVist;
//        Cookie[] cookies = request.getCookies();
//        String lastVisit = null;
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("lastVisit")) {
//                    lastVisit = cookie.getValue();
//                    break;
//                }
//            }
//        }
//        if (lastVisit == null) {
//            response.getWriter().write("Bienvenue sur notre site web !");
//        } else {
//            response.getWriter().write("Votre dernière visite était le " + lastVisit);
//        }

        // Vérification des informations d'authentification
        if (checkCredentials(username, password)) {
            // Création d'un objet User avec le rôle "admin"
            // Stockage de l'utilisateur dans la session
            boolean admin = isAdmin(username);
            HttpSession session = request.getSession();
            session.setAttribute("login", username);
            session.setAttribute("admin", admin);
            LocalDateTime current_time = LocalDateTime.now();
            Cookie cookie = new Cookie("lastVisit", current_time.toString());
            cookie.setMaxAge(1 * 24 * 60 * 60); // durée de vie de 30 jours
            response.addCookie(cookie);
            // Redirection vers une page de succès
            if (admin) {
                response.sendRedirect("AdminLogin.jsp");
            } else {
                response.sendRedirect("success.jsp");
            }
        } else {
            // Redirection vers une page d'échec
            response.sendRedirect("failure.jsp");
        }
    }

    private boolean isAdmin(String username) {
        Hashtable<String, User> users_table = (Hashtable<String, User>) getServletContext().getAttribute("usersTable");
        if (users_table != null) {
            for (User user : users_table.values()) {
                if (user.getEmail().equals(username) && user.getAdmin().equals("Admin")) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkCredentials(String username, String password) {
        // Vérification des informations d'authentification
        // TODO: ajouter le code de vérification ici
        Hashtable<String, User> users_table = (Hashtable<String, User>) getServletContext().getAttribute("usersTable");
        if (users_table != null) {
            for (User user : users_table.values()) {
                if (user.getPassword().equals(password) && user.getEmail().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }
}
