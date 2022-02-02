package Add;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAdd extends Remote {
    int RMI_PORT = 1099;
    String RMI_ADD_NAME = "add";
    AddResponse add(AddRequest addRequest) throws RemoteException;
}
