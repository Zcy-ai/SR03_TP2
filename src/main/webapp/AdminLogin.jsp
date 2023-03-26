<%--
  Created by IntelliJ IDEA.
  User: zhacheny
  Date: 24/03/2023
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html><head><title>Navigation</title></head>
<body>
<%--<%--%>
<%--    if (session.getAttribute("login") == null) {--%>
<%--        response.sendRedirect("index.jsp");--%>
<%--    } else {--%>
<%--        response.sendRedirect("success_admin.jsp");--%>
<%--    }--%>
<%--%>--%>
<% if (session.getAttribute("login") == null) { %>
    <% response.sendRedirect("index.jsp"); %>
<% } else { %>
    <% Cookie[] cookies = request.getCookies(); boolean flag = false;%>
    <%  if (cookies != null) { %>
        <% for (Cookie cookie : cookies) { %>
            <% if (cookie.getName().equals("lastVisit")) { %>
                <p> Bonjour <%= session.getAttribute("login") %> !</p>
                <p> Votre dernière visite était le <%=cookie.getValue()%> </p>
                <% flag = true;%>
            <%}%>
        <%}%>
    <%}%>
    <% if (!flag) {%>
        <p> Bienvenue <%= session.getAttribute("login") %> !</p>
    <%}%>
    <nav> <ul>
        <li>Connected</li>
        <li><a href="CreateUser.jsp">Créer un nouveau utilisateur</a></li>
        <li><a href="/td22_war_exploded/display_user">Afficher la liste des utilisateurs</a></li>
        <li><a href="/td22_war_exploded/deconnexion">Déconnexion</a></li>
    </ul>
    </nav>
<% } %>
</body>
</html>