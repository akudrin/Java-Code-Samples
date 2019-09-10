import java.util.concurrent.*;

public class ParallelismConcurrency5 {
    public static void main(String[] args) {

        //Submitting a Callable and returning the Future
        ExecutorService serviceA = Executors.newCachedThreadPool();
        Future<String> futureA = serviceA.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(100);
                return "Hello, World!";
            }
        });
        System.out.println("Processing...");
        getIfNotCancelled(futureA);

        //Using a lambda expression and checking if the Future is done
        ExecutorService serviceB = Executors.newCachedThreadPool();
        Future<String> futureB = serviceB.submit(() -> {
            Thread.sleep(10);
            return "Hello, World!";
        });
        System.out.println("More processing...");
        while (!futureB.isDone()) {
            System.out.println("Waiting...");
        }
        getIfNotCancelled(futureB);


    }

    //Retrieving a value from a Future
    public static void getIfNotCancelled(Future<String> future) {
        try {
            if (!future.isCancelled()) {
                System.out.println(future.get());
            } else {
                System.out.println("Cancelled");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
