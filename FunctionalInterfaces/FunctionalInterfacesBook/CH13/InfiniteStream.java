import java.util.stream.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.function.*;
class InfiniteStream {
    private static Semaphore sem = new Semaphore(0);
    private static int number;
    public static void main(String[] args) throws Exception
    {
        Consumer<Integer> acquire = x -> {
            try {
                sem.acquire();
            } catch (InterruptedException e) {}
        };
        Runnable r = () -> {
            Stream.generate( () -> (new Random()).nextInt(100))
                    .peek(acquire)
                    .forEach(x -> number = x);
        };
        Thread generator = new Thread(r);
        generator.setDaemon(true);
        generator.start();
        Supplier<Boolean> finished = () -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Do you want another number" +
                    "(Y for yes):");
            return input.nextLine().charAt(0) != 'Y';
        };
        do
        {
            sem.release();
            Thread.sleep(1000);
            System.out.println("The number is " + number);
        } while (!finished.get());
    }
}