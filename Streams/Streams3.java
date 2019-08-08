import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams3 {
    public static void main(String[] args) {

        //Reduction operations on IntStream
        String[] strings = "this is an array of strings".split(" ");
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();
        System.out.println("There are " + count + " strings");
        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
        System.out.println("The total length is " + totalLength);
        OptionalDouble ave = Arrays.stream(strings)
                .mapToInt(String::length)
                .average();
        System.out.println("The average length is " + ave);
        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max();
        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();
        System.out.println("The max and min lengths are " + max + " and " + min);

        //Summing numbers using reduce
        int sum1 = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + y).orElse(0);


        int sum2 = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d, y=%d%n", x, y);
                    return x + y;
                }).orElse(0);


        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> x + 2 * y);

        //Performing a reduce with a binary operator
        int sum3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);
        System.out.println(sum3);

        //Finding the max using reduce
        Integer maxReduce = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("The max value is " + max);

        //Concatenating strings from a stream using reduce
        String s1 = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);
        System.out.println(s1);

        //Collecting strings using a StringBuilder
        String s2 = Stream.of("this", "is", "a", "list")
                .collect(() -> new StringBuilder(),
                        (sb, str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2))
                .toString();

        //Collecting strings, with method references
        String s3 = Stream.of("this", "is", "a", "list")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();

        //Joining strings using Collectors
        String s4 = Stream.of("this", "is", "a", "list")
                .collect(Collectors.joining());

        //Accumulating Books into a Map
        Book book1 = new Streams3().new Book(1, "Book 1");
        Book book2 = new Streams3().new Book(2, "Book 2");
        Book book3 = new Streams3().new Book(3, "Book 3");
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        HashMap<Integer, Book> bookMap = books.stream()
                .reduce(new HashMap<Integer, Book>(),
                        (map, book) -> {
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) -> {
                            map1.putAll(map2);
                            return map1;
                        });
        bookMap.forEach((k,v) -> System.out.println(k + ": " + v));

    }

    class Book {
        private Integer id;
        private String title;

        public Book(Integer id, String title) {
            this.id = id;
            this.title = title;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return id.equals(book.id) &&
                    title.equals(book.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title);
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

