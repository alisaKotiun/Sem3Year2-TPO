package tpo.as7_2;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ResponseWrapper extends HttpServletResponseWrapper {
    //close does nothing
    private StringWriter writer;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        writer = new StringWriter();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(writer);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        throw new IllegalStateException("getOutputStream() is not allowed in StringResponseWrapper");
    }

    public String content(){
        return writer.toString();
    }
}
