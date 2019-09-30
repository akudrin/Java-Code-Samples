import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToDoubleBiFunction;
public class Sect10_Ex1 
{
    public static void main(String[] args)
    {
        ToIntBiFunction<String, Double> tib = (x,z) -> 
            Integer.parseInt(x) + (Double.valueOf(z)).intValue();
        ToLongBiFunction<Double, String> tlb = (x,z) -> 
            x.longValue() + Long.parseLong(z);
        ToDoubleBiFunction<Integer, Long> tdb = (x,z) -> 
            (Integer.valueOf(x)).doubleValue() + (Long.valueOf(z)).doubleValue();

        System.out.println(tib.applyAsInt("5",4.2));	
        System.out.println(tlb.applyAsLong(5.1, "6"));	
        System.out.println(tdb.applyAsDouble(7, 8L));	
    }
}
