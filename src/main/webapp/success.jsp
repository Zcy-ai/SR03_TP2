<%--
  Created by IntelliJ IDEA.
  User: zhacheny
  Date: 24/03/2023
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentification réussie</title>
</head>
<body>
<h1>Authentification réussie !</h1>
<p>Bienvenue <%= session.getAttribute("login") %> !</p>
<%--<p>Votre rôle est <%= session.getAttribute("role") %> .</p>--%>
<a href="/td22_war_exploded/deconnexion">Déconnexion</a>
</body>
</html>
