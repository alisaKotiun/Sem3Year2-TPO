import Protocols.AddProtocol;
import Protocols.EchoProtocol;
import Protocols.IProtocol;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

//add 5555
//echo 5555

public class Server {
    private ByteBuffer byteBuffer;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private int size = 1024;
    private IProtocol protocol;

    public static void main(String[] args) {
        IProtocol iProtocol = args[0].equalsIgnoreCase("echo") ?
                new EchoProtocol() : new AddProtocol();
        int port = Integer.parseInt(args[1]);
        Server server = new Server(port, iProtocol);
        server.serviceConnection();
    }

    public Server(int port, IProtocol iProtocol){
        try {
            protocol = iProtocol;
            serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", port);
            serverSocketChannel.bind(inetSocketAddress);
            selector = Selector.open();
            byteBuffer = ByteBuffer.allocate(size);
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serviceConnection(){
        while (true){
            try {
                selector.select();
                Set keys = selector.selectedKeys();
                Iterator iterator = keys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = (SelectionKey) iterator.next();
                    iterator.remove();

                    if(key.isAcceptable()){
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        continue;
                    }
                    if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        byteBuffer.clear();
                        socketChannel.read(byteBuffer);
                        byteBuffer.flip();
                        String request = new String(byteBuffer.array(), 0, byteBuffer.limit());
                        String response = protocol.processRequest(request);
                        byteBuffer.clear();
                        byteBuffer.put(response.getBytes());
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        socketChannel.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
