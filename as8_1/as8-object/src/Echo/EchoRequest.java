package Echo;

import java.io.Serializable;

public class EchoRequest implements Serializable {
    public String request;

    public EchoRequest(String r){
        request = r;
    }
}
