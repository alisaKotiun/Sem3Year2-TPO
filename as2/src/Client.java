import Protocols.AddProtocol;
import Protocols.EchoProtocol;
import Protocols.IProtocol;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
//add 5555 6AND1232
//echo 5555 hello

public class Client {
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;
    private int size = 1024;
    private IProtocol protocol;

    public static void main(String[] args) {
        IProtocol iProtocol = args[0].equalsIgnoreCase("echo") ?
                new EchoProtocol() : new AddProtocol();
        int port = Integer.parseInt(args[1]);
        Client client = new Client(port, iProtocol);
        client.serviceConnection(args[2]);
    }

    public Client(int port, IProtocol iProtocol){
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", port);
            socketChannel = SocketChannel.open(inetSocketAddress);
            byteBuffer = ByteBuffer.allocate(size);
            protocol = iProtocol;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String serviceConnection(String msg){
        try {
            byteBuffer.clear();
            byteBuffer.put(protocol.sendRequest(msg).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            socketChannel.read(byteBuffer);
            byteBuffer.flip();
            String result = new String(byteBuffer.array(), 0, byteBuffer.limit());
            protocol.processResponse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "asd";
    }
}
