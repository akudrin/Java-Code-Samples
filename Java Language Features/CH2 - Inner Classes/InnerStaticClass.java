public class InnerStaticClass {
    static int k = 1001;
    int m = 9008;

    public static void staticMethod() {
        // Class Inner is defined in a static context
        class Inner {
            int j = k; // OK. Referencing static field k
            int n = m; // An error. Referencing non-static field m
        }
    }
}