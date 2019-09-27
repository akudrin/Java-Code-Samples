import java.util.ArrayList;
import java.util.function.Predicate;

public class Project3_1 {
    private static boolean qualifyCustomer(
            Customer c,
            ArrayList<Predicate<Customer>> pList)
    {
        int count = 0;
        for (Predicate<Customer> p : pList)
        {
            if (p.test(c))
            {
                count++;
                System.out.println("MATCH " + count);
            }
        }
        return count >= 3;
    }

    public static void main(String[] args)
    {
        ArrayList< Predicate<Customer> > elantraQualifier
                = new ArrayList<>();
        elantraQualifier.add(c -> c.gender.equals("female"));
        elantraQualifier.add(c -> c.state.equals("New Jersey")
                || c.state.equals("Pennsylvania"));
        elantraQualifier.add(c -> c.age > 40 && c.age < 50);
        elantraQualifier.add(
                c -> c.ed.compareTo(Education.HIGHSCHOOL) > 0);
        ArrayList< Predicate<Customer> > priusQualifier
                = new ArrayList<>();
        priusQualifier.add(c -> c.gender.equals("male"));
        priusQualifier.add(c -> c.state.equals("New York"));
        priusQualifier.add(c -> c.age > 20 && c.age < 30);
        priusQualifier.add(c -> c.ed.equals(Education.BACHELORS));

        ArrayList< Predicate<Customer> > odysseyQualifier
                = new ArrayList<>();
        odysseyQualifier.add(c -> c.gender.equals("female"));
        odysseyQualifier.add(c -> c.state.equals("New Jersey"));
        odysseyQualifier.add(c -> c.age > 40);
        odysseyQualifier.add(
                c -> c.ed.compareTo(Education.BACHELORS) > 0);
        Customer c1 = new Customer("female", "New York", 43,
                Education.BACHELORS);
        Customer c2 = new Customer("male", "New York", 45,
                Education.BACHELORS);
        Customer c3 = new Customer("female", "New York", 52,
                Education.PHD);
        System.out.println("Qualify customer: " + c1);
        if (qualifyCustomer(c1,elantraQualifier))
            System.out.println("Sell customer a Hyundai Elantra");
        if (qualifyCustomer(c1,priusQualifier))
            System.out.println("Sell customer a Toyota Prius");
        if (qualifyCustomer(c1,odysseyQualifier))
            System.out.println("Sell customer a Honda Odyssey");
        System.out.println("Qualify customer: " + c2);
        if (qualifyCustomer(c2,elantraQualifier))
            System.out.println("Sell customer a Hyundai Elantra");
        if (qualifyCustomer(c2,priusQualifier))
            System.out.println("Sell customer a Toyota Prius");
        if (qualifyCustomer(c2,odysseyQualifier))
            System.out.println("Sell customer a Honda Odyssey");
        System.out.println("Qualify customer: " + c3);
        if (qualifyCustomer(c3,elantraQualifier))
            System.out.println("Sell customer a Hyundai Elantra");
        if (qualifyCustomer(c3,priusQualifier))
            System.out.println("Sell customer priusQualifier");
        if (qualifyCustomer(c3,odysseyQualifier))
            System.out.println("Sell customer a Honda Odyssey");
    }
}
