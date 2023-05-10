<%--
  Created by IntelliJ IDEA.
  User: studentdev03
  Date: 10-05-23
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<% if(session.getAttribute("user") == null){
    response.sendRedirect(request.getContextPath() + "/login");
}%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bienvenue</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/home.css">
    </head>
    <body>
        <header>
            <ul class="nav justify-content-end">
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
        </header>

        <section>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquam aut culpa cum, dicta distinctio ea eaque est
                facilis harum illo iste, laudantium libero molestiae nihil quae quibusdam quos unde.
            </p>
            <p>A alias commodi deleniti distinctio incidunt ipsum, nostrum numquam optio possimus quasi recusandae reprehenderit
                suscipit voluptatibus? Accusamus dolorem dolores eaque possimus quam veniam vero. Cumque iusto molestiae neque
                obcaecati placeat.
            </p>
            <p>Delectus dolorum impedit perferendis perspiciatis quam quis reiciendis ut! Ab alias blanditiis cupiditate debitis,
                eligendi et exercitationem fugiat fugit incidunt ipsa itaque molestias quaerat quia quo reiciendis sed sint
                suscipit!
            </p>
        </section>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>