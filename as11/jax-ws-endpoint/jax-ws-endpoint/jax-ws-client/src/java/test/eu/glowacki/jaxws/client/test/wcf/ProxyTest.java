package eu.glowacki.jaxws.client.test.wcf;

import eu.glowacki.jaxws.client.wcf.proxy.CalculatorImpl;
import eu.glowacki.jaxws.client.wcf.proxy.ICalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public final class ProxyTest {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    private ICalculator _proxy;

    @Before
    public void before() {
        CalculatorImpl service = new CalculatorImpl();
        _proxy = service.getBasicHttpBindingICalculator();
    }

    @Test
    public void add() {
        final int constituent1 = 2;
        final int constituent2 = 3;
        final int expected = constituent1 + constituent2;
        final int result = _proxy.add(constituent1, constituent2);
        Assert.assertEquals(expected, result);
        LOGGER.info("result: " + result);
    }
}