package tpo.as7_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/date")
public class DateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        PrintWriter out = resp.getWriter();
        out.write("{ \"date\" : \"" + d + "\"}");
        out.close();
    }
}
