import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ParallelismConcurrency4 {
    public static void main(String[] args) {

        //Specifying the common pool size programmatically
        System.setProperty(
                "java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        long total = LongStream.rangeClosed(1, 3_000_000)
                .parallel()
                .sum();
        int poolSize = ForkJoinPool.commonPool().getPoolSize();
        System.out.println("Pool size: " + poolSize);

        //Creating your own ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool(15);
        ForkJoinTask<Long> task = pool.submit(
                () -> LongStream.rangeClosed(1, 3_000_000)
                        .parallel()
                        .sum());
        try {
            total = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        poolSize = pool.getPoolSize();
        System.out.println("Pool size: " + poolSize);





    }
}
