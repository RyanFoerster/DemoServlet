package be.technifutur.demoservletjava23.servlets;

import be.technifutur.demoservletjava23.models.Recipe;
import be.technifutur.demoservletjava23.repositories.RecipeRepository;
import be.technifutur.demoservletjava23.repositories.RecipeRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productList", urlPatterns = "/productList")


public class ProductListServlet extends HttpServlet {
    RecipeRepository recipeRepository = new RecipeRepositoryImpl();
    HttpSession session;
    Boolean setUpdate;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession(true);
        setUpdate = false;
        if(req.getParameter("id")!= null){
            int id = Integer.parseInt(req.getParameter("id"));
            recipeRepository.delete(id);
        }
        List<Recipe> recipes = recipeRepository.getAll();

        req.setAttribute("recipes", recipes);
        session.setAttribute("setUpdate", setUpdate);
        req.getRequestDispatcher("pages/productList.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            setUpdate = true;
            int id = Integer.parseInt(req.getParameter("id"));
            Recipe recipe = recipeRepository.getById(id);

            session.setAttribute("setUpdate", setUpdate);
            session.setAttribute("recipe_id", recipe.getId());
            session.setAttribute("recipe_name", recipe.getName());
            session.setAttribute("recipe_ingredient", recipe.getIngredient());

            req.getRequestDispatcher("pages/productList.jsp").forward(req, resp);

    }

    @Override
    public void init() throws ServletException {

    }
}
