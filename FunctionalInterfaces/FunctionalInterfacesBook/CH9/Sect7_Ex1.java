import java.util.Set;
import java.util.TreeSet;

public class Sect7_Ex1 {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add("Jeremy");
        names.add("Javier");
        names.add("Rose");
        names.removeIf(x -> x.charAt(0) == 'J');
        names.forEach(x -> System.out.println(x));
    }
}
