import java.util.function.*;

public class Sect5_Ex1
{
    public static void main(String[] args)
    {
        //Convert from Primitive Types
        IntFunction<String> fi = x -> (Integer.valueOf(x).toString());
        DoubleFunction<Boolean> fd = x -> x > 5.0? true : false;
        LongFunction<Integer> fl = x -> (int)x;

        System.out.println(fi.apply(5));
        System.out.println(fd.apply(4.5));
        System.out.println(fl.apply(20L));

        //Convert to Primitive Types
        ToIntFunction<String> ti     = x -> Integer.parseInt(x);
        ToLongFunction<Double> tl    = x -> x.longValue();
        ToDoubleFunction<Integer> td = x -> (Integer.valueOf(x).doubleValue());

        System.out.println(ti.applyAsInt("5"));
        System.out.println(tl.applyAsLong(5.1));
        System.out.println(td.applyAsDouble(7));
    }
}
