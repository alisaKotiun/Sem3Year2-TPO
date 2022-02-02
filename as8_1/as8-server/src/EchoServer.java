import Echo.IEcho;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EchoServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(IEcho.RMI_PORT);
            IEcho echo = new RemoteObject();
            Naming.bind(IEcho.RMI_ECHO_NAME, echo);
            System.out.println("Server is ready");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
