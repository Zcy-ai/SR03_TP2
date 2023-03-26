<%--
  Created by IntelliJ IDEA.
  User: zhacheny
  Date: 24/03/2023
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation de l'utilisateur</title>
</head>
<body>
<h2>L'utilisateur suivant existe déjà :</h2>
<table>
    <tr>
        <th>First Name</th>
        <th>Family Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Gender</th>
    </tr>
    <tr>
        <td>${FirstName}</td>
        <td>${FamilyName}</td>
        <td>${Email}</td>
        <td>${Password}</td>
        <td>${Gender}</td>
    </tr>
</table>
<form action="/td22_war_exploded/insertion" method="post">
    <input type="hidden" name="User first Name" value="${FirstName}">
    <input type="hidden" name="User family name" value="${FamilyName}">
    <input type="hidden" name="User email" value="${Email}">
    <input type="hidden" name="User password" value="${Password}">
    <input type="hidden" name="gender" value="${Gender}">
    <input type="submit" value="Ajouter quand même">
</form>
<form action="/td22_war_exploded" method="post">
    <input type="submit" value="Retour">
</form>
</body>
</html>

