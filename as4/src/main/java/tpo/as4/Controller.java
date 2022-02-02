package tpo.as4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/add")
public class Controller extends HttpServlet {

    private Logic logic;
    public static String MODEL_ATTRIBUTE = "model";

    public Controller(){
        logic = new Logic();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Integer int1 = parse(req.getParameter("integer1"));
        Integer int2 = parse(req.getParameter("integer2"));

        Model model = logic.add(int1, int2);

        req.setAttribute(MODEL_ATTRIBUTE, model);
        ServletContext context = req.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/view");
        dispatcher.forward(req, res);
    }

    private Integer parse(String string){
        if(string.isEmpty() || string == null) return null;
        return Integer.parseInt(string);
    }
}
