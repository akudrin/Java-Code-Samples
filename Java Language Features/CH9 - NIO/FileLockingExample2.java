import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockingExample2 {
    public static void main(String[] args) {
        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        FileChannel fileChannel = raf.getChannel();
        FileLock lock = null;
        try {
            lock = fileChannel.lock(0, 10, true);
            /* Work with the file here */
        } catch (IOException e) {
            // Handle the exception
        } finally {
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException e) {
                    // Handle the exception
                }
            }
        }
    }

}