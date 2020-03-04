public class AvailCharsets {
    public static void main(String[] args) {
        SortedMap<String, Charset> acs = Charset.availableCharsets();
        System.out.println(acs);
    }
}