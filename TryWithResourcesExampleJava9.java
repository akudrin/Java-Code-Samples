public class TryWithResourcesExampleJava9 {

    public static void main(String[] args) {
        try {
            writeFile(new BufferedWriter(new FileWriter("Easy TryWithResources")), "This is easy in Java 9");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void writeFile(BufferedWriter writer, String text) {
        try (writer) {
            writer.write(text);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}

/*
Prior to Java 9, the writeFile would have looked as follows:

public static void writeFile(BufferedWriter writer, String text) {
try (BufferedWriter w = writer) {
w.write(text);
} catch (IOException ioe) {
System.out.println(ioe);
}
}
*/
