package tpo.as7_2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "footer", urlPatterns = {"*.html", "*.servlet"})
public class Footer implements Filter {

    private static String FOOTER =
            "<div id=\"date\"></div>" +
            "</body></html>";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(servletRequest, responseWrapper);

        //response
        String wrapperContent = responseWrapper.content();
        PrintWriter out = servletResponse.getWriter();
        out.print(wrapperContent);

        //append
        out.println(FOOTER);
        out.close();
    }
}
