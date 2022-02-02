package Protocols;

public interface IProtocol {
    String processRequest(String string);
    String sendRequest(String string);
    void processResponse(String string);
}
