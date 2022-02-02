package Echo;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEcho extends Remote {
    int RMI_PORT = 1099;
    String RMI_ECHO_NAME = "echo";

    EchoResponse echo(EchoRequest echoRequest) throws RemoteException;
}
