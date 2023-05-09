
<%--
  Created by IntelliJ IDEA.
  User: studentdev03
  Date: 08-05-23
  Time: 16:32
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
    <title>Title</title>
</head>
<body>
    <header>
        <ul class="nav justify-content-end">
            <li class="nav-item active">
                <a class="nav-link active" href="">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="productList">Product List</a>
            </li>
        </ul>
    </header>


    <form action="addProduct" method="post" class="form">
        <label for="productName" class="form-label">Product name : </label>
        <input type="text" name="productName" id="productName" class="form-control-sm" value="${productName}">
        <label for="productIngredient" class="form-label">Product ingredient : </label>
        <input type="text" name="productIngredient" id="productIngredient" class="form-control-sm" value="${productIngredient}">
        <button type="submit" class="btn btn-primary">Add product</button>
    </form>


</body>
</html>