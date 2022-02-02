import Echo.EchoRequest;
import Echo.EchoResponse;
import Echo.IEcho;

import java.rmi.Naming;

public class EchoClient {
    public static void main(String[] args) {
        try {
            IEcho echo = (IEcho) Naming.lookup(IEcho.RMI_ECHO_NAME);
            EchoRequest request = new EchoRequest(args[0]);
            EchoResponse response = echo.echo(request);
            System.out.println("req: " + request.request + "; resp: " + response.response);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
