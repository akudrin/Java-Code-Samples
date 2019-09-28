import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<String, Integer> f;
        f = x -> Integer.parseInt(x);

        Integer i = f.apply("100");
        System.out.println(i);

        
    }
}
