public class FileLockingExample1 {

    public static void main(String[] args) {
        // Create a random access file and obtain a channel for it
        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        FileChannel fileChannel = raf.getChannel();
        // Get an exclusive lock on the file
        FileLock lock1 = fileChannel.lock();
        // Get an exclusive lock on first 10 bytes
        FileLock lock2 = fileChannel.lock(0, 10, false);
        // Try to get an exclusive lock on the entire file
        FileLock lock3 = fileChannel.tryLock();
        if (lock == null) {
            // Could not get the lock
        } else {
            // Got the lock
        }
        // Try to lock 100 bytes starting from the 11th byte in a shared mode
        FileLock lock4 = fileChannel.tryLock(11, 100, true);
        if (lock == null) {
            // Could not get the lock
        } else {
            // Got the lock
        }
    }
}