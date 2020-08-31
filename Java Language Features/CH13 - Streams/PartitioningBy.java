public class PartitionningBy {
    public static void main(String[] args) {
        Map<Boolean, List<Person>> partionedByMaleGender1 = Person.persons().stream()
                .collect(Collectors.partitioningBy(Person::isMale));
        System.out.println(partionedByMaleGender1);
        Map<Boolean, String> partionedByMaleGender2 = Person.persons().stream().collect(Collectors
                .partitioningBy(Person::isMale, Collectors.mapping(Person::getName, Collectors.joining(", "))));
        System.out.println(partionedByMaleGender2);
    }
}