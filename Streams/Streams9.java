import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Streams9 {
    public static void main(String[] args) {
        Customer sheridan = new Customer("Sheridan");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");
        sheridan.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));
        ivanova.addOrder(new Order(4))
                .addOrder(new Order(5));
        List<Customer> customers = Arrays.asList(sheridan, ivanova, garibaldi);

        customers.stream()
                .map(Customer::getName)
                .forEach(System.out::println);

        customers.stream()
                .map(Customer::getOrders)
                .forEach(System.out::println);
        customers.stream()
                .map(customer -> customer.getOrders().stream())
                .forEach(System.out::println);

        customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .forEach(System.out::println);

    }
}

class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();
    public Customer(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public List<Order> getOrders() { return orders; }
    public Customer addOrder(Order order) {
        orders.add(order);
        return this;
    }
}
class Order {
    private int id;
    public Order(int id) {
        this.id = id;
    }
    public int getId() { return id; }
}