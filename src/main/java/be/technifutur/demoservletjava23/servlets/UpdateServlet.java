package be.technifutur.demoservletjava23.servlets;

import be.technifutur.demoservletjava23.models.Recipe;
import be.technifutur.demoservletjava23.services.RecipeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "updateProduct", urlPatterns = "/updateProduct")

public class UpdateServlet extends HttpServlet {
    RecipeServiceImpl recipeService = new RecipeServiceImpl();
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession(true);
        Integer id = Integer.parseInt(req.getParameter("id"));
        Recipe recipe = recipeService.getById(id);
        String productName = recipe.getName();
        String productIngredient = recipe.getIngredient();

        session.setAttribute("productName", productName);
        session.setAttribute("productIngredient", productIngredient);
        session.setAttribute("productId", id);

        req.getRequestDispatcher("pages/updateProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productName = req.getParameter("productName");
        String productIngredient = req.getParameter("productIngredient");

        Recipe recipe = Recipe.builder().name(productName).ingredient(productIngredient).build();
        System.out.println(session.getAttribute("productId").toString());
        Integer id = Integer.parseInt(session.getAttribute("productId").toString());
        Boolean success = recipeService.update(id, recipe);

        if(success){

        }
        resp.sendRedirect("productList");
    }

    @Override
    public void init() throws ServletException {

    }
}
