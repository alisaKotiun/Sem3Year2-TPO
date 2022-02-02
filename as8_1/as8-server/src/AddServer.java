import Add.IAdd;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AddServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(IAdd.RMI_PORT);
            IAdd add = new RemoteObject();
            Naming.bind(IAdd.RMI_ADD_NAME, add);
            System.out.println("Server is ready");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
