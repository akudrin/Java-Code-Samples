import java.util.HashMap;
import java.util.Map;
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