import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismConcurrency7 {
    public static void main(String[] args) {

        //Coordinating tasks using a CompletableFuture
        CompletableFuture.supplyAsync(() -> new ParallelismConcurrency7().sleepThenReturnString())
                .thenApply(Integer::parseInt)
                .thenApply(x -> 2 * x)
                .thenAccept(System.out::println)
                .join();
        System.out.println("Running...");

        //Running CompletableFuture tasks on a separate thread pool
        ExecutorService service = Executors.newFixedThreadPool(4);

        CompletableFuture.supplyAsync(() -> new ParallelismConcurrency7().sleepThenReturnString(), service)
                .thenApply(Integer::parseInt)
                .thenApply(x -> 2 * x)
                .thenAccept(System.out::println)
                .join();
        System.out.println("Running...");

    }

    private String sleepThenReturnString() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return "42";
    }


}
