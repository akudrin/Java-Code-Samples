public class NumbersExample1 {

public static void main (String[] args) {

//Rounding Float and Double Values to Integers
public static int roundFloatToInt(float myFloat){
return Math.round(myFloat);
}
public static long roundDoubleToLong(double myDouble){
return Math.round(myDouble);

//Formatting Double and Long Decimal Values
public static void formatDouble(double myDouble){
NumberFormat numberFormatter = new DecimalFormat("##.000");
String result = numberFormatter.format(myDouble);
System.out.println(result);
}

//Comparing int Values
int int1 = 1;
int int2 = 10;
int int3 = -5;
System.out.println(int1 == int2); // Result: false
System.out.println(int3 == int1); // Result: false
System.out.println(int1 == int1); // Result: true
System.out.println(int1 > int3); // Result: true
System.out.println(int2 < int3); // Result: false

System.out.println("Compare method -> int3 and int1: " + Integer.compare(int3, int1));
// Result -1
System.out.println("Compare method -> int2 and int1: " + Integer.compare(int2, int1));
// Result 1

//Comparing Floating-Point Numbers
Float float1 = new Float("9.675");
Float float2 = new Float("7.3826");
Float float3 = new Float("23467.373");
System.out.println(float1.compareTo(float3)); // Result: -1
System.out.println(float2.compareTo(float3)); // Result: -1
System.out.println(float1.compareTo(float1)); // Result: 0
System.out.println(float3.compareTo(float2)); // Result: 1

System.out.println(Float.compare(float1, float3)); // Result: -1
System.out.println(Float.compare(float2, float3)); // Result: -1
System.out.println(Float.compare(float1, float1)); // Result: 0
System.out.println(Float.compare(float3, float2)); // Result: 1

}
//Use underscores in place of commas or decimals in larger numbers in order to make them more readable.
int million = 1_000_000;
int billion = 1_000_000_000;
float ten_pct = 1_0f;
double exp = 1_234_56.78_9e2;

//Make use of binary literals to make your code readable. prefix the number with 0b or 0B.
int bin1 = 0b1100;
short bin2 = 0B010101;
short bin3 = (short) 0b1001100110011001;
System.out.println(bin1);
System.out.println(bin2);
System.out.println(bin3);

}

}
