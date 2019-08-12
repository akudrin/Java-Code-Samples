import java.io.BufferedWriter;
import java.io.FileWriter;

public class DataScience2 {
    public static void main(String[] args) {

        String[] myList = {"a", "b", "c"};
        /* in Java 8 */
        String newString1 = String.join(",",myList);
        /* or feed in an Iterator */
        String newString2 = String.join(",", myList);

        System.out.println(newString1 + "   " + newString2);

        /* in Java 7 */
        String[] strings = {"a", "b", "c"};
        /* create a StringBuilder and add the first member */
        StringBuilder sb = new StringBuilder();
        sb.append(strings[0]);
        /* skip the first string since we already have it */
        for(int i = 1; i < strings.length; i++){
            /* choose a delimiter here ... could also be a \t for tabs */
            sb.append(",");
            sb.append(strings[i]);
        }
        String newString3 = sb.toString();

        /* setting FileWriter append bit to true keeps existing data and appends new data */
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("somefile.txt")) ) {
            for(String s : myList){
                bw.write(s);
                /* don't forget to append a new line! */
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
