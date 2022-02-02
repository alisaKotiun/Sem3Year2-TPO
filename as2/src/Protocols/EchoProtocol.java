package Protocols;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoProtocol implements IProtocol{
    String request = "^ECHO-.+$";

    @Override
    public String processRequest(String string) {
        Matcher matcher = Pattern.compile(request).matcher(string);
        String result = "";
        if (matcher.matches()){
            String[] strings = string.split("-");
            result = strings[1];
            System.out.println("REQUEST: " + result);
        }
        else {
            System.out.println("shit...");
        }
        return result.toUpperCase();
    }

    @Override
    public String sendRequest(String msg) {
        return "ECHO-" + msg;
    }

    @Override
    public void processResponse(String string) {
        System.out.println("RESPONSE: " + string);
    }
}
