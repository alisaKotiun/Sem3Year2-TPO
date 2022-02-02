package Echo;
import java.io.Serializable;

public class EchoResponse implements Serializable {
    public String response;

    public EchoResponse(EchoRequest request) {
        this(request.request);
    }

    public EchoResponse(String r){
        response = r.toUpperCase();
    }
}
