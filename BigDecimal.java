/*
Avoid this kind of code for currency calculations
The output should have been 20.20 (20 dollars and 20 cents), 
but the floating point calculation made it 20.19999999999996. 
This is the loss of precision (or loss of significance).
*/

public class DoubleForCurrency {

    public static void main(String[] args) {

        double total = 0.2;

        for (int i = 0; i < 100; i++) {

            total += 0.2;

        }

        System.out.println("total = " + total);

    }

}


//use this code instead

import java.math.BigDecimal;

public class BigDecimalForCurrency {

    public static void main(String[] args) {

        int scale = 4;

        double value = 0.11111;

        BigDecimal tempBig = new BigDecimal(Double.toString(value));

        tempBig = tempBig.setScale(scale, BigDecimal.ROUND_HALF_EVEN);

        String strValue = tempBig.stripTrailingZeros().toPlainString();

        System.out.println("tempBig = " + strValue);

    }

}