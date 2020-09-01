public class CollectorsAndThen {
    public static void main(String[] args) {
        List<String> names = Person.persons().stream().map(Person::getName).collect(
                Collectors.collectingAndThen(Collectors.toList(), result -> Collections.unmodifiableList(result)));
        System.out.println(names);
        Map<Month, String> dobCalendar = Person.persons().stream()
                .collect(groupingBy(p -> p.getDob().getMonth(), mapping(Person::getName, joining(", "))));
        dobCalendar.entrySet().forEach(System.out::println);
    }

}