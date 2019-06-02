public static StringExample5 {

public static void main(String[] args){
  //Making a String That Can Contain Dynamic Information
  double temperature = 98.6;
  String temperatureString = "The current temperature is %.1f degrees Farenheit.";
  System.out.println(String.format(temperatureString, temperature));
  temperature = 101.2;
  System.out.println(String.format(temperatureString, temperature));
  
  
  double temperature1 = 98.6;
  System.out.printf("The current temperature is %.1f degrees Farenheit.\n", temperature1);
  temperature1 = 101.2;
  System.out.printf("The current temperature is %.1f degrees Farenheit.", temperature1);
  
 
}

}
