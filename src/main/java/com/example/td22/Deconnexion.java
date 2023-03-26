package com.example.td22;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deconnexion")

public class Deconnexion extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false); // récupère la session actuelle ou null s'il n'y en a pas

        if (session != null) {
            session.invalidate(); // ferme la session
        }
        response.sendRedirect("/td22_war_exploded"); // redirige vers la page de connexion
    }
}

