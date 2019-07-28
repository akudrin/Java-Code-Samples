import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JsonParserExample {

    public void parseObject() {
        Reader fileReader = new InputStreamReader(getClass().getResourceAsStream("BookObject.json"));
        JsonParser parser = Json.createParser(fileReader);
        
        
        while (parser.hasNext()) {
            Event ev = parser.next();
            System.out.println(ev);
            if(ev.equals(Event.VALUE_STRING)){
                System.out.println(parser.getString());
            }
        }
    }

    public static void main(String[] args) {
        JsonParserExample ex = new JsonParserExample();
        ex.parseObject();
    }
}
