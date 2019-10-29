class Home
{
    String community;
    double price;
    int numBedrooms;
    double acres;
    double schoolDistance;
    double trainDistance;
    public Home(String co, double pr, int bed, double ac,
                double sd, double td)
    {
        community = co;
        price = pr;
        numBedrooms = bed;
        acres = ac;
        schoolDistance = sd;
        trainDistance = td;
    }
    @Override
    public String toString()
    {
        return numBedrooms + " bedroom house in " + community
                + " for $" + price + " on " + acres + " acres\n "
                + schoolDistance + " miles from school "
                + trainDistance + " miles from train";
    }
}