import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImmutableCollections {
    public static void main(String[] args) {

    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityAdd() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.add(99);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityClear() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityRemove() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilityReplace() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.replaceAll(n -> -n);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void showImmutabilitySet() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        intList.set(0, 99);
    }

    @Test
    public void areWeImmutableOrArentWe() throws Exception {
        List<Holder> holders = List.of(new Holder(1), new Holder(2));
        assertEquals(1, holders.get(0).getX());
        holders.get(0).setX(4);
        assertEquals(4, holders.get(0).getX());
    }

    @Test
    public void immutableMapFromEntries() throws Exception {
        Map<String, String> jvmLanguages = Map.ofEntries(
                Map.entry("Java", "http://www.oracle.com/technetwork/java/index.html"),
                Map.entry("Groovy", "http://groovy-lang.org/"),
                Map.entry("Scala", "http://www.scala-lang.org/"),
                Map.entry("Clojure", "https://clojure.org/"),
                Map.entry("Kotlin", "http://kotlinlang.org/"));
        Set<String> names = Set.of("Java", "Scala", "Groovy", "Clojure", "Kotlin");
        List<String> urls = List.of("http://www.oracle.com/technetwork/java/index.html",
                "http://groovy-lang.org/",
                "http://www.scala-lang.org/",
                "https://clojure.org/",
                "http://kotlinlang.org/");
        Set<String> keys = jvmLanguages.keySet();
        Collection<String> values = jvmLanguages.values();
        names.forEach(name -> assertTrue(keys.contains(name)));
        urls.forEach(url -> assertTrue(values.contains(url)));
        Map<String, String> javaMap = Map.of("Java",
                "http://www.oracle.com/technetwork/java/index.html",
                "Groovy",
                "http://groovy-lang.org/",
                "Scala",
                "http://www.scala-lang.org/",
                "Clojure",
                "https://clojure.org/",
                "Kotlin",
                "http://kotlinlang.org/");
        javaMap.forEach((name, url) -> assertTrue(
                jvmLanguages.keySet().contains(name) &&
                jvmLanguages.values().contains(url)));
    }

}

class Holder {
    private int x;

    public Holder(int x) {
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
