import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArray_2 {
    public static void main(String[] args) throws IOException
    {
        ByteArrayOutputStream byte_output = new ByteArrayOutputStream();

        byte[] buffer = {'J', 'A', 'V', 'A'};

        for (byte a : buffer)
        {
            // Use of write(int byte) :
            byte_output.write(a);
        }

        // Use of size() :
        int size = byte_output.size();
        System.out.println("Use of size() : " + size);

        // Use of reset() :
        System.out.println("Use of reset()");

        // USe of toString() :
        String str = byte_output.toString();
        System.out.println("Use of toString() : "+ str);

        // Use of toString(String charsetName)
        String str1 = byte_output.toString("UTF-8");
        System.out.println("Use of toString(String charsetName) : "+ str1);

        // Closing the stream
        byte_output.close();

    }
}
