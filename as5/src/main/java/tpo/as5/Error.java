package tpo.as5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public final class Error extends HttpServlet {

    private static final String ExceptionTypeAttribute = "javax.servlet.error.exception_type";
    private static final String ExceptionAttribute = "javax.servlet.error.exception";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Class<?> exceptionType = (Class<?>)request.getAttribute(ExceptionTypeAttribute);
        CustomException exception = (CustomException) request.getAttribute(ExceptionAttribute);

        if (exception != null) {
            PrintWriter writer = response.getWriter();
            writer.println("<html><head><title>Oops</title></head><body>");
            writer.print("<h2>" + exceptionType.getCanonicalName() + "</h2><br>");
            writer.println("<h2>" + exception.getMessage() + "</h2><hr>");
            Throwable cause = exception.getCause();
            if (cause instanceof SQLException) {
                writer.print("<h2>" + cause.getClass().getCanonicalName() + "</h2><br>");
                SQLException sqlexc = (SQLException) cause;
                writer.println(sqlexc.getMessage() + "<br><br>");
                writer.println("Error code: " + sqlexc.getErrorCode() + "<br>");
                writer.println("SQL state : " + sqlexc.getSQLState() + "<br>");
            }
            writer.print("</body></html>");
            writer.close();
        }
    }
}
