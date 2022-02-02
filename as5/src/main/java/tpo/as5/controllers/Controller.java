package tpo.as5.controllers;

import tpo.as5.CustomException;
import tpo.as5.logic.UserLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class Controller extends HttpServlet {

    private static final String USER_LOGIN = "userLogin";
    private static final String USER_PASSWORD = "userPassword";
    public static final String ID = "id";

    @Resource(name = "as5")
    private DataSource dataSource;

    private UserLogic logic;

    public void init() {
        logic = new UserLogic(dataSource);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = logic(req);

        if(id == -1) {
            throw new CustomException("USER IS NOT FOUND");
        }

        HttpSession session = req.getSession();
        Integer attribute = (Integer) session.getAttribute(ID);
        if(attribute == null){
            session.setAttribute(ID, id);
        }

        resp.sendRedirect("/resourceView");
    }

    private int logic(HttpServletRequest req){
        int id = -1;
        try{
            String login = req.getParameter(USER_LOGIN);
            String password = req.getParameter(USER_PASSWORD);
            if(check(login, password)){
                id = logic.get(login, password);
            }
            else throw new CustomException("INVALID VALUES");
        } catch (SQLException exc){
            exc.printStackTrace();
        }
        return id;
    }

    private boolean check(String lo, String p){
        return lo != null && !lo.isEmpty() &&
                p != null && !p.isEmpty();
    }
}
