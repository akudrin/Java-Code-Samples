public class OptionalTestJava9 {
    public static void main(String[] args) {
        List<Optional<Integer>> optionalList = List.of(Optional.of(1), Optional.empty(), Optional.of(2),
                Optional.empty(), Optional.of(3));
        optionalList.stream().forEach(p -> p.ifPresentOrElse(System.out::println, () -> System.out.println("Empty")));
        optionalList.stream().map(p -> p.or(() -> Optional.of(0))).forEach(System.out::println);
        // Print the values in all non-empty Optionals
        optionalList.stream().filter(Optional::isPresent).map(Optional::get).forEach(System.out::println);
        // Print the values in all non-empty Optionals
        optionalList.stream().flatMap(Optional::stream).forEach(System.out::println);
    }

}