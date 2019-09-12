import java.util.concurrent.CompletableFuture;

public class ParallelismConcurrency7 {
    public static void main(String[] args) {

        //Coordinating tasks using a CompletableFuture
        CompletableFuture.supplyAsync(() -> new ParallelismConcurrency7().sleepThenReturnString())
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
