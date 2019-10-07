class BankAccount
{
    String name;
    int id;
    double balance;
    public BankAccount(String n, int i, double b)
    {
        name = n;
        id = i;
        balance = b;
    }
    @Override
    public boolean equals(Object ba)
    {
        return id == ((BankAccount)ba).id;
    }
    @Override
    public String toString()
    {
        return "name = " + name + " id = " + id
                + " balance = " + balance;
    }
}