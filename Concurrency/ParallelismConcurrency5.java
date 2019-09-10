import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelismConcurrency5 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(100);
                return "Hello, World!";
            }
        });
        System.out.println("Processing...");
        getIfNotCancelled(future);

    }
}
