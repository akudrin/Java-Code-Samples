public class MonetaryValues {

public static void main(String[] args){

//BigDecimal
BigDecimal currencyOne = new BigDecimal("25.65");
BigDecimal currencyTwo = new BigDecimal("187.32");
BigDecimal currencyThree = new BigDecimal("4.86");
BigDecimal result = null;
String printFormat = null;
// Add all three values
result = currencyOne.add(currencyTwo).add(currencyThree);
// Convert to double and send to formatDollars(), returning a String
printFormat = formatDollars(result.doubleValue());
System.out.println(printFormat);
// Subtract the first currency value from the second
result = currencyTwo.subtract(currencyOne);
printFormat = formatDollars(result.doubleValue());
System.out.println(printFormat);

//Java Money API
MonetaryAmount amount1 = Money.of(25.65, Monetary.getCurrency("USD"));
MonetaryAmount amount2 = Money.of(187.32, Monetary.getCurrency("USD"));
MonetaryAmount amount3 = Money.of(4.86,Monetary.getCurrency("USD"));
MonetaryAmount result = null;
result = amount1.add(amount2).add(amount3);
MonetaryAmountFormat printFormat = MonetaryFormats.getAmountFormat(
AmountFormatQuery.of(Locale.US));
System.out.println("Sum of all: " + printFormat.format(result));
result = amount2.subtract(amount1);
System.out.println("Subtract amount1 from amount 2: " + printFormat.format(result));

}

public static String formatDollars(double value){
NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
return dollarFormat.format(value);
}

}
