import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArray_1 {
    public static void main(String[] args) throws IOException
    {
        ByteArrayOutputStream byte_output = new ByteArrayOutputStream();

        byte[] buffer = {'J', 'A', 'V', 'A'};

        // Use of write(byte[] buffer, int offset, int maxlen)
        byte_output.write(buffer, 0, 4);
        System.out.print("Use of write(buffer, offset, maxlen) by toByteArray() : ");

        // Use of toByteArray() :
        for (byte b: byte_output.toByteArray())
        {
            System.out.print(" " + b);
        }
    }
}
