import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("luci5.txt");
        FileChannel fc = fis.getChannel();
        long startRegion = 0;
        long endRegion = fc.size();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, startRegion, endRegion);
        while (mbb.hasRemaining()) {
            System.out.print((char) mbb.get());
        }
        fc.close();
    }

}