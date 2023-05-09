package be.technifutur.demoservletjava23.servlets;

import be.technifutur.demoservletjava23.dtos.ConnectedCustomiserDto;
import be.technifutur.demoservletjava23.models.Customiser;
import be.technifutur.demoservletjava23.services.CustomiserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomiserServiceImpl customiserService = new CustomiserServiceImpl();

        String login = req.getParameter("register");
        String password = req.getParameter("password");

        Customiser customiser = Customiser.builder().login(login).password(password).build();
        HttpSession session = req.getSession(true);
        session.setAttribute("user", ConnectedCustomiserDto.fromEntity(customiser));
        customiserService.register(customiser);
        resp.sendRedirect(req.getContextPath() + "/");


    }

    @Override
    public void init() throws ServletException {

    }
}
