package tpo.as5.controllers;

import tpo.as5.entities.Resource;
import tpo.as5.logic.UserResourceLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/resourceView")
public class ResourceController extends HttpServlet {

    @javax.annotation.Resource(name = "as5")
    private DataSource dataSource;

    private UserResourceLogic logic;

    public void init(){
        logic = new UserResourceLogic(dataSource);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Resource> list = new ArrayList<>();
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute(Controller.ID);

        try {
            list = logic.get(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        PrintWriter writer = res.getWriter();
        String content = getHTML(list);
        writer.println(content);

        writer.close();

    }

    private String getHTML(List<Resource> list){
        String CONTENT = "<!DOCTYPE html>" //
                + "<html>" //
                + "<head>"
                + "<title>Resources"
                + "</title>"
                +"</head>"//
                + "<body>" //
                + "<form align=\"right\" method=\"get\" action=\"/index.html\">"
                + "<button type=\"submit\">Log out</button>"
                + "</form>"
                + "<h1>RESOURCES</h1>";

        for (Resource r:list) {
            String string = "<a href=\"/content?name=" + r.getName() + "\">" + r.getName()
                    + "</a><br>";
            CONTENT += string;
        }

        CONTENT = CONTENT
                + "</body>" //
                + "</html>";
        return  CONTENT;
    }

}
