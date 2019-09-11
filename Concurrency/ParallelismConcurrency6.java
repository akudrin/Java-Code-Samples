import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class ParallelismConcurrency6 {

    private Map<Integer, Product> cache = new HashMap<>();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    //Retrieving a product from Map
    private Product getLocal(int id) {
        return cache.get(id);
    }

    //Retrieving a product from a DB or REST
    private Product getRemote(int id) {
        try {
            Thread.sleep(100);
            if (id == 666) {
                throw new RuntimeException("Evil request");
            }
        } catch (InterruptedException ignored) {
        }
        return new Product(id, "name");
    }

    //Completing a CompletableFuture
    public CompletableFuture<Product> getProduct(int id) {
        try {
            Product product = getLocal(id);
            if (product != null) {
                return CompletableFuture.completedFuture(product);
            } else {
                CompletableFuture<Product> future = new CompletableFuture<>();
                Product p = getRemote(id);
                cache.put(id, p);
                future.complete(p);
                return future;
            }
        } catch (Exception e) {
            CompletableFuture<Product> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }


    public static void main(String[] args) {

    }
}

class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}