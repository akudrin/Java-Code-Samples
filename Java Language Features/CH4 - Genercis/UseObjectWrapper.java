
public class UseObjectWrapper {

    public static void main(String[] args) {
        ObjectWrapper stringWrapper = new ObjectWrapper("Hello");
        stringWrapper.set("Another string");
        String myString = (String) stringWrapper.get();

        stringWrapper.set(Integer.valueOf(101));
        myString = (String) stringWrapper.get();
    }

}