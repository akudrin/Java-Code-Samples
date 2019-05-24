import java.util.*;
import java.util.stream.*; 

public class StreamsExample1 {
   
    public static void main(String[] args) {
    
        List<String> myLangs = Arrays.asList("Jython is great", "Groovy is awesome", "Scala is functional","JRuby is productive", "Java is streamlined","", "Kotlin is interesting");
        myLangs.stream().takeWhile(s -> !s.contains("Java")).forEach(System.out::println);
        Stream.of("Jython is great","Groovy is awesome","Scala is functional", "JRuby is productive","Java is streamlined","","Kotlin is interesting")
        .dropWhile(s -> !s.contains("Java")).forEach(System.out::println);
    
    }


}