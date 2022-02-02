package Add;

import java.io.Serializable;
import java.math.BigInteger;

public class AddRequest implements Serializable {
    public BigInteger int1;
    public BigInteger int2;

    public AddRequest(String i1, String i2){
        this(BigInteger.valueOf(Long.parseLong(i1)),
                BigInteger.valueOf(Long.parseLong(i2)));
    }

    public AddRequest(BigInteger i1, BigInteger i2){
        int1 = i1;
        int2 = i2;
    }
}
