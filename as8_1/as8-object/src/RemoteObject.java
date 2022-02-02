import Add.AddRequest;
import Add.AddResponse;
import Add.IAdd;
import Echo.EchoRequest;
import Echo.EchoResponse;
import Echo.IEcho;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObject extends UnicastRemoteObject implements IEcho, IAdd {

    protected RemoteObject() throws RemoteException {
    }

    @Override
    public AddResponse add(AddRequest addRequest) throws RemoteException {
        return new AddResponse(addRequest);
    }

    @Override
    public EchoResponse echo(EchoRequest echoRequest) throws RemoteException {
        return new EchoResponse(echoRequest);
    }
}
