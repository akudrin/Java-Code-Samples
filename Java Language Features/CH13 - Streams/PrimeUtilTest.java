public class PrimeUtilTest {
    public static void main(String[] args) {
        // infinite stream of prime numbers and prints the first five prime
        // numbers on the standard output
        Stream.iterate(2L, PrimeUtil::next).limit(5).forEach(System.out::println);
        // another way to get the first five prime numbers. You can generate an infinite
        // stream of natural
        // numbers, apply a filter operation to pick only the prime numbers, and limit
        // the filtered stream to five.
        Stream.iterate(2L, n -> n + 1).filter(PrimeUtil::isPrime).limit(5).forEach(System.out::println);
        // print five prime numbers, skipping the first 100 prime numbers
        Stream.iterate(2L, PrimeUtil::next).skip(100).limit(5).forEach(System.out::println);
    }
}