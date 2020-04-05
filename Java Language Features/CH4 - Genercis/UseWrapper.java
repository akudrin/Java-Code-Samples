
public class UseWrapper {
    public static void main(String[] args) {
        Wrapper<String> greetingWrapper = new Wrapper<String>("Hello");
        greetingWrapper.set("Hi"); // OK to pass a String
        String greeting = greetingWrapper.get(); // No need to cast

        // A compile-time error. You can use greetingWrapper only to store a String.
        greetingWrapper.set(Integer.valueOf(101));

        Wrapper<Integer> idWrapper = new Wrapper<Integer>(new Integer(101));
        idWrapper.set(Integer.valueOf(101)); // OK to pass an Integer
        Integer id = idWrapper.get();
        // A compile-time error. You can use idWrapper only with an Integer.
        idWrapper.set("hello");

        Wrapper<Person> personWrapper = new Wrapper<Person>(new Person(1, "Chris"));
        personWrapper.set(new Person(2, "Laynie"));
        Person laynie = personWrapper.get();

    }
}