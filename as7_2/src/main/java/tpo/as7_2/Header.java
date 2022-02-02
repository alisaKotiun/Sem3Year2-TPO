package tpo.as7_2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "header", urlPatterns = {"*.html", "*.servlet"})
public class Header implements Filter {

    private static String HEADER = "<html>" +
            "<head>" +
            "<script src=\"scripts/jquery.js\"></script>" +
            "<script src=\"scripts/date.js\"></script>" +
            "</head><body>";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.write(HEADER);
        out.write("<h1>MY HEADER</h1>");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
