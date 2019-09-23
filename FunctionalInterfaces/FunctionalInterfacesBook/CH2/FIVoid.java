@FunctionalInterface
public interface FIVoid 
{
    void method1(int i);
}

class FIVoidExample {
    public static void main(String[] args) {
        FIVoid LambdaVoid = x -> System.out.println(x);
        LambdaVoid.method1(5);
    }
}