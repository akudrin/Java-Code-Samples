public class WaitMethodCall {
    // Object that is used to synchronize a block
    private Object objectRef = new Object();

    public synchronized void someMethod_1() {
    // The thread running here has already acquired the monitor lock on
    // the object represented by the reference this because it is a
    // synchronized non-static method
    // other statements go here
    while (some condition is true) {
    // It is ok to call the wait() method on this, because the
    // current thread possesses monitor lock on this
    this.wait();
    }
    // other statements go here
    }

    public static synchronized void someMethod_2() {
    // The thread executing here has already acquired the monitor lock on
    // the class object represented by the WaitMethodCall.class reference
    // because it is a synchronized static method
    while (some condition is true) {
    // It is ok to call the wait() method on WaitMethodCall.class
    // because the current thread possesses monitor lock on
    // WaitMethodCall.class object
    WaitMethodCall.class.wait();
    }
    // other statements go here
    }

public void someMethod_3() {
    // other statements go here
    synchronized(objectRef) {
    // Current thread possesses monitor lock of objectRef
    while (some condition is true) {
    // It is ok to call the wait() method on objectRef because
    // the current thread possesses monitor lock on objectRef
    objectRef.wait();
}
}
// other statements go here
}

public void wrongSynchronizationMethod
    {
        // This objectRef is created every time a thread calls this method
        Object objectRef = new Object();
        // It is a blunder to use objectRef for synchronization below
        synchronized (objectRef) {
            // In fact, this block works as if there is no synchronization, because every
            // thread creates a new objectRef and acquires its monitor lock immediately.
        }
    }

}