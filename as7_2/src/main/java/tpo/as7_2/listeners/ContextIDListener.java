package tpo.as7_2.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class ContextIDListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ContextIDListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //severe or info
        LOGGER.severe("Context initialization " + sce.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.severe("Context destroyed " + sce.toString());
    }
}
