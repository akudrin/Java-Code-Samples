/*
The method should return boolean and it needs to return true if two double numbers are the same up to three decimal places. Otherwise return false.
*/

public class DecimalComparator{
 public static boolean areEqualByThreeDecimalPlaces (double par1, double par2) {
    int numDigits = 3;
    String arg1=""+par1;
    String arg2=""+par2;
    
    int idx1 = arg1.indexOf('.');
    if(idx1!=-1){
        if(arg1.length()>idx1+numDigits){
            arg1=arg1.substring(0,idx1+numDigits+1);
            par1 = Double.parseDouble(arg1);
        }
    }
    
    int idx2 = arg2.indexOf('.');
    if(idx2!=-1){
        if(arg2.length()>idx2+numDigits){
            arg2=arg2.substring(0,idx2+numDigits+1);
            par2 = Double.parseDouble(arg2);
        }
    }
    
    if(par1==par2){
        return true;
    } else {
        return false;
    }
    
    
 }
}