import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupExample2 {
    public static void main(String[] args) throws IOException {

        //Loading
        String blogUrl = "https://spring.io/blog";
        Document doc = Jsoup.connect(blogUrl).get();

        try {
            Document doc404 = Jsoup.connect("https://spring.io/will-not-be-found").get();
        } catch (HttpStatusException ex) {
            //...
        }

        Connection connection = Jsoup.connect(blogUrl);
        connection.userAgent("Mozilla");
        connection.timeout(5000);
        connection.cookie("cookiename", "val234");
        connection.cookie("cookiename", "val234");
        connection.referrer("http://google.com");
        connection.header("headersecurity", "xyz123");
        Document docCustomConnA = connection.get();

        Document docCustomConnB = Jsoup.connect(blogUrl)
                .userAgent("Mozilla")
                .timeout(5000)
                .cookie("cookiename", "val234")
                .cookie("anothercookie", "ilovejsoup")
                .referrer("http://google.com")
                .header("headersecurity", "xyz123")
                .get();

        //Filtering - Selecting
        Elements links = doc.select("a");
        Elements sections = doc.select("section");
        Elements logo = doc.select(".spring-logo--container");
        Elements pagination = doc.select("#pagination_control");
        Elements divsDescendant = doc.select("header div");
        Elements divsDirect = doc.select("header > div");

        Element pag = doc.getElementById("pagination_control");
        Elements desktopOnly = doc.getElementsByClass("desktopOnly");



    }
}
