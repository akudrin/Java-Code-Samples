import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class Sect4_Ex3
{
    public static void main(String[] args)
    {
        try {
            String s = null;
            String opt = Optional.ofNullable(s)
                                 .orElseThrow();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        Supplier<Optional<String> > supplier = () -> {
            System.out.print("Enter a string:");
            return Optional.of((new Scanner(System.in)).nextLine());
        };
        String s = null;
        Optional<String> os = Optional.ofNullable(s)
                .or(supplier);
        if (os.isPresent())
            System.out.println(os.get());
    }
}