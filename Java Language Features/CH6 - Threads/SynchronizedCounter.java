public class SynchronizedCounter {
    private long value;

    public synchronized long next() {
        return ++value;
    }
}
