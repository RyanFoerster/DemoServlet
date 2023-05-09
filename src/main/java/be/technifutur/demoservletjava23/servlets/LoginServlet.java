package be.technifutur.demoservletjava23.servlets;

import java.io.*;

import be.technifutur.demoservletjava23.dtos.ConnectedCustomiserDto;
import be.technifutur.demoservletjava23.exceptions.InvalidPasswordUserException;
import be.technifutur.demoservletjava23.models.Customiser;
import be.technifutur.demoservletjava23.services.CustomiserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {


    public void init() {
        String connectionString = this.getServletContext().getInitParameter("CONNECTION_STRING");
        String dbUser = this.getServletContext().getInitParameter("DB_USER");
        String dbPassword = this.getServletContext().getInitParameter("DB_PASSWORD");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("login", "");
        request.getRequestDispatcher("pages/login.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CustomiserServiceImpl customiserService = new CustomiserServiceImpl();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try{
            Customiser customiser = customiserService.findByLogin(login, password);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", ConnectedCustomiserDto.fromEntity(customiser));
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }catch (InvalidPasswordUserException e){
            request.setAttribute("errorMessage", "Invalid password");
        }

    }

    public void destroy() {


    }
}