package tpo.Adding;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "add", value = "/add")
public class AddServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        String int1 = req.getParameter("integer1");
        String int2 = req.getParameter("integer2");

        if(int1 == null || int2 == null){
            out.println("Invalid arguments");
            out.close();
            return;
        }

        int integer1 = Integer.parseInt(int1);
        int integer2 = Integer.parseInt(int2);

        out.println("Result: " + (integer2 + integer1));
        out.close();
    }
}