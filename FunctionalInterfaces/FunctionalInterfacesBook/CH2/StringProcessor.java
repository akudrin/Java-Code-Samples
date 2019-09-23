@FunctionalInterface
public interface StringProcessor 
{
       String process(String x);
}

class StringProcessorExample {
       public static void main(String[] args) {
              StringProcessor lambdaSP = x -> x;
              System.out.println(lambdaSP.process("Hello"));
       }
}