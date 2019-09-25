public class Sect6_Ex1
{
    public static void main(String[] args)
    {
        ReceiptPrinter simpleReceiptPrinter = x -> {
            System.out.println("\nItem :\t"  + x.item);
            System.out.println("Price:\t"    + x.price);
            System.out.println("Disc:\t"     + x.discount);
            System.out.println("Tax:\t"      + x.tax);

            /*
            public double computeTotal(Receipt receipt)// ERROR: illegal

            {
                return receipt.price - (receipt.price * receipt.discount);
            }
            */

        };
        
        Receipt receipt = new Receipt("shirt", 20.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);
        System.out.println("Total:\t"    
                         + simpleReceiptPrinter.computeTotal(receipt));

        StringProcessor toLowerCase = x -> x.toLowerCase();
        String s = toLowerCase.process("FUNCTIONALINTERFACES");
        System.out.println(s);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(s));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(s));
        StringProcessor toUpperCase = x -> x.toUpperCase();
        String t = toUpperCase.process(s);
        System.out.println("\n" + t);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(t));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(t));
    }
}
