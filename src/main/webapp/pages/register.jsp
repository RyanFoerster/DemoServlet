<%--
  Created by IntelliJ IDEA.
  User: studentdev03
  Date: 08-05-23
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/style.css">
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form method="post" action="register" class="form">
        <label for="register" class="form-label">Login : </label>
        <input type="text" id="register" name="register" class="form-control-sm">
        <label for="password" class="form-label">Password : </label>
        <input type="password" id="password" name="password" class="form-control-sm">
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</body>
</html>