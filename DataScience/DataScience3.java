import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

//import https://cliftonlabs.github.io/json-simple/

public class DataScience3 {
    public static void main(String[] args) throws Exception {


        try(BufferedReader br = new BufferedReader(new FileReader("somefile.txt")) ) {
            String columnNames = br.readLine(); // ONLY do this if it exists
            String line;
            JSONParser parser = new JSONParser();
            while ((line = br.readLine()) != null) {
                /* parse each line */
                int id = Integer.parseInt(line.substring(0, 4));
                int year = Integer.parseInt(line.substring(4, 8));
                int city = Integer.parseInt(line.substring(8, 10));

                /* parse each line */
                String[] s = line.split(",");
                int id1 = Integer.parseInt(s[0].trim());
                int year1 = Integer.parseInt(s[1].trim());
                String city1 = s[2].trim().replace("\"", "");

                /* parse each line */
                //use the Apache Commons CSV parser library
                CSVParser parser = CSVParser.parse(line, CSVFormat.RFC4180);
                for(CSVRecord cr : parser) {
                    int id2 = cr.get(1); // columns start at 1 not 0 !!!
                    int year2 = cr.get(2);
                    String city2 = cr.get(3);
                }


                /* create an object by casting the parsed string */
                JSONObject obj1 = (JSONObject) parser.parse(line);
                int id3 = Integer.parseInt(j.get("id").toString());
                int year3 = Integer.parseInt(j.get("year").toString());
                String city3 = j.get("city").toString();

                //if JSON file has curly braces (object) or square braces (array):
                JSONObject jObj2 = (JSONObject) parser.parse(new FileReader("data.json"));
                JSONArray jArr = (JSONArray) parser.parse(new FileReader("data.json"));

            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // or log error
        }

        URL url = new URL("http://storage.example.com/public-data/somefile.txt");
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream())) ) {
            String columnNames = br.readLine(); // ONLY do this if it exists
            String line;
            while ((line = br.readLine()) != null) {
        // TODO parse each line
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // or log error
        }

    }

}
