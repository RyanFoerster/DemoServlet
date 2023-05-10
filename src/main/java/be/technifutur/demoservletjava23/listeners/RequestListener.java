package be.technifutur.demoservletjava23.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class RequestListener implements ServletRequestListener {

    private static final Logger LOGGER = Logger.getLogger(RequestListener.class.getName());

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        request.getSession(true).setAttribute("startTime", System.currentTimeMillis());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        Long startTime = (Long) request.getSession().getAttribute("startTime");
        LOGGER.log(Level.INFO, "Request takes {0} milliseconds", System.currentTimeMillis() - startTime);

    }
}
