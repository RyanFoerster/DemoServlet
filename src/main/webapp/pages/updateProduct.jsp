<%--
  Created by IntelliJ IDEA.
  User: studentdev03
  Date: 09-05-23
  Time: 11:22
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
    <a href="productList">Product List</a>

    <form action="updateProduct" method="post" class="form">
      <label for="productName" class="form-label">Product name : </label>
      <input type="text" name="productName" id="productName" class="form-control-sm" value="${productName}">
      <label for="productIngredient" class="form-label">Product ingredient : </label>
      <input type="text" name="productIngredient" id="productIngredient" class="form-control-sm" value="${productIngredient}">
      <button type="submit" class="btn btn-primary">Update product</button>
    </form>
</body>
</html>