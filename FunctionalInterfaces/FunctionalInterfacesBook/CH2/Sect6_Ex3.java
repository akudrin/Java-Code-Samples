abstract class TwoIntsProcessorAbstract
    implements TwoArgsProcessor<Integer> 
{
}

public class Sect6_Ex3 
{
    public static void main(String[] args)
    {
        TwoIntsProcessorAbstract divideInts = (x,y) -> x / y  // ERROR: ProcessTwoIntsAbstract is 
                                                              //        not a functional interface 
        
    }
}
