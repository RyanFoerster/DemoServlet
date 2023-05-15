<%@ page import="be.technifutur.demoservletjava23.models.Customiser" %>
<%@ page import="be.technifutur.demoservletjava23.dtos.ConnectedCustomiserDto" %><%--
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
        <link rel="stylesheet" href="styles/home.css">
    </head>
    <body>
    <%
        ConnectedCustomiserDto user = (ConnectedCustomiserDto) session.getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("login");
        }else{
        String login = user.getLogin().substring(0,1).toUpperCase() + user.getLogin().substring(1).toLowerCase();
    %>
        <header>
            <h1>Welcome back <span class="user_name"><%= login %></span></h1>
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
    <% } %>
        <div class="wrapper">
            <section>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquam aut culpa cum, dicta distinctio ea eaque est
                    facilis harum illo iste, laudantium libero molestiae nihil quae quibusdam quos unde.
                </p>
                <p>
                    A alias commodi deleniti distinctio incidunt ipsum, nostrum numquam optio possimus quasi recusandae reprehenderit
                    suscipit voluptatibus? Accusamus dolorem dolores eaque possimus quam veniam vero. Cumque iusto molestiae neque
                    obcaecati placeat.
                </p>
                <p>
                    Delectus dolorum impedit perferendis perspiciatis quam quis reiciendis ut! Ab alias blanditiis cupiditate debitis,
                    eligendi et exercitationem fugiat fugit incidunt ipsa itaque molestias quaerat quia quo reiciendis sed sint
                    suscipit!
                </p>
            </section>
            <section>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus alias, beatae delectus id in
                    magnam porro repudiandae saepe sit veniam! Aliquam blanditiis ex facere laborum nisi non praesentium
                    quas ratione!</p>
                <p>Accusamus architecto aut culpa dolores eaque, hic illo ipsum magni maiores nihil optio perspiciatis
                    quae quaerat quo tempora unde velit voluptatem. Accusantium illum laboriosam nesciunt, nisi
                    provident quibusdam repudiandae voluptatum.</p>
                <p>Ab alias beatae deserunt dignissimos doloribus eaque earum eius fuga harum inventore, ipsum laborum,
                    maiores minima nisi non, officiis pariatur porro quaerat qui quos ratione repellat sint tenetur unde
                    veritatis.</p>
            </section>
            <section>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur at consectetur debitis earum
                    eius eos error et ex excepturi fugiat id in omnis qui ratione sapiente, velit vero vitae
                    voluptates!</p>
                <p>Adipisci doloremque ducimus ex ipsa, ipsum minus neque nihil nobis nulla obcaecati pariatur, quasi
                    reiciendis reprehenderit sapiente, ut. Ea est fuga ipsa, labore officiis tempore! Adipisci aperiam
                    repudiandae vel voluptatem!</p>
                <p>Adipisci asperiores autem blanditiis deserunt dignissimos eum excepturi, ipsum itaque laborum libero
                    maxime nostrum obcaecati perferendis quae quas quo ratione sint, soluta, tempora voluptate. Ad
                    adipisci, autem? Officia, perferendis, veniam.</p>
            </section>
            <section>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A ad labore maiores molestias mollitia!
                    Amet architecto labore maxime quas totam unde! Beatae cumque distinctio eius nulla omnis porro sint
                    veniam.</p>
                <p>Animi, assumenda consectetur dolorum esse fugiat porro quo ullam unde! Accusantium alias aliquid
                    beatae consequatur, deserunt esse laudantium non odio quibusdam, quo recusandae repellendus sapiente
                    similique ullam vel. Consequuntur, quasi?</p>
                <p>Ab aliquid at blanditiis dolorum, eaque est, eveniet, exercitationem inventore laborum magni
                    obcaecati quisquam similique veritatis vero voluptatem. Architecto aspernatur assumenda culpa dolore
                    ducimus, eligendi id nisi perferendis quia sit.</p>
            </section>
            <section>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam aliquid assumenda ducimus expedita
                    fuga ipsum laudantium mollitia optio sunt tenetur. Blanditiis enim eveniet, ipsam iure neque odio
                    quisquam ratione saepe!</p>
                <p>Ad, aut dignissimos dolor doloremque dolorum ea earum esse illo ipsam ipsum laborum molestiae nam
                    nihil nulla omnis optio placeat porro possimus quaerat qui quis quod reprehenderit, temporibus?
                    Architecto, harum!</p>
                <p>A at corporis deserunt dolorum eos est excepturi iure laboriosam libero maiores modi natus
                    necessitatibus, nihil nobis odio quaerat quam quibusdam quo, quod saepe temporibus totam veniam vero
                    vitae voluptatem!</p>
            </section>
            <section>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab accusamus adipisci amet consequatur
                    dolore, dolorum id inventore magni, nulla numquam qui soluta sunt? Error ipsum mollitia rerum
                    soluta? A, reprehenderit.</p>
                <p>Accusantium cum dolorem, ex ipsa provident rem sapiente totam ullam vero voluptatibus? Adipisci
                    corporis deleniti, eius explicabo fuga minus nisi nostrum odit, optio perspiciatis quibusdam ratione
                    soluta suscipit voluptate voluptatem.</p>
                <p>Consequuntur cupiditate doloremque, doloribus earum esse explicabo fugiat id in ipsam minima modi
                    nemo numquam obcaecati ratione similique veritatis vitae voluptatibus. Accusamus amet commodi
                    deserunt dolor, facilis modi pariatur quo!</p>
            </section>
        </div>


        <a href="#" class="back-to-top"><i class="fas fa-arrow-up"></i></a>



    <script src="https://kit.fontawesome.com/b05136d21f.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>