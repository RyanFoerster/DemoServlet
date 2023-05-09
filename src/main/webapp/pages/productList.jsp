<%@ page import="java.util.List" %>
<%@ page import="be.technifutur.demoservletjava23.models.Recipe" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.concurrent.ScheduledExecutorService" %>
<%@ page import="java.util.concurrent.Executors" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: studentdev03
  Date: 08-05-23
  Time: 16:18
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
    <link rel="stylesheet" href="styles/style.css" type="text/css">
    <title>Product list</title>
</head>
<body>

    <% List<Recipe> recipes = (List<Recipe>) request.getAttribute("recipes");
    %>

    <% if(recipes.size() == 0){ %>
        <h1 class="alert alert-danger">LISTE VIDE</h1>
    <% }else{ %>
    <header>
        <h1>Bienvenue sur la liste des produits</h1>
        <ul class="nav justify-content-end">
            <li class="nav-item active">
                <a class="nav-link active" href="login">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addProduct">Add Product</a>
            </li>
        </ul>
    </header>

    <section class="form-div">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Recipe name</th>
                    <th>Recipe ingredient</th>
                </tr>
            </thead>

            <tbody>
                <%
                    recipes.sort(Comparator.comparing(Recipe::getId));
                    for (Recipe r : recipes){ %>
                <tr>
                    <td><%= r.getId()%></td>
                    <td><%= r.getName()%></td>
                    <td><%= r.getIngredient()%></td>

                        <td>
                            <form action="updateProduct" method="get">
                                <button type="submit" class="btn btn-info" name="upd" id="button-update">Update</button>
                                <input type="text" name="id" value="<%= r.getId()%>" hidden="hidden">
                            </form>
                        </td>
                    <td>
                        <form action="productList" method="get">
                            <button type="submit" class="btn btn-info" name="del" id="button-delete">Delete</button>
                            <input type="text" name="id" value="<%= r.getId()%>" hidden="hidden">
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </section>
    <% } %>



</body>
</html>