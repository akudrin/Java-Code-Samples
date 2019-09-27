enum Education {ELEMENTARY, HIGHSCHOOL, BACHELORS, MASTERS, PHD }
class Customer
{
    String gender;
    String state;
    int age;
    Education ed;
    public Customer(String g, String st, int a, Education e)
    {
        gender = g;
        state = st;
        age = a;
        ed = e;
    }
    @Override
    public String toString()
    {
        return age + " year old " + gender + " from "
                + state + " with " + ed;
    }
}