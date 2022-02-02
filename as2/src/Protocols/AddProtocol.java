package Protocols;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddProtocol implements IProtocol {
    String requestAdd = "^ADD-([0-9]+)AND([0-9]+)$";
    @Override
    public String processRequest(String string) {
        Pattern pattern = Pattern.compile(requestAdd);
        Matcher matcher = pattern.matcher(string);
        int i1, i2; String result = "";
        if (matcher.matches()){
            int[] arg = extract(string);
            i1 = arg[0]; i2 = arg[1];
            System.out.println("REQUEST: " + i1 + " + " + i2);
            result = result(i1, i2);
        }
        else {
            System.out.println("shit...");
        }
        return result;
    }

    String result(int i1, int i2){
        return "" + i1 + " + " + i2 + " = " + (i1 + i2);
    }

    int[] extract (String string) {
        int [] arg = new int[2];
        Matcher matcher = Pattern.compile("[0-9]+").matcher(string);
        int i = 0;
        while (matcher.find()){
            arg[i++] = Integer.parseInt(matcher.group());
        }
        return arg;
    }

    @Override
    public String sendRequest(String string) {
        return "ADD-" + string;
    }

    @Override
    public void processResponse(String string) {
        System.out.println("RESPONSE: " + string);
    }
}
