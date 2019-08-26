import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Optionals1 {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        Optional<AtomicInteger> optional = Optional.ofNullable(counter);

        System.out.println(optional); // Optional[0]
        counter.incrementAndGet();
        System.out.println(optional); // Optional[1]
        optional.get().incrementAndGet();

        System.out.println(optional); // Optional[2]
        optional = Optional.ofNullable(new AtomicInteger());



    }

    public static <T> Optional<T> createOptionalTheHardWay(T value) {
        return value == null ? Optional.empty() : Optional.of(value);
    }

    public static <T> Optional<T> createOptionalTheEasyWay(T value) {
        return Optional.ofNullable(value);
    }


}
