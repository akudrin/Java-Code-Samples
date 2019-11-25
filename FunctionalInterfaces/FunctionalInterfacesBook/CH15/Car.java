import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
    String manu;
    String model;
    int mpg;
    public Car(String ma, String mo, int mp)
    {
        manu = ma;
        model = mo;
        mpg = mp;
    }
    public String toString()
    {
        return manu + " " + model + " gets " + mpg + " mpg";
    }
    public String getManu() { return manu; }
    public String getModel() { return model; }
    public int getMpg() { return mpg; }

    public static void main(String[] args) {
        Stream.of(new Car("Buick" ,"Regal" ,25),
                new Car("Hyundai","Elantra",27),
                new Car("Buick" ,"Skylark",26),
                new Car("Hyundai","Accent" ,30))
                .collect(Collectors.groupingBy(
                        Car::getManu,
                        Collectors.mapping(Car::getMpg,
                                Collectors.toList())))
                .forEach( (x,y) ->
                        System.out.println(x + ": " +y ));
    }
}
