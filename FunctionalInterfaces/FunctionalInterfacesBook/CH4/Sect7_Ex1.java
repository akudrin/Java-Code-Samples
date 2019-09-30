import java.util.function.*;
public class Sect7_Ex1 
{
    public static void main(String[] args)
    {
        DoubleToIntFunction  di = x -> (Double.valueOf(x)).intValue();
        DoubleToLongFunction dl = x -> (Double.valueOf(x)).longValue();
        IntToDoubleFunction  id = x -> (Integer.valueOf(x)).doubleValue();
        IntToLongFunction    il = x -> (Integer.valueOf(x)).longValue();
        LongToDoubleFunction ld = x -> (Long.valueOf(x)).doubleValue();
        LongToIntFunction    li = x -> (Long.valueOf(x)).intValue();
        
        System.out.println(di.applyAsInt(4.1));	
        System.out.println(dl.applyAsLong(5.2));	
        System.out.println(id.applyAsDouble(6));	
        System.out.println(il.applyAsLong(7));
        System.out.println(ld.applyAsDouble(8));
        System.out.println(li.applyAsInt(9));	
    }
}
