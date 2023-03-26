<%--
  Created by IntelliJ IDEA.
  User: zhacheny
  Date: 24/03/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authentification</title>
</head>
<body>
<h2>Authentification</h2>
<form action="/td22_war_exploded/Connexion" method="post">
    <label for="username">Adresse mail:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Mot de passe:</label>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Connexion">
</form>
</body>
</html>

