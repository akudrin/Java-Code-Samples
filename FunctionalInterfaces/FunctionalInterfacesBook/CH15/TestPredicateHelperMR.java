class TestPredicateHelperMR
{
    public static boolean myTest(Integer x)
    {
        return (x > 2)? true : false;
    }
    public static boolean myTest(String s)
    {
        return (s.charAt(0) == 'H')? true : false;
    }
    public static void main(String[] args)
    {
        result(TestPredicateHelperMR::myTest, 6);
        result(TestPredicateHelperMR::myTest, "Hello");
    }
}