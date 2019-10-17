class Employee
{
    String name;
    double baseSalary;
    double bonus;
    double multiplier;
    public Employee(String n, double bs, double bn, double m)
    {
        name = n;
        baseSalary = bs;
        bonus = bn;
        multiplier = m;
    }
    @Override
    public String toString()
    {
        return name + ": base salary = " + baseSalary
                + " bonus = " + bonus;
    }
}