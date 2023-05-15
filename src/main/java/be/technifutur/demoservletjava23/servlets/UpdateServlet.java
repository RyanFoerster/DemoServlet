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


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        String productName = (String) req.getParameter("recipe_name");
        String productIngredient = (String) req.getParameter("recipe_ingredient");

        Recipe recipe = Recipe.builder().name(productName).ingredient(productIngredient).build();

        Integer id = Integer.parseInt(req.getParameter("recipe_id"));

        recipeService.update(id, recipe);

        resp.sendRedirect("productList");
    }

    @Override
    public void init() throws ServletException {

    }
}
