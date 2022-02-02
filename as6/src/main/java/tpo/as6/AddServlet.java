package tpo.as6;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "add", value = "/add")
public class AddServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        String int1 = req.getParameter("integer1");
        String int2 = req.getParameter("integer2");

        String result = result(int1, int2);

        out.write("{ \"result\" : " + result + "}");
        out.close();
    }

    private String result(String i1, String i2){
        if(i1 == null || i2 == null){
            return "";
        }
        int integer1 = Integer.parseInt(i1);
        int integer2 = Integer.parseInt(i2);
        return String.valueOf(integer1 + integer2);
    }
}