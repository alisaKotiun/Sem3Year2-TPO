package tpo.as7_2.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class RequestIDListener implements ServletRequestListener {
    private static final Logger LOGGER = Logger.getLogger(RequestIDListener.class.getName());

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //severe or info
        LOGGER.severe("Request initialization " + sre.toString());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        LOGGER.severe("Request destroyed " + sre.toString());
    }
}
