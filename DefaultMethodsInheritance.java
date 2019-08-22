public class DefaultMethodsInheritance implements Company, Employee {
    public static void main(String[] args) {


    }

    private String first;
    private String last;
    @Override
    public void convertCaffeineToCodeForMoney() {
        System.out.println("Coding...");
    }
    @Override
    public String getFirst() {
        return first;
    }

    @Override
    public String getLast() {
        return last;
    }

    @Override
    public String getName() {
        return String.format("%s working for %s",
                Employee.super.getName(), Company.super.getName());
    }
}


interface Company {
    default String getName() {
        return "Initech";
    }
// other methods
}

interface Employee {
    String getFirst();

    String getLast();

    void convertCaffeineToCodeForMoney();

    default String getName() {
        return String.format("%s %s", getFirst(), getLast());
    }
}