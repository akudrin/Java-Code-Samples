public class HelloLambda {
    
    /*
     * Functional Interface
     */
    public interface HelloType {
        /*
         * Function that will be implemented within the lambda
         *  
         */
        void hello(String text);
    }
    
    public static void main(String[] args){
        // Invoke the lambda, passing a parameter named "text" to the
        // hello() method, returning the string
        HelloType helloLambda = 
                (String text) -> {System.out.println("Hello " + text);};
        // Invoke the method call
        helloLambda.hello("Lambda");
    }
}
