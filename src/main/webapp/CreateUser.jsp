<%--
  Created by IntelliJ IDEA.
  User: zhacheny
  Date: 24/03/2023
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>TODO supply a title</title> <meta charset="UTF-8"> <meta name="viewport" content="width=device-width,
initial-scale=1.0">
</head>
<body>
<form action="/td22_war_exploded/validation" method="post">
    <label> First name </label> <input type="text" id="frname" name="User first name"/><br/>
    <label> Familly name </label> <input type="text" id="faname" name="User family name"/><br/>
    <label> Email </label> <input type="email" id="email" name="User email"/> <br>
    <label> Password </label> <input type="password" id="psw" name="User password"/><br/>
    <label> male </label> <input type="radio" id="male" name="gender" value="male" checked/><br/>
    <label> female </label> <input type="radio" id="female" name="gender" value="female"/> <br/>
    <label> Admin </label> <input type="radio" id="Admin" name="Admin" value="Admin"/> <br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
