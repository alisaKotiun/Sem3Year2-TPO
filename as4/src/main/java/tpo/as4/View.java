package tpo.as4;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view")
public class View extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Model model = (Model) req.getAttribute(Controller.MODEL_ATTRIBUTE);
        PrintWriter writer = res.getWriter();

        if(model.getResult() == null){
            String error = "Arguments are not valid";
            writer.println(error);
            writer.close();
            return;
        }

        writer.println("Result: " + model.getResult());
        writer.close();


    }
}
