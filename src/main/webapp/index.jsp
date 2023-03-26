<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
<body>
<h1>Connexion</h1>
<form action="/td22_war_exploded/connexion" method="POST">
    <label for="email">Adresse e-mail :</label>
    <input type="email" id="email" name="username" required><br><br>
    <label for="password">Mot de passe :</label>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="Se connecter">
    <a href="/td22_war_exploded/CreateUser.jsp">Registre</a>
</form>
</body>
</html>
