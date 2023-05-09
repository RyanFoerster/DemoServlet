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

@WebServlet(name = "addProduct", urlPatterns = "/addProduct")

public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/addProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RecipeServiceImpl recipeService = new RecipeServiceImpl();

            String productName = req.getParameter("productName");
            String productIngredient = req.getParameter("productIngredient");

            Recipe recipe = Recipe.builder().name(productName).ingredient(productIngredient).build();

            recipeService.create(recipe);

            req.getRequestDispatcher("pages/addProduct.jsp").forward(req, resp);

    }

    @Override
    public void init() throws ServletException {

    }
}
