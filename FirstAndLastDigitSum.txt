public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        int sum = 0;
        int last;
        int first=number;
        if(number < 0 ){
            return -1;
        } else if(number==0){
            return 0;
        
       } else {
            
            
            last = number%10;
            
    while (first > 9) {
        first = first/10;
    }
    return sum = first+last;
}
            
        }
    }