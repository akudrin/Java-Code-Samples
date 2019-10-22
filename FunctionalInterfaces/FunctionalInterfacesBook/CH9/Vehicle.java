class Vehicle
{
    String make;
    String model;
    int year;
    public Vehicle(String ma, String mo, int y)
    {
        make = ma;
        model = mo;
        year = y;
    }
    @Override
    public String toString()
    {
        return year + " " + make + " " + model;
    }
}