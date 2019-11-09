import java.util.stream.*;
public class Sect10_Ex1 
{
    public static void main(String[] args)
    {
        Stream.Builder<String> bld = Stream.builder();

        bld.accept("RED");
        bld.accept("GREEN");
        bld.accept("BLUE");

        Stream<String> st = bld.build();
        st.forEach(x -> System.out.println(x));
        //attempting to add the element “YELLOW” to the builder after the stream has been
        //generated causes an IllegalStateException
        try {
            bld.accept("YELLOW");
        }
        catch (IllegalStateException e) {
            System.out.println("IllegalStateException");
        }


    }
}