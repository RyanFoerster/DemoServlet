<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/style.css" type="text/css">
    <title>Product list</title>
</head>
<body>

    <%
        List<Recipe> recipes = (List<Recipe>) request.getAttribute("recipes");
        Boolean setUpdate = (Boolean) session.getAttribute("setUpdate");
    %>


    <header>
        <h1>Bienvenue sur la liste des produits</h1>
        <ul class="nav justify-content-end">
            <li class="nav-item active">
                <a class="nav-link active" href="<%= request.getContextPath() + "/"%>">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addProduct">Add Product</a>
            </li>
        </ul>
    </header>

    <section class="container-style">
        <c:forEach items="${recipes}" var="recipe">
                <div id="myCard${recipe.id}" class="card card-main" style="width: 18rem;">
                    <div id="myCardBody${recipe.id}" class="card-body">
                        <h5 class="card-title">${recipe.name}</h5>
                        <p class="card-text">${recipe.ingredient.length() > 50 ? recipe.ingredient.substring(0,50).concat("...") : recipe.ingredient}</p>
                        <div class="button-style">
                            <form action="productList" method="post">
                                <button type="button" class="btn btn-info button-update text-white" name="upd" onclick="switchMode(${recipe.id})" >Update</button>
                                <input type="text" name="id" value="${recipe.id}" hidden="hidden">
                            </form>
                            <form action="productList" method="get">
                                <button type="submit" class="btn btn-info button-delete text-white" name="del">Delete</button>
                                <input type="text" name="id" value="${recipe.id}" hidden="hidden">
                            </form>
                            <button type="button" class="btn btn-info button-details text-white" data-bs-toggle="modal" data-bs-target="#modal${recipe.id}">Details</button>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="modal${recipe.id}" tabindex="-1" aria-labelledby="modalLabel${recipe.id}" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="modalLabel${recipe.id}">${recipe.name}</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h2>Ingredients : </h2>
                                <p>${recipe.ingredient}</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>

        </c:forEach>

    </section>

    <script src="script/scriptUpdate.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>