import java.io.ByteArrayInputStream;

public class ByteArray_3 {
    public static void main(String[] args) throws Exception
    {
        byte[] buffer = {74,65,86,65,56};
        ByteArrayInputStream stream_input = null;
        try
        {
            stream_input = new ByteArrayInputStream(buffer);

            // Use of available() method : telling the no. of bytes to be read
            int number = stream_input.available();
            System.out.println("Use of available() method : " + number);


            // Use of read() method : reading and printing Characters one by one
            System.out.println("\nChar : "+(char)stream_input.read());
            System.out.println("Char : "+(char)stream_input.read());
            System.out.println("Char : "+(char)stream_input.read());

            // Use of mark() :
            stream_input.mark(0);

            // Use of skip() : it results in skiping 'A' from "JAVA8"
            stream_input.skip(1);
            System.out.println("skip() method comes to play");
            System.out.println("mark() method comes to play");
            System.out.println("Char : "+(char)stream_input.read());

            // Use of markSupported
            boolean check = stream_input.markSupported();
            System.out.println("\nmarkSupported() : " + check);
            if(stream_input.markSupported())
            {
                // Use of reset() method : repositioning the stream to marked positions.
                stream_input.reset();
                System.out.println("\nreset() invoked");
                System.out.println("Char : "+(char)stream_input.read());
                System.out.println("Char : "+(char)stream_input.read());
            }
            else
            {
                System.out.println("reset() method not supported.");
            }

            System.out.println("stream_input.markSupported() supported reset() : "+check);

        }
        catch(Exception excpt)
        {
            // in case of I/O error
            excpt.printStackTrace();
        }
        finally
        {
            // releasing the resources back to the GarbageCollector when closes
            if(stream_input!=null)
            {
                // Use of close() : closing the file and releasing resources
                stream_input.close();
            }
        }
    }
}
