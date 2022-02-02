package Add;
import java.io.Serializable;
import java.math.BigInteger;

public class AddResponse implements Serializable {
    public BigInteger response;

    public AddResponse(AddRequest request){
        this(request.int1, request.int2);
    }

    public AddResponse(BigInteger integer1, BigInteger integer2){
        response = add(integer1, integer2);
    }

    private BigInteger add(BigInteger i1, BigInteger i2){
        return (i1 == null ? BigInteger.ZERO : i1).add(i2 == null ? BigInteger.ZERO : i2);
    }
}
