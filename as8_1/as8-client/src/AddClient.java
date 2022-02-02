import Add.AddRequest;
import Add.AddResponse;
import Add.IAdd;

import java.rmi.Naming;

public class AddClient {
    public static void main(String[] args) {
        try {
            IAdd add = (IAdd) Naming.lookup(IAdd.RMI_ADD_NAME);
            AddRequest request = new AddRequest(args[0], args[1]);
            AddResponse response = add.add(request);
            System.out.println("req: " + request.int1 + " and " + request.int2
                    + "; resp: " + response.response);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
