import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Recipe10_12 {

    public static void main(String[] args) {
        try {
            CompletableFuture tasks = performWork()
                    .thenApply(work -> {
                        String newTask = work + " Second task complete!";
                        System.out.println(newTask);
                        return newTask;
                    }).thenApply(finalTask -> finalTask + " Final Task Complete!");
            
            CompletableFuture future = performSecondWork("Java 9 is Great! ");
            while(!tasks.isDone()){
               System.out.println(future.get());
            }
            System.out.println(tasks.get());
            
            
        } catch (ExecutionException | InterruptedException ex) {

        }
    }

    public static CompletableFuture performWork() {
        CompletableFuture resultingWork = CompletableFuture.supplyAsync(
                () -> {
                    String taskMessage = "First task complete!";
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                    System.out.println(taskMessage);
                    return taskMessage;
                });
        return resultingWork;

    }

    public static CompletableFuture performSecondWork(String message) {
        CompletableFuture resultingWork = CompletableFuture.supplyAsync(
                () -> {
                    String taskMessage = message + " Another task complete!";
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }

                    return taskMessage;
                });
        return resultingWork;

    }
}
