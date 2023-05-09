package be.technifutur.demoservletjava23.servlets;

import be.technifutur.demoservletjava23.models.Recipe;
import be.technifutur.demoservletjava23.repositories.RecipeRepository;
import be.technifutur.demoservletjava23.repositories.RecipeRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "productList", urlPatterns = "/productList")


public class ProductListServlet extends HttpServlet {
    RecipeRepository recipeRepository = new RecipeRepositoryImpl();
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("id")!= null){
            Integer id = Integer.parseInt(req.getParameter("id"));
            recipeRepository.delete(id);
        }
        List<Recipe> recipes = recipeRepository.getAll();

        req.setAttribute("recipes", recipes);

        req.getRequestDispatcher("pages/productList.jsp").forward(req, resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    public void init() throws ServletException {

    }
}
