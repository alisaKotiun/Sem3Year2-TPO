
package eu.glowacki.jaxws.client.wcf.proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICalculator", targetNamespace = "http://glowacki.eu")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICalculator {


    /**
     * 
     * @param constituent2
     * @param constituent1
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(operationName = "Add", action = "http://glowacki.eu/ICalculator/Add")
    @WebResult(name = "AddResult", targetNamespace = "http://glowacki.eu")
    @RequestWrapper(localName = "Add", targetNamespace = "http://glowacki.eu", className = "eu.glowacki.jaxws.client.wcf.proxy.Add")
    @ResponseWrapper(localName = "AddResponse", targetNamespace = "http://glowacki.eu", className = "eu.glowacki.jaxws.client.wcf.proxy.AddResponse")
    public Integer add(
        @WebParam(name = "constituent1", targetNamespace = "http://glowacki.eu")
        Integer constituent1,
        @WebParam(name = "constituent2", targetNamespace = "http://glowacki.eu")
        Integer constituent2);

}
