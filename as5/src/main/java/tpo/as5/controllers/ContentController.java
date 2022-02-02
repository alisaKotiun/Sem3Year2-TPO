package tpo.as5.controllers;

import tpo.as5.logic.ResourcesLogic;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/content")
public class ContentController extends HttpServlet {

    @Resource(name = "as5")
    private DataSource dataSource;

    private ResourcesLogic logic;

    public void init(){
        logic = new ResourcesLogic(dataSource);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String content = "";
        try {
            content = logic.get(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter writer = resp.getWriter();
        writer.println(getContent(name, content));

        writer.close();
    }

    private String getContent(String name, String content){
        String CONTENT = "<!DOCTYPE html>" //
                + "<html>"
                + "<head>"
                + "<title>Content"
                + "</title>"
                +"</head>"//
                + "<body>" //
                + "<a align=\"right\">"
                + "<form method=\"get\" action=\"/resourceView\">"
                + "<button type=\"submit\">Back</button>"
                + "</form>"
                + "<form method=\"get\" action=\"/index.html\">"
                + "<button type=\"submit\">Log out</button>"
                + "</form>"
                + "</a>"
                + "<h1>CONTENT</h1>"//
                + "<h3>RESOURCE NAME:</h3>"//
                + "<h4>" + name + "</h4><br>"//
                + "<h3>CONTENT:</h3>"//
                + "<h4>" + content + "</h4>"//
                + "</body>" //
                + "</html>";
        return CONTENT;
    }
}
