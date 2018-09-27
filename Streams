//Create a stream of random numbers
DoubleStream s = new Random().doubles();
s.forEach(System.out::println);

IntStream s = new Random().ints();
s.forEach(System.out::println);

IntStream s1 = new Random().ints(5, 1, 10);

That returns an IntStream of five random ints from one (inclusive) to ten (exclusive).

Classify the elements in even or odd:

Map<Integer, Map<String, List<Integer>>> map =
   Stream.of(2,34,54,23,33,20,59,11,19,37)
       .collect(groupingBy(i -> i/10 * 10,
                  groupingBy(i ->
                               i%2 == 0 ? "EVEN" : "ODD")
                )
       );
