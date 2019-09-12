import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismConcurrency7 {


    public static void main(String[] args) throws Exception {


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

        int x = 2;
        int y = 3;
        //Composing two Futures together
        CompletableFuture<Integer> completableFutureA =
                CompletableFuture.supplyAsync(() -> x)
                        .thenCompose(n -> CompletableFuture.supplyAsync(() -> n + y));
        //Combining two Futures
        CompletableFuture<Integer> completableFutureB =
                CompletableFuture.supplyAsync(() -> x)
                        .thenCombine(CompletableFuture.supplyAsync(() -> y),
                                (n1, n2) -> n1 + n2);

        //Using the handle method
        new ParallelismConcurrency7().handleWithException();
        new ParallelismConcurrency7().handleWithoutException();
    }

    private String sleepThenReturnString() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        return "42";
    }

    private CompletableFuture<Integer> getIntegerCompletableFuture(String num) {
        return CompletableFuture.supplyAsync(() -> Integer.parseInt(num))
                .handle((val, exc) -> val != null ? val : 0);
    }

    public void handleWithException() throws Exception {
        String num = "abc";
        CompletableFuture<Integer> value = getIntegerCompletableFuture(num);
        System.out.println(value.get() == 0);
    }

    public void handleWithoutException() throws Exception {
        String num = "42";
        CompletableFuture<Integer> value = getIntegerCompletableFuture(num);
        System.out.println(value.get() == 42);
    }


}
