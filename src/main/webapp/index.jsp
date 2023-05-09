<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <link rel="icon" type="image/x-icon" href="images/logo.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/style.css" type="text/css">
    </head>
    <body>

        <header>
                <% if(session.getAttribute("user") != null){ %>
                <h1>Hello ${user.login} !</h1>
                    <ul class="nav justify-content-end">
                        <li class="nav-item active">
                            <a class="nav-link active" href="#">Accueil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="addProduct">Add Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="productList">Product list</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                    </ul>
                <% } else { %>
                    <ul class="nav justify-content-end">
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register">Register</a>
                        </li>
                    </ul>
                <% } %>

        </header>

        <figure>
            <img src="images/nyancat.gif" alt="nyancat" style="width: 100vw;">
        </figure>
    </body>
</html>