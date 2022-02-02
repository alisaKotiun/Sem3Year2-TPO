import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Main{
    private RandomAccessFile randomAccessFile;
    private MappedByteBuffer buffer;
    private int size = 10;

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\User\\OneDrive\\Робочий стіл\\TPO\\as1\\src\\file.txt");
        Mode mode = args[0].equalsIgnoreCase(Mode.write.getMode()) ? Mode.write : Mode.read;
        Main main = new Main(file, mode);
        if (mode == Mode.write) main.write();
        else main.read();
    }

    public Main(File file, Mode mode) throws Exception{
        if(!file.exists() || !file.canRead() || !file.canWrite()){
            throw new Exception("something is wrong with file");
        }
        randomAccessFile = new RandomAccessFile(file.getPath(), "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        //mapping a file
        buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);
    }

    void write(){
        while(true){
            buffer.rewind(); //set the current position to 0; limit - the same
            int mode = buffer.get();
            if(mode == Mode.write.getValue()){
                int first = random();
                int second = random();
                System.out.println("send: " + first + "; " + second);
                buffer.rewind();
                buffer.put(Mode.read.getValue());
                buffer.put((byte) first);
                buffer.put((byte) second);
            }
            sleep();
        }
    }

    void read(){
        while(true){
            buffer.rewind();
            int mode = buffer.get();
            if(mode == Mode.read.getValue()){
                sleep(); //kind of processing
                int first = buffer.get();
                int second = buffer.get();
                buffer.rewind();
                buffer.put(Mode.write.getValue());

                System.out.println("result of adding " + first + " and " + second + ": " + (first + second));
            }
            sleep();
        }
    }

    private int random(){
        Random random = new Random();
        int i = random.nextInt(100);
        return i;
    }

    private void sleep(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}