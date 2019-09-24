public class Sect5_Ex2 {
    public static void main(String[] args)
    {
        StringProcessor spBlock = x -> {
            System.out.print(x + " ");
            return x + x;
        };

        System.out.println(spBlock.process("Hello"));
    }
}
